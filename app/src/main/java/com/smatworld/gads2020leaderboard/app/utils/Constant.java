package com.smatworld.gads2020leaderboard.app.utils;

public enum Constant {
    TAG("GADS"),
    EMAIL("com.smatworld.gads2020leaderboard.EMAIL"),
    FIRST_NAME("com.smatworld.gads2020leaderboard.FIRST_NAME"),
    LAST_NAME("com.smatworld.gads2020leaderboard.LAST_NAME"),
    GITHUB_LINK("com.smatworld.gads2020leaderboard.GITHUB_LINK");

    private String mConstant;

    Constant(String constant) {
        mConstant = constant;
    }

    public String getConstant() {
        return mConstant;
    }
}
