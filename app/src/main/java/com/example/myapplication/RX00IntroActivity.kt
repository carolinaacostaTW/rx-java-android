package com.example.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class RX00IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rx00_intro)

        val numbersObservable: Observable<String> =
            Observable.just("1", "2", "3", "4", "5", "6", "7", "8", "9", "10")

        val numbersObserver = object : Observer<String> {
            override fun onSubscribe(d: Disposable) {
                Log.d("TAG1", "onSubscribe Hilo: " + Thread.currentThread().name)
            }

            override fun onError(e: Throwable) {
                Log.d("TAG1", "onError Hilo: " + Thread.currentThread().name)
            }

            override fun onComplete() {
                Log.d(
                    "TAG1",
                    "onComplete: Se han emitido todos los datos del Hilo: " + Thread.currentThread().name
                )
            }

            override fun onNext(number: String) {
                Log.d(
                    "TAG1",
                    "onNext: Numero: $number" + "Hilo: " + Thread.currentThread().name
                )
            }
        }
        numbersObservable
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe(numbersObserver)
        //suscribeOn es donde queremos que se ejecute el observable.
        // observeOn es donde queremos que se ejecute el observer.
    }
}