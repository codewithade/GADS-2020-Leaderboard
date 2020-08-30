package com.smatworld.gads2020leaderboard.domain.usecases.base;

import androidx.lifecycle.LiveData;

/*
* @param I signifies Input
* @param O signifies Output
*
* returns an observable of the specified Output Type*/
public abstract class ObservableUseCase<O, I> {

    protected abstract LiveData<O> generateObservable(I input);

    public LiveData<O> buildUseCase(I input) {
        return generateObservable(input);
    }
}
