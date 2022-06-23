package com.example.recipes.ui.main

import com.example.recipes.network.ApiService
import javax.inject.Inject

class RecipeRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getAllRecipes() = apiService.getAllMeals("Dessert")
}