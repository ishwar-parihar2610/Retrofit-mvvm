package com.ishwar.retrofitmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.ishwar.retrofitmvvm.api.ApiInterface
import com.ishwar.retrofitmvvm.api.ApiUtilities
import com.ishwar.retrofitmvvm.repository.MemesRepository
import com.ishwar.retrofitmvvm.viewmodel.MemesViewModel
import com.ishwar.retrofitmvvm.viewmodel.MemesViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var memesViewModel: MemesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository=(application as MyApplication).memesRepository

        memesViewModel = ViewModelProvider(
            this,
            MemesViewModelFactory(repository)
        ).get(MemesViewModel::class.java)

        memesViewModel.memes.observe(this) {
            Toast.makeText(applicationContext, "size : ${it.data.memes.size}", Toast.LENGTH_SHORT).show()
            it.data.memes.iterator().forEach {
                Log.d("ISP", "onCreate: ${it.url}")
            }

        }

    }
}