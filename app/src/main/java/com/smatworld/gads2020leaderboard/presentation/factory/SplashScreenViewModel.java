package com.smatworld.gads2020leaderboard.presentation.factory;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

public class SplashScreenViewModel extends ViewModel {
    private MutableLiveData<Boolean> isFirstRun = new MutableLiveData<>();

    @Inject
    public SplashScreenViewModel() {
        isFirstRun.setValue(true);
    }

    public LiveData<Boolean> getIsFirstRun() {
        return isFirstRun;
    }

    public void setIsFirstRun(boolean isFirstRun) {
        this.isFirstRun.setValue(isFirstRun);
    }

}
