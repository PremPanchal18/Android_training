package com.example.practical_exam;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class pViewHolder extends RecyclerView.ViewHolder
{
    TextView txtDateTime;

    View view;

    public pViewHolder(View itemView) {
        super(itemView);

        txtDateTime=itemView.findViewById(R.id.txtDateTime);


        view=itemView;
    }
}