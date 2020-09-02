package com.smatworld.gads2020leaderboard.domain.repository;

import androidx.lifecycle.LiveData;

import com.smatworld.gads2020leaderboard.domain.entities.LearningLeaders;
import com.smatworld.gads2020leaderboard.domain.entities.SkillIQ;

import java.util.List;

public interface LeaderRepository {

    LiveData<List<LearningLeaders>> getLearningHourLeaders();

    LiveData<List<SkillIQ>> getSkillIQLeaders();
}
