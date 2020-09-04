package com.smatworld.gads2020leaderboard.data.repository;

import androidx.lifecycle.LiveData;

import com.smatworld.gads2020leaderboard.app.utils.State;
import com.smatworld.gads2020leaderboard.domain.entities.LearningLeaders;
import com.smatworld.gads2020leaderboard.domain.entities.SkillIQ;
import com.smatworld.gads2020leaderboard.domain.entities.SubmissionDetails;
import com.smatworld.gads2020leaderboard.domain.repository.LeaderRepository;

import java.util.List;

import javax.inject.Inject;

// fulfills the contract set by the Domain Layer
public class LeaderRepositoryImpl implements LeaderRepository {
    private RemoteDataSource mRemoteDataSource;
    private LocalDataSource mLocalDataSource;

    @Inject
    public LeaderRepositoryImpl(RemoteDataSource remoteDataSource, LocalDataSource localDataSource) {
        mRemoteDataSource = remoteDataSource;
        mLocalDataSource = localDataSource;
    }

    @Override
    public LiveData<List<LearningLeaders>> getLearningHourLeaders() {
        return mRemoteDataSource.getLearningLeaders();
    }

    @Override
    public LiveData<List<SkillIQ>> getSkillIQLeaders() {
        return mRemoteDataSource.getSkillIQ();
    }

    @Override
    public LiveData<State> getSubmissionDetails(SubmissionDetails submissionDetails) {
        return mRemoteDataSource.getSubmissionDetails(submissionDetails);
    }
}
