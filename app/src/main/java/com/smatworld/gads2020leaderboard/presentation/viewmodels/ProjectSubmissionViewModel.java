package com.smatworld.gads2020leaderboard.presentation.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.smatworld.gads2020leaderboard.app.utils.State;
import com.smatworld.gads2020leaderboard.domain.entities.SubmissionDetails;
import com.smatworld.gads2020leaderboard.domain.usecases.ProjectSubmissionTask;

import javax.inject.Inject;

public class ProjectSubmissionViewModel extends ViewModel {

    private ProjectSubmissionTask mProjectSubmissionTask;

    @Inject
    public ProjectSubmissionViewModel(ProjectSubmissionTask projectSubmissionTask) {
        mProjectSubmissionTask = projectSubmissionTask;
    }

    public LiveData<State> submitProject(SubmissionDetails submissionDetails) {
        return mProjectSubmissionTask.buildUseCase(submissionDetails);
    }
}
