package com.smatworld.gads2020leaderboard.app.di;

import com.smatworld.gads2020leaderboard.data.repository.LocalDataSource;
import com.smatworld.gads2020leaderboard.local.source.LocalDataSourceImpl;

import dagger.Binds;
import dagger.Module;

@Module(includes = {LocalModule.Binders.class})
public abstract class LocalModule {

    @Module
    interface Binders {
        // use @Binds (instead of @Provides) to bind an Implementation to an Interface
        @Binds
        LocalDataSource bindLocalDataSource(LocalDataSourceImpl localDataSourceImpl);
    }

}
