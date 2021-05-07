package com.theonedayapps.academiaa.ui2.time_table;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.theonedayapps.academiaa.R;
import com.theonedayapps.academiaa.ui2.notice.NoticeViewModel;

public class Time_table extends Fragment {

    private Time_tableViewModel time_tableViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        time_tableViewModel =
                new ViewModelProvider(this).get(Time_tableViewModel.class);
        View root = inflater.inflate(R.layout.fragment_time_table, container, false);

        time_tableViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        return root;
    }
}
