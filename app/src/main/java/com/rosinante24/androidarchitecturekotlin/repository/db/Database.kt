package com.rosinante24.androidarchitecturekotlin.repository.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.rosinante24.androidarchitecturekotlin.repository.data.User

/*
 * Created by Rosinante24 on 29/10/17.
 */
@Database(entities = arrayOf(User::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}