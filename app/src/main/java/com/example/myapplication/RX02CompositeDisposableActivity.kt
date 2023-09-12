package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.schedulers.Schedulers

class RX02CompositeDisposableActivity : AppCompatActivity() {

    private lateinit var numberObserver: DisposableObserver<String>
    private lateinit var numberLetterObserver: DisposableObserver<String>

    private lateinit var numberObservable: Observable<String>
    private lateinit var numberLetterObservable: Observable<String>

    private lateinit var compositeDisposable: CompositeDisposable


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rx02_composite_disposable)

        compositeDisposable = CompositeDisposable()

        numberObservable = Observable.just("1", "2", "3", "4", "5", "6", "7", "8", "9", "10")
        numberLetterObservable = Observable.just("uno", "dos", "tres", "cuatro", "cinco", "seis")

        numberObserver = object : DisposableObserver<String>() {
            override fun onNext(s: String) {
                Log.d("TAG1", "onNextNumero: $s")
            }

            override fun onError(e: Throwable) {
                Log.d("TAG1", "onErrorNumero:")
            }

            override fun onComplete() {
                Log.d("TAG1", "onCompleteNumero: ")
            }
        }

        numberLetterObserver = object : DisposableObserver<String>() {
            override fun onNext(t: String) {
                Log.d("TAG1", "onNextLetra: $t");
            }

            override fun onError(e: Throwable) {
                Log.d("TAG1", "onErrorLetra: ");
            }

            override fun onComplete() {
                Log.d("TAG1", "onCompleteLetra: ");
            }
        }
        compositeDisposable.add(
            numberObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(numberObserver)
        )
        compositeDisposable.add(
            numberLetterObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(numberLetterObserver)
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}