package com.example.sharedviewmodelforfragmentcommunication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedviewmodelforfragmentcommunication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {



    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportFragmentManager.beginTransaction()
            .add(R.id.container_a,fragmentA())
            .add(R.id.container_b , FragmentB())
            .commit()

    }
}