package com.smatworld.gads2020leaderboard.data.repository;

import com.smatworld.gads2020leaderboard.domain.repository.LeaderRepository;

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
}
