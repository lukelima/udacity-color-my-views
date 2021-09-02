package com.example.colormyviews

import android.databinding.BindingMethod
import android.databinding.DataBindingUtil
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.colormyviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        val clickableViews: List<View> = listOf(
            binding.boxOneText,
            binding.boxTwoText,
            binding.boxThreeText,
            binding.boxFourText,
            binding.boxFiveText,
            binding.constraintLayout,
            binding.redButton,
            binding.yellowButton,
            binding.greenButton)

        for(item in clickableViews) {
            item.setOnClickListener {makeColored(it)}
        }
    }

    private fun makeColored(view: View) {
        when (view.id) {

            // Boxes using Color class colors for background
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)

            // Boxes using Android color resources for background
            R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.box_five_text -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.red_button -> binding.boxThreeText.setBackgroundResource(android.R.color.holo_red_light)
            R.id.yellow_button -> binding.boxFourText.setBackgroundColor(Color.YELLOW)
            R.id.green_button -> binding.boxFiveText.setBackgroundResource(android.R.color.holo_green_dark)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}