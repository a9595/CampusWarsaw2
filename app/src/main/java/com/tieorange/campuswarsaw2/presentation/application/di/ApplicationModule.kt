package com.tieorange.campuswarsaw2.presentation.application.di

import android.content.Context
import android.content.SharedPreferences

import com.tieorange.campuswarsaw2.presentation.CampusApplication

import javax.inject.Singleton

import dagger.Module
import dagger.Provides

/**
 * Created by andrii.kovalchuk on 3/11/17.
 */

@Module
class ApplicationModule(private val app: CampusApplication) {

    @Provides
    @Singleton
    internal fun provideApplicationContext(): Context {
        return this.app
    }

    @Provides
    @Singleton
    internal fun providesSharedPreferences(): SharedPreferences {
        return app.getSharedPreferences(SHARED_PREFERENCES_FILE, Context.MODE_PRIVATE)
    }

    companion object {
        val SHARED_PREFERENCES_FILE = "prefs"
    }
}
