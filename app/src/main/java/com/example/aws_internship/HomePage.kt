package com.example.aws_internship

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aws_internship.databinding.ActivityHomePageBinding

class HomePage : AppCompatActivity() {

    private lateinit var binding: ActivityHomePageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        binding = ActivityHomePageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val fragment = Settings()
        binding.imgAvatar.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragmentlayout, fragment).commit()
        }

//        val bundle : Bundle = intent.extras!!
//        val resId : Int = bundle.getInt("resId")
//        binding.imgAvatar.setImageResource(resId)
    }

}