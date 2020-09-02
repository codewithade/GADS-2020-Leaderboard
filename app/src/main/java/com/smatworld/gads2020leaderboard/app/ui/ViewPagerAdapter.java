package com.smatworld.gads2020leaderboard.app.ui;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {
    private static final int TAB_COUNT = 2;

    public ViewPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return LearningFragment.newInstance();
            case 1:
                return SkillFragment.newInstance();
            default:
                throw new IllegalArgumentException("Illegal position: " + position);
        }
    }

    @Override
    public int getItemCount() {
        return TAB_COUNT;
    }
}
