package com.example.aplikasilari

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class Berandafragment : Fragment(R.layout.fragment_beranda) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnLogin = view.findViewById<Button>(R.id.buttonLogin)
        val btnSignUp = view.findViewById<Button>(R.id.buttonSignUp)

        btnLogin.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, LoginFragment())
                .addToBackStack(null)
                .commit()
        }

        btnSignUp.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, BlankFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}