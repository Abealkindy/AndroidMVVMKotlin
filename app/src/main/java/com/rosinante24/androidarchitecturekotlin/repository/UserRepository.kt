package com.rosinante24.androidarchitecturekotlin.repository

import com.rosinante24.androidarchitecturekotlin.repository.api.UserApi
import com.rosinante24.androidarchitecturekotlin.repository.db.UserDao
import com.rosinante24.androidarchitecturekotlin.repository.data.User
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

/*
 * Created by Rosinante24 on 29/10/17.
 */
class UserRepository(private val userApi: UserApi, private val userDao: UserDao) {

    fun getUsers(): Observable<List<User>> {
        return Observable.concatArray(
                getUsersFromDb(),
                getUsersFromApi())
    }


    private fun getUsersFromDb(): Observable<List<User>> {
        return userDao.getUsers().filter { it.isNotEmpty() }
                .toObservable()
                .doOnNext {
                    Timber.d("Dispatching ${it.size} users from DB...")
                }
    }

    private fun getUsersFromApi(): Observable<List<User>> {
        return userApi.getUsers()
                .doOnNext {
                    Timber.d("Dispatching ${it.size} users from API...")
                    storeUsersInDb(it)
                }
    }

    private fun storeUsersInDb(users: List<User>) {
        Observable.fromCallable { userDao.insertAll(users) }
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe {
                    Timber.d("Inserted ${users.size} users from API in DB...")
                }
    }

}
