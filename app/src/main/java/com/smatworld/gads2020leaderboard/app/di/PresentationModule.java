package com.smatworld.gads2020leaderboard.app.di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.smatworld.gads2020leaderboard.presentation.factory.ViewModelProviderFactory;
import com.smatworld.gads2020leaderboard.presentation.viewmodels.LearningViewModel;
import com.smatworld.gads2020leaderboard.presentation.viewmodels.SkillViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/*This module provides dependency for AuthViewModel itself.
  Remember we have added @inject annotation in AuthViewModel constructor.*/
@Module
public abstract class PresentationModule {

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory viewModelProviderFactory);

    @Binds
    @IntoMap
    @ViewModelKey(LearningViewModel.class)
    public abstract ViewModel bindLearningViewModel(LearningViewModel learningViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(SkillViewModel.class)
    public abstract ViewModel bindSkillViewModel(SkillViewModel skillViewModel);

}
