package com.tieorange.campuswarsaw2.presentation.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.infullmobile.android.infullmvp.InFullMvpActivity
import com.tieorange.campuswarsaw2.presentation.main.di.MainGraph
import javax.inject.Inject

class MainActivity : InFullMvpActivity<MainPresenter, MainView>() {

    @Inject lateinit var mainPresenter: MainPresenter
    @Inject lateinit var mainView: MainView
    lateinit var mainGraph: MainGraph

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainGraph = MainGraph(this)
    }

    override val presenter: MainPresenter get() = mainPresenter
    override val presentedView: MainView get() = mainView

    override fun injectIntoGraph() {
        mainGraph.inject(this)
    }

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }
}
