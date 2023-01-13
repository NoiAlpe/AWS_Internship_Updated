package com.example.aws_internship

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.example.aws_internship.databinding.ActivityLoginCredentialsBinding

class LoginCredentials : AppCompatActivity() {

    private lateinit var binding: ActivityLoginCredentialsBinding

    private var samplePass = "Admin123"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_credentials)

        binding = ActivityLoginCredentialsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvForgotPassword.setOnClickListener {
            val intent = Intent(this@LoginCredentials, ForgotPassword01::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnLoginContinue.setOnClickListener{
            val match = passwordValidation(binding.tiPassword.text.toString())
            if (match){
                binding.tilPassword.helperText = null
                binding.tilPassword.error = null
                val sharedPreferences = getSharedPreferences(MainActivity().preferenceName, 0)
                var editor = sharedPreferences.edit()

                editor.putBoolean("hasLoggedIn",false)
                editor.putBoolean("hasLoggedInHome",false)
                editor.putBoolean("hasLoggedInHome2",true)
                editor.commit()

                val intent = Intent(this@LoginCredentials, HomePage::class.java)
                startActivity(intent)
            } else {
                binding.tilPassword.error = "Password does not match"
            }


        }
// TODO: If want to check via text changed in textview, uncomment the onTextChanged

        binding.tiPassword.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                if (binding.tiPassword.text.toString().isNotEmpty()){
                    binding.tilPassword.error = null
                }

//                val error = passwordValidation(binding.tiPassword.text.toString())
//
//                if (error){
//                    binding.tilPassword.error = null
//                    binding.tilPassword.helperText = null
//                } else {
//                    binding.tilPassword.error = "Password does not match"
//                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })

    }

    private fun passwordValidation(password: String) : Boolean = password == samplePass
}