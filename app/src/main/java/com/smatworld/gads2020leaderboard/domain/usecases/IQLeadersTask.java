package com.smatworld.gads2020leaderboard.domain.usecases;

import com.smatworld.gads2020leaderboard.domain.repository.LeaderRepository;

import javax.inject.Inject;

public class IQLeadersTask {
    private LeaderRepository mLeaderRepository;

    @Inject
    public IQLeadersTask(LeaderRepository leaderRepository) {
        mLeaderRepository = leaderRepository;
    }
}
