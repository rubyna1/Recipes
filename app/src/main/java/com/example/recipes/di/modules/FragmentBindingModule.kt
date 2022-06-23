package com.example.recipes.di.modules

import com.example.recipes.di.scopes.FragmentScope
import com.example.recipes.ui.details.DetailsFragment
import com.example.recipes.ui.main.RecipeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindingModule {
    @FragmentScope
    @ContributesAndroidInjector
    abstract fun bindRecipeFragment(): RecipeFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun bindDetailsFragment(): DetailsFragment
}