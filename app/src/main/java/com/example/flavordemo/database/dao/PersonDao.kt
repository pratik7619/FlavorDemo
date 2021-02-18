package com.example.flavordemo.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.flavordemo.database.entity.Person
import io.reactivex.Single

@Dao
interface PersonDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertPerson(person: Person): Single<Long>

    @Query("SELECT * from Person ORDER BY id DESC LIMIT 1")
    fun getPerson(): Single<Person>
}