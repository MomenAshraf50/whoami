package com.example.whoami;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;


import com.example.whoami.questions.QuestionsGroupFiveFragment;
import com.example.whoami.questions.QuestionsGroupFourFragment;
import com.example.whoami.questions.QuestionsGroupOneFragment;
import com.example.whoami.questions.QuestionsGroupSevenFragment;
import com.example.whoami.questions.QuestionsGroupSixFragment;
import com.example.whoami.questions.QuestionsGroupThreeFragment;
import com.example.whoami.questions.QuestionsGroupTwoFragment;

import org.jetbrains.annotations.NotNull;

public class TestTapsAdapter extends FragmentStateAdapter {
    public TestTapsAdapter(@NonNull @NotNull FragmentManager fragmentManager, @NonNull @NotNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @NotNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1:
                return new QuestionsGroupTwoFragment();
            case 2:
                return new QuestionsGroupThreeFragment();
            case 3:
                return new QuestionsGroupFourFragment();
            case 4:
                return new QuestionsGroupFiveFragment();
            case 5:
                return new QuestionsGroupSixFragment();
            case 6:
                return new QuestionsGroupSevenFragment();
        }
        return new QuestionsGroupOneFragment();
    }

    @Override
    public int getItemCount() {
        return 7;
    }
}
