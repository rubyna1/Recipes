package com.example.recipes.ui.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipes.R
import com.example.recipes.entity.Meals
import com.google.firebase.auth.FirebaseAuth
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_recipe.*
import javax.inject.Inject

class RecipeFragment : DaggerFragment(), ItemRecipeAdapter.OnItemCallbacks {
    @Inject
    lateinit var recipeViewModel: RecipeViewModel
    lateinit var adapter: ItemRecipeAdapter
    lateinit var listener: NavigationInterface

    private val listOfRecipes = mutableListOf<Meals>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recipe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() {
        adapter = ItemRecipeAdapter(listOfRecipes, requireContext(), this)
        fragment_recipe_recycler_view.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        fragment_recipe_recycler_view.adapter = adapter
        fragment_recipe_recycler_view.setItemViewCacheSize(listOfRecipes.size)

        recipeViewModel.getAllRecipes()
        recipeViewModel.allRecipes.observe(viewLifecycleOwner, Observer {
            if (it.isNullOrEmpty()) {
                fragment_recipe_recycler_view.visibility = View.GONE
                fragment_recipe_error_view.visibility = View.VISIBLE
                fragment_recipe_progress_bar.visibility = View.GONE
            } else {
                listOfRecipes.clear()
                listOfRecipes.addAll(it)
                fragment_recipe_recycler_view.visibility = View.VISIBLE
                fragment_recipe_error_view.visibility = View.GONE
                fragment_recipe_progress_bar.visibility = View.GONE
                adapter.notifyDataSetChanged()
            }
        })
        recipeViewModel.error.observe(viewLifecycleOwner, Observer {
            fragment_recipe_error_view.visibility = View.VISIBLE
            fragment_recipe_recycler_view.visibility = View.GONE
            fragment_recipe_progress_bar.visibility = View.GONE

        })

        fragment_recipe_logout_image_view.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            activity?.finish()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            RecipeFragment()
    }

    override fun onItemClicked(id: String?) {
        listener.onMealSelected(id)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as NavigationInterface
    }

    interface NavigationInterface {
        fun onMealSelected(id: String?)
    }
}