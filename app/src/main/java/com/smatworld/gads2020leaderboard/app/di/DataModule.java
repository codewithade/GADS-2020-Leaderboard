package com.smatworld.gads2020leaderboard.app.di;

import com.smatworld.gads2020leaderboard.data.repository.LeaderRepositoryImpl;
import com.smatworld.gads2020leaderboard.domain.repository.LeaderRepository;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class DataModule {

    @Binds
    public abstract LeaderRepository bindLeaderRepository(LeaderRepositoryImpl repoIml);

}
