package com.curso.android.app.practica.pruebatp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.curso.android.app.practica.pruebatp.databinding.ActivityMainBinding
import androidx.activity.viewModels



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.compareButton.setOnClickListener {
            val text1 = binding.editText1.text.toString()
            val text2 = binding.editText2.text.toString()

            mainViewModel.compareText(text1,text2)
        }

        mainViewModel.compareResultx.observe(this){ result ->
            binding.resultTextView.text = result
        }

    }
}