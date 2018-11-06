package com.rxjava.example

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCreatingObserverable.setOnClickListener {
            startActivity(Intent(this, CreatingObserverableActivity::class.java))
        }

        btnTransformingObserverable.setOnClickListener {

        }

        btnFilteringObserverable.setOnClickListener {
            startActivity(Intent(this, FilteringObserverableActivity::class.java))
        }
    }
}
