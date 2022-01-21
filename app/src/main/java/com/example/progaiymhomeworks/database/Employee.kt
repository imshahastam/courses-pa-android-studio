package com.example.progaiymhomeworks.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Employee(
    @PrimaryKey(autoGenerate = false)
    val id: Long?,
    val name: String,
    val company: String,
    val salary: Int
)