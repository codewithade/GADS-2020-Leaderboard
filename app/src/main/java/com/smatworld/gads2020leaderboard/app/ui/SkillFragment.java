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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.smatworld.gads2020leaderboard.R;
import com.smatworld.gads2020leaderboard.app.utils.Helper;
import com.smatworld.gads2020leaderboard.databinding.FragmentSkillBinding;
import com.smatworld.gads2020leaderboard.presentation.factory.ViewModelProviderFactory;
import com.smatworld.gads2020leaderboard.presentation.viewmodels.SkillViewModel;

import javax.inject.Inject;

public class SkillFragment extends Fragment {

    private SkillAdapter mAdapter;
    @Inject
    public ViewModelProviderFactory mViewModelProviderFactory;
    private SkillViewModel mSkillViewModel;
    private FragmentSkillBinding mBinding;
    private static SkillFragment sInstance;

    private SkillFragment() {
    }

    public static SkillFragment newInstance() {
        if (sInstance == null)
            sInstance = new SkillFragment();
        return sInstance;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Helper.getApplicationComponent(requireActivity()).inject(this);
        initViewModel();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_skill, container, false);
        return mBinding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRecyclerView();

        //mSkillViewModel.getSkillIQLeaders().observe(getViewLifecycleOwner(), mAdapter::submitList);
        mSkillViewModel.getLiveData().observe(getViewLifecycleOwner(), mAdapter::submitList);
    }

    private void initRecyclerView() {
        final int SPAN_COUNT = 1;
        RecyclerView recyclerView = mBinding.skillRecyclerView;

        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if (manager == null)
            recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), SPAN_COUNT));
        mAdapter = (SkillAdapter) recyclerView.getAdapter();
        if (mAdapter == null) {
            mAdapter = new SkillAdapter();
            recyclerView.setAdapter(mAdapter);
        }
    }

    private void initViewModel() {
        // use 'requireActivity()' so as to retrieve the same instance of GalleryViewModel created by the Activity
        // This gives a single GalleryViewModel that is available for use by any fragment within the Activity
        mSkillViewModel = new ViewModelProvider(requireActivity(), mViewModelProviderFactory).get(SkillViewModel.class);
    }
}