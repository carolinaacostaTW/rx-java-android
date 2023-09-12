package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class RX03OperadoresActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rx03_operadores)

//        testJust()

//        testJustArray()

//        testJustFromArray()

//        testRange()

        testRepeat()

    }

    private fun testJust() {
        Log.d("TAG1", "-----------------Just---------------")
        Observable.just("1", "2", "3", "4", "5", "6", "7", "8", "9", "10")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<String> {
                override fun onSubscribe(d: Disposable) {
                }

                override fun onError(e: Throwable) {
                }

                override fun onNext(t: String) {
                    Log.d("TAG 1", "Just->onNext$t")
                }

                override fun onComplete() {
                }
            })
    }

    private fun testJustArray() {
        //enviar en vez de formato String cada uno, envia un array de string
        Log.d("TAG1", "-----------------JustArray---------------")
        val numbers = arrayOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10")
        Observable.just(numbers)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<Array<String>> {
                override fun onSubscribe(d: Disposable) {
                }

                override fun onError(e: Throwable) {
                }

                override fun onComplete() {
                }

                override fun onNext(t: Array<String>) {
                    Log.d("TAG 1", "JustArray->onNext ${t.size}")
                }
            })
    }

    private fun testJustFromArray() {
        //aqui cada elemento del Array es emitido uno en uno y no all en uno como en JustArray.
        Log.d("TAG1", "-----------------JustFromArray---------------")
        val numbers = arrayOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10")
        Observable.fromArray(*numbers)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<String> {
                override fun onSubscribe(d: Disposable) {
                }

                override fun onError(e: Throwable) {
                }

                override fun onComplete() {
                }

                override fun onNext(t: String) {
                    Log.d("TAG 1", "JustFromArray->onNext$t")
                }
            })
    }

    private fun testRange() {
        Log.d("TAG1", "-----------------Range---------------")
        //crea observable mediante una secuencia de enteros generados. Le pasamos el valor inicial y el de la secuencia. Ejemplo: For que empiece por 0 ++.
        Observable.range(7, 17)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<Int> {
                override fun onSubscribe(d: Disposable) {
                }

                override fun onError(e: Throwable) {
                }

                override fun onComplete() {
                }

                override fun onNext(t: Int) {
                    Log.d("TAG 1", "Range->onNext $t")
                }
            })
    }

    private fun testRepeat() {
        //repite tantas veces le digas.
        Log.d("TAG1", "-----------------Repeat---------------")
        Observable.range(10, 3)
            .repeat(4)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<Int> {
                override fun onSubscribe(d: Disposable) {
                }

                override fun onError(e: Throwable) {
                }

                override fun onComplete() {
                }

                override fun onNext(t: Int) {
                    Log.d("TAG 1", "Repeat->onNext $t")
                }
            })
    }
}
