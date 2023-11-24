package com.goodness.goodplace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.goodness.goodplace.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val binding = ActivityMainBinding.inflate(layoutInflater)

    setContentView(binding.root)

    binding.btnCheck.setOnClickListener {
      val weightText = binding.etWeight.text
      val heightText = binding.etHeight.text

      if (weightText.isEmpty() || heightText.isEmpty()) {
        Toast.makeText(this, "신장과 체중을 입력해주세요.", Toast.LENGTH_SHORT).show()
        return@setOnClickListener
      }

      val weight = weightText.toString().toInt()
      val height = heightText.toString().toInt()

      if (height <= 0 || weight <= 0) {
        Toast.makeText(this, "신장과 체중은 0보다 커야 합니다.", Toast.LENGTH_SHORT).show()
        return@setOnClickListener
      }

      val intent = Intent(this, ResultActivity::class.java)
      intent.putExtra("weight", weight)
      intent.putExtra("height", height)

      startActivity(intent)
    }
  }
}