package com.example.aws_internship

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.aws_internship.databinding.ActivitySignup01Binding

class Signup01 : AppCompatActivity() {

    private lateinit var binding: ActivitySignup01Binding
    private var email = "sample@email.com"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_01)

        binding = ActivitySignup01Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnProceed.setOnClickListener{

            if (binding.tiEmail.text.toString() != email) {
                val intent = Intent(this@Signup01, SignUp::class.java)
                startActivity(intent)
            }

            else {
                Toast.makeText(this,"Account Exists, Going to Log-in page",Toast.LENGTH_SHORT).show()
                val intent = Intent(this@Signup01, LoginCredentials::class.java)
                startActivity(intent)
            }
        }



    }
}