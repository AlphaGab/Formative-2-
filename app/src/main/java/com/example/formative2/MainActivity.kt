package com.example.formative2

import android.location.GnssAntennaInfo.Listener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.RatingBar
import android.widget.Toast
import android.widget.ToggleButton

class MainActivity : AppCompatActivity() {
    lateinit var text: CharSequence
    var duration = 0;
    var RatingBar =""
    var checkBoxData = "None\n"
    var radioGroup= "One"
    var powerButtnStatus = "Off"
    var meat = false
    var fruit = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val text_btn = findViewById<Button>(R.id.btn_text)
        duration = Toast.LENGTH_SHORT
        text_btn.setOnClickListener(object: View.OnClickListener{
            override fun onClick(view: View?){
                Toast.makeText(this@MainActivity,"You clicked the Text Button ",duration,).show()
            }
        })
       val rBar = findViewById<RatingBar>(R.id.rbar_star)
        rBar.setOnRatingBarChangeListener { _, rating, _ ->
            RatingBar = rating.toString()
        }
        }
    fun doButtonTextImage (view : View){
        Toast.makeText(applicationContext,"You clicked Text Image Button" ,duration).show()
    }
    fun doImageButton(view: View){
        Toast.makeText(applicationContext,"You clicked Image Button",duration).show()
    }
    fun doCheckBox(view: View) {
        val isChecked = (view as CheckBox).isChecked

        when (view.id) {
            R.id.cbx_fruit -> {
                if (isChecked) fruit = true
                if (!isChecked) fruit = false
            }
            R.id.cbx_meat -> {
                if(isChecked) meat = true
                if(!isChecked) meat = false
            }


        }
        if(meat && fruit) checkBoxData = "Fruit and Meat\n"

        else if(meat) checkBoxData = "Meat\n"

       else if(fruit) checkBoxData = "fruit\n"

        else
            checkBoxData = "None\n"
    }
    fun doToast(view:View){

        var editText = findViewById<EditText>(R.id.etxt_msg)
        text = "CheckBox ${checkBoxData}Radio Button $radioGroup\nToggle Button $powerButtnStatus\nRating Bar $RatingBar\n" +
                "Edit Text ${editText.text} "
        Toast.makeText(applicationContext,text,duration).show()
    }
    fun doRadioButton(view: View){
        val isChecked = (view as RadioButton).isChecked
        when(view.id){
            R.id.rtbn_one -> {
                if(isChecked) radioGroup = "One"
            }
            R.id.rtbn_two -> {
                if(isChecked)  radioGroup = "Two"
            }
            R.id.rbtn_three ->{
                if(isChecked)  radioGroup = "Three"
            }

        }
    }

    fun doPowerButton(view: View){
        val isChecked = (view as ToggleButton).isChecked
        when(view.id){
            R.id.tbtn_power -> {
                if(isChecked) powerButtnStatus = "On"
                else powerButtnStatus = "Off"
            }
        }

    }


   }


