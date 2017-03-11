package com.tieorange.campuswarsaw2.presentation.application.di

import javax.inject.Singleton

import dagger.Component

/**
 * Created by andrii.kovalchuk on 3/11/17.
 */

@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {
    //    GetDrugCategories providesGetCategoriesUseCase();
}
