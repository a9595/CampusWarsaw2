package com.tieorange.campuswarsaw2.presentation.main.di;

import android.support.annotation.VisibleForTesting;

import com.tieorange.campuswarsaw2.presentation.main.MainActivity;

import dagger.Component;

public class MainGraph {

    private final DaggerMainGraph_MainComponent.Builder builder;

    public MainGraph(MainActivity activity) {
        this.builder = DaggerMainGraph_MainComponent
                .builder()
                .mainModule(new MainModule(activity));
    }

    public void inject(MainActivity activity) {
        builder.build().inject(activity);
    }

    @VisibleForTesting
    public void setMainModule(MainModule module) {
        builder.mainModule(module);
    }

    @MainScope
    @Component(
            modules = MainModule.class
    )
    public interface MainComponent {
        void inject(MainActivity activity);
    }
}
