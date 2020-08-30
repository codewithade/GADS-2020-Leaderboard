package com.smatworld.gads2020leaderboard.app.di;

import com.smatworld.gads2020leaderboard.data.repository.RemoteDataSource;
import com.smatworld.gads2020leaderboard.remote.source.RemoteDataSourceImpl;

import dagger.Binds;
import dagger.Module;

@Module(includes = {RemoteModule.Binders.class})
public abstract class RemoteModule {

    @Module
    interface Binders {
        @Binds
        RemoteDataSource bindRemoteDataSource(RemoteDataSourceImpl remoteImpl);
    }

    // @Provides tell Dagger how to create instances of the type that this function
    // returns (i.e. FirebaseAuth.getInstance()).
    // Function parameters are the dependencies of this type (No dependencies in this case).
    /*@Provides
    public static FirebaseAuth provideFirebaseAuth() {
        // Whenever Dagger needs to provide an instance of type FirebaseAuth.getInstance(),
        // this code (the one inside the @Provides method) will be run.
        return FirebaseAuth.getInstance();
    }

    @Provides
    public static FirebaseFirestore provideFirebaseFirestore() {
        return FirebaseFirestore.getInstance();
    }*/

}
