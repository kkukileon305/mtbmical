package com.goodness.goodplace

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.goodness.goodplace.databinding.ActivityResultBinding
import kotlin.math.round

class ResultActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val binding = ActivityResultBinding.inflate(layoutInflater)

    val height = intent.getIntExtra("height", 0).toDouble() / 100
    val weight = intent.getIntExtra("weight", 0).toDouble()

    val bmi = weight / (height * height)

    var resultText = ""
    var resultColor = 0

    when (bmi) {
      in 0.0..<18.5 -> {
        resultText = "저체중"
        resultColor = Color.RED
      }

      in 18.5..<23.0 -> {
        resultText = "정상체중"
        resultColor = Color.GREEN
      }

      else -> {
        resultText = "좋은 체중"
        resultColor = Color.BLUE
        binding.tvResImage.setImageResource(R.drawable.good)
      }
    }

    binding.tvResText.text = resultText
    binding.tvResText.setTextColor(resultColor)
    binding.tvResValue.text = (round(bmi * 10) / 10).toString()

    setContentView(binding.root)

    binding.button.setOnClickListener {
      finish()
    }
  }
}