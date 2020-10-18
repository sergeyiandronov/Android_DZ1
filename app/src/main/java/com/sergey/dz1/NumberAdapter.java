package com.sergey.dz1;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NumberAdapter  extends RecyclerView.Adapter<NumberViewHolder> {
    private ArrayList<Integer>  mData;
    private ReportClickListener mReport;
    public NumberAdapter(ArrayList<Integer> data, ReportClickListener report){
            mData=data;
            mReport=report;
    }
    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.number_view, parent, false);
        return new NumberViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NumberViewHolder holder, int position) {
        holder.Number.setText(mData.get(position).toString());
        final int pos=mData.get(position);
        if(pos%2==0){
            holder.Number.setTextColor(Color.RED);
        }
        else{
            holder.Number.setTextColor(Color.BLUE);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mReport.onClickInListReport(pos);
            }

        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
}
