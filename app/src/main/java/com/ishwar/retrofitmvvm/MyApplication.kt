package com.ishwar.retrofitmvvm

import android.app.Application
import com.ishwar.retrofitmvvm.api.ApiInterface
import com.ishwar.retrofitmvvm.api.ApiUtilities
import com.ishwar.retrofitmvvm.repository.MemesRepository
import com.ishwar.retrofitmvvm.room.MemeDatabase

class MyApplication : Application() {

    lateinit var memesRepository: MemesRepository

    override fun onCreate() {
        super.onCreate()
        val apiInterface = ApiUtilities.getInstance().create(ApiInterface::class.java)
        val dataBase = MemeDatabase.getDatabase(applicationContext)
        memesRepository = MemesRepository(apiInterface, dataBase,applicationContext)

    }


}