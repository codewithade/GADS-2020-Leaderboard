package com.smatworld.gads2020leaderboard.app.ui;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.smatworld.gads2020leaderboard.R;
import com.smatworld.gads2020leaderboard.app.utils.DataBindingAdapter;
import com.smatworld.gads2020leaderboard.domain.entities.SkillIQ;

public class SkillAdapter extends DataBindingAdapter<SkillIQ> {

    protected SkillAdapter() {
        super(DIFF_CALLBACK);
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.item_skill_leaderboard;
    }

    private static final DiffUtil.ItemCallback<SkillIQ> DIFF_CALLBACK = new DiffUtil.ItemCallback<SkillIQ>() {
        @Override
        public boolean areItemsTheSame(@NonNull SkillIQ oldSkillIq, @NonNull SkillIQ newSkillIq) {
            return oldSkillIq.getName().equals(newSkillIq.getName());
        }

        @Override
        public boolean areContentsTheSame(@NonNull SkillIQ oldSkillIq, @NonNull SkillIQ newSkillIq) {
            return oldSkillIq.equals(newSkillIq);
        }
    };
}
