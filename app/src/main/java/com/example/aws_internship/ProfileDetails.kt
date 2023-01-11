package com.example.aws_internship

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.example.aws_internship.databinding.ActivityEmailOtpBinding
import com.example.aws_internship.databinding.ActivityProfileDetailsBinding

class ProfileDetails : AppCompatActivity() {

    private lateinit var binding: ActivityProfileDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_details)

        binding = ActivityProfileDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

            binding.btnProceed.setOnClickListener {
                if (binding.tiFirstName.text.toString().isNotEmpty() and binding.tiLastName.text.toString().isNotEmpty()) {
                    val intent = Intent(this@ProfileDetails, AddAvatar::class.java)
                    startActivity(intent)
                }
        }

        binding.tiFirstName.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.tilFirstName.helperText = validateFirstname(binding.tiFirstName.text.toString())
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })

        binding.tiLastName.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.tilLastName.helperText = validateLastname(binding.tiLastName.text.toString())
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
    }

    private fun validateFirstname(firstnameText:String): String? {
        return if (firstnameText.isEmpty()){
            "Required"
        } else {
            null
        }
    }

    private fun validateLastname(lastnameText:String): String? {

        return if (lastnameText.isEmpty()){
            "Required"
        } else {
            null
        }
    }

    override fun onBackPressed() {
        // Do nothing
    }
}