package com.example.aws_internship

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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
                Toast.makeText(this@SignUp, "${if (passwordValidationAlphaNumeric(binding.tiPassword.text.toString())) "" else "Password should be Alpha Numeric" } ${if (passwordValidationCharLength(binding.tiPassword.toString())) "and should be 6 digits" else ""}", Toast.LENGTH_SHORT).show()
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })

        binding.tiRetypePassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Toast.makeText(this@SignUp, if (!binding.tiRetypePassword.text.toString().equals(binding.tiPassword.text.toString())) "password dont match" else "password matches", Toast.LENGTH_SHORT).show()
            }

            override fun afterTextChanged(p0: Editable?) {
                Toast.makeText(this@SignUp, if (!binding.tiRetypePassword.text.toString().equals(binding.tiPassword.text.toString())) "" else "password matches", Toast.LENGTH_SHORT).show()
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

    private fun passwordValidationCharLength (password : String) : Boolean = password.length >= 6
    private fun passwordValidationAlphaNumeric (password: String) : Boolean = password.matches("[A-Za-z0-9]".toRegex())

}