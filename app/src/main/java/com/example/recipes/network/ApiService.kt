package com.example.recipes.network

import com.example.recipes.entity.MealModel
import com.example.recipes.entity.RecipeModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("filter.php")
    suspend fun getAllMeals(
        @Query("c") c: String
    ): Response<RecipeModel>

    @GET("lookup.php")
    suspend fun getMealsDetails(
        @Query("i") i: String
    ): Response<MealModel>
}