package com.smatworld.gads2020leaderboard.app.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.smatworld.gads2020leaderboard.R;
import com.smatworld.gads2020leaderboard.app.utils.Constant;
import com.smatworld.gads2020leaderboard.databinding.FragmentMainBinding;

public class MainFragment extends Fragment {

    private FragmentMainBinding mBinding;
    private static final String TAG = Constant.TAG.getConstant();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        return mBinding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MaterialButton submitButton = mBinding.submitButton;
        submitButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_MainFragment_to_SubmissionFragment));
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

    private void dialogBuilder(String message){
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(requireContext());
        builder.setMessage(message);

    }
}