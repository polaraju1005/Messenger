package com.example.messenger

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import de.hdodenhof.circleimageview.CircleImageView

class HomeRecyclerAdapter(val context:Context, val userList:ArrayList<User>):RecyclerView.Adapter<HomeRecyclerAdapter.HomeViewHolder>() {
    class HomeViewHolder(view: View):RecyclerView.ViewHolder(view){
        var uname = itemView.findViewById<TextView>(R.id.txtUsername)
        var txtLastMsg = itemView.findViewById<TextView>(R.id.txtLastMsg)
        var txtMsgTime = itemView.findViewById<TextView>(R.id.msgTime)
        var profile = itemView.findViewById<CircleImageView>(R.id.profile)
        val stack = itemView.findViewById<RelativeLayout>(R.id.home)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.home_recycler_view,parent,false)
        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(holder:HomeViewHolder, position: Int) {
        val currentUser:User = userList[position]

        holder.uname.text = currentUser.name
        //holder.txtLastMsg.text = currentUser.name
        //holder.txtMsgTime.text = currentUser.name

        holder.itemView.setOnClickListener {
            val i = Intent(context,ChatOpenActivity::class.java)

            i.putExtra("name",currentUser.name)
            i.putExtra("uid",currentUser.uid)

            context.startActivity(i)
        }

    }

    override fun getItemCount(): Int {
       return userList.size
    }

}