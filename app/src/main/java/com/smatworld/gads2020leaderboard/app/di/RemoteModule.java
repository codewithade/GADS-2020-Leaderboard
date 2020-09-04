package com.smatworld.gads2020leaderboard.app.di;

import com.smatworld.gads2020leaderboard.data.repository.RemoteDataSource;
import com.smatworld.gads2020leaderboard.remote.api.LeaderBoardService;
import com.smatworld.gads2020leaderboard.remote.api.ServiceBuilder;
import com.smatworld.gads2020leaderboard.remote.api.SubmissionBuilder;
import com.smatworld.gads2020leaderboard.remote.api.SubmissionService;
import com.smatworld.gads2020leaderboard.remote.source.RemoteDataSourceImpl;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module(includes = {RemoteModule.Binders.class})
public abstract class RemoteModule {

    @Module
    interface Binders {
        @Binds
        RemoteDataSource bindRemoteDataSource(RemoteDataSourceImpl remoteImpl);
    }

    // @Provides tells Dagger how to create instances of the type that this function returns
    // Function parameters are the dependencies of this type (No dependencies in this case).
    @Provides
    public static LeaderBoardService provideLeaderBoardService() {
        return ServiceBuilder.buildService(LeaderBoardService.class);
    }

    @Provides
    public static SubmissionService provideSubmissionService() {
        return SubmissionBuilder.buildService(SubmissionService.class);
    }


}
