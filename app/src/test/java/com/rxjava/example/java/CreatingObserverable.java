package com.rxjava.example.java;

import io.reactivex.*;
import io.reactivex.disposables.Disposable;
import org.junit.Test;

import java.util.concurrent.Callable;

public class CreatingObserverable {

    @Test
    public void rxCreate1() {
        Observable<String> myObserverable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("Hello");
                emitter.onComplete();
            }
        });
        Observer<String> myObserver = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext " + s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };
        myObserverable.subscribe(myObserver);
    }

    @Test
    public void rxCreate2() {
        Observable<String> myObserverable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("Hello");
                emitter.onNext("World");
                emitter.onComplete();
            }
        });
        Observer<String> myObserver = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext " + s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };
        myObserverable.subscribe(myObserver);
    }

    @Test
    public void rxJust1() {
        Observable<String> myObserverable = Observable.just("Hello");
        Observer<String> myObserver = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("1 onSubscribe");
            }

            @Override
            public void onNext(String s) {
                System.out.println("2 " + s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                System.out.println("3 onComplete");
            }
        };
        myObserverable.subscribe(myObserver);
    }

    @Test
    public void rxJust2() {
        Observable<String> myObserverable = Observable.just("Hello");
        myObserverable.subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("1 onSubscribe");
            }

            @Override
            public void onNext(String s) {
                System.out.println("2 " + s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                System.out.println("3 onComplete");
            }
        });
    }

    @Test
    public void rxJust3() {
        Observable<String> myObserverable = Observable.just("Hello", "World");
        myObserverable.subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("1 onSubscribe");
            }

            @Override
            public void onNext(String s) {
                System.out.println("2 " + s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                System.out.println("3 onComplete");
            }
        });
    }


    @Test
    public void rxJust4() {
        Observable<Integer> myObserverable = Observable.just(1, 2, 3, 4, 5);
        myObserverable.subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext : " + integer);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });
    }

    @Test
    public void rxJust5() {
        Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        System.out.println("onSubscribe");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("onNext: " + integer);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete");
                    }
                });
    }

    @Test
    public void rxJust6() {
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Observable.just(numbers)
                .subscribe(new Observer<Integer[]>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        System.out.println("onSubscribe");
                    }

                    @Override
                    public void onNext(Integer[] integer) {
                        System.out.println("onNext: " + integer.length);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete");
                    }
                });
    }

    @Test
    public void rxFrom() {
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Observable.fromArray(numbers)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        System.out.println("onSubscribe");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("onNext: " + integer);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete");
                    }
                });
    }

    @Test
    public void rxRange() {
        Observable.range(1, 10)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        System.out.println("onSubscribe");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("onNext: " + integer);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete");
                    }
                });
    }

    @Test
    public void rxRepeat() {
        Observable.range(1, 5).repeat(5)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        System.out.println("onSubscribe");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("onNext: " + integer);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete");
                    }
                });
    }

    @Test
    public void rxEmpty() {
        Observable<Integer> myObserverable = Observable.empty();
        //Observable<Integer> myObserverable = Observable.never();

        myObserverable.subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext : " + integer);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });
    }

    @Test
    public void RxDefer() {
        Observable.defer(new Callable<ObservableSource<String>>() {
            @Override
            public ObservableSource<String> call() throws Exception {
                return Observable.just("Hello", "World");
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext : " + s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });
    }

    @Test
    public void rxStart() {
        // Unresolve reference
        // Observable.start
    }
}