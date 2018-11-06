package com.rxjava.example.kotlin

import org.junit.Test

import java.util.concurrent.TimeUnit

import io.reactivex.CompletableObserver
import io.reactivex.MaybeObserver
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Predicate

class FilteringObservables {

    @Test
    fun rxDebounce() {
        Observable.just(1, 2, 3, 4, 5)
                .debounce(1, TimeUnit.SECONDS)
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
    fun rxDistinct() {
        Observable.just(1, 1, 2, 2, 3, 3, 4, 5)
                .distinct()
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
    fun rxElementAt() {
        Observable.just(1, 2, 3, 4, 5)
                .elementAt(2)
                .subscribe(object : MaybeObserver<Int> {
                    override fun onSubscribe(d: Disposable) {
                        println("onSubscribe")
                    }

                    override fun onSuccess(integer: Int) {
                        println("onNext: $integer")
                    }

                    override fun onError(e: Throwable) {
                        println("onError: " + e.message)
                    }

                    override fun onComplete() {
                        println("onComplete")
                    }
                })
    }

    @Test
    fun rxFilter() {
        Observable.just(1, 2, 3, 4, 5)
                .filter(object : Predicate<Int> {
                    @Throws(Exception::class)
                    override fun test(integer: Int): Boolean {
                        return integer % 2 == 1
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

    @Test
    fun rxFirst() {
        Observable.just(6, 7, 8, 9, 10)
                .first(0)
                .subscribe(object : SingleObserver<Int> {
                    override fun onSubscribe(d: Disposable) {
                        println("onSubscribe")
                    }

                    override fun onSuccess(integer: Int) {
                        println("onNext: " + integer)
                    }

                    override fun onError(e: Throwable) {

                    }
                })
    }

    @Test
    fun rxFirstElement() {
        Observable.just(1, 2, 3, 4, 5)
                .firstElement()
                .subscribe(object : MaybeObserver<Int> {
                    override fun onSubscribe(d: Disposable) {
                        println("onSubscribe")
                    }

                    override fun onSuccess(integer: Int) {
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
    fun rxIgnoreElements() {
        Observable.just(1, 2, 3, 4, 5)
                .ignoreElements()
                .subscribe(object : CompletableObserver {
                    override fun onSubscribe(d: Disposable) {
                        println("onSubscribe")
                    }

                    override fun onComplete() {
                        println("onComplete")
                    }

                    override fun onError(e: Throwable) {

                    }
                })
    }

    @Test
    fun rxLast() {
        Observable.just(6, 7, 8, 9, 10)
                .last(0)
                .subscribe(object : SingleObserver<Int> {
                    override fun onSubscribe(d: Disposable) {
                        println("onSubscribe")
                    }

                    override fun onSuccess(integer: Int) {
                        println("onNext: $integer")
                    }

                    override fun onError(e: Throwable) {

                    }
                })
    }

    @Test
    fun rxLastElement() {
        Observable.just(1, 2, 3, 4, 5)
                .lastElement()
                .subscribe(object : MaybeObserver<Int> {
                    override fun onSubscribe(d: Disposable) {
                        println("onSubscribe")
                    }

                    override fun onSuccess(integer: Int) {
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
    fun rxSample() {
        Observable.just(1, 2, 3, 4, 5)
                .sample(1, TimeUnit.SECONDS)
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
    fun rxSkip() {
        Observable.just(6, 7, 8, 9, 10)
                .skip(2)
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
    fun rxSkipLast() {
        Observable.just(6, 7, 8, 9, 10)
                .skipLast(2)
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
    fun rxTake() {
        Observable.just(6, 7, 8, 9, 10)
                .take(3)
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
    fun rxTakeLast() {
        Observable.just(6, 7, 8, 9, 10)
                .takeLast(3)
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
