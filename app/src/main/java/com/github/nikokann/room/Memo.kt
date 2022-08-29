package com.github.nikokann.room

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Memo(
    @PrimaryKey(autoGenerate = true)
    var id: Int, val memo: String) {

}