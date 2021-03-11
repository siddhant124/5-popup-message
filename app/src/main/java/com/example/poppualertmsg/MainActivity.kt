package com.example.poppualertmsg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.poppualertmsg.databinding.ActivityMainBinding
import com.tapadoo.alerter.Alerter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.buttonForAlert.setOnClickListener{
            Alerter.create(this)
                .setTitle("Alert Title")
                .setText("Alert Text")
                .setIcon(R.drawable.ic_android_black_24dp)
                .setBackgroundColorRes(R.color.purple_200)
                .setDuration(3000)
                .setOnClickListener {
                    // do something when
                    // Alerter message was clicked
                    startActivity(Intent(this, AfterNotificationClicked::class.java))

                }
                .setOnShowListener {
                    // do something when
                    // Alerter message shows
//                    Toast.makeText(this, "Showing Alert Msg", Toast.LENGTH_SHORT).show()
                }
                .setOnHideListener {
                    // do something when
                    // Alerter message hides
//                    Toast.makeText(this, "hiding Alert Msg", Toast.LENGTH_SHORT).show()

                }

                .show()
        }
    }
}