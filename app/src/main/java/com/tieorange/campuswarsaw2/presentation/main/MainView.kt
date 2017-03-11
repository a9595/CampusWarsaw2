package com.tieorange.campuswarsaw2.presentation.main

import android.support.annotation.LayoutRes
import android.widget.TextView
import com.infullmobile.android.infullmvp.PresentedActivityView
import com.tieorange.campuswarsaw2.R

open class MainView()
    : PresentedActivityView<MainPresenter>() {

    @LayoutRes override val layoutResId = R.layout.activity_main
    val textView: TextView by bindView(R.id.text_view)

    override fun onViewsBound() {

    }

    fun showHtmlContent(html: String) {
        textView.setText("Hello")
    }
}
