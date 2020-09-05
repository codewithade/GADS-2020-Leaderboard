package com.smatworld.gads2020leaderboard.app.ui;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.smatworld.gads2020leaderboard.R;
import com.smatworld.gads2020leaderboard.app.utils.Helper;
import com.smatworld.gads2020leaderboard.app.utils.State;
import com.smatworld.gads2020leaderboard.databinding.DialogConfirmSubmissionBinding;
import com.smatworld.gads2020leaderboard.databinding.FragmentSubmissionBinding;
import com.smatworld.gads2020leaderboard.domain.entities.SubmissionDetails;
import com.smatworld.gads2020leaderboard.presentation.factory.ViewModelProviderFactory;
import com.smatworld.gads2020leaderboard.presentation.viewmodels.ProjectSubmissionViewModel;

import java.util.Objects;

import javax.inject.Inject;

public class SubmissionFragment extends Fragment {
    @Inject
    public ViewModelProviderFactory mViewModelProviderFactory;
    private ProjectSubmissionViewModel mSubmissionViewModel;

    private FragmentSubmissionBinding mBinding;
    private TextInputLayout mFirstName;
    private TextInputLayout mLastName;
    private TextInputLayout mEmail;
    private TextInputLayout mGitLink;
    private boolean isEmpty = true;
    private MaterialButton mSubmitButton;
    private ProgressBar mProgressBar;

    public SubmissionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Helper.getApplicationComponent(requireActivity()).inject(this);
        mSubmissionViewModel = new ViewModelProvider(requireActivity(), mViewModelProviderFactory).get(ProjectSubmissionViewModel.class);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_submission, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding.backButton.setOnClickListener(view1 -> launchHomePage());
        bindViews();
        addTextWatcher();

        mSubmitButton.setOnClickListener(view1 -> {
            addTextChangeListener();
            if (!isEmpty)
                //dialogBuilder();
                displayFeedback(State.FAILURE);
        });

    }

    private void addTextWatcher() {
        Objects.requireNonNull(mFirstName.getEditText()).addTextChangedListener(mTextWatcher);
        Objects.requireNonNull(mLastName.getEditText()).addTextChangedListener(mTextWatcher);
        Objects.requireNonNull(mEmail.getEditText()).addTextChangedListener(mTextWatcher);
        Objects.requireNonNull(mGitLink.getEditText()).addTextChangedListener(mTextWatcher);
    }

    private void addTextChangeListener() {
        mFirstName.addOnEditTextAttachedListener(mTextAttachedListener);
        mLastName.addOnEditTextAttachedListener(mTextAttachedListener);
        mEmail.addOnEditTextAttachedListener(mTextAttachedListener);
        mGitLink.addOnEditTextAttachedListener(mTextAttachedListener);
    }

    private void submitProject() {
        String firstName = Objects.requireNonNull(mFirstName.getEditText()).getText().toString();
        String lastName = Objects.requireNonNull(mLastName.getEditText()).getText().toString();
        String email = Objects.requireNonNull(mEmail.getEditText()).getText().toString();
        String projectLink = Objects.requireNonNull(mGitLink.getEditText()).getText().toString();

        SubmissionDetails submissionDetails = new SubmissionDetails(firstName, lastName, email, projectLink);
        mSubmissionViewModel.submitProject(submissionDetails).observe(getViewLifecycleOwner(), this::displayFeedback);
    }


    private void bindViews() {
        mFirstName = mBinding.firstNameText;
        mLastName = mBinding.lastNameText;
        mEmail = mBinding.emailText;
        mGitLink = mBinding.gitLinkText;
        mSubmitButton = mBinding.submitButton;
        mProgressBar = mBinding.progressBar;
    }

    private void launchHomePage() {
        NavHostFragment.findNavController(SubmissionFragment.this).popBackStack(R.id.MainFragment, false);
    }

    private TextInputLayout.OnEditTextAttachedListener mTextAttachedListener = inputLayout -> {
        if (Objects.requireNonNull(inputLayout.getEditText()).getText().toString().isEmpty()) {
            inputLayout.setError(getResources().getString(R.string.empty_input_text_error));
            isEmpty = true;
        } else {
            inputLayout.setError("");
            isEmpty = false;
        }
    };

    private TextWatcher mTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            mFirstName.setError("");
            mLastName.setError("");
            mEmail.setError("");
            mGitLink.setError("");
        }
    };

    private void displayFeedback(State state) {
        AlertDialog dialog = null;
        String feedback;
        switch (state) {
            case SUCCESS:
                feedback = getString(R.string.submission_success);
                dialog = new MaterialAlertDialogBuilder(requireContext()).setView(R.layout.dialog_success).show();
                break;
            case FAILURE:
                feedback = getString(R.string.submission_failed);
                dialog = new MaterialAlertDialogBuilder(requireContext()).setView(R.layout.dialog_failure).show();
                break;
            case PENDING:
                feedback = getString(R.string.submission_pending);
                break;
            default:
                throw new IllegalArgumentException("Illegal state: " + state.name());
        }
        Snackbar.make(requireView(), feedback, Snackbar.LENGTH_SHORT).show();
        if (state == State.SUCCESS) {
            //if (dialog.isShowing()) dialog.dismiss();
            // launchHomePage();
        }
    }

    private void dialogBuilder() {
        final AlertDialog alertDialog = new MaterialAlertDialogBuilder(requireContext()).create();

        DialogConfirmSubmissionBinding binding = DataBindingUtil.inflate(LayoutInflater.from(requireContext()), R.layout.dialog_confirm_submission, null, false);
        binding.cancelButton.setOnClickListener(view -> alertDialog.dismiss());
        binding.yesButton.setOnClickListener(view -> {
            alertDialog.dismiss();
            Toast.makeText(requireContext(), "submission in progress...", Toast.LENGTH_SHORT).show();
            mProgressBar.setVisibility(View.VISIBLE);
        });//view -> submitProject());

        alertDialog.setView(binding.getRoot());
        alertDialog.show();
    }

}