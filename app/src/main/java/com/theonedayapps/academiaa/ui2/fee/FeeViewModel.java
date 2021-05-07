package com.theonedayapps.academiaa.ui2.fee;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FeeViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public FeeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Fee fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}