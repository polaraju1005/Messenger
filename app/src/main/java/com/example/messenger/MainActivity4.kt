package com.example.messenger

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.TextView

class MainActivity4 : AppCompatActivity() {
    lateinit var email:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        Handler().postDelayed({display()},3000)
        email = findViewById(R.id.txtEmail)
        supportActionBar?.hide()

        val x = intent.getStringExtra("name")
        email.text = x
    }
    fun display(){
        startActivity(Intent(this,LoginActivity5::class.java))
        finish()
    }
}