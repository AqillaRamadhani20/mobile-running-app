package com.example.aplikasilari

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class LoginFragment : Fragment(R.layout.fragment_login) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val etEmail = view.findViewById<EditText>(R.id.et_email)
        val etPassword = view.findViewById<EditText>(R.id.et_password)
        val btnLogin = view.findViewById<Button>(R.id.btn_login)

        val dataUser = arguments?.getParcelable<DataRegistrasi>("data_user")

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            // validasi kosong
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(requireContext(), "Isi semua field", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // cek dengan data registrasi
            if (email == dataUser?.email && password == dataUser.password) {
                Toast.makeText(requireContext(), "Login berhasil", Toast.LENGTH_SHORT).show()

                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, Welcomefragment())
                    .commit()
            } else {
                Toast.makeText(requireContext(), "Email atau password salah", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}