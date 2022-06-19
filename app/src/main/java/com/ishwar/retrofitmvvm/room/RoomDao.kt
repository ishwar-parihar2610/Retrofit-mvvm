package com.ishwar.retrofitmvvm.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ishwar.retrofitmvvm.model.Meme
import com.ishwar.retrofitmvvm.model.memes


@Dao
interface RoomDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMemes(memes: List<Meme>)

    @Query("SELECT * FROM memes")
    suspend fun getMemes():List<Meme>

}