package com.android.qhackfst.ui.home.adult

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.android.qhackfst.R

class AdultFragment : Fragment() {

    private lateinit var adultViewModel: AdultViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        adultViewModel =
            ViewModelProvider(this).get(AdultViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_adult, container, false)

        return root
    }
}