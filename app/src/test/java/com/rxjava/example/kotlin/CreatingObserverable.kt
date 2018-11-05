package com.rxjava.example.kotlin

import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.ObservableSource
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import org.junit.Test
import java.util.concurrent.Callable

class CreatingObserverable {

    @Test
    fun rxCreate1() {
        val myObserverable = Observable.create(ObservableOnSubscribe<String> { emitter ->
            emitter.onNext("Hello")
            emitter.onComplete()
        })
        val myObserver = object : Observer<String> {
            override fun onSubscribe(d: Disposable) {
                println("onSubscribe")
            }

            override fun onNext(s: String) {
                println("onNext $s")
            }

            override fun onError(e: Throwable) {

            }

            override fun onComplete() {
                println("onComplete")
            }
        }
        myObserverable.subscribe(myObserver)
    }

    @Test
    fun rxCreate2() {
        val myObserverable = Observable.create(ObservableOnSubscribe<String> { emitter ->
            emitter.onNext("Hello")
            emitter.onNext("World")
            emitter.onComplete()
        })
        val myObserver = object : Observer<String> {
            override fun onSubscribe(d: Disposable) {
                println("onSubscribe")
            }

            override fun onNext(s: String) {
                println("onNext $s")
            }

            override fun onError(e: Throwable) {

            }

            override fun onComplete() {
                println("onComplete")
            }
        }
        myObserverable.subscribe(myObserver)
    }

    @Test
    fun rxJust1() {
        val myObserverable = Observable.just("Hello")
        val myObserver = object : Observer<String> {
            override fun onSubscribe(d: Disposable) {
                println("1 onSubscribe")
            }

            override fun onNext(s: String) {
                println("2 $s")
            }

            override fun onError(e: Throwable) {

            }

            override fun onComplete() {
                println("3 onComplete")
            }
        }
        myObserverable.subscribe(myObserver)
    }

    @Test
    fun rxJust2() {
        val myObserverable = Observable.just("Hello")
        myObserverable.subscribe(object : Observer<String> {
            override fun onSubscribe(d: Disposable) {
                println("1 onSubscribe")
            }

            override fun onNext(s: String) {
                println("2 $s")
            }

            override fun onError(e: Throwable) {

            }

            override fun onComplete() {
                println("3 onComplete")
            }
        })
    }

    @Test
    fun rxJust3() {
        val myObserverable = Observable.just("Hello", "World")
        myObserverable.subscribe(object : Observer<String> {
            override fun onSubscribe(d: Disposable) {
                println("1 onSubscribe")
            }

            override fun onNext(s: String) {
                println("2 $s")
            }

            override fun onError(e: Throwable) {

            }

            override fun onComplete() {
                println("3 onComplete")
            }
        })
    }

    @Test
    fun rxJust4() {
        val myObserverable = Observable.just(1, 2, 3, 4, 5)
        myObserverable.subscribe(object : Observer<Int> {
            override fun onSubscribe(d: Disposable) {
                println("onSubscribe")
            }

            override fun onNext(integer: Int) {
                println("onNext $integer")
            }

            override fun onError(e: Throwable) {

            }

            override fun onComplete() {
                println("onComplete")
            }
        })
    }

    @Test
    fun rxJust5() {
        Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
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

    @Test
    fun rxJust6() {
        val numbers = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        Observable.just(numbers)
            .subscribe(object : Observer<Array<Int>> {
                override fun onSubscribe(d: Disposable) {
                    println("onSubscribe")
                }

                override fun onNext(integer: Array<Int>) {
                    println("onNext: " + integer.size)
                }

                override fun onError(e: Throwable) {

                }

                override fun onComplete() {
                    println("onComplete")
                }
            })
    }

    @Test
    fun rxFrom() {
        val numbers = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        Observable.fromArray(*numbers)
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

    @Test
    fun rxRange() {
        Observable.range(1, 10)
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

    @Test
    fun rxRepeat() {
        Observable.range(1, 5).repeat(5)
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

    @Test
    fun rxEmpty() {
        val myObserverable = Observable.empty<Int>()
        //val myObserverable = Observable.never<Int>()

        myObserverable.subscribe(object : Observer<Int> {
            override fun onSubscribe(d: Disposable) {
                println("onSubscribe")
            }

            override fun onNext(integer: Int) {
                println("onNext : $integer")
            }

            override fun onError(e: Throwable) {

            }

            override fun onComplete() {
                println("onComplete")
            }
        })
    }

    @Test
    fun RxDefer() {
        Observable.defer { Observable.just(1, 2, 3) }
            .subscribe(object : Observer<Int> {
                override fun onSubscribe(d: Disposable) {
                    println("onSubscribe")
                }

                override fun onNext(integer: Int) {
                    println("onNext : $integer")
                }

                override fun onError(e: Throwable) {

                }

                override fun onComplete() {
                    println("onComplete")
                }
            })
    }

    @Test
    fun rxStart() {
        // Unresolve reference
        // Observable.start
    }
}