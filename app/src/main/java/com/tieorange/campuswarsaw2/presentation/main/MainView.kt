package com.tieorange.campuswarsaw2.presentation.main

import android.support.annotation.LayoutRes
import com.infullmobile.android.infullmvp.PresentedActivityView
import com.tieorange.campuswarsaw2.R

open class MainView()
    : PresentedActivityView<MainPresenter>() {

    @LayoutRes override val layoutResId = R.layout.activity_main

    override fun onViewsBound() {

    }
}
