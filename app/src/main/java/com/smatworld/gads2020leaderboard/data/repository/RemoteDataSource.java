package com.smatworld.gads2020leaderboard.data.repository;

import androidx.lifecycle.LiveData;

import com.smatworld.gads2020leaderboard.app.utils.State;
import com.smatworld.gads2020leaderboard.domain.entities.LearningLeaders;
import com.smatworld.gads2020leaderboard.domain.entities.SkillIQ;
import com.smatworld.gads2020leaderboard.domain.entities.SubmissionDetails;

import java.util.List;

// set contract for the Remote Data Layer
public interface RemoteDataSource {

    LiveData<List<SkillIQ>> getSkillIQ();

    LiveData<List<LearningLeaders>> getLearningLeaders();

    LiveData<State> getSubmissionDetails(SubmissionDetails submissionDetails);
}
