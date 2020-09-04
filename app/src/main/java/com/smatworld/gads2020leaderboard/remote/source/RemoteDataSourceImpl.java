package com.smatworld.gads2020leaderboard.remote.source;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.smatworld.gads2020leaderboard.app.utils.Constant;
import com.smatworld.gads2020leaderboard.app.utils.State;
import com.smatworld.gads2020leaderboard.data.repository.RemoteDataSource;
import com.smatworld.gads2020leaderboard.domain.entities.LearningLeaders;
import com.smatworld.gads2020leaderboard.domain.entities.SkillIQ;
import com.smatworld.gads2020leaderboard.domain.entities.SubmissionDetails;
import com.smatworld.gads2020leaderboard.remote.api.LeaderBoardService;
import com.smatworld.gads2020leaderboard.remote.api.SubmissionService;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

// fulfills the contract set by the Data layer
public class RemoteDataSourceImpl implements RemoteDataSource {

    private static final String TAG = Constant.TAG.getConstant();

    private SubmissionService mSubmissionService;
    private LeaderBoardService mLeaderBoardService;
    private Call<List<LearningLeaders>> mLearningLeadersCall;
    private Call<List<SkillIQ>> mSkillIQCall;

    @Inject
    public RemoteDataSourceImpl(LeaderBoardService leaderBoardService, SubmissionService submissionService) {
        mLeaderBoardService = leaderBoardService;
        mSubmissionService = submissionService;
    }

    @Override
    public LiveData<List<SkillIQ>> getSkillIQ() {
        final MutableLiveData<List<SkillIQ>> skillIq = new MutableLiveData<>();
        mSkillIQCall = mLeaderBoardService.getSkillIQLeaders();

        mSkillIQCall.enqueue(new Callback<List<SkillIQ>>() {
            @Override
            public void onResponse(Call<List<SkillIQ>> call, Response<List<SkillIQ>> response) {
                if (response.body() != null) {
                    skillIq.setValue(response.body());
                    Log.i(TAG, "onResponse: " + response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<List<SkillIQ>> call, Throwable t) {
                Log.i(TAG, "getSkillIQ Failure: " + t.getMessage());
            }
        });
        return skillIq;
    }

    @Override
    public LiveData<List<LearningLeaders>> getLearningLeaders() {
        final MutableLiveData<List<LearningLeaders>> learningLeaders = new MutableLiveData<>();
        mLearningLeadersCall = mLeaderBoardService.getLearningHoursLeaders();

        mLearningLeadersCall.enqueue(new Callback<List<LearningLeaders>>() {
            @Override
            public void onResponse(Call<List<LearningLeaders>> call, Response<List<LearningLeaders>> response) {
                learningLeaders.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<LearningLeaders>> call, Throwable t) {
                Log.i(TAG, "getLearningLeaders Failure: " + t.getMessage());
            }
        });
        return learningLeaders;
    }

    @Override
    public LiveData<State> getSubmissionDetails(SubmissionDetails details) {
        // initialize pending state
        final MutableLiveData<State> stateMutableLiveData = new MutableLiveData<>();
        stateMutableLiveData.setValue(State.PENDING);

        // attempt to post project
        mSubmissionService.postProject(details.getFirstName(), details.getLastName(), details.getEmail(), details.getProjectLink()).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                stateMutableLiveData.setValue(State.SUCCESS);
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                stateMutableLiveData.setValue(State.FAILURE);
            }
        });
        // TODO
        return stateMutableLiveData;
    }
}
