package com.example.practical_exam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<pViewHolder>{
    ArrayList<UseModel> list;
    Context context;

    public RecyclerAdapter(ArrayList<UseModel> list,Context context)
    {
        this.list = list;
        this.context = context;
    }

    @Override
    public pViewHolder
    onCreateViewHolder(ViewGroup parent,int viewType)
    {

        Context context
                = parent.getContext();
        LayoutInflater inflater
                = LayoutInflater.from(context);


        View photoView
                = inflater
                .inflate(R.layout.raw,
                        parent, false);

        pViewHolder viewHolder
                = new pViewHolder(photoView);
        return viewHolder;
    }

    @Override
    public void
    onBindViewHolder(final pViewHolder viewHolder,final int position)
    {

        viewHolder.txtDateTime
                .setText(list.get(position).getDateTime());

        viewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

            }
        });
    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(
            RecyclerView recyclerView)
    {
        super.onAttachedToRecyclerView(recyclerView);
    }
}

