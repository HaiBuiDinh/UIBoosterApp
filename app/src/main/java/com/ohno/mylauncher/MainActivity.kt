package com.ohno.mylauncher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        loadFragment(TestBoosterFragment())

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home->loadFragment(TestBoosterFragment())
                R.id.toolkit->loadFragment(TestToolkitFragment())
                R.id.settings->loadFragment(TestSettingFragment())
            }
            true
        }

    }

    private fun loadFragment(fragment: Fragment) {
        fragment?.let {
            supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        loadFragment(TestBoosterFragment())
    }
}