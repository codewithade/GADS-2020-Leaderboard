package com.smatworld.gads2020leaderboard.presentation.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.smatworld.gads2020leaderboard.domain.entities.SkillIQ;
import com.smatworld.gads2020leaderboard.domain.usecases.IQLeadersTask;

import java.util.List;

import javax.inject.Inject;

public class SkillViewModel extends ViewModel {

    private MutableLiveData<List<SkillIQ>> mLiveData = new MutableLiveData<>();
    private IQLeadersTask mIQLeadersTask;

    @Inject
    public SkillViewModel(IQLeadersTask iqLeadersTask) {
        mIQLeadersTask = iqLeadersTask;
    }

    public LiveData<List<SkillIQ>> getSkillIQLeaders() {
        return mIQLeadersTask.buildUseCase();
    }

    public void setLiveData(List<SkillIQ> iqList){
        mLiveData.setValue(iqList);
    }

    public LiveData<List<SkillIQ>> getLiveData() {
        return mLiveData;
    }
}
