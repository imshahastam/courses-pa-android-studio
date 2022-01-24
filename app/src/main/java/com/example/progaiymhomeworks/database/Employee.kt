package com.example.progaiymhomeworks.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Employee(
    @PrimaryKey(autoGenerate = false)
    val id: Long?,
    var name: String,
    var company: String,
    var salary: Int
)