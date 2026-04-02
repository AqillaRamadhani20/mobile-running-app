package com.example.aplikasilari

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.fragment.app.Fragment

class Welcomefragment : Fragment(R.layout.fragment_welcome) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnAddRun = view.findViewById<ImageButton>(R.id.buttonAddRun)
        val btnProfile = view.findViewById<ImageButton>(R.id.buttonProfile)

        btnAddRun.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, RunLogFragment())
                .addToBackStack(null)
                .commit()
        }

        btnProfile.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ProfileFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}