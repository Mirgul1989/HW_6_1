package com.example.hw_6_1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hw_6_1.MainActivity.Companion.RESULT
import com.example.hw_6_1.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.editText2.setText(intent.getStringExtra(RESULT))
        initClicker()
    }

    private fun initClicker() {
        with(binding) {
            btnBack.setOnClickListener {
                val returnIntent = Intent()
                returnIntent.putExtra(RESULT, editText2.text.toString())
                setResult(Activity.RESULT_OK, returnIntent)
                finish()
            }
        }
    }
}