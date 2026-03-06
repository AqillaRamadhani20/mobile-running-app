package com.example.aplikasilari

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class Welcomefragment : Fragment(R.layout.fragment_welcome) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnNext = view.findViewById<Button>(R.id.buttonNext)

        btnNext.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, Berandafragment())
                .addToBackStack(null)
                .commit()
        }
    }
}