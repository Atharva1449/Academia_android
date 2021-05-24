package com.theonedayapps.academiaa.ui2.notice;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.theonedayapps.academiaa.R;
import com.theonedayapps.academiaa.Useractivity;

public class Notice extends Fragment {

    private NoticeViewModel noticeViewModel;
    private RecyclerView recyclerView;
    NoticehandleAdapter adapter;
    DatabaseReference mbase;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        noticeViewModel =
                new ViewModelProvider(this).get(NoticeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notice, container, false);

        noticeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

              //  mbase= FirebaseDatabase.getInstance().getReference().child("Notice");


            }

        });
        recyclerView = root.findViewById(R.id.recycler1);

        // To display the Recycler view linearly
        recyclerView.setLayoutManager(
                new LinearLayoutManager(getActivity()));

        // It is a class provide by the FirebaseUI to make a
        // query in the database to fetch appropriate data
        FirebaseRecyclerOptions<Noticehandle> options
                = new FirebaseRecyclerOptions.Builder<Noticehandle>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Notice").child(((Useractivity) getActivity()).gettextviewyear()).child(((Useractivity) getActivity()).gettextviewdepar()), Noticehandle.class)
                .build();
        // Connecting object of required Adapter class to
        // the Adapter class itself
        adapter = new NoticehandleAdapter(options);
        // Connecting Adapter class with the Recycler view*/
        recyclerView.setAdapter(adapter);


        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }
    ///s
}
