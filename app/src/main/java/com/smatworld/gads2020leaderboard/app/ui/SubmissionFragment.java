package com.smatworld.gads2020leaderboard.app.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.smatworld.gads2020leaderboard.R;
import com.smatworld.gads2020leaderboard.databinding.FragmentSubmissionBinding;

import java.util.Objects;

public class SubmissionFragment extends Fragment {

    private FragmentSubmissionBinding mBinding;
    private TextInputLayout mFirstName;
    private TextInputLayout mLastName;
    private TextInputLayout mEmail;
    private TextInputLayout mGitLink;
    private boolean isEmpty = true;
    private MaterialButton mSubmitButton;

    public SubmissionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_submission, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setUpToolBar();
        bindViews();
        addTextWatcher();
        mSubmitButton.setOnClickListener(view1 -> {
            addTextChangeListener();
            if (!isEmpty)
                submitProject();
        });

    }

    private void addTextWatcher() {
        Objects.requireNonNull(mFirstName.getEditText()).addTextChangedListener(mTextWatcher);
        Objects.requireNonNull(mLastName.getEditText()).addTextChangedListener(mTextWatcher);
        Objects.requireNonNull(mEmail.getEditText()).addTextChangedListener(mTextWatcher);
        Objects.requireNonNull(mGitLink.getEditText()).addTextChangedListener(mTextWatcher);
    }

    private void submitProject() {
        //TODO
        Toast.makeText(requireContext(), "Project submission in progress...", Toast.LENGTH_SHORT).show();
    }


    private void addTextChangeListener() {
        mFirstName.addOnEditTextAttachedListener(mTextAttachedListener);
        mLastName.addOnEditTextAttachedListener(mTextAttachedListener);
        mEmail.addOnEditTextAttachedListener(mTextAttachedListener);
        mGitLink.addOnEditTextAttachedListener(mTextAttachedListener);
    }

    private void bindViews() {
        mFirstName = mBinding.firstNameText;
        mLastName = mBinding.lastNameText;
        mEmail = mBinding.emailText;
        mGitLink = mBinding.gitLinkText;
        mSubmitButton = mBinding.submitButton;
    }

    private void setUpToolBar() {
        ImageButton backButton = mBinding.backButton;
        backButton.setOnClickListener(view -> NavHostFragment.findNavController(SubmissionFragment.this).popBackStack(R.id.MainFragment, false));
        /*MaterialToolbar toolbar = mBinding..toolbar;
        toolbar.setNavigationOnClickListener(view1 -> NavHostFragment.findNavController(SubmissionFragment.this).popBackStack(R.id.MainFragment, false));*/
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

    public static void hideKeyboard(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        if (imm != null)
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}