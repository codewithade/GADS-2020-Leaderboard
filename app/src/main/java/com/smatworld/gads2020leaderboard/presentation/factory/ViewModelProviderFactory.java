package com.smatworld.gads2020leaderboard.presentation.factory;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

/*Now, What’s the point of creating ViewModelProviderFactory class?
        it's because by default classes that extend ViewModel can only have an empty constructor.
        You can’t pass any parameter through the constructor.
        So if you want to use constructor injection you can’t pass parameters through a constructor.
        So to solve the issue we have to create custom ViewModelProviderFactory.
        If we create the factory then we can effectively do the injection.
        In the constructor of the class, you can see the @Inject annotation.
        That’s a particular thing that has to do with the Multibinding.
        It’s a known issue in the Android community as I mentioned earlier.*/

// Scope this class to a component using @Singleton scope (i.e. ApplicationGraph)
@Singleton
public class ViewModelProviderFactory implements ViewModelProvider.Factory {
    private Map<Class<? extends ViewModel>, Provider<ViewModel>> providers;

    @Inject
    public ViewModelProviderFactory(Map<Class<? extends ViewModel>, Provider<ViewModel>> providers) {
        this.providers = providers;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        Provider<ViewModel> provider = providers.get(modelClass);
        if (provider == null) {
            for (Class<? extends ViewModel> viewModelClass : providers.keySet()) {
                if (modelClass.isAssignableFrom(viewModelClass)) {
                    provider = providers.get(viewModelClass);
                    break;
                }

            }
        }

        if (provider == null) {
            throw new IllegalStateException("Unknown View Model: +" + modelClass);
        }
        try {
            return (T) provider.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

