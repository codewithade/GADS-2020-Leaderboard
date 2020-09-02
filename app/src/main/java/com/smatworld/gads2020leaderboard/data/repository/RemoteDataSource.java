package com.smatworld.gads2020leaderboard.data.repository;

import androidx.lifecycle.LiveData;

import com.smatworld.gads2020leaderboard.domain.entities.LearningLeaders;
import com.smatworld.gads2020leaderboard.domain.entities.SkillIQ;

import java.util.List;

// set contract for the Remote Data Layer
public interface RemoteDataSource {

    LiveData<List<SkillIQ>> getSkillIQ();

    LiveData<List<LearningLeaders>> getLearningLeaders();
}
