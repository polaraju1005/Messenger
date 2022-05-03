package com.example.messenger

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity5 : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var login: Button
    lateinit var auth: FirebaseAuth
    lateinit var register: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login5)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = "User Login"
        email = findViewById(R.id.etLoginEmail)
        password = findViewById(R.id.etLoginPassword)
        login = findViewById(R.id.btnLogin)
        register = findViewById(R.id.txtRegister)
        auth = FirebaseAuth.getInstance()

        login.setOnClickListener {
            login()
        }

        register.setOnClickListener {
            val i = Intent(this, MainActivity3::class.java)
            startActivity(i)
        }
    }

    private fun login() {
        auth.signInWithEmailAndPassword(email.text.toString(), password.text.toString())
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    val i = Intent(this, ChatActivity5::class.java)
                    startActivity(i)
                } else {
                    Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show()
                }
            }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}