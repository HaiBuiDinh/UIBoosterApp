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
        loadFragment(TestBoosterFragment(), -1)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home->loadFragment(TestBoosterFragment(), -1)
                R.id.toolkit->loadFragment(TestToolkitFragment(), -1)
                R.id.settings->loadFragment(TestSettingFragment(), -1)
            }
            true
        }

    }

    private fun loadFragment(fragment: Fragment, int: Int) {
        val bundle = Bundle()
        bundle.putInt("type_func", int);
        fragment.arguments = bundle
        fragment?.let {
            supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        loadFragment(TestBoosterFragment(), -1)
    }
}