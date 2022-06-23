package com.example.recipes.ui.details

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.recipes.R
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_details.*
import javax.inject.Inject


private const val MEAL_ID = "meal_id"

class DetailsFragment : DaggerFragment() {
    @Inject
    lateinit var detailsViewModel: DetailsViewModel
    private var mealId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            mealId = it.getString(MEAL_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    @SuppressLint("SetTextI18n")
    private fun initialize() {
        mealId?.let {
            detailsViewModel.getMealDetails(it)
        }
        fragment_details_back_image_view.setOnClickListener {
            activity?.onBackPressed()
        }
        detailsViewModel.detailsResponse.observe(viewLifecycleOwner, Observer {
            if (it.meals.isNotEmpty()) {
                fragment_details_main_view.visibility = View.VISIBLE
                fragment_details_progress_bar.visibility = View.GONE
                Glide.with(requireContext()).load(it.meals[0].strMealThumb)
                    .into(fragment_details_image_view)
                if (!it.meals[0].strMeal.isNullOrEmpty()) {
                    fragment_details_meal_name_text_view.text = it.meals[0].strMeal
                }
                if (!it.meals[0].strInstructions.isNullOrEmpty()) {
                    fragment_details_instructions_text_view.text = it.meals[0].strInstructions
                }
                if (!it.meals[0].strIngredient1.isNullOrEmpty() && !it.meals[0].strMeasure1.isNullOrEmpty()) {
                    fragment_details_ingredients_text_view1.text =
                        it.meals[0].strIngredient1 + ":" + it.meals[0].strMeasure1
                }
                if (!it.meals[0].strIngredient2.isNullOrEmpty() && !it.meals[0].strMeasure2.isNullOrEmpty()) {
                    fragment_details_ingredients_text_view2.text =
                        it.meals[0].strIngredient2 + ":" + it.meals[0].strMeasure2
                }
                if (!it.meals[0].strIngredient3.isNullOrEmpty() && !it.meals[0].strMeasure3.isNullOrEmpty()) {
                    fragment_details_ingredients_text_view3.text =
                        it.meals[0].strIngredient3 + ":" + it.meals[0].strMeasure3
                }
                if (!it.meals[0].strIngredient4.isNullOrEmpty() && !it.meals[0].strMeasure4.isNullOrEmpty()) {
                    fragment_details_ingredients_text_view4.text =
                        it.meals[0].strIngredient4 + ":" + it.meals[0].strMeasure4
                }
                if (!it.meals[0].strIngredient5.isNullOrEmpty() && !it.meals[0].strMeasure5.isNullOrEmpty()) {
                    fragment_details_ingredients_text_view5.text =
                        it.meals[0].strIngredient5 + ":" + it.meals[0].strMeasure5
                }
                if (!it.meals[0].strIngredient6.isNullOrEmpty() && !it.meals[0].strMeasure6.isNullOrEmpty()) {
                    fragment_details_ingredients_text_view6.text =
                        it.meals[0].strIngredient6 + ":" + it.meals[0].strMeasure6
                }
                if (!it.meals[0].strIngredient7.isNullOrEmpty() && !it.meals[0].strMeasure7.isNullOrEmpty()) {
                    fragment_details_ingredients_text_view7.text =
                        it.meals[0].strIngredient7 + ":" + it.meals[0].strMeasure7
                }
                if (!it.meals[0].strIngredient8.isNullOrEmpty() && !it.meals[0].strMeasure8.isNullOrEmpty()) {
                    fragment_details_ingredients_text_view8.text =
                        it.meals[0].strIngredient8 + ":" + it.meals[0].strMeasure8
                }
                if (!it.meals[0].strIngredient9.isNullOrEmpty() && !it.meals[0].strMeasure9.isNullOrEmpty()) {
                    fragment_details_ingredients_text_view9.text =
                        it.meals[0].strIngredient9 + ":" + it.meals[0].strMeasure9
                }
                if (!it.meals[0].strIngredient10.isNullOrEmpty() && !it.meals[0].strMeasure10.isNullOrEmpty()) {
                    fragment_details_ingredients_text_view10.text =
                        it.meals[0].strIngredient10 + ":" + it.meals[0].strMeasure10
                }
                if (!it.meals[0].strIngredient11.isNullOrEmpty() && !it.meals[0].strMeasure11.isNullOrEmpty()) {
                    fragment_details_ingredients_text_view11.text =
                        it.meals[0].strIngredient11 + ":" + it.meals[0].strMeasure11
                }
                if (!it.meals[0].strIngredient12.isNullOrEmpty() && !it.meals[0].strMeasure12.isNullOrEmpty()) {
                    fragment_details_ingredients_text_view12.text =
                        it.meals[0].strIngredient12 + ":" + it.meals[0].strMeasure12
                }
                if (!it.meals[0].strIngredient13.isNullOrEmpty() && !it.meals[0].strMeasure13.isNullOrEmpty()) {
                    fragment_details_ingredients_text_view13.text =
                        it.meals[0].strIngredient13 + ":" + it.meals[0].strMeasure13
                }
                if (!it.meals[0].strIngredient14.isNullOrEmpty() && !it.meals[0].strMeasure14.isNullOrEmpty()) {
                    fragment_details_ingredients_text_view14.text =
                        it.meals[0].strIngredient14 + ":" + it.meals[0].strMeasure14
                }
                if (!it.meals[0].strIngredient15.isNullOrEmpty() && !it.meals[0].strMeasure15.isNullOrEmpty()) {
                    fragment_details_ingredients_text_view15.text =
                        it.meals[0].strIngredient15 + ":" + it.meals[0].strMeasure15
                }
                if (!it.meals[0].strIngredient16.isNullOrEmpty() && !it.meals[0].strMeasure16.isNullOrEmpty()) {
                    fragment_details_ingredients_text_view16.text =
                        it.meals[0].strIngredient16 + ":" + it.meals[0].strMeasure16
                }
                if (!it.meals[0].strIngredient17.isNullOrEmpty() && !it.meals[0].strMeasure17.isNullOrEmpty()) {
                    fragment_details_ingredients_text_view17.text =
                        it.meals[0].strIngredient17 + ":" + it.meals[0].strMeasure17
                }
                if (!it.meals[0].strIngredient18.isNullOrEmpty() && !it.meals[0].strMeasure18.isNullOrEmpty()) {
                    fragment_details_ingredients_text_view18.text =
                        it.meals[0].strIngredient18 + ":" + it.meals[0].strMeasure18
                }
                if (!it.meals[0].strIngredient19.isNullOrEmpty() && !it.meals[0].strMeasure19.isNullOrEmpty()) {
                    fragment_details_ingredients_text_view19.text =
                        it.meals[0].strIngredient19 + ":" + it.meals[0].strMeasure19
                }
                if (!it.meals[0].strIngredient20.isNullOrEmpty() && !it.meals[0].strMeasure20.isNullOrEmpty()) {
                    fragment_details_ingredients_text_view20.text =
                        it.meals[0].strIngredient20 + ":" + it.meals[0].strMeasure20
                }
            }
        })
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String?) =
            DetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(MEAL_ID, param1)
                }
            }
    }
}