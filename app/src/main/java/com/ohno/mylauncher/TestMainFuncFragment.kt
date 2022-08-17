package com.ohno.mylauncher

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class TestMainFuncFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var fragmentId: Int? = this.arguments?.getInt("type_func")
        var layoutId:Int = 0;
        layoutId = when (fragmentId) {
            0 -> R.layout.scan_virus
            1-> R.layout.scan_virus
            2 -> R.layout.cpu_cooler
            3 -> R.layout.battery_saver
            else -> R.layout.scan_virus
        }
        val view = inflater.inflate(layoutId, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}