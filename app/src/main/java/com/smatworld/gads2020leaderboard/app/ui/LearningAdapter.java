package com.smatworld.gads2020leaderboard.app.ui;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.smatworld.gads2020leaderboard.R;
import com.smatworld.gads2020leaderboard.app.utils.DataBindingAdapter;
import com.smatworld.gads2020leaderboard.domain.entities.LearningLeaders;

public class LearningAdapter extends DataBindingAdapter<LearningLeaders> {

    protected LearningAdapter() {
        super(DIFF_CALLBACK);
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.item_learning_leaderboard;
    }

    private static final DiffUtil.ItemCallback<LearningLeaders> DIFF_CALLBACK = new DiffUtil.ItemCallback<LearningLeaders>() {
        @Override
        public boolean areItemsTheSame(@NonNull LearningLeaders oldLearningLeaders, @NonNull LearningLeaders newLearningLeaders) {
            return oldLearningLeaders.getName().equals(newLearningLeaders.getName());
        }

        @Override
        public boolean areContentsTheSame(@NonNull LearningLeaders oldLearningLeaders, @NonNull LearningLeaders newLearningLeaders) {
            return oldLearningLeaders.equals(newLearningLeaders);
        }
    };
}
