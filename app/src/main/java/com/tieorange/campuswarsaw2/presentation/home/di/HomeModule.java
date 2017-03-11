package com.tieorange.campuswarsaw2.presentation.home.di;

import android.content.Context;

import com.tieorange.campuswarsaw2.presentation.home.HomeActivity;
import com.tieorange.campuswarsaw2.presentation.home.HomeModel;
import com.tieorange.campuswarsaw2.presentation.home.HomePresenter;
import com.tieorange.campuswarsaw2.presentation.home.HomeView;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeModule {

    private HomeActivity activity;

    public HomeModule(HomeActivity activity) {
        this.activity = activity;
    }

    @HomeScope
    @Provides
    Context providesContext() {
        return activity;
    }

    @HomeScope
    @Provides
    HomeView providesHomeView() {
        return new HomeView();
    }

    @HomeScope
    @Provides
    public HomeModel providesHomeModel() {
        return new HomeModel();
    }

    @HomeScope
    @Provides
    HomePresenter providesHomePresenter(HomeModel model,
            HomeView view) {
        return new HomePresenter(model, view);
    }
}
