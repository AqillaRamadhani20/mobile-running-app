package com.example.aplikasilari

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnEdit = view.findViewById<Button>(R.id.btn_edit)
        val btnLogout = view.findViewById<Button>(R.id.btn_logout)
        val btnRun = view.findViewById<Button>(R.id.btn_run)

        btnEdit.setOnClickListener {
            Toast.makeText(requireContext(), "Edit", Toast.LENGTH_SHORT).show()
        }

        btnLogout.setOnClickListener {
            Toast.makeText(requireContext(), "Logout", Toast.LENGTH_SHORT).show()
        }

        btnRun.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, RunLogFragment())
                .commit()
        }
    }
}