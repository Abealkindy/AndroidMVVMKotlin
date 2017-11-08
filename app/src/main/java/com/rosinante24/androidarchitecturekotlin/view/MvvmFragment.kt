package com.rosinante24.androidarchitecturekotlin.view

import android.support.v4.app.Fragment
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/*
 * Created by Rosinante24 on 29/10/17.
 */
open class MvvmFragment : Fragment() {

    private val subscriptions = CompositeDisposable()

    fun subscribe(disposable: Disposable): Disposable {
        subscriptions.add(disposable)
        return disposable
    }

    override fun onStop() {
        super.onStop()
        subscriptions.clear()
    }
}