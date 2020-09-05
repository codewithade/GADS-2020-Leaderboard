package com.smatworld.gads2020leaderboard.local.source;

import androidx.lifecycle.LiveData;

import com.smatworld.gads2020leaderboard.data.repository.LocalDataSource;
import com.smatworld.gads2020leaderboard.domain.entities.LearningLeaders;
import com.smatworld.gads2020leaderboard.domain.entities.SkillIQ;

import java.util.List;

import javax.inject.Inject;

// fulfills the contract set by the Data layer but not used for now
public class LocalDataSourceImpl implements LocalDataSource {

    @Inject
    public LocalDataSourceImpl() {
    }

    @Override
    public LiveData<List<SkillIQ>> getSkillIQ() {
        return null;
    }

    @Override
    public LiveData<List<LearningLeaders>> getLearningLeaders() {
        return null;
    }
}
