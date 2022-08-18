package com.nandani.shareprefrences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.nandani.shareprefrences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = getSharedPreferences(
            resources.getString(R.string.app_name),
            Context.MODE_PRIVATE
        )
        editor = sharedPreferences.edit()
        if (sharedPreferences.contains("Data")){
            binding.edittext.setText(sharedPreferences.getString("Data",""))
        }

        binding.btn1.setOnClickListener {
            if (binding.edittext.text.isNullOrEmpty() == false) {
                editor.putString("Data",binding.edittext.text.toString())
                editor.apply()
            } else {
                Toast.makeText(this, "enter value to save", Toast.LENGTH_SHORT)
            }
        }
        binding.btn2.setOnClickListener{
            editor.clear()
            editor.apply()
        }
    }
}