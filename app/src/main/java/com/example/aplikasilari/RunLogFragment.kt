package com.example.aplikasilari

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.aplikasilari.databinding.FragmentRunLogBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class RunLogFragment : Fragment(R.layout.fragment_run_log) {

    private var _binding: FragmentRunLogBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentRunLogBinding.bind(view)

        val cal = Calendar.getInstance()
        val formatter = SimpleDateFormat("dd/MM/yyyy", Locale("id", "ID"))

        binding.etTanggal.setOnClickListener {
            DatePickerDialog(
                requireContext(),
                { _, year, month, day ->
                    cal.set(year, month, day)
                    binding.etTanggal.setText(formatter.format(cal.time))
                },
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            ).show()
        }


        binding.btnSave.setOnClickListener {
            val tgl = binding.etTanggal.text?.toString().orEmpty()
            val jarak = binding.etJarak.text?.toString().orEmpty()
            val durasi = binding.etDurasi.text?.toString().orEmpty()

            binding.tilTanggal.error = null
            binding.tilJarak.error = null
            binding.tilDurasi.error = null

            var valid = true
            if (tgl.isBlank()) { binding.tilTanggal.error = "Tanggal wajib diisi"; valid = false }
            if (jarak.isBlank()) { binding.tilJarak.error = "Jarak wajib diisi"; valid = false }
            if (durasi.isBlank()) { binding.tilDurasi.error = "Durasi wajib diisi"; valid = false }

            if (valid) {
                val run = Run(
                    tanggal = tgl,
                    jarakKm = jarak.toDouble(),
                    durasiMenit = durasi.toInt()
                )

                Toast.makeText(requireContext(), "Data tersimpan: ${run.jarakKm} km dalam ${run.durasiMenit} menit", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}