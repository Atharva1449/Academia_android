package com.theonedayapps.academiaa.ui2.time_table;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Time_tableViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public Time_tableViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is time_table fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}