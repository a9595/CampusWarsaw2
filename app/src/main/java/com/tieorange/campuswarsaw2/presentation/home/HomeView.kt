package com.tieorange.campuswarsaw2.presentation.home

import android.support.annotation.LayoutRes
import com.infullmobile.android.infullmvp.PresentedActivityView
import com.tieorange.campuswarsaw2.R

open class HomeView()
    : PresentedActivityView<HomePresenter>() {

    @LayoutRes override val layoutResId = R.layout.activity_home

    override fun onViewsBound() {

    }
}
