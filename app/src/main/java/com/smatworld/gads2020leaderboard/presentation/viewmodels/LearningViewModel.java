package com.smatworld.gads2020leaderboard.presentation.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.smatworld.gads2020leaderboard.domain.entities.LearningLeaders;
import com.smatworld.gads2020leaderboard.domain.usecases.LearningLeadersTask;

import java.util.List;

import javax.inject.Inject;

public class LearningViewModel extends ViewModel {

    LearningLeadersTask mLearningLeadersTask;
    private MutableLiveData<List<LearningLeaders>> mLiveData = new MutableLiveData<>();

    @Inject
    public LearningViewModel(LearningLeadersTask learningLeadersTask) {
        mLearningLeadersTask = learningLeadersTask;
    }

    public LiveData<List<LearningLeaders>> getLearningLeaders(){
        return mLearningLeadersTask.buildUseCase();
    }

    public void setLiveData(List<LearningLeaders> learningLeaders){
        mLiveData.setValue(learningLeaders);
    }

    public LiveData<List<LearningLeaders>> getLiveData() {
        return mLiveData;
    }
}
