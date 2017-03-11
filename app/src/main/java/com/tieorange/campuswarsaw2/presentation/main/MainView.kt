package com.tieorange.campuswarsaw2.presentation.main

import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import com.infullmobile.android.infullmvp.PresentedActivityView
import com.tieorange.campuswarsaw2.R

open class MainView()
    : PresentedActivityView<MainPresenter>() {

    @LayoutRes override val layoutResId = R.layout.activity_main

    val list: RecyclerView by bindView(R.id.main_events_list)
    private lateinit var adapter: MainEventsAdapter

    override fun onViewsBound() {
        initList()
    }


    private fun initList() {
        adapter = MainEventsAdapter()
        list.adapter = adapter
    }

    fun showEvents(eventsList: ArrayList<Event>) {
        adapter.setData(eventsList)
    }


}
