package com.example.recipes.ui.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipes.entity.MealModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailsViewModel @Inject constructor(private val detailsRepository: DetailsRepository) :
    ViewModel() {
    var detailsResponse = MutableLiveData<MealModel>()
    var error = MutableLiveData<String>()
    fun getMealDetails(id: String) {
        viewModelScope.launch {
            val response = detailsRepository.getMealDetails(id)
            if (response.isSuccessful) {
                detailsResponse.value = response.body()
            } else {
                error.value = response.message()
            }
        }
    }
}