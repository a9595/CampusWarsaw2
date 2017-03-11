package com.tieorange.campuswarsaw2.presentation.application.di

import com.tieorange.campuswarsaw2.presentation.CampusApplication
import dagger.internal.DaggerCollections

class ApplicationGraph(application: CampusApplication) {
    private var componentBuilder: DaggerApplicationComponent.Builder

    init {
        componentBuilder = DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(application))
    }

    fun getComponent(): ApplicationComponent {
        return componentBuilder.build()
    }
}