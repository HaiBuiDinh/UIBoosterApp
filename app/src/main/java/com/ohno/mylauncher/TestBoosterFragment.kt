package com.ohno.mylauncher

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_test_booster_layout.*
import kotlinx.android.synthetic.main.test.*

class TestBoosterFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.test, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        ripple.startRippleAnimation()
//        with(animation_view) {
//            setMinFrame(30)
//        }

        animation_view.setOnClickListener {
            Toast.makeText(requireContext(), "Clicked", Toast.LENGTH_SHORT).show()
        }

        layout_phone_boost.setOnClickListener { loadFragment(TestMainFuncFragment(), 0) }
        layout_scan_virus.setOnClickListener { loadFragment(TestMainFuncFragment(), 1) }
        layout_battery_saver.setOnClickListener { loadFragment(TestMainFuncFragment(), 3) }
        layout_cpu_cooler.setOnClickListener { loadFragment(TestMainFuncFragment(), 2) }
    }

    private fun loadFragment(fragment: Fragment, int: Int) {
        val bundle = Bundle()
        bundle.putInt("type_func", int);
        fragment.arguments = bundle
        fragment?.let {
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.container, fragment).addToBackStack("a").commit()
        }
    }

}