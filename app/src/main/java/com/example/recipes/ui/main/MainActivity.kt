package com.example.recipes.ui.main

import android.os.Bundle
import com.example.recipes.R
import com.example.recipes.ui.details.DetailsFragment
import com.example.recipes.utils.Constants.DETAILS_FRAGMENT
import com.example.recipes.utils.Constants.RECIPE_FRAGMENT
import dagger.android.support.DaggerAppCompatActivity
import dagger.android.support.DaggerFragment

class MainActivity : DaggerAppCompatActivity(), RecipeFragment.NavigationInterface {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_container)
        initialize()
    }

    private fun initialize() {
        showFragment(RecipeFragment.newInstance(), RECIPE_FRAGMENT)
    }

    private fun showFragment(fragment: DaggerFragment, tag: String) {
        supportFragmentManager.beginTransaction()
            .add(R.id.activity_main_container, fragment, tag)
            .addToBackStack(tag)
            .commit()
    }

    override fun onMealSelected(id: String?) {
        showFragment(DetailsFragment.newInstance(id), DETAILS_FRAGMENT)
    }
}