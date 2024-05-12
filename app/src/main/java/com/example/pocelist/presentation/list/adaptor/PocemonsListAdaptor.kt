package com.example.pocelist.presentation.list.adaptor

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pocelist.domain.model.Pocemon

class PocemonsListAdaptor(
    private val clickListener: ClickListener
) : RecyclerView.Adapter<PocemonsListViewHolder>() {
    fun interface ClickListener {
        fun click(pocemon: Pocemon)
    }

    var pocemons = listOf<Pocemon>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PocemonsListViewHolder {
        return PocemonsListViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return pocemons.size
    }

    override fun onBindViewHolder(holder: PocemonsListViewHolder, position: Int) {
        holder.bind(pocemons[position])
        holder.itemView.setOnClickListener { clickListener.click(pocemons[position]) }
    }
}