package com.example.lab_2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab_2.adapter.CelebrityAdapter
import com.example.lab_2.databinding.ActivityMainBinding
import com.example.lab_2.model.Celebrity
import com.example.lab_2.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: CelebrityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = CelebrityAdapter { celebrity -> onClickCelebrity(celebrity) }
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                fetchCelebrities(query)
                return true
            }
            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })

    }

    private fun onClickCelebrity(celebrity: Celebrity) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("celebrity", celebrity)
        startActivity(intent)
    }

    private fun fetchCelebrities(name: String) {
        val client = ApiClient.instance
        val response = client.fetchCelebrityList(name)
        response.enqueue(object : Callback<List<Celebrity>> {
            override fun onResponse(
                call: Call<List<Celebrity>>,
                response: Response<List<Celebrity>>
            ) {
                val celebrities = response.body() ?: emptyList()
                celebrities.let {
                    Log.d("MainActivity", "Data: ${celebrities}")
                    adapter.submitList(it)
                }
            }

            override fun onFailure(call: Call<List<Celebrity>>, t: Throwable) {
                Log.e("MainActivity", "Error fetching data", t)
                adapter.submitList(emptyList())
            }
        })
    }

}