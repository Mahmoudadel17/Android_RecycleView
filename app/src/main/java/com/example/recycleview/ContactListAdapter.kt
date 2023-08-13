package com.example.recycleview

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ContactListAdapter (val contactList: List<Contact>,private val onNavigate:(Int) -> Unit) : RecyclerView.Adapter<ContactListAdapter.ContactListView>(){
    var context: Context? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactListView {
        context = parent.context

        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.contact_item_view, parent, false)
        // Return a new holder instance
        return ContactListView(contactView)
    }

    override fun onBindViewHolder(holder: ContactListView, position: Int) {
        holder.myTextView.text = contactList.get(position).name
        holder.myButtom.text = "Click"


        holder.myButtom.setOnClickListener {
           // Toast.makeText(context, "you pressed item number ${position+1}", Toast.LENGTH_SHORT).show()
            onNavigate(position+1)
        }
    }
    override fun getItemCount(): Int {
        return contactList.size
    }


    class ContactListView(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val myTextView = itemView.findViewById<TextView>(R.id.contact_name)
        val myButtom = itemView.findViewById<Button>(R.id.message_button)
    }
}