package com.example.movieappmad23

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.movieappmad23.navigation.Navigation
import com.example.movieappmad23.ui.theme.MovieAppMAD23Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MovieAppMAD23Theme {
                Navigation()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i(" onStart", "Yoyoyo this is onstart")
    }
    override fun onResume() {
        super.onResume()
        Log.i("onResume","This is onResume")
    }
    override fun onPause() {
        super.onPause()
        Log.i("onPause", "onPause has started")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("onDestroy", "onDestroy has started")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("onRestart", "onRestart has started")
    }


}

