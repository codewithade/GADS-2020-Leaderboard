package com.smatworld.gads2020leaderboard.app.utils;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.google.android.material.textview.MaterialTextView;
import com.smatworld.gads2020leaderboard.R;
import com.smatworld.gads2020leaderboard.domain.entities.LearningLeaders;
import com.smatworld.gads2020leaderboard.domain.entities.SkillIQ;

public class CustomBindingAdapters {

    // Takes the model data, format its to the appropriate form and binds it to TextView
    @BindingAdapter(value = {"learning_hours"})
    public static void setLearningHours(MaterialTextView textView, LearningLeaders learningLeaders) {
        if (learningLeaders != null) {
            String learningHours = learningLeaders.getHours() + " learning hours, " + learningLeaders.getCountry();
            textView.setText(learningHours);
        }
    }

    @BindingAdapter(value = {"skill_iq"})
    public static void setSkillIQ(MaterialTextView textView, SkillIQ skillIQ) {
        if (skillIQ != null) {
            String learningHours = skillIQ.getScore() + " skill IQ Score, " + skillIQ.getCountry();
            textView.setText(learningHours);
        }
    }

    // download and display the image url
    @BindingAdapter(value = {"skill_badge"})
    public static void setSkillBadge(ImageView imageView, String url) {
        if (url != null) {
            Glide.with(imageView.getContext()).load(url).placeholder(R.drawable.skill_iq).error(R.drawable.skill_iq).into(imageView);
        }
    }

    @BindingAdapter(value = {"learning_badge"})
    public static void setLearningBadge(ImageView imageView, String url) {
        if (url != null) {
            Glide.with(imageView.getContext()).load(url).placeholder(R.drawable.top_learner).error(R.drawable.top_learner).into(imageView);
        }
    }
}
