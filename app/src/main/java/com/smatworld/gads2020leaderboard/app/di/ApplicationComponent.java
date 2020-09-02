package com.smatworld.gads2020leaderboard.app.di;

import android.content.Context;

import com.smatworld.gads2020leaderboard.app.ui.LearningFragment;
import com.smatworld.gads2020leaderboard.app.ui.SkillFragment;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {DataModule.class, PresentationModule.class, RemoteModule.class, LocalModule.class})
public interface ApplicationComponent {

    // Factory to create instances of the AppComponent
    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        ApplicationComponent create(@BindsInstance Context context);
    }

    // Classes that can be injected by this Component
    // This tells Dagger that WelcomeFragment requests injection from AuthComponent
    // so that this subcomponent graph needs to satisfy all the dependencies of the
    // fields that WelcomeFragment is injecting
    void inject(LearningFragment learningFragment);

    void inject(SkillFragment skillFragment);
}
