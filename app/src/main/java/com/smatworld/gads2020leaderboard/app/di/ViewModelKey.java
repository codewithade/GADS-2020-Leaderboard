package com.smatworld.gads2020leaderboard.app.di;


import androidx.lifecycle.ViewModel;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import dagger.MapKey;

/*Multi Binding working in that way you create a key and you map certain dependencies to that key.
  You can use these dependencies and use/inject them in different classes.*/

@Documented
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.METHOD)
@MapKey
public @interface ViewModelKey {
    Class<? extends ViewModel> value();
}
