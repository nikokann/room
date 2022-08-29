
package com.github.nikokann.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.Observer
import androidx.room.Room
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private lateinit var db: MemoDatabase
    private lateinit var  dao:MemoDAO

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.db = Room.databaseBuilder(
            this, MemoDatabase::class.java, "memo.dp"
        ).build()
        this.dao = this.db.memoDAO()

        findViewById<Button>(R.id.button).setOnClickListener {
            GlobalScope.launch{
                val memo = Memo(id = 0, memo = "Sample!")
                dao.insert(memo)
            }

        }
    }

    override fun onStart(){
        super.onStart()

        this.dao.getAll().observe(this, Observer {
            println(it)
        })
    }
}