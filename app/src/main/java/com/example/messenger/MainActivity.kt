package com.example.messenger

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionBar = supportActionBar
        actionBar!!.hide()

        Handler().postDelayed(Runnable { display() },2000)
    }
    private fun display(){
        startActivity(Intent(this,LoginActivity5::class.java))
        finish()
    }
}