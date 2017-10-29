package com.rosinante24.androidarchitecturekotlin.viewmodel

import com.rosinante24.androidarchitecturekotlin.repository.UserRepository
import com.rosinante24.androidarchitecturekotlin.viewmodel.data.UsersList
import io.reactivex.Observable
import timber.log.Timber
import java.util.concurrent.TimeUnit

/**
 * Created by Rosinante24 on 29/10/17.
 */
class UserListViewModel(private val userRepository: UserRepository) {

    fun getUsers(): Observable<UsersList> {

        return userRepository.getUsers()
                .debounce(400, TimeUnit.MILLISECONDS)
                .map {
                    Timber.d("Mapping users to UIData...")
                    UsersList(it.take(10), "Top 10 Users")
                }
                .onErrorReturn {
                    UsersList(emptyList(), "An error occurred", it)
                }
    }
}