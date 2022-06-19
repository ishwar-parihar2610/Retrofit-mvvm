package com.ishwar.retrofitmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ishwar.retrofitmvvm.model.memes
import com.ishwar.retrofitmvvm.repository.MemesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MemesViewModel(private val memesRepository: MemesRepository) : ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO) {
            memesRepository.getMemes()
        }
    }

    val memes: LiveData<memes> get() = memesRepository.memes

}