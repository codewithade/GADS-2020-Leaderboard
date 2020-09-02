package com.smatworld.gads2020leaderboard.app.ui;

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
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.smatworld.gads2020leaderboard.R;
import com.smatworld.gads2020leaderboard.app.utils.Constant;
import com.smatworld.gads2020leaderboard.databinding.FragmentLaunchBinding;

public class LaunchFragment extends Fragment {

    private static final String TAG = Constant.TAG.getConstant();
    private FragmentLaunchBinding mBinding;

    public LaunchFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_launch, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        new Handler().postDelayed(() -> {
            Log.i(TAG, "Thread: " + Thread.currentThread().getName());
            NavController navController = NavHostFragment.findNavController(LaunchFragment.this);
            navController.navigate(R.id.action_launchFragment_to_MainFragment);
        }, 3000);
    }
}