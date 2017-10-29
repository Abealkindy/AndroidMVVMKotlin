package com.rosinante24.androidarchitecturekotlin.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.rosinante24.androidarchitecturekotlin.App
import com.rosinante24.androidarchitecturekotlin.R
import com.rosinante24.androidarchitecturekotlin.view.MvvmFragment
import com.rosinante24.androidarchitecturekotlin.viewmodel.data.UsersList
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_user_list.*
import timber.log.Timber
import java.net.ConnectException


/**
 * A simple [Fragment] subclass.
 */
class UserListFragment : MvvmFragment() {

    private val userListViewModel = App.injectUserListViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_user_list, container, false)
    }

    override fun onStart() {
        super.onStart()
        subscribe(userListViewModel.getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Timber.d("Received UIModel with ${it.users.size} users.")
                    showUsers(it)
                }, {
                    Timber.w(it)
                    showError()
                }))
    }

    private fun showUsers(data: UsersList) {
        when {
            data.error == null -> usersList.adapter = ArrayAdapter(context, android.R.layout.simple_list_item_1, data.users)
            data.error is ConnectException -> Timber.d("No connection, maybe inform user that data loaded from DB.")
            else -> showError()
        }
    }

    private fun showError() {
        Toast.makeText(context, "An error occurred :(", Toast.LENGTH_SHORT).show()
    }
}

// Required empty public constructor
