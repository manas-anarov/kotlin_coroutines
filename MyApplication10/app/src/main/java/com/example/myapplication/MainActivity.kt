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

        val job = GlobalScope.launch (Dispatchers.Default){
//            repeat(5){
//                Log.d(TAG, "Courutine is still working...")
//                delay(1000L)
//            }

            Log.d(TAG, "Starting long calculation")

            withTimeout(3000L){
                for(i in 30..40){
                    if (isActive){
                        Log.d(TAG, "Result for i = $i: ${fib(i)}")
                    }

                }
            }


        }

//        runBlocking {
//            delay(2000L)
//            job.cancel()
//            Log.d(TAG, "Canseled Job...")
//        }



    }

    fun fib(n: Int): Long{
        return if(n == 0) 0
        else if(n == 1) 1
        else fib(n-1) + fib(n-2)
    }




}