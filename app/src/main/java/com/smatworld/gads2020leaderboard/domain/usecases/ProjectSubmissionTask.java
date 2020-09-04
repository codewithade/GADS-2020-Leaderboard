package com.smatworld.gads2020leaderboard.domain.usecases;

import androidx.lifecycle.LiveData;

import com.smatworld.gads2020leaderboard.app.utils.State;
import com.smatworld.gads2020leaderboard.domain.entities.SubmissionDetails;
import com.smatworld.gads2020leaderboard.domain.repository.LeaderRepository;
import com.smatworld.gads2020leaderboard.domain.usecases.base.CompletableUseCase;

import javax.inject.Inject;

public class ProjectSubmissionTask extends CompletableUseCase<SubmissionDetails> {

    private LeaderRepository mLeaderRepository;

    @Inject
    public ProjectSubmissionTask(LeaderRepository leaderRepository) {
        mLeaderRepository = leaderRepository;
    }

    @Override
    protected LiveData<State> generateCompletable(SubmissionDetails submissionDetails) {
        return mLeaderRepository.getSubmissionDetails(submissionDetails);
    }
}
