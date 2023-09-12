package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var buttonIntroduction: Button
    private lateinit var buttonDisposable: Button
    private lateinit var buttonCompositeDisposable: Button
    private lateinit var buttonOperadores: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonIntroduction = findViewById(R.id.btnRX00Introduction)

        buttonIntroduction.setOnClickListener {
            val intent = Intent(applicationContext, RX00IntroActivity::class.java)
            startActivity(intent)
        }

        buttonDisposable = findViewById(R.id.btnRX01Disposable)
        buttonDisposable.setOnClickListener {
            val intent = Intent(applicationContext, RX01DisposableActivity::class.java)
            startActivity(intent)
        }

        buttonCompositeDisposable = findViewById(R.id.btnRX02CompositeDisposable)
        buttonCompositeDisposable.setOnClickListener {
            val intent = Intent(applicationContext, RX02CompositeDisposableActivity::class.java)
            startActivity(intent)
        }

        buttonOperadores = findViewById(R.id.btnRX03Operadores)
        buttonOperadores.setOnClickListener {
            val intent = Intent(applicationContext, RX03OperadoresActivity::class.java)
            startActivity(intent)
        }
    }
}