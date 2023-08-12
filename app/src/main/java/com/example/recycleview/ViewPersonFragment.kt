package com.example.recycleview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class ViewPersonFragment :Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the fragment's layout
        val rootView = inflater.inflate(R.layout.fragment_show_person, container, false)

        // Use findViewById on the rootView to find views within the layout
        val textView = rootView.findViewById<TextView>(R.id.textView2)
        val data = arguments?.getString("dataKey") ?: "No value passed"
        // Now you can work with the textView
        textView.text = data
        return rootView
    }
}