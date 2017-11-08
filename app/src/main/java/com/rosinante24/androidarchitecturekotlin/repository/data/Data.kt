package com.rosinante24.androidarchitecturekotlin.repository.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/*
 * Created by Rosinante24 on 29/10/17.
 */
@Entity(tableName = "users")
data class User(
        @PrimaryKey
        @ColumnInfo(name = "email")
        val email: String,
        @ColumnInfo(name = "firstName")
        val first: String,
        @ColumnInfo(name = "lastName")
        val last: String)