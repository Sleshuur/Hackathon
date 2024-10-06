package com.example.letgo

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.letgo.databinding.ActivityMain3Binding
import com.example.letgo.databinding.ActivityMainBinding

class MainActivity3 : AppCompatActivity() {
    private lateinit var binding: ActivityMain3Binding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding= ActivityMain3Binding.inflate(layoutInflater)

        fun loadTextFromAssets(): String {
            val assetManager = assets
            val inputStream = assetManager.open("book.txt")
            val bufferedReader = inputStream.bufferedReader()
            return bufferedReader.use { it.readText() }
        }
        binding.backbutton2.setOnClickListener{
            val intent= Intent(this@MainActivity3,MainActivity2::class.java)
            startActivity(intent)
        }

        binding.TextView3.text = loadTextFromAssets()

        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}