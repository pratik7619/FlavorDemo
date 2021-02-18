package com.example.flavordemo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class RegistrationSuccessActivity : AppCompatActivity() {

    companion object {
        fun startIntent(context: Context) = Intent(context, RegistrationSuccessActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration_success)
    }

}