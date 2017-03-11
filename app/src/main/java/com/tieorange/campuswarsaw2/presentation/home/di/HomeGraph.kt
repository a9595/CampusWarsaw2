package com.tieorange.campuswarsaw2.presentation.home.di

import android.app.Application
import android.support.annotation.VisibleForTesting
import com.tieorange.campuswarsaw2.presentation.CampusApplication
import com.tieorange.campuswarsaw2.presentation.HasComponent

import com.tieorange.campuswarsaw2.presentation.application.di.ApplicationComponent
import com.tieorange.campuswarsaw2.presentation.home.HomeActivity

import dagger.Component

class HomeGraph(activity: HomeActivity) {

    private val builder: DaggerHomeGraph_HomeComponent.Builder

    init {
        this.builder = DaggerHomeGraph_HomeComponent
                .builder()
                .applicationComponent(Components.from(activity.application))
                .homeModule(HomeModule(activity))
    }

    fun inject(activity: HomeActivity) {
        builder.build().inject(activity)
    }

    @VisibleForTesting
    fun setHomeModule(module: HomeModule) {
        builder.homeModule(module)
    }

    @HomeScope
    @Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(HomeModule::class))
    interface HomeComponent {
        fun inject(activity: HomeActivity)
    }
}

class Components private constructor() {

    init {
        throw AssertionError("No instances.")
    }

    companion object {

        fun <T> from(withComponent: HasComponent<T>): T {
            return withComponent.getComponent()
        }

        //We are unable to reach application in its derived type
        fun from(application: Application): ApplicationComponent {
            return (application as CampusApplication).getComponent()
        }
    }
}