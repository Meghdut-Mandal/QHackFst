package com.android.qhackfst.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.qhackfst.Model.SearchElement
import com.android.qhackfst.R

class SearchAdapter(val list:ArrayList<SearchElement>) : RecyclerView.Adapter<SearchAdapter.SearchHolder>() {
    class SearchHolder( itemView: View):RecyclerView.ViewHolder(itemView)

    {
        val text = itemView.findViewById<TextView>(R.id.searchItem);

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.item_recycle,parent,false)
        return SearchHolder(inflater);
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SearchHolder, position: Int) {
        holder.text.text = list[position].name
    }

}