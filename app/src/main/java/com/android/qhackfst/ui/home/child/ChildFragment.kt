package com.android.qhackfst.ui.home.child

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.android.qhackfst.R

class ChildFragment : Fragment() {

    private val dashboardViewModel: ChildViewModel by lazy {
        ViewModelProvider(requireActivity()).get(
            ChildViewModel::class.java
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_child, container, false)

        return root
    }
}