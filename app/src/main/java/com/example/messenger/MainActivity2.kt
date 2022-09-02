package com.example.messenger

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val actionBar = supportActionBar

        actionBar!!.hide()

        setContentView(R.layout.activity_main2)

        Handler().postDelayed(Runnable {display()},3000)
    }
   private fun display(){
        startActivity(Intent(this,ChatActivity5::class.java))
        finish()
    }
}