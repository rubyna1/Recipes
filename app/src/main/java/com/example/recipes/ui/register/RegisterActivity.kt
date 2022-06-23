package com.example.recipes.ui.register

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.recipes.R
import com.example.recipes.ui.main.MainActivity
import com.example.recipes.utils.hideSoftKeyboard
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : DaggerAppCompatActivity() {
    private var mAuth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        initialize()
    }

    private fun initialize() {
        mAuth = Firebase.auth
        val currentUser = mAuth?.currentUser
        if (currentUser != null) {
            val intent = Intent(this@RegisterActivity, MainActivity::class.java)
            startActivity(intent)
        }
        activity_register_back_button.setOnClickListener {
            onBackPressed()
        }
        activity_register_button.setOnClickListener {
            hideSoftKeyboard(this)
            if (activity_register_email_edit_text.text.isNullOrEmpty() || activity_register_password_edit_text.text.isNullOrEmpty()) {
                Toast.makeText(
                    baseContext,
                    "Email and Password can not be empty",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                activity_register_progress_bar.visibility = View.VISIBLE
                mAuth?.createUserWithEmailAndPassword(
                    activity_register_email_edit_text.text.toString(),
                    activity_register_password_edit_text.text.toString()
                )?.addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        activity_register_progress_bar.visibility = View.GONE
                        activity_register_email_edit_text.text.clear()
                        activity_register_email_edit_text.clearFocus()
                        activity_register_password_edit_text.text.clear()
                        activity_register_password_edit_text.clearFocus()
                        val intent = Intent(this@RegisterActivity, MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        activity_register_progress_bar.visibility = View.GONE
                        Toast.makeText(
                            baseContext, "${task.exception?.message}!!!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }
}