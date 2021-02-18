package com.example.flavordemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.flavordemo.data.PersonRepository

class SplashScreen : AppCompatActivity() {

    companion object {
        private val TAG = SplashScreen::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        openMain()
    }

    private fun openMain() {
        PersonRepository(this)
            .fetchPerson()
            .subscribe(
                {
                    startActivity(
                        RegistrationSuccessActivity.startIntent(this)
                    )
                },
                {
                    Log.e(TAG, "Error $it", it)
                    startActivity(
                        MainActivity.startIntent(this)
                    )
                }
            ).also {

            }
    }

}