package com.tieorange.campuswarsaw2.presentation.main

import android.view.View
import com.tieorange.campuswarsaw2.R
import com.tieorange.campuswarsaw2.presentation.common.BaseAdapter
import com.tieorange.campuswarsaw2.presentation.common.BaseViewHolder


/**
 * Created by andrii.kovalchuk on 3/11/17.
 */
class MainEventsAdapter : BaseAdapter<MainEventsViewHolder, Event>() {
    override fun createHolder(view: View, viewType: Int) =  MainEventsViewHolder(view)

    override fun layoutId(viewType: Int) = R.layout.list_item_event

}

