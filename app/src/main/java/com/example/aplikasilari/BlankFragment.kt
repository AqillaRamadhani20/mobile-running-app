package com.example.aplikasilari

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment

class BlankFragment : Fragment(R.layout.fragment_blank) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val etNama = view.findViewById<EditText>(R.id.et_nama)
        val spinnerGender = view.findViewById<Spinner>(R.id.spinnerGender)
        val etEmail = view.findViewById<EditText>(R.id.et_email)
        val etPassword = view.findViewById<EditText>(R.id.et_password)
        val btnDaftar = view.findViewById<Button>(R.id.btn_daftar)

        btnDaftar.setOnClickListener {
            val nama = etNama.text.toString().trim()
            val gender = spinnerGender.selectedItem.toString()
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (nama.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(requireContext(), "Semua data harus diisi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val dataRegistrasi = DataRegistrasi(
                nama = nama,
                gender = gender,
                email = email,
                password = password
            )

            // Cek hasil sementara
            Toast.makeText(
                requireContext(),
                "Data: ${dataRegistrasi.nama}, ${dataRegistrasi.gender} Tersimpan",
                Toast.LENGTH_SHORT
            ).show()

            val loginFragment = LoginFragment()

            val bundle = Bundle()
            bundle.putParcelable("data_user", dataRegistrasi)

            loginFragment.arguments = bundle

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, loginFragment)
                .commit()
        }
    }
}