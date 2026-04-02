package com.example.aplikasilari

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataRegistrasi(
    val nama: String,
    val gender: String,
    val email: String,
    val password: String
) : Parcelable