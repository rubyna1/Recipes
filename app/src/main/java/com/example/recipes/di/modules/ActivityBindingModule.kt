package com.example.recipes.di.modules

import com.example.recipes.di.scopes.ActivityScope
import com.example.recipes.ui.login.LoginActivity
import com.example.recipes.ui.main.MainActivity
import com.example.recipes.ui.register.RegisterActivity
import com.example.recipes.ui.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ActivityScope
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun bindLoginActivity(): LoginActivity

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun bindSplashActivity(): SplashActivity

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun bindRegisterActivity(): RegisterActivity
}