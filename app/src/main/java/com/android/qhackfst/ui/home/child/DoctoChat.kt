package com.android.qhackfst.ui.home.child

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.qhackfst.R
import com.android.qhackfst.data.Question
import com.android.qhackfst.ui.adapter.GenericAdapter
import com.android.qhackfst.ui.adapter.ItemRenderer
import kotlinx.coroutines.delay
import kotlin.concurrent.thread

class DoctoChat : Fragment(), ItemRenderer<Question> {

    val adpater by lazy { GenericAdapter(R.layout.option_layout, this) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_docto_chat, container, false)
    }

    val questions = listOf(
        Question(
            "Do you have any pain?",
            listOf("In Muscles", "Forehead", "Stomach", "Arms and Legs")
        ),
        Question("How's your throat?", listOf("Sore throat", "Dry throat", "Swollen throat")),
        Question(
            "Any problem with skin?",
            listOf("Itchy red spots", "Rashes", "Dry scaly skin", "Blisters")
        ),
        Question("Experiencing any pain in joints?", listOf("Yes", "No", "Occasionally")),
        Question(
            "Condtion of your nose ?",
            listOf("Running nose", "Blocked nose", "Swollen red nose")
        ),
    )


    override fun onResume() {
        super.onResume()
        thread {
            Thread.sleep(1000L)

        }
    }

    override fun renderItem(layout: View?, item: Question, position: Int) {

    }


}