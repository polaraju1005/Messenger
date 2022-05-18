package com.example.messenger

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class ChatActivity5 : AppCompatActivity() {
    lateinit var itemList: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var userList: ArrayList<User>
    private lateinit var adapter: HomeRecyclerAdapter
    lateinit var user: TextView
    lateinit var auth: FirebaseAuth
    lateinit var imgButton: ImageButton
    lateinit var mDbRef: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat5)

        auth = FirebaseAuth.getInstance()
        mDbRef = FirebaseDatabase.getInstance().getReference()

        userList = ArrayList()
        adapter = HomeRecyclerAdapter(this, userList)

        itemList = findViewById(R.id.RecyclerView)
        itemList.layoutManager = LinearLayoutManager(this)
        itemList.adapter = adapter

        mDbRef.child("user").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                userList.clear()
                for (postSnapshot in snapshot.children) {
                    val currentUser = postSnapshot.getValue(User::class.java)

                    if (auth.currentUser?.uid != currentUser?.uid) {
                        userList.add(currentUser!!)
                    }
                }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
        val actionBar = supportActionBar

        actionBar!!.title = "Messenger"

        user = findViewById(R.id.txtUser)
        imgButton = findViewById(R.id.imgBtn)

        imgButton.setOnClickListener {
            val i = Intent(this, ContactsActivity5::class.java)
            startActivity(i)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.chat, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.search -> Toast.makeText(this, "Search Clicked", Toast.LENGTH_SHORT).show()
        }
        if (item.itemId == R.id.logout) {
            auth.signOut()
            val i = Intent(this, LoginActivity5::class.java)
            finish()
            startActivity(i)
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}