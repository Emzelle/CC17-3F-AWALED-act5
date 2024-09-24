package com.example.dicerollerapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var next: Button
    private lateinit var previous: Button
    private lateinit var art: ImageView
    private lateinit var descriptionTextView: TextView
    private var x: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Enable edge-to-edge system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        next = findViewById(R.id.next)
        previous = findViewById(R.id.previous)
        art = findViewById(R.id.art)
        descriptionTextView = findViewById(R.id.descriptionTextView)


        next.setOnClickListener(this)
        previous.setOnClickListener(this)


        updateView(x)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.next -> {
                x++
                if (x > 5) x = 1
            }

            R.id.previous -> {
                x--
                if (x < 1) x = 5
            }
        }


        updateView(x)
    }


    private fun updateView(value: Int) {
        val artResources = arrayOf(
            R.drawable.k1,
            R.drawable.k2,
            R.drawable.v3,
            R.drawable.amazon,
            R.drawable.stronger
        )

        val descriptions = listOf(
            "Kamen Rider 1 by 箱子",
            "Kamen Rider 2 guts_",
            "Kamen Rider V3 by Samkumi",
            "Kamen Rider Amazon by 小",
            "Kamen Rider Stronger by Ukyo"
        )

        if (value in 1..5) {
            art.setImageResource(artResources[value - 1])
            descriptionTextView.text = descriptions[value - 1]
        }
    }
}
