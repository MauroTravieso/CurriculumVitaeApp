package com.example.curriculumvitaeapp.ui.workexperience

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.curriculumvitaeapp.R

class WorkExperienceFragment : Fragment() {

    private lateinit var slideshowViewModel: WorkExperienceViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        slideshowViewModel =
            ViewModelProviders.of(this).get(WorkExperienceViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_workexperience, container, false)
        val textView: TextView = root.findViewById(R.id.text_slideshow)
        slideshowViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}