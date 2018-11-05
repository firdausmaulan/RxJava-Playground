package com.rxjava.example

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.rxjava.example.network.ApiService
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private val service = ApiService.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rxCallApi()
    }

    private fun print(data: String) {
        println(data)
        tvData.text = data
    }

    // Creating Observerable
    private fun rxInterval() {
        val myObserverable = Observable
                .interval(2, TimeUnit.SECONDS)
                .take(5)
                .startWith(1L)
                .subscribeOn(Schedulers.io()) // This tell the Observable to run the task on a background thread.
                .observeOn(AndroidSchedulers.mainThread()) // This tells the Observer to receive the data on android UI thread so that you can take any UI related actions.

        myObserverable.subscribe(object : Observer<Long> {
            override fun onSubscribe(d: Disposable) {
                println("onSubscribe")
            }

            override fun onNext(aLong: Long) {
                print("onNext : $aLong")
            }

            override fun onError(e: Throwable) {

            }

            override fun onComplete() {
                println("onComplete")
            }
        })
    }

    // Creating Observerable
    private fun rxTimer() {
        Observable.timer(5, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<Long> { // must Long
                    override fun onSubscribe(d: Disposable) {
                        println("onSubscribe")
                    }

                    override fun onNext(aLong: Long) {
                        print("onNext: $aLong")
                    }

                    override fun onError(e: Throwable) {

                    }

                    override fun onComplete() {
                        println("onComplete")
                    }
                })
    }

    // Creating Observerable
    @SuppressLint("CheckResult")
    private fun rxCallApi() {
        Observable.defer { service.getProfile() }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { response ->
                            this.print(response)
                        },
                        { err ->
                            println(err.message.toString())
                        },
                        {
                            println("onComplete")
                        })

        /*Observable.just(service.getProfile())
                .flatMap { return@flatMap it }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { response ->
                            this.print(response)
                        },
                        { err ->
                            println(err.message.toString())
                        },
                        {
                            println("onComplete")
                        })*/
    }
}
