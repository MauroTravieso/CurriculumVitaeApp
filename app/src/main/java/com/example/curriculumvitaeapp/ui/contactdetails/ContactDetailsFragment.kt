package com.example.curriculumvitaeapp.ui.contactdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.curriculumvitaeapp.R

class ContactDetailsFragment : Fragment() {

    private lateinit var toolsViewModel: ContactDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        toolsViewModel =
            ViewModelProviders.of(this).get(ContactDetailsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_contactdetails, container, false)
        val textView: TextView = root.findViewById(R.id.text_gallery)
        toolsViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}