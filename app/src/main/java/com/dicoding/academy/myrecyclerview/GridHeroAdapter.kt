package com.dicoding.academy.myrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.util.zip.Inflater

class GridHeroAdapter(val listHeroes: ArrayList<Hero>) : RecyclerView.Adapter<GridHeroAdapter.GridViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

   fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
       this.onItemClickCallback = onItemClickCallback
   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridHeroAdapter.GridViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_grid_hero, parent, false)
        return GridViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listHeroes.size
    }

    override fun onBindViewHolder(holder: GridHeroAdapter.GridViewHolder, position: Int) {
        val hero = listHeroes[position]

        Glide.with(holder.itemView.context)
            .load(hero.photo)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)

        holder.namePhoto.text = hero.name
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listHeroes[holder.adapterPosition]) }
    }

    inner class GridViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var namePhoto: TextView = itemView.findViewById(R.id.name_item_photo)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Hero)
    }

}