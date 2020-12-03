package com.jjwestendarp.mealrandomizer.presentation

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.jjwestendarp.core.base.BaseFragment
import com.jjwestendarp.mealrandomizer.R
import com.jjwestendarp.mealrandomizer.databinding.FragmentMealRandomizerBinding
import com.jjwestendarp.mealrandomizer.domain.Meal
import okio.Okio
import org.koin.android.ext.android.bind
import org.koin.androidx.viewmodel.ext.android.viewModel

class MealRandomizerFragment : BaseFragment<MealRandomizerUiState, MealRandomizerViewModel, FragmentMealRandomizerBinding>(
    R.layout.fragment_meal_randomizer)  {
    override val viewModel: MealRandomizerViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnAddItem.setOnClickListener {
            viewModel.addItem(binding.etItem.text.toString())
            binding.etItem.setText("")
        }
        binding.btnRandomize.setOnClickListener {
            viewModel.shuffleMeals()
        }
        binding.btnShow.setOnClickListener {
            showMealDialog()
        }
        viewModel.getMealList()

    }

    override fun onUiStateUpdated(uiState: MealRandomizerUiState) {
        when {
            uiState.hasError -> {}
            uiState.isLoading -> {}
            else -> {
                when (uiState.action) {
                    is MealRandomizerAction.DefaultAction -> {}
                    is MealRandomizerAction.LoadedAction -> {
                        binding.tvNumber.text = getString(R.string.tv_total_meals, uiState.mealList.size)
                        if (uiState.mealList.isEmpty()) {
                            firstRun()
                        }
                    }
                    is MealRandomizerAction.RandomizeMealAction -> {
                        updateList(uiState.action.mealList)
                    }
                }
            }
        }
    }

    private fun updateList(mealList: List<Meal>) {
        binding.rvMealList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = MealRandomizerAdapter(mealList,  object : ListItemClickListener {
                override fun onClick() {
                    viewModel.saveListToDatabase(mealList)
                }
            })
        }
    }

    private fun firstRun() {
        val list = mutableListOf<Meal>()
        activity?.assets?.open("meals.txt").use { input ->
            input?.let {
                Okio.buffer(Okio.source(it)).use { source ->
                    generateSequence { source.readUtf8Line() }
                        .forEach { mealName ->
                            list.add(Meal(mealName, 0))
                        }
                }
            }
        }
        viewModel.addItemList(list)
    }

    private fun showMealDialog() {
        val adapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1)
        uiState.mealList.forEach {
            adapter.add(it.mealName)
        }
        AlertDialog.Builder(requireContext())
            .setAdapter(adapter) { _, _ ->
                // Nothing
            }
            .setCancelable(true)
            .show()
    }
}