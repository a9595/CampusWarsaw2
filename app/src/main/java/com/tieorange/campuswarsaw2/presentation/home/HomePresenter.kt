package com.tieorange.campuswarsaw2.presentation.home

import android.os.Bundle
import android.net.Uri
import com.infullmobile.android.infullmvp.Presenter

open class HomePresenter(private val model: HomeModel,
                         view: HomeView) : Presenter<HomeView>(view) {

    override fun bind(intentBundle: Bundle, savedInstanceState: Bundle, intentData: Uri?) {

    }
}
