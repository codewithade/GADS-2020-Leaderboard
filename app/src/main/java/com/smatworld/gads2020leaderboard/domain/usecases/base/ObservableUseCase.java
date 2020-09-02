package com.smatworld.gads2020leaderboard.domain.usecases.base;

import androidx.lifecycle.LiveData;

/*
 * @param I signifies Input data
 * @param O signifies Output data
 *
 * returns an observable of the specified Output Type*/
public abstract class ObservableUseCase<O> {

    protected abstract LiveData<O> generateObservable();

    public LiveData<O> buildUseCase() {
        return generateObservable();
    }
}
