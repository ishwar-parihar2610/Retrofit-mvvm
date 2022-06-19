package com.ishwar.retrofitmvvm.api

import com.ishwar.retrofitmvvm.model.Meme
import com.ishwar.retrofitmvvm.model.memes
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("/get_memes")
    suspend fun getJokes():Response<memes>
}