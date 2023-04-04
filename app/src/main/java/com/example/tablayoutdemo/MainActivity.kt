package com.example.tablayoutdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottom_navigation)

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.tab1 -> switchFragment(Tab1Fragment())
                R.id.tab2 -> switchFragment(Tab2Fragment())
                R.id.tab3 -> switchFragment(Tab3Fragment())
            }
            true
        }

        // Select the default tab
        bottomNavigationView.selectedItemId = R.id.tab1
    }

    private fun switchFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
            .commit()
    }
}