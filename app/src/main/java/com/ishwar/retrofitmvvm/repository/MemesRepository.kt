package com.ishwar.retrofitmvvm.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ishwar.retrofitmvvm.api.ApiInterface
import com.ishwar.retrofitmvvm.model.Data
import com.ishwar.retrofitmvvm.model.memes
import com.ishwar.retrofitmvvm.room.MemeDatabase
import com.ishwar.retrofitmvvm.util.MyUtil

class MemesRepository(
    private val apiInterface: ApiInterface,
    private val memeDatabase: MemeDatabase,
    private val applicationContext: Context
) {
    private val memesLiveData = MutableLiveData<memes>()

    val memes: LiveData<memes> get() = memesLiveData

    suspend fun getMemes() {
        if(MyUtil.isInternetAvailable(applicationContext)!!){
            val result = apiInterface.getJokes()
            if (result.body() != null) {
                memeDatabase.memeDao().insertMemes(result.body()!!.data.memes)
                memesLiveData.postValue(result.body())
            }
        }else{
            val memes=memeDatabase.memeDao().getMemes()
            val memesList=memes(Data(memes),true)
            memesLiveData.postValue(memesList)
        }

    }
}