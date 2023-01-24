package com.example.hw_6_1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.hw_6_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        const val RESULT = "key"
    }

    private lateinit var binding: ActivityMainBinding
    private var resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                binding.editText1.setText(data?.getStringExtra(RESULT))
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClicker()
    }

    private fun initClicker() {
        with(binding) {
            btnSend.setOnClickListener {
                if (editText1.text.isEmpty()) {
                    Toast.makeText(
                        this@MainActivity,
                        "Вы не ввели сообщение!!!",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    val intent = Intent(this@MainActivity, MainActivity2::class.java)
                    intent.putExtra(RESULT, editText1.text.toString())
                    resultLauncher.launch(intent)

                }
            }
        }
    }

}