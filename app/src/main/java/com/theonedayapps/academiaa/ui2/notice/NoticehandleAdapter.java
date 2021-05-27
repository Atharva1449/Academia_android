package com.theonedayapps.academiaa.ui2.notice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.theonedayapps.academiaa.R;

// FirebaseRecyclerAdapter is a class provided by
// FirebaseUI. it provides functions to bind, adapt and show
// database contents in a Recycler View
public class NoticehandleAdapter extends FirebaseRecyclerAdapter<
        Noticehandle, NoticehandleAdapter.NoticeViewholder> {

    public NoticehandleAdapter(
            @NonNull FirebaseRecyclerOptions<Noticehandle> options)
    {
        super(options);
    }

    // Function to bind the view in Card view(here
    // "person.xml") iwth data in
    // model class(here "person.class")
    @Override
    protected void
    onBindViewHolder(@NonNull NoticeViewholder holder,
                     int position, @NonNull Noticehandle model)
    {

        // Add firstname from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")
        holder.titletext.setText(model.getTitle1());

        // Add lastname from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")
        holder.contenttext.setText(model.getContent1());

        // Add age from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")
        holder.linktext.setText(model.getLink());

      //  TextView t2 = (TextView) findViewById(R.id.text2);
//        holder.linktext.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=6f8UWpneEzA")));
//            }
//        });
        holder.datetext.setText(model.getDate());
    }

    // Function to tell the class about the Card view (here
    // "person.xml")in
    // which the data will be shown
    @NonNull
    @Override
    public NoticeViewholder
    onCreateViewHolder(@NonNull ViewGroup parent,
                       int viewType)
    {
        View view
                = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card, parent, false);
        return new NoticehandleAdapter.NoticeViewholder(view);
    }

    // Sub Class to create references of the views in Crad
    // view (here "person.xml")
    class NoticeViewholder
            extends RecyclerView.ViewHolder {
        TextView titletext,contenttext,linktext,datetext;
        public NoticeViewholder(@NonNull View itemView)
        {
            super(itemView);

            titletext  = itemView.findViewById(R.id.textView_title);
            contenttext = itemView.findViewById(R.id.textView_context);
            linktext = itemView.findViewById(R.id.textView_link);
           datetext = itemView.findViewById(R.id.textView_date);
        }
    }

}