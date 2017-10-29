package com.rosinante24.androidarchitecturekotlin.repository.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.rosinante24.androidarchitecturekotlin.repository.data.User
import io.reactivex.Single

/**
 * Created by Rosinante24 on 29/10/17.
 */
@Dao
interface UserDao {

    @Query("SELECT * FROM users")
    fun getUsers(): Single<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users: List<User>)
}