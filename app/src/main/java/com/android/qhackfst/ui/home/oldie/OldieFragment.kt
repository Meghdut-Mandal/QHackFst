package com.android.qhackfst.ui.home.oldie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.android.qhackfst.R
import com.android.qhackfst.util.navController
import kotlinx.android.synthetic.main.fragment_oldie.*

class OldieFragment : Fragment() {

    private val oldieViewModel by lazy {
        ViewModelProvider(requireActivity()).get(
            OldieViewModel::class.java
        )
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_oldie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        heart_monitor.setOnClickListener {
            navController.navigate(R.id.action_navigation_oldie_to_cameraFragment)
        }
    }
}