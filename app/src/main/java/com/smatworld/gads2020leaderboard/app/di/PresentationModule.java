package com.smatworld.gads2020leaderboard.app.di;

import dagger.Module;

/*This module provides dependency for AuthViewModel itself.
  Remember we have added @inject annotation in AuthViewModel constructor.*/
@Module
public abstract class PresentationModule {

    /*@Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory viewModelProviderFactory);

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel.class)
    public abstract ViewModel bindAuthViewModel(AuthViewModel authViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(FeedbackViewModel.class)
    public abstract ViewModel bindFeedbackViewModel(FeedbackViewModel feedbackViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(GalleryViewModel.class)
    public abstract ViewModel bindGalleryViewModel(GalleryViewModel galleryViewModel);*/
}
