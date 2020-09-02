package com.smatworld.gads2020leaderboard.presentation.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.smatworld.gads2020leaderboard.domain.entities.LearningLeaders;
import com.smatworld.gads2020leaderboard.domain.usecases.LearningLeadersTask;

import java.util.List;

import javax.inject.Inject;

public class LearningViewModel extends ViewModel {

    LearningLeadersTask mLearningLeadersTask;

    @Inject
    public LearningViewModel(LearningLeadersTask learningLeadersTask) {
        mLearningLeadersTask = learningLeadersTask;
    }

    public LiveData<List<LearningLeaders>> getLearningLeaders(){
        return mLearningLeadersTask.buildUseCase();
    }
}
