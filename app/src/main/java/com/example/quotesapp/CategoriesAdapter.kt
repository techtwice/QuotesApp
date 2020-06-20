package com.example.quotesapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class CategoriesAdapter(val context: Context, val categories: List<CategoryData>) :
    RecyclerView.Adapter<CategoriesAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.category_item, parent, false)
        val myViewHolder = MyViewHolder(view)

        return myViewHolder
    }

    override fun getItemCount(): Int {
        return categories.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder!!.bindData(categories[position], context)
    }

    //Tis Class will be used for either create or Views
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val categoryImage = itemView!!.findViewById<ImageView>(R.id.ivCategoryImage)
        val categoryName = itemView!!.findViewById<TextView>(R.id.tvCategoryName)
        fun bindData(category: CategoryData, context: Context) {
            categoryImage.setImageResource(category.resourceId)
            categoryName.text = category.name
        }
    }


}