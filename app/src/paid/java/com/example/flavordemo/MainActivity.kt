package com.example.flavordemo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.flavordemo.data.PersonRepository
import com.example.flavordemo.database.entity.Person

class MainActivity : AppCompatActivity() {

    companion object {

        private val TAG = MainActivity::class.java.simpleName

        fun startIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstName = findViewById<EditText>(R.id.firstNameET)
        val lastName = findViewById<TextView>(R.id.lastNameET)
        val email = findViewById<EditText>(R.id.emailET)

        findViewById<Button>(R.id.registrationButton)
            .setOnClickListener {
                PersonRepository(this)
                    .insertPerson(
                        Person(
                            firstName = firstName.text.toString(),
                            email = email.text.toString(),
                            lastName = lastName.text.toString()
                        )
                    ).subscribe(
                        {
                            Toast.makeText(
                                this,
                                "Person Added",
                                Toast.LENGTH_SHORT
                            ).show()
                        },
                        {
                            Log.e(TAG, "Error while inserying person")
                        }
                    ).also {

                    }
            }
    }
}