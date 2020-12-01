package com.jjwestendarp.mealrandomizer.domain

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Meal(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "meal_name") val mealName: String,
    @ColumnInfo(name = "last_used") val lastUsed: Long
) {
    constructor(mealName: String, lastUsed: Long) : this(0, mealName, lastUsed)
}