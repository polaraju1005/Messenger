package com.example.messenger

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity3 : AppCompatActivity() {
    lateinit var mail: EditText
    lateinit var password: EditText
    lateinit var signup: Button
    lateinit var auth: FirebaseAuth
    lateinit var login: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        title = "register"
        mail = findViewById(R.id.etEmail)
        password = findViewById(R.id.etPassword)
        signup = findViewById(R.id.btnSignup)
        login = findViewById(R.id.txtLogin)
        auth = FirebaseAuth.getInstance()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        signup.setOnClickListener {
            signup()
        }
        login.setOnClickListener {
            val intent = Intent(this, LoginActivity5::class.java)
            startActivity(intent)
        }
    }

    private fun signup() {
        auth.createUserWithEmailAndPassword(mail.text.toString(), password.text.toString())
            .addOnCompleteListener(this) { it ->
                if (it.isSuccessful) {
                    val intent2 = Intent(this, MainActivity4::class.java)
                    intent2.putExtra("name", mail.text.toString())
                    startActivity(intent2)
                } else {
                    Toast.makeText(this, "You already have an account", Toast.LENGTH_SHORT).show()
                }
            }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}