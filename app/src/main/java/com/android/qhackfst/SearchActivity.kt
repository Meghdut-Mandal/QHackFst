package com.android.qhackfst

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.transition.Fade
import android.widget.Adapter
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.qhackfst.Adapter.SearchAdapter
import com.android.qhackfst.Model.SearchElement


class SearchActivity : AppCompatActivity() {
    lateinit var adapter1: SearchAdapter
    lateinit var list: ArrayList<SearchElement>
    lateinit var recyclerView:RecyclerView
    lateinit var filteredList:ArrayList<SearchElement>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.search)
        filteredList = ArrayList<SearchElement>();

        list = ArrayList<SearchElement>()
        adapter1 = SearchAdapter(filteredList)
        createList()
        val decor= window.decorView

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView).apply{
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@SearchActivity)
            adapter = adapter1


        }
        //recyclerView.hasFixedSize()
       // recyclerView.layoutManager(LinearLayoutManager(this))

        val editText:EditText = findViewById(R.id.editText);
        createList();
        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence,start: Int, before: Int,count: Int   ) {
            }

            override fun onTextChanged(s: CharSequence,start: Int, before: Int,count: Int ) {
            }

            override fun afterTextChanged(s: Editable) {
                filter(s.toString())
            }
        })
        val fade = Fade()
        fade.excludeTarget(android.R.id.statusBarBackground, true);
        fade.excludeTarget(android.R.id.navigationBarBackground, true);
        getWindow().setEnterTransition(fade);
        getWindow().setExitTransition(fade);

    }

    public fun filter(text:String)
    {

        filteredList.clear()
        for(item:SearchElement in list)
        {
            if(item.name.toLowerCase().contains(text.toLowerCase()))
            {
                filteredList.add(item)
            }
        }
      //  adapter1 = SearchAdapter(filteredList)
        adapter1.notifyDataSetChanged()

    }
      fun createList()
    {
        list.add(SearchElement("fever"))
        list.add(SearchElement("headache"))
        list.add(SearchElement("fever"))
        list.add(SearchElement("fever"))

        list.add(SearchElement("fever"))
        list.add(SearchElement("fever"))
        list.add(SearchElement("fever"))
        list.add(SearchElement("fever"))

        list.add(SearchElement("fever"))
        list.add(SearchElement("fever"))
        list.add(SearchElement("fever"))
        list.add(SearchElement("fever"))

        list.add(SearchElement("fever"))
        list.add(SearchElement("fever"))
        list.add(SearchElement("fever"))
        list.add(SearchElement("fever"))
       // adapter1.notifyDataSetChanged()

    }



}
