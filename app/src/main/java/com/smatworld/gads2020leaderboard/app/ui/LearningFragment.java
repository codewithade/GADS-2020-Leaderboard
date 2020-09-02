package com.smatworld.gads2020leaderboard.app.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.smatworld.gads2020leaderboard.R;
import com.smatworld.gads2020leaderboard.app.utils.Constant;
import com.smatworld.gads2020leaderboard.app.utils.Helper;
import com.smatworld.gads2020leaderboard.databinding.FragmentLearningBinding;
import com.smatworld.gads2020leaderboard.presentation.factory.ViewModelProviderFactory;
import com.smatworld.gads2020leaderboard.presentation.viewmodels.LearningViewModel;

import javax.inject.Inject;

public class LearningFragment extends Fragment {

    private static final String TAG = Constant.TAG.getConstant();
    private FragmentLearningBinding mBinding;
    private LearningAdapter mAdapter;
    @Inject
    public ViewModelProviderFactory mViewModelProviderFactory;
    private LearningViewModel mLearningViewModel;

    public LearningFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static LearningFragment newInstance() {
        return new LearningFragment();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Helper.getApplicationComponent(requireActivity()).inject(this);
        initViewModel();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_learning, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRecyclerView();

        mLearningViewModel.getLearningLeaders().observe(getViewLifecycleOwner(), mAdapter::submitList);
    }

    private void initRecyclerView() {
        final int SPAN_COUNT = 1;
        RecyclerView recyclerView = mBinding.learningRecyclerView;

        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if (manager == null) {
            recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), SPAN_COUNT));
            //recyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));
        }
        mAdapter = (LearningAdapter) recyclerView.getAdapter();
        if (mAdapter == null) {
            mAdapter = new LearningAdapter();
            recyclerView.setAdapter(mAdapter);
        }
    }

    private void initViewModel() {
        // use 'requireActivity()' so as to retrieve the same instance of GalleryViewModel created by the Activity
        // This gives a single GalleryViewModel that is available for use by any fragment within the Activity
        mLearningViewModel = new ViewModelProvider(requireActivity(), mViewModelProviderFactory).get(LearningViewModel.class);
    }
}