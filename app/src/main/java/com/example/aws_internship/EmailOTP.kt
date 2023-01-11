package com.example.aws_internship

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.example.aws_internship.databinding.ActivityEmailOtpBinding

class EmailOTP : AppCompatActivity() {

    private lateinit var binding: ActivityEmailOtpBinding
    private var temporaryOTP: String = "012345"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email_otp)

        binding = ActivityEmailOtpBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnProceed.setOnClickListener {

            if (temporaryOTP == (binding.tiOPP0.text.toString()
                        + binding.tiOPP1.text.toString()
                        + binding.tiOPP2.text.toString()
                        + binding.tiOPP3.text.toString()
                        + binding.tiOPP4.text.toString()
                        + binding.tiOPP5.text.toString())
            ) {
                Toast.makeText(this@EmailOTP,"OTP Accepted", Toast.LENGTH_SHORT).show()

                val sharedPreferences = getSharedPreferences(MainActivity().preferenceName, 0)
                var editor = sharedPreferences.edit()

                editor.putBoolean("hasLoggedIn",true)
                editor.commit()


                val intent = Intent(this@EmailOTP, ProfileDetails::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this@EmailOTP,"OTP Did Not Match", Toast.LENGTH_SHORT).show()
            }

        }

        binding.tiOPP0.addTextChangedListener(object :  TextWatcher {
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

        binding.tiOPP1.addTextChangedListener(object :  TextWatcher {
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

        binding.tiOPP2.addTextChangedListener(object :  TextWatcher {
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
        binding.tiOPP3.addTextChangedListener(object :  TextWatcher {
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
        binding.tiOPP4.addTextChangedListener(object :  TextWatcher {
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
            val intent = Intent (this@EmailOTP, SignUp::class.java)
            startActivity(intent)
        }
    }
}