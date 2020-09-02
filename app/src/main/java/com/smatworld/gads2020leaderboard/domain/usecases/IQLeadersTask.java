package com.smatworld.gads2020leaderboard.domain.usecases;

import androidx.lifecycle.LiveData;

import com.smatworld.gads2020leaderboard.domain.entities.SkillIQ;
import com.smatworld.gads2020leaderboard.domain.repository.LeaderRepository;
import com.smatworld.gads2020leaderboard.domain.usecases.base.ObservableUseCase;

import java.util.List;

import javax.inject.Inject;

public class IQLeadersTask extends ObservableUseCase<List<SkillIQ>> {
    private LeaderRepository mLeaderRepository;

    @Inject
    public IQLeadersTask(LeaderRepository leaderRepository) {
        mLeaderRepository = leaderRepository;
    }

    @Override
    protected LiveData<List<SkillIQ>> generateObservable() {
        return mLeaderRepository.getSkillIQLeaders();
    }
}
