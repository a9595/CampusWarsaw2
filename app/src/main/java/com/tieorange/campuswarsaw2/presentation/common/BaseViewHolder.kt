package com.tieorange.campuswarsaw2.presentation.common

import android.support.v7.widget.RecyclerView
import android.view.View

abstract class BaseViewHolder<ItemType>(view: View) : RecyclerView.ViewHolder(view) {

    var onItemSelectedListener: ((listItem: ItemType) -> Unit)? = null

    abstract fun displayItem(item: ItemType)
}