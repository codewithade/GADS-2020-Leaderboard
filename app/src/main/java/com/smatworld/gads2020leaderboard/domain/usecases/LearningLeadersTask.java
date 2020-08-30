package com.smatworld.gads2020leaderboard.domain.usecases;

import com.smatworld.gads2020leaderboard.domain.repository.LeaderRepository;

import javax.inject.Inject;

public class LearningLeadersTask {
    private LeaderRepository mLeaderRepository;

    @Inject
    public LearningLeadersTask(LeaderRepository leaderRepository) {
        mLeaderRepository = leaderRepository;
    }
}
