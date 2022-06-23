package com.example.recipes.di

import android.app.Application
import com.example.recipes.Recipes
import com.example.recipes.di.modules.ActivityBindingModule
import com.example.recipes.di.modules.ApiModule
import com.example.recipes.di.modules.ApplicationBindingModule
import com.example.recipes.di.modules.FragmentBindingModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [(AndroidSupportInjectionModule::class), (ActivityBindingModule::class), (FragmentBindingModule::class),
        (ApiModule::class),(ApplicationBindingModule::class)]
)
interface AppComponent : AndroidInjector<Recipes> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(App: Application): Builder
        fun build(): AppComponent
    }
}