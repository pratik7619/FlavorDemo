package com.example.flavordemo.data

import android.content.Context
import com.example.flavordemo.database.AppDataBase
import com.example.flavordemo.database.entity.Person
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class PersonRepository(
    context: Context
) {

    private val personDao = AppDataBase.getInstance(context).personDao()

    fun insertPerson(person: Person) = personDao.insertPerson(person)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

    fun fetchPerson(): Single<Person> {
        return Single.timer(
            2,
            TimeUnit.SECONDS
        ).flatMap {
            personDao.getPerson()
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}

