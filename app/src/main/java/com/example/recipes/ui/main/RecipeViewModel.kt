package com.example.recipes.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipes.entity.Meals
import kotlinx.coroutines.launch
import javax.inject.Inject

class RecipeViewModel @Inject constructor(private val recipeRepository: RecipeRepository) :
    ViewModel() {
    var allRecipes = MutableLiveData<List<Meals>>()
    var error = MutableLiveData<String>()
    fun getAllRecipes() {
        viewModelScope.launch {
            val response = recipeRepository.getAllRecipes()
            if (response.isSuccessful) {
                allRecipes.value = response.body()?.meals
            } else {
                error.value = response.message()
            }

        }
    }
}