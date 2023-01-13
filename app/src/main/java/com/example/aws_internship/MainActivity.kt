package com.example.aws_internship

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var preferenceName = "MyPrefsFile"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        Handler().postDelayed({
            val sharedPreferences = getSharedPreferences(preferenceName, 0)
            val hasLoggedIn : Boolean = sharedPreferences.getBoolean("hasLoggedIn",false)
//            val hasLoggedInHome : Boolean = sharedPreferences.getBoolean("hasLoggedInHome",false)

            if (hasLoggedIn){
                val intent = Intent(this@MainActivity,ProfileDetails::class.java)
                startActivity(intent)
                finish()
//            } else if (hasLoggedInHome) {
//                val intent = Intent(this@MainActivity, HomePage::class.java)
//                startActivity(intent)
//                finish()
            } else{
                val intent = Intent(this@MainActivity, GetStarted::class.java)
                startActivity(intent)
                finish()
            }

        }, 1500)

    }
}