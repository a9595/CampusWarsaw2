package com.tieorange.campuswarsaw2.presentation.main

import android.os.Bundle
import android.net.Uri
import com.infullmobile.android.infullmvp.Presenter

open class MainPresenter(private val model: MainModel,
                         view: MainView) : Presenter<MainView>(view) {

    override fun bind(intentBundle: Bundle, savedInstanceState: Bundle, intentData: Uri?) {

    }
}
