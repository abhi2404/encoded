package com.example.notes;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.MyViewHolder> {

    private ArrayList<notesData>mExampleList;

    public  NotesAdapter(ArrayList<notesData> exampleList){
        mExampleList=exampleList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list, viewGroup, false);
        MyViewHolder evh=new MyViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int i) {
        notesData currentItem = mExampleList.get(i);
        viewHolder.title.setText(currentItem.getedit1());
        viewHolder.body.setText(currentItem.getedit2());

    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title, body;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.put_title);
            body =(TextView) itemView.findViewById(R.id.put_body);
        }
    }
}

