package com.android.qhackfst.ui.home.oldie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.qhackfst.R

class OldieFragment : Fragment() {

    private lateinit var notificationsViewModel: OldieViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_oldie, container, false)
    }
}