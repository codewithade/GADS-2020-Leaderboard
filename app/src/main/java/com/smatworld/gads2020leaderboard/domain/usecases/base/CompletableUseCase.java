package com.smatworld.gads2020leaderboard.domain.usecases.base;

import androidx.lifecycle.LiveData;

import com.smatworld.gads2020leaderboard.app.utils.State;

public abstract class CompletableUseCase<Input> {

    protected abstract LiveData<State> generateCompletable(Input input);

    public LiveData<State> buildUseCase(Input input) {
        return generateCompletable(input);
    }
}
