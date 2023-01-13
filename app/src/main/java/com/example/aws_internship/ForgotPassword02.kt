package com.example.aws_internship

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import com.example.aws_internship.databinding.ActivitySignUpBinding

class ForgotPassword02 : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password02)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.tiPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val error = passwordValidation(binding.tiPassword.text.toString())

                if (error != null){
                    binding.tilPassword.error = error
                } else {
                    binding.tilPassword.error = null
                }

                if (binding.tiRetypePassword.text.toString().isNotEmpty()) {

                    val errorText = passwordMatch(binding.tiPassword.text.toString(), binding.tiRetypePassword.text.toString())

                    if (errorText == "Password Matches"){
                        binding.tilRetypePassword.error = null
                        binding.tilRetypePassword.helperText = errorText
                        binding.tilPassword.helperText = errorText
                    } else {
                        binding.tilRetypePassword.error = errorText
                    }
                }

            }

            override fun afterTextChanged(p0: Editable?) {
//                binding.tilPassword.helperText = passwordValidation(binding.tiPassword.text.toString())
            }

        })

        binding.tiRetypePassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val error = passwordMatch(binding.tiPassword.text.toString(), binding.tiRetypePassword.text.toString())

                if (error == "Password Matches"){
                    binding.tilRetypePassword.error = null
                    binding.tilRetypePassword.helperText = error
                    binding.tilPassword.helperText = error
                } else {
                    binding.tilRetypePassword.error = error
                    binding.tilPassword.helperText = null
                }

            }

            override fun afterTextChanged(p0: Editable?) {
                val error = passwordMatch(binding.tiPassword.text.toString(), binding.tiRetypePassword.text.toString())

                if (error == "Password Matches"){
                    binding.tilRetypePassword.error = null
                    binding.tilRetypePassword.helperText = error
                } else {
                    binding.tilRetypePassword.error = error
                    binding.tilPassword.helperText = null
                }
            }

        })

        binding.btnProceed.setOnClickListener {
            if (binding.tiPassword.text.toString().isNotEmpty()){
                if (binding.tiRetypePassword.text.toString().isNotEmpty()){
                    if (passwordMatch(binding.tiPassword.text.toString(),binding.tiRetypePassword.text.toString()) == "Password Matches"){
                        val sharedPreferences = getSharedPreferences(MainActivity().preferenceName, 0)
                        var editor = sharedPreferences.edit()

                        editor.putBoolean("hasLoggedIn",false)
                        editor.putBoolean("hasLoggedInHome",false)
                        editor.putBoolean("hasLoggedInHome2",true)
                        editor.commit()

                        val intent = Intent(this@ForgotPassword02, HomePage::class.java)
                        startActivity(intent)
                    }
                } else{
                    binding.tilRetypePassword.error = "This field is required"
                }
            } else{
                binding.tilPassword.error = "This field is required"
            }
        }

        binding.ibBackButton.setOnClickListener {
            super.onBackPressed()
        }

    }


    private fun passwordValidation(password: String) : String? {
        return if (passwordValidationNumeric(password) && (passwordValidationCharLength(password) || passwordValidationAlpha(password))){
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