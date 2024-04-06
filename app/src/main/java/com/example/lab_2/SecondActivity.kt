package com.example.lab_2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lab_2.databinding.ActivitySecondBinding
import com.example.lab_2.model.Celebrity

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val celebrity = intent.getSerializableExtra("celebrity") as? Celebrity
        celebrity?.let {
            binding.nameTextView.text = it.name
            binding.netWorthTextView.text = "Net Worth: $${it.netWorth}"
            binding.genderTextView.text = "Gender: ${celebrity.gender ?: "Unknown"}"
            binding.nationalityTextView.text = "Nationality: ${celebrity.nationality ?: "Unknown"}"
            binding.occupationTextView.text = "Occupation: ${celebrity.occupation?.joinToString(", ") ?: "Unknown"}"
            binding.heightTextView.text = "Height: ${celebrity.height ?: "Unknown"}"
            binding.birthdayTextView.text = "Birthday: ${celebrity.birthday ?: "Unknown"}"
            binding.ageTextView.text = "Age: ${celebrity.age ?: "Unknown"}"
            binding.isAliveTextView.text = "Is Alive: ${celebrity.isAlive ?: "Unknown"}"

            binding.backButton.setOnClickListener {
                onBackPressed()
            }
        }

    }

}
