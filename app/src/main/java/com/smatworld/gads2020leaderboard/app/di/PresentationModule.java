package com.smatworld.gads2020leaderboard.app.di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.smatworld.gads2020leaderboard.presentation.factory.SplashScreenViewModel;
import com.smatworld.gads2020leaderboard.presentation.factory.ViewModelProviderFactory;
import com.smatworld.gads2020leaderboard.presentation.viewmodels.LearningViewModel;
import com.smatworld.gads2020leaderboard.presentation.viewmodels.ProjectSubmissionViewModel;
import com.smatworld.gads2020leaderboard.presentation.viewmodels.SkillViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/*This module provides dependency for any ViewModel
  Remember we added @inject annotation in all the ViewModel constructor.*/
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

    @Binds
    @IntoMap
    @ViewModelKey(ProjectSubmissionViewModel.class)
    public abstract ViewModel bindProjectSubmissionViewModel(ProjectSubmissionViewModel submissionViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(SplashScreenViewModel.class)
    public abstract ViewModel bindSplashScreenViewModel(SplashScreenViewModel screenViewModel);

}
