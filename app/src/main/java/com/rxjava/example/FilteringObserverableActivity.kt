package com.rxjava.example

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.filtering_observerable.*
import java.util.concurrent.TimeUnit

class FilteringObserverableActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.filtering_observerable)
        rxSample()
    }

    private fun print(data: String) {
        println(data)
        myTextView.text = data
    }

    @SuppressLint("CheckResult")
    private fun rxDebounce() {
        RxTextView.textChanges(myEditText)
                .debounce(2, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe { value ->
                    myTextView.text = value
                }
    }

    fun rxSample() {
        Observable.just(1, 2, 3, 4, 5)
                .sample(1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(object : Observer<Int> {
                    override fun onSubscribe(d: Disposable) {
                        println("onSubscribe")
                    }

                    override fun onNext(integer: Int) {
                        print("onNext: $integer")
                    }

                    override fun onError(e: Throwable) {

                    }

                    override fun onComplete() {
                        println("onComplete")
                    }
                })
    }
}