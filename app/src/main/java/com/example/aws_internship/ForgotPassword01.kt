package com.example.aws_internship

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.aws_internship.databinding.ActivityForgotPassword01Binding

class ForgotPassword01 : AppCompatActivity() {

    private lateinit var binding: ActivityForgotPassword01Binding
    private var temporaryOTP: String = "012345"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password01)

        binding = ActivityForgotPassword01Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnProceed.setOnClickListener {

            if (temporaryOTP == (binding.tiOPP0.text.toString()
                        + binding.tiOPP1.text.toString()
                        + binding.tiOPP2.text.toString()
                        + binding.tiOPP3.text.toString()
                        + binding.tiOPP4.text.toString()
                        + binding.tiOPP5.text.toString())
            ) {
                Toast.makeText(this@ForgotPassword01,"OTP Accepted", Toast.LENGTH_SHORT).show()

                //TODO: For user who discontinued onboarding, return to last page
//                val sharedPreferences = getSharedPreferences(MainActivity().preferenceName, 0)
//                var editor = sharedPreferences.edit()
//
//                editor.putBoolean("hasLoggedIn",true)
//                editor.commit()

                val intent = Intent(this@ForgotPassword01, ForgotPassword02::class.java)
                binding.ivHelperText.isVisible = false
                startActivity(intent)
                finish()
            } else {
                binding.ivHelperText.isVisible = true
            }

        }

        binding.tiOPP0.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (binding.tiOPP0.text.toString().length == 1) {
                    binding.tiOPP1.requestFocus()
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })

        binding.tiOPP1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (binding.tiOPP1.text.toString().length == 1) {
                    binding.tiOPP2.requestFocus()
                } else {
                    binding.tiOPP0.requestFocus()
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })

        binding.tiOPP2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (binding.tiOPP2.text.toString().length == 1) {
                    binding.tiOPP3.requestFocus()
                } else {
                    binding.tiOPP1.requestFocus()
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
        binding.tiOPP3.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (binding.tiOPP3.text.toString().length == 1) {
                    binding.tiOPP4.requestFocus()
                } else {
                    binding.tiOPP2.requestFocus()
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
        binding.tiOPP4.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (binding.tiOPP4.text.toString().length == 1) {
                    binding.tiOPP5.requestFocus()
                } else {
                    binding.tiOPP3.requestFocus()
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })

        binding.tiOPP5.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (binding.tiOPP5.text.toString().isEmpty()) {
                    binding.tiOPP4.requestFocus()
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })

        binding.ibBackButton.setOnClickListener {
            super.onBackPressed()
        }
    }
}