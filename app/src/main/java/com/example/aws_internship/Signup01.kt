package com.example.aws_internship

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
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
            binding.tilEmail.helperText = validEmail()
            if ((binding.tiEmail.text.toString() != email)
                && (binding.tiEmail.text.toString().isNotEmpty())
                && Patterns.EMAIL_ADDRESS.matcher(binding.tiEmail.text.toString()).matches()) {
                val intent = Intent(this@Signup01, SignUp::class.java)
                startActivity(intent)
            }

            else if (Patterns.EMAIL_ADDRESS.matcher(binding.tiEmail.text.toString()).matches()) {
                val intent = Intent(this@Signup01, LoginCredentials::class.java)
                startActivity(intent)
            }
        }

        binding.tiEmail.addTextChangedListener( object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.tilEmail.helperText = validEmail()
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
    }


    private fun validEmail(): String? {
        val emailText = binding.tiEmail.text.toString()
        if (emailText.isEmpty()) {
            return "Required"
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
            return "Invalid Email Address"
        }

        return null
    }
}