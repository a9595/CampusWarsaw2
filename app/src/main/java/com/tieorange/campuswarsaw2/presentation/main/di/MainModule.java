package com.tieorange.campuswarsaw2.presentation.main.di;

import android.content.Context;

import com.tieorange.campuswarsaw2.presentation.main.MainActivity;
import com.tieorange.campuswarsaw2.presentation.main.MainModel;
import com.tieorange.campuswarsaw2.presentation.main.MainPresenter;
import com.tieorange.campuswarsaw2.presentation.main.MainView;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    private MainActivity activity;

    public MainModule(MainActivity activity) {
        this.activity = activity;
    }

    @MainScope
    @Provides
    Context providesContext() {
        return activity;
    }

    @MainScope
    @Provides
    MainView providesMainView() {
        return new MainView();
    }

    @MainScope
    @Provides
    public MainModel providesMainModel() {
        return new MainModel();
    }

    @MainScope
    @Provides
    MainPresenter providesMainPresenter(MainModel model,
            MainView view) {
        return new MainPresenter(model, view);
    }
}
