package com.rosinante24.androidarchitecturekotlin.view.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.rosinante24.androidarchitecturekotlin.R
import com.rosinante24.androidarchitecturekotlin.view.fragment.UserListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.frag_container, UserListFragment()).commit()
        }
    }
}
