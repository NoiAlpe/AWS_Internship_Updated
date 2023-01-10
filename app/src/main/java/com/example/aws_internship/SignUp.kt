package com.example.aws_internship

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import com.example.aws_internship.databinding.ActivitySignUpBinding
import com.example.aws_internship.databinding.ActivitySignup01Binding

class SignUp : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.tiPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.tilPassword.helperText = passwordValidation(binding.tiPassword.text.toString())
                if (binding.tiRetypePassword.text.toString().isNotEmpty()) {
                    binding.tilRetypePassword.helperText = passwordMatch(binding.tiPassword.text.toString(), binding.tiRetypePassword.text.toString())
                }

            }

            override fun afterTextChanged(p0: Editable?) {
                binding.tilPassword.helperText = passwordValidation(binding.tiPassword.text.toString())
            }

        })

        binding.tiRetypePassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.tilRetypePassword.helperText = passwordMatch(binding.tiPassword.text.toString(), binding.tiRetypePassword.text.toString())
            }

            override fun afterTextChanged(p0: Editable?) {
                binding.tilRetypePassword.helperText = passwordMatch(binding.tiPassword.text.toString(), binding.tiRetypePassword.text.toString())
            }

        })

        binding.btnProceed.setOnClickListener {
            val intent = Intent(this@SignUp, EmailOTP::class.java)
            startActivity(intent)
        }

        binding.ibBackButton.setOnClickListener {
            val intent = Intent (this@SignUp, Signup01::class.java)
            startActivity(intent)
        }

    }


    private fun passwordValidation(password: String) : String? {
        return if (passwordValidationNumeric(password) && passwordValidationCharLength(password) && passwordValidationAlpha(password)){
            "Minimum 6 Alphanumeric Characters"
        } else if (passwordValidationNumeric(password)){
            "At least 1 number is required"
        } else if (passwordValidationAlpha(password)){
            "At least 1 letter is required"
        }else if (passwordValidationCharLength(password)){
            "Minimum 6 Characters"
        } else null

    }

    private fun passwordMatch(password: String, passwordRetype: String) : String? {

        Log.i("SIGN UP","PASSWORD: $password, PASSWORD RETYPE: $passwordRetype")

        return if (password == passwordRetype) {
            "Password Matches"
        } else if (passwordRetype.isNotEmpty()) {
            "Password doesn't match"
        } else if (passwordRetype.isEmpty()) {
            "This field is required"
        } else {
            null
        }

    }

    private fun passwordValidationCharLength (password : String) : Boolean = password.length < 6
    private fun passwordValidationNumeric (password: String) : Boolean = !password.contains("[0-9]".toRegex())
    private fun passwordValidationAlpha (password: String) : Boolean = !password.contains("[A-Za-z]".toRegex())

}