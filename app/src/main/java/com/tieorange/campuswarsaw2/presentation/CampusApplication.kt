package com.tieorange.campuswarsaw2.presentation

import android.app.Application

/**
 * Created by andrii.kovalchuk on 3/11/17.
 */

open class CampusApplication : Application() {
//    lateinit internal var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
//        applicationComponent = buildComponent();
    }

   /* open protected fun buildComponent(): ApplicationComponent {
        return ApplicationGraph(this).getComponent()
    }

    override fun getComponent(): ApplicationComponent {
        return applicationComponent
    }*/
}

interface HasComponent<out T> {
    fun getComponent(): T
}
