package com.example.lab_2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_2.databinding.ItemCelebrityBinding
import com.example.lab_2.model.Celebrity
import com.example.lab_2.model.CelebrityItemCallback

class CelebrityAdapter(private val onClickCelebrity: (Celebrity) -> Unit) : ListAdapter<Celebrity, CelebrityAdapter.CelebrityViewHolder>(CelebrityItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CelebrityViewHolder {
        val binding = ItemCelebrityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CelebrityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CelebrityViewHolder, position: Int) {
        val celebrity = getItem(position)
        holder.bind(celebrity)
        holder.itemView.setOnClickListener { onClickCelebrity(celebrity) }
    }

    inner class CelebrityViewHolder(private val binding: ItemCelebrityBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(celebrity: Celebrity) {
            binding.apply {
                nameTextView.text = "Name: ${celebrity.name}"
                netWorthTextView.text = "Net Worth: $${celebrity.netWorth}"
                genderTextView.text = "Gender: ${celebrity.gender ?: "Unknown"}"
                nationalityTextView.text = "Nationality: ${celebrity.nationality ?: "Unknown"}"
                occupationTextView.text = "Occupation: ${celebrity.occupation?.joinToString(", ") ?: "Unknown"}"
                heightTextView.text = "Height: ${celebrity.height ?: "Unknown"}"
                birthdayTextView.text = "Birthday: ${celebrity.birthday ?: "Unknown"}"
                ageTextView.text = "Age: ${celebrity.age ?: "Unknown"}"
                isAliveTextView.text = "Is Alive: ${celebrity.isAlive ?: "Unknown"}"
                deathTextView.text = "Death: ${celebrity.death ?: "Unknown"}"
            }
        }
    }

}
