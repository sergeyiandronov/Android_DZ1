package com.sergey.dz1;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NumberViewHolder extends RecyclerView.ViewHolder {
    public final TextView Number;
    public NumberViewHolder(@NonNull View itemView) {
        super(itemView);
        Number = itemView.findViewById(R.id.number);
    }
}
