package com.rosinante24.androidarchitecturekotlin.repository.api

import com.rosinante24.androidarchitecturekotlin.repository.data.User
import io.reactivex.Observable
import retrofit2.http.GET

/*
 * Created by Rosinante24 on 29/10/17.
 */
interface UserApi {

    @GET("6de6abfedb24f889e0b5f675edc50deb?fmt=raw&sole")
    fun getUsers(): Observable<List<User>>
}
