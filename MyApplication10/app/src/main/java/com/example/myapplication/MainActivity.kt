package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {

    val TAG = "MAinActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        GlobalScope.launch(Dispatchers.IO) {

            val time = measureTimeMillis {
//                val answer1 = networkCall1()
//                val answer2 = networkCall2()

//                var answer1:String ? = null
//                var answer2:String ? = null
//                val job1 = launch {
//                    answer1 = networkCall1()
//                }
//                val job2 = launch {
//                    answer2 = networkCall2()
//                }
//
//                job1.join()
//                job2.join()

                val answer1 = async { networkCall1() }
                val answer2 = async { networkCall2() }

                Log.d(TAG, "Answer1 is ${answer1.await()}")
                Log.d(TAG, "Answer2 is ${answer2.await()}")
            }

            Log.d(TAG, "Request took is $time")

        }




    }

    suspend fun networkCall1() :String {
        delay(3000L)
        return "answer1";
    }

    suspend fun networkCall2() :String {
        delay(3000L)
        return "answer2";
    }





}