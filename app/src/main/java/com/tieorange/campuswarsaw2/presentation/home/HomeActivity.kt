package com.tieorange.campuswarsaw2.presentation.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.infullmobile.android.infullmvp.InFullMvpActivity
import com.tieorange.campuswarsaw2.presentation.home.di.HomeGraph
import javax.inject.Inject

class HomeActivity : InFullMvpActivity<HomePresenter, HomeView>() {

    @Inject lateinit var homePresenter: HomePresenter
    @Inject lateinit var homeView: HomeView
    lateinit var homeGraph: HomeGraph

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeGraph = HomeGraph(this)
    }

    override val presenter: HomePresenter get() = homePresenter
    override val presentedView: HomeView get() = homeView

    override fun injectIntoGraph() {
        homeGraph.inject(this)
    }

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, HomeActivity::class.java)
        }
    }
}
