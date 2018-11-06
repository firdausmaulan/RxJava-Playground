package com.rxjava.example.kotlin

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.functions.BiFunction
import io.reactivex.functions.Function
import org.junit.Test

class TransformingObservables {

    @Test
    fun rxBuffer() {
        Observable.just(1, 2, 3, 4, 5, 6, 7)
            .buffer(3)
            .subscribe(object : Observer<List<Int>> {
                override fun onSubscribe(d: Disposable) {
                    println("onSubscribe")
                }

                override fun onNext(integers: List<Int>) {
                    println("onNext: $integers")
                }

                override fun onError(e: Throwable) {

                }

                override fun onComplete() {
                    println("onComplete")
                }
            })
    }

    @Test
    fun rxFlatMap() {
        val observable1 = Observable.just(1, 2, 3)
        val observable2 = Observable.just(1, 2, 3)

        observable1.flatMap(object : Function<Int, ObservableSource<Int>> {
            @Throws(Exception::class)
            override fun apply(integer: Int): ObservableSource<Int> {
                return observable2
            }
        }).subscribe(object : Observer<Int> {
            override fun onSubscribe(d: Disposable) {
                println("onSubscribe")
            }

            override fun onNext(integer: Int) {
                println("onNext: " + integer)
            }

            override fun onError(e: Throwable) {

            }

            override fun onComplete() {
                println("onComplete")
            }
        })
    }

    @Test
    fun rxMap() {
        Observable.just(1, 2, 3, 4, 5)
            .map(object : Function<Int, Int> {
                @Throws(Exception::class)
                override fun apply(integer: Int): Int {
                    return integer * 2
                }
            })
            .subscribe(object : Observer<Int> {
                override fun onSubscribe(d: Disposable) {
                    println("onSubscribe")
                }

                override fun onNext(integer: Int) {
                    println("onNext: " + integer)
                }

                override fun onError(e: Throwable) {

                }

                override fun onComplete() {
                    println("onComplete")
                }
            })
    }

    @Test
    fun rxMapLambda() {
        Observable.just(1, 2, 3, 4, 5)
            .map { integer -> integer * 2 }
            .subscribe(
                { next ->
                    println("onNext: $next")
                },
                { error ->
                    println(error.message.toString())
                },
                {
                    println("onComplete")
                }
            )
    }

    @Test
    fun rxScan() {
        Observable.just(1, 2, 3, 4, 5)
            .scan(object : BiFunction<Int, Int, Int> {
                @Throws(Exception::class)
                override fun apply(integer: Int, integer2: Int): Int {
                    return integer + integer2
                }
            })
            .subscribe(object : Observer<Int> {
                override fun onSubscribe(d: Disposable) {
                    println("onSubscribe")
                }

                override fun onNext(integer: Int) {
                    println("onNext: $integer")
                }

                override fun onError(e: Throwable) {

                }

                override fun onComplete() {
                    println("onComplete")
                }
            })
    }

}