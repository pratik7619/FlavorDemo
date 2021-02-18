package com.example.flavordemo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
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

        val name = findViewById<EditText>(R.id.nameET)
        val email = findViewById<EditText>(R.id.emailET)

        findViewById<Button>(R.id.registrationButton).setOnClickListener {
            PersonRepository(this)
                .insertPerson(
                    Person(
                        name = name.text.toString(),
                        email = email.text.toString()
                    )
                )
                .subscribe(
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
                )
        }
    }
}