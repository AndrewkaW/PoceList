package com.example.pocelist.presentation.list.adaptor

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.pocelist.R
import com.example.pocelist.domain.model.Pocemon

class PocemonsListViewHolder(parentView: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parentView.context).inflate(R.layout.pocemon_item, parentView, false)
) {

    private val name: TextView = itemView.findViewById(R.id.tv_name)
    private val artwork: ImageView = itemView.findViewById(R.id.iv_avatar)

    fun bind(model: Pocemon) {
        name.text = model.name
        Glide.with(itemView)
            .load(model.imageUrl)
            .placeholder(R.drawable.default_art_work)
            .transform(RoundedCorners(itemView.resources.getDimensionPixelSize(R.dimen.art_work_radius)))
            .into(artwork)
    }
}