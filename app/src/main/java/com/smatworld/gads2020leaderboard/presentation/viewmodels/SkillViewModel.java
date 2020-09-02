package com.smatworld.gads2020leaderboard.presentation.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.smatworld.gads2020leaderboard.domain.entities.SkillIQ;
import com.smatworld.gads2020leaderboard.domain.usecases.IQLeadersTask;

import java.util.List;

import javax.inject.Inject;

public class SkillViewModel extends ViewModel {

    private IQLeadersTask mIQLeadersTask;

    @Inject
    public SkillViewModel(IQLeadersTask iqLeadersTask) {
        mIQLeadersTask = iqLeadersTask;
    }

    public LiveData<List<SkillIQ>> getSkillIQLeaders() {
        return mIQLeadersTask.buildUseCase();
    }
}
