package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    val TAG = "MAinActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "Before runbloking")
        runBlocking {
            launch(Dispatchers.IO){
                delay(3000L)
                Log.d(TAG, "Finished IO Courutine 1")
            }

            launch(Dispatchers.IO){
                delay(3000L)
                Log.d(TAG, "Finished IO Courutine 2")
            }

            Log.d(TAG, "Start of runbloking")
            delay(5000L)
            Log.d(TAG, "End of runbloking")
        }
        Log.d(TAG, "After runbloking")





    }




}