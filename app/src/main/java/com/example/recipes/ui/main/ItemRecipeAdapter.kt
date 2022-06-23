package com.example.recipes.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recipes.R
import com.example.recipes.entity.Meals

class ItemRecipeAdapter(
    private val listOfRecipes: List<Meals>, private val context: Context,
    private val listener: OnItemCallbacks
) :
    RecyclerView.Adapter<ItemRecipeAdapter.ItemRecipeViewHolder>() {
    class ItemRecipeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.item_recipe_name_text_view)
        val imageView: ImageView = view.findViewById(R.id.item_recipe_image_view)
        val mainContainer: ConstraintLayout = view.findViewById(R.id.item_recipe_main_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemRecipeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recipe, parent, false)
        return ItemRecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemRecipeViewHolder, position: Int) {
        val model = listOfRecipes[position]
        holder.nameTextView.text = model.strMeal
        Glide.with(context).load(model.strMealThumb).into(holder.imageView)
        holder.mainContainer.setOnClickListener {
            listener.onItemClicked(model.idMeal)
        }
    }

    override fun getItemCount(): Int {
        return listOfRecipes.size
    }

    interface OnItemCallbacks {
        fun onItemClicked(id: String?)
    }
}