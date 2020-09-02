package com.smatworld.gads2020leaderboard.app.utils;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public abstract class DataBindingAdapter<T> extends ListAdapter<T, DataBindingViewHolder<T>> {


    protected DataBindingAdapter(@NonNull DiffUtil.ItemCallback<T> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public DataBindingViewHolder<T> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), viewType, parent, false);
        return new DataBindingViewHolder<>(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DataBindingViewHolder<T> holder, int position) {
        holder.bind(getItem(position));
    }
}
