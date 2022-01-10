package ru.vlsv.firstkotlinapp

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var mMainTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mMainTextView = findViewById(R.id.txt_main)

        var mainBtn = findViewById<Button>(R.id.btn_main)

        mainBtn.setOnClickListener {
            mMainTextView.setText(getString(R.string.press_main_btn))
            it.setBackgroundColor(Color.BLUE)
        }
    }
}