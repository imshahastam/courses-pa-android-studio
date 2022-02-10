package com.example.progaiymhomeworks.database

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.Disposable

@Dao
interface EmployeeDao {

    @Query("SELECT * FROM employee")
    fun getAll(): Observable<List<Employee>>

    @Query("SELECT * FROM employee WHERE id = :id")
    fun getById(id: Long?): Single<Employee>

    @Insert
    fun insert(employee: Employee) : Completable

    @Update
    fun update(employee: Employee) : Completable

    @Delete
    fun delete(employee: Employee) : Completable
}