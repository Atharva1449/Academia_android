package com.theonedayapps.academiaa.ui2.assignment;

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
import com.theonedayapps.academiaa.ui.home.HomeViewModel;
import com.theonedayapps.academiaa.ui2.attendance.Attendance;
import com.theonedayapps.academiaa.ui2.attendance.AttendanceViewModel;
import com.theonedayapps.academiaa.ui2.notice.NoticeViewModel;

public class Assignment extends Fragment {

    private AssignmentViewModel attendanceViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        attendanceViewModel =
                new ViewModelProvider(this).get(AssignmentViewModel.class);
        View root = inflater.inflate(R.layout.fragment_attendance, container, false);

        attendanceViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        return root;
    }
}

