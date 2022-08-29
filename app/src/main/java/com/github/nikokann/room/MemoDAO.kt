package com.github.nikokann.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MemoDAO {

    @Insert
    fun insert(memo:Memo)

    @Query("select * from memo")
    fun getAll(): LiveData<List<Memo>>
}