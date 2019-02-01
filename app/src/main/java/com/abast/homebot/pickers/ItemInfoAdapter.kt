package com.abast.homebot.pickers

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abast.homebot.R
import kotlinx.android.synthetic.main.list_item.view.*

class ItemInfoAdapter(val context : Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items : List<ItemInfo> = emptyList()

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ListItemViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item,parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items.get(position)
        val vh : ListItemViewHolder = holder as ListItemViewHolder
        vh.image.setImageDrawable(item.loadIcon(context.packageManager))
        vh.label.text = item.loadLabel(context.packageManager)
    }

    class ListItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val label = view.label
        val image = view.image
    }

}