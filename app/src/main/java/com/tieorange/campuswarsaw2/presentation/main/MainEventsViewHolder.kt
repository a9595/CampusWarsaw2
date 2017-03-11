package com.tieorange.campuswarsaw2.presentation.main

import android.view.View
import android.widget.TextView
import com.infullmobile.android.infullmvp.bindView
import com.tieorange.campuswarsaw2.R
import com.tieorange.campuswarsaw2.presentation.common.BaseViewHolder

class MainEventsViewHolder(view: View) : BaseViewHolder<Event>(view) {
    val name: TextView by bindView(R.id.event_name)

    override fun displayItem(item: Event) {
        name.text = item.name
    }

}