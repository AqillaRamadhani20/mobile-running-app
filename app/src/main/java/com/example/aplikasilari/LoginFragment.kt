package com.example.aplikasilari

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment

class LoginFragment : Fragment(R.layout.fragment_login) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnLogin = view.findViewById<Button>(R.id.btn_login)

        btnLogin.setOnClickListener {

            Toast.makeText(requireContext(), "Login berhasil", Toast.LENGTH_SHORT).show()

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, Welcomefragment())
                .commit()
        }
    }
}