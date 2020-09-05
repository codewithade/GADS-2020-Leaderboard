package com.smatworld.gads2020leaderboard.app.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.smatworld.gads2020leaderboard.R;
import com.smatworld.gads2020leaderboard.app.utils.Constant;
import com.smatworld.gads2020leaderboard.app.utils.Helper;
import com.smatworld.gads2020leaderboard.databinding.FragmentMainBinding;
import com.smatworld.gads2020leaderboard.presentation.factory.SplashScreenViewModel;
import com.smatworld.gads2020leaderboard.presentation.factory.ViewModelProviderFactory;
import com.smatworld.gads2020leaderboard.presentation.viewmodels.LearningViewModel;
import com.smatworld.gads2020leaderboard.presentation.viewmodels.SkillViewModel;

import javax.inject.Inject;

public class MainFragment extends Fragment {

    private FragmentMainBinding mBinding;
    private static final String TAG = Constant.TAG.getConstant();

    @Inject
    public ViewModelProviderFactory mViewModelProviderFactory;
    private LearningViewModel mLearningViewModel;
    private SkillViewModel mSkillViewModel;
    private SplashScreenViewModel mSplashScreenViewModel;

    public MainFragment() {
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Helper.getApplicationComponent(requireActivity()).inject(this);
        initViewModel();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        return mBinding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding.submitButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_MainFragment_to_SubmissionFragment));
        setUpTabLayout();

        mSplashScreenViewModel.getIsFirstRun().observe(getViewLifecycleOwner(), isFirstRun -> {
            if (isFirstRun) NavHostFragment.findNavController(MainFragment.this).navigate(R.id.action_MainFragment_to_LaunchFragment);
        });
        // fetch and observe data from repository
        mLearningViewModel.getLearningLeaders().observe(getViewLifecycleOwner(), learningLeaders -> mLearningViewModel.setLiveData(learningLeaders));
        mSkillViewModel.getSkillIQLeaders().observe(getViewLifecycleOwner(), skillIQS -> mSkillViewModel.setLiveData(skillIQS));
    }

    private void initViewModel() {
        mSkillViewModel = new ViewModelProvider(requireActivity(), mViewModelProviderFactory).get(SkillViewModel.class);
        mLearningViewModel = new ViewModelProvider(requireActivity(), mViewModelProviderFactory).get(LearningViewModel.class);
        mSplashScreenViewModel = new ViewModelProvider(requireActivity(), mViewModelProviderFactory).get(SplashScreenViewModel.class);
    }

    private void setUpTabLayout() {
        TabLayout tabLayout = mBinding.tabLayout;
        ViewPager2 viewPager = mBinding.viewPager;
        viewPager.setAdapter(new ViewPagerAdapter(this));
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText(R.string.learning_fragment_label);
                    break;
                case 1:
                    tab.setText(R.string.skill_fragment_label);
                    break;
                default:
                    throw new IllegalArgumentException("Illegal Tab Position: " + position);
            }
        }).attach();
    }
}