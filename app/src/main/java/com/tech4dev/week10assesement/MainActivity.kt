package com.tech4dev.week10assesement

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.tech4dev.week10assesement.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
//    private  var y :Int = 100


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        checkwords()
        val spinner: Spinner = binding.spinner
         ArrayAdapter.createFromResource(
            this,
            R.array.country_codes,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter

        }

        spinner.onItemSelectedListener = object:AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val selected = p0?.getItemAtPosition(p2)
                binding.cCode.text = selected.toString()

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

        }

    }

//    private fun checkwords() {
//      var words = binding.bio.text
//        var length = words.length
//        binding.words.text = "${length}/${y}"
//
//    }
}
