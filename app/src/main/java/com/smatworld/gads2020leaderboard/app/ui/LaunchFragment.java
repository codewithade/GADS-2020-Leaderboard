package com.smatworld.gads2020leaderboard.app.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.smatworld.gads2020leaderboard.R;
import com.smatworld.gads2020leaderboard.app.utils.Constant;
import com.smatworld.gads2020leaderboard.app.utils.Helper;
import com.smatworld.gads2020leaderboard.presentation.factory.SplashScreenViewModel;
import com.smatworld.gads2020leaderboard.presentation.factory.ViewModelProviderFactory;

import javax.inject.Inject;

public class LaunchFragment extends Fragment {

    private static final String TAG = Constant.TAG.getConstant();
    @Inject
    ViewModelProviderFactory mViewModelProviderFactory;
    private SplashScreenViewModel mSplashScreenViewModel;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Helper.getApplicationComponent(requireActivity()).inject(this);
        mSplashScreenViewModel = new ViewModelProvider(requireActivity(), mViewModelProviderFactory).get(SplashScreenViewModel.class);
    }

    public LaunchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return DataBindingUtil.inflate(inflater, R.layout.fragment_launch, container, false).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        new Handler().postDelayed(() -> {
            mSplashScreenViewModel.setIsFirstRun(false);
            Log.i(TAG, "Thread: " + Thread.currentThread().getName());
            NavHostFragment.findNavController(LaunchFragment.this).popBackStack(R.id.MainFragment, false);
        }, 3000);
    }
}