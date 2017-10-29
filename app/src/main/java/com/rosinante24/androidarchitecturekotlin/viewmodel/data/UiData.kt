package com.rosinante24.androidarchitecturekotlin.viewmodel.data

import com.rosinante24.androidarchitecturekotlin.repository.data.User

/**
 * Created by Rosinante24 on 29/10/17.
 */
data class UsersList(val users: List<User>, val message: String, val error: Throwable? = null)