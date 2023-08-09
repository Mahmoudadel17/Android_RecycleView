package com.example.recycleview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ContactListFragment :  Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_contact_list, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mContactRecycleView: RecyclerView = view.findViewById<RecyclerView>(R.id.my_contact_recycle_view)
        val mContactAdapter : ContactListAdapter = ContactListAdapter(createContactsList(50))


        val layoutManager  = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        mContactRecycleView.layoutManager = layoutManager
        mContactRecycleView.adapter = mContactAdapter


    }

}