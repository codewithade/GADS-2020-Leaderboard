package com.smatworld.gads2020leaderboard.app.utils;

import androidx.fragment.app.FragmentActivity;

import com.smatworld.gads2020leaderboard.app.application.GADSApplication;
import com.smatworld.gads2020leaderboard.app.di.ApplicationComponent;

public class Helper {
    private static final Helper ourInstance = new Helper();

    static Helper getInstance() {
        return ourInstance;
    }

    private Helper() {
    }

    public static ApplicationComponent getApplicationComponent(FragmentActivity fragmentActivity) {
        return ((GADSApplication) fragmentActivity.getApplication()).getApplicationComponent();
    }

}
