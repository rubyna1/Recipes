package com.example.recipes.ui.details

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.RelativeLayout.LayoutParams.WRAP_CONTENT
import android.widget.TextView
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.recipes.R
import com.example.recipes.entity.MealModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_details.*
import javax.inject.Inject


private const val MEAL_ID = "meal_id"

class DetailsFragment : DaggerFragment() {
    @Inject
    lateinit var detailsViewModel: DetailsViewModel
    private var mealId: String? = null
    private val ingredientTextView = arrayOfNulls<TextView>(20)

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
                val ingredientsList = getIngredientsList(it)
                val measurementList = getMeasurementList(it)
                for (i in 0 until ingredientsList.size) {
                    if (!ingredientsList[i].isNullOrEmpty() && !measurementList[i].isNullOrEmpty()
                    ) {
                        ingredientTextView[i] = TextView(context)
                        val params = RelativeLayout.LayoutParams(
                            WRAP_CONTENT, WRAP_CONTENT
                        )
                        params.leftMargin = 50
                        params.topMargin = i * 50
                        ingredientTextView[i]?.text = ingredientsList[i] + ":" + measurementList[i]
                        ingredientTextView[i]!!.textSize = 16f
                        ingredientTextView[i]!!.setPadding(20, 50, 20, 50)
                        ingredientTextView[i]!!.setTextColor(resources.getColor(R.color.gray))
                        ingredientTextView[i]!!.layoutParams = params
                        fragment_details_ingredients_and_mesure_view.addView(ingredientTextView[i])
                    } else {
                        break
                    }
                }
            }
        })
    }

    private fun getIngredientsList(model: MealModel): MutableList<String?> {
        return mutableListOf(
            model.meals[0].strIngredient1,
            model.meals[0].strIngredient2,
            model.meals[0].strIngredient3,
            model.meals[0].strIngredient4,
            model.meals[0].strIngredient5,
            model.meals[0].strIngredient6,
            model.meals[0].strIngredient7,
            model.meals[0].strIngredient8,
            model.meals[0].strIngredient9,
            model.meals[0].strIngredient10,
            model.meals[0].strIngredient11,
            model.meals[0].strIngredient12,
            model.meals[0].strIngredient13,
            model.meals[0].strIngredient14,
            model.meals[0].strIngredient15,
            model.meals[0].strIngredient16,
            model.meals[0].strIngredient17,
            model.meals[0].strIngredient18,
            model.meals[0].strIngredient19,
            model.meals[0].strIngredient10
        )
    }

    private fun getMeasurementList(model: MealModel): MutableList<String?> {
        return mutableListOf(
            model.meals[0].strMeasure1,
            model.meals[0].strMeasure2,
            model.meals[0].strMeasure3,
            model.meals[0].strMeasure4,
            model.meals[0].strMeasure5,
            model.meals[0].strMeasure6,
            model.meals[0].strMeasure7,
            model.meals[0].strMeasure8,
            model.meals[0].strMeasure9,
            model.meals[0].strMeasure10,
            model.meals[0].strMeasure11,
            model.meals[0].strMeasure12,
            model.meals[0].strMeasure13,
            model.meals[0].strMeasure14,
            model.meals[0].strMeasure15,
            model.meals[0].strMeasure16,
            model.meals[0].strMeasure17,
            model.meals[0].strMeasure18,
            model.meals[0].strMeasure19,
            model.meals[0].strMeasure20
        )
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