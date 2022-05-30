package com.example.whoami.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.whoami.ui.PersonalitiesFactorsFragment;
import com.example.whoami.ui.PersonalitiesFragment;

import org.jetbrains.annotations.NotNull;

public class MoreInfoTabsAdapter extends FragmentStateAdapter {
    public MoreInfoTabsAdapter(@NonNull @NotNull FragmentManager fragmentManager, @NonNull @NotNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @NotNull
    @Override
    public Fragment createFragment(int position) {

        if (position == 1){
            return new PersonalitiesFragment();
        }

        return new PersonalitiesFactorsFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
