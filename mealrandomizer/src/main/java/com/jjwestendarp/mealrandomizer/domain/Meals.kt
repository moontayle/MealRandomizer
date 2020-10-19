package com.jjwestendarp.mealrandomizer.domain

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Meals(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "meal_name") val mealName: String,
    @ColumnInfo(name = "last_used") val lastUsed: Long
)