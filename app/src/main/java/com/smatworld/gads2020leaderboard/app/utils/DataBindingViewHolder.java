package com.smatworld.gads2020leaderboard.app.utils;

import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.smatworld.gads2020leaderboard.BR;


public class DataBindingViewHolder<T> extends RecyclerView.ViewHolder {

    private ViewDataBinding mBinding;

    public DataBindingViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    // 'item' must be a variable in each layout where data binding is enabled
    public void bind(T item) {
        mBinding.setVariable(BR.item, item);
        mBinding.executePendingBindings();
    }
}
