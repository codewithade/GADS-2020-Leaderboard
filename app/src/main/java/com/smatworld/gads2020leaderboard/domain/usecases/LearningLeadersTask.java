package com.smatworld.gads2020leaderboard.domain.usecases;

import androidx.lifecycle.LiveData;

import com.smatworld.gads2020leaderboard.domain.entities.LearningLeaders;
import com.smatworld.gads2020leaderboard.domain.repository.LeaderRepository;
import com.smatworld.gads2020leaderboard.domain.usecases.base.ObservableUseCase;

import java.util.List;

import javax.inject.Inject;

public class LearningLeadersTask extends ObservableUseCase<List<LearningLeaders>> {
    private LeaderRepository mLeaderRepository;

    @Inject
    public LearningLeadersTask(LeaderRepository leaderRepository) {
        mLeaderRepository = leaderRepository;
    }

    @Override
    protected LiveData<List<LearningLeaders>> generateObservable() {
        return mLeaderRepository.getLearningHourLeaders();
    }
}
