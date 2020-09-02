package com.smatworld.gads2020leaderboard.remote.api;

import com.smatworld.gads2020leaderboard.domain.entities.LearningLeaders;
import com.smatworld.gads2020leaderboard.domain.entities.SkillIQ;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LeaderBoardService {
    @GET("skilliq")
    Call<List<SkillIQ>> getSkillIQLeaders();

    @GET("hours")
    Call<List<LearningLeaders>> getLearningHoursLeaders();
}
