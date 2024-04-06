package com.example.lab_2.model

import androidx.recyclerview.widget.DiffUtil

class CelebrityItemCallback : DiffUtil.ItemCallback<Celebrity>() {
    override fun areItemsTheSame(oldItem: Celebrity, newItem: Celebrity): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Celebrity, newItem: Celebrity): Boolean {
        return oldItem == newItem
    }

}