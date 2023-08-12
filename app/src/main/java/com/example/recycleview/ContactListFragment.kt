package com.example.recycleview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ContactListFragment(private val start:Int, private val contactNumbers:Int) :  Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_contact_list, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mContactRecycleView: RecyclerView = view.findViewById(R.id.my_contact_recycle_view)
        val mContactAdapter = ContactListAdapter(createContactsList(start,contactNumbers),navigateToFragment)


        val layoutManager  = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        mContactRecycleView.layoutManager = layoutManager
        mContactRecycleView.adapter = mContactAdapter
    }

    private val navigateToFragment = fun(position:Int) {
        val bundle = Bundle()
        bundle.putString("dataKey", "you pressed item number $position")

        val viewPersonFragment = ViewPersonFragment()
        viewPersonFragment.arguments = bundle

        parentFragmentManager.beginTransaction()
            .replace(R.id.fragmentHome,viewPersonFragment)
            .addToBackStack(null)
            .commit()
    }


}