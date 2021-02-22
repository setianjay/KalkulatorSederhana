package com.setianjay.kalkulatorsederhana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var edit_value1: EditText
    private lateinit var edit_value2: EditText
    private lateinit var button_calculator: Button
    private lateinit var text_result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initListner()
    }

    // Initialize View
    private fun initView(){
        edit_value1 = findViewById(R.id.edit_value1)
        edit_value2 = findViewById(R.id.edit_value2)
        button_calculator = findViewById(R.id.button_calculator)
        text_result = findViewById(R.id.text_result)
    }

    // Initialize event
    private fun initListner(){
        button_calculator.setOnClickListener {
            if (inputValidate()){
                val value1 = edit_value1.text.toString().toInt()
                val value2 = edit_value2.text.toString().toInt()
                text_result.text = countCalculate(value1,value2)
            }else{
                Toast.makeText(applicationContext, "Input tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun inputValidate(): Boolean{
        if (edit_value1.text.isNullOrEmpty() || edit_value2.text.isNullOrEmpty()){
            return false
        }
        return true
    }

    private fun countCalculate(value1: Int, value2: Int): String{
        val result = value1 + value2
        return result.toString()
    }
}