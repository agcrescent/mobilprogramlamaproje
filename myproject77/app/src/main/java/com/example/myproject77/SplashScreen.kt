package com.example.myproject77

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.ImageView
import android.widget.Toast

class SplashScreen : AppCompatActivity() {

    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        initializeVariables()
        startTimer()
    }

    private fun initializeVariables(){
        imageView = findViewById(R.id.imageView)
    }

    private fun startTimer(){

        var i = -1

        object : CountDownTimer(5000,1000){
            override fun onTick(millisUntilFinished: Long) {
                i++

                if (i == 1)
                    showImageView()
                else if (i == 4)
                    hideImageView()
            }

            override fun onFinish() {
                if (checkInternetConnection() != null && checkInternetConnection()!!){
                    val intent = Intent(this@SplashScreen, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                else{
                    Toast.makeText(this@SplashScreen, getString(R.string.nointernet), Toast.LENGTH_SHORT).show()
                    finish()
                }

            }

        }.start()

    }

    private fun showImageView(){
        imageView.visibility = View.VISIBLE
    }

    private fun hideImageView(){
        imageView.visibility = View.INVISIBLE
    }

    private fun checkInternetConnection() : Boolean?{
        val connectionManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectionManager.activeNetworkInfo

        return networkInfo?.isConnected
    }
}