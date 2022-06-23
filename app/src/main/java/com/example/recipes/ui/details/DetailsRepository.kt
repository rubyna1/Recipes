package com.example.recipes.ui.details

import com.example.recipes.network.ApiService
import javax.inject.Inject

class DetailsRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getMealDetails(id: String) = apiService.getMealsDetails(id)
}