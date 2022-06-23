package com.example.recipes.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import com.example.recipes.R
import com.example.recipes.ui.login.LoginActivity
import com.example.recipes.ui.main.MainActivity
import com.example.recipes.ui.register.RegisterActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_splash.*


@SuppressLint("CustomSplashScreen")
class SplashActivity : DaggerAppCompatActivity() {
    private var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        initialize()
    }

    private fun initialize() {
        mAuth = Firebase.auth
        val currentUser = mAuth?.currentUser
        if (currentUser != null) {
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
        }
        activity_login_button.setOnClickListener {
            val intent = Intent(this@SplashActivity, LoginActivity::class.java)
            startActivity(intent)
        }
        activity_register_button.setOnClickListener {
            val intent = Intent(this@SplashActivity, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}