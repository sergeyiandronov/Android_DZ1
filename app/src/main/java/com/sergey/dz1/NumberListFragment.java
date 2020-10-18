package com.sergey.dz1;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NumberListFragment extends Fragment {
    private ArrayList<Integer> ArrayNumberList;
    private ReportClickListener report;
    private int spanCount;
    RecyclerView NumberList;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            spanCount=3;
        }
        else if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            spanCount=4;
        }
        if(savedInstanceState==null){
            ArrayNumberList = new ArrayList<Integer>();
            for(int i=0;i<6;i++){
                ArrayNumberList.add(i+1);
            }
        }
        else{
            ArrayNumberList=savedInstanceState.getIntegerArrayList("ArrayNumberList");
        }
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View MyView=inflater.inflate(R.layout.fragment_first, container, false);
        MyView.findViewById(R.id.btn_open_num).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                report.onClickReport(ArrayNumberList);
            }
        });

        NumberList=MyView.findViewById(R.id.numlist);
        NumberList.setLayoutManager(new GridLayoutManager(inflater.getContext(),spanCount));
        NumberAdapter MyAdapter= new NumberAdapter(ArrayNumberList,report);
        NumberList.setAdapter(MyAdapter);

        return MyView;

    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);


        report = (ReportClickListener) context;
    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putIntegerArrayList("ArrayNumberList",ArrayNumberList);

    }
    @Override
    public void onViewStateRestored(@Nullable final Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

    }

}

