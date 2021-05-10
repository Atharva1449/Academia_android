package com.theonedayapps.academiaa.ui2.fee;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.theonedayapps.academiaa.R;
import com.theonedayapps.academiaa.ui2.notice.NoticeViewModel;

public class Fee extends Fragment {

    private FeeViewModel feeViewModel;
private WebView mywebview;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        feeViewModel =
                new ViewModelProvider(this).get(FeeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_fee, container, false);

        feeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
               mywebview = (WebView) root.findViewById(R.id.webView1);
                mywebview.loadUrl("https://feepayr.com/");

            }
        });
        return root;
    }
}
