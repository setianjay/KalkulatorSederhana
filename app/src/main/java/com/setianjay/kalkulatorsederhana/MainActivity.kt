package com.setianjay.kalkulatorsederhana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    private lateinit var edit_value1: EditText
    private lateinit var edit_value2: EditText
    private lateinit var radio_group_opeators: RadioGroup
    private lateinit var radio_button: RadioButton
    private lateinit var button_calculator: Button
    private lateinit var text_result: TextView

    private var OPERATOR: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initListner()
    }

    // Initialize View
    private fun initView(){
        edit_value1 = findViewById(R.id.edt_value1)
        edit_value2 = findViewById(R.id.edt_value2)
        radio_group_opeators = findViewById(R.id.rg_operators)
        button_calculator = findViewById(R.id.btn_count)
        text_result = findViewById(R.id.txt_result)
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

        radio_group_opeators.setOnCheckedChangeListener { group, checkedId ->
            radio_button = findViewById(group.checkedRadioButtonId)
            OPERATOR = radio_button.text.toString()
            text_result.text = "HASIL"
        }
    }

    private fun inputValidate(): Boolean{
        if (edit_value1.text.isNullOrEmpty() || edit_value2.text.isNullOrEmpty()){
            return false
        }else if(OPERATOR.isNullOrEmpty()){
            return false
        }
        return true
    }

    private fun countCalculate(value1: Int, value2: Int): String{
        var result = 0
        when(OPERATOR){
            "+" -> result = value1 + value2
            "-" -> result = value1 - value2
            "x" -> result = value1 * value2
            ":" -> result = value1 / value2
        }

        return result.toString()
    }
}