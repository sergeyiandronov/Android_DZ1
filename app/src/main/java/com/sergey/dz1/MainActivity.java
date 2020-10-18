package com.sergey.dz1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ReportClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportFragmentManager().findFragmentById(R.id.fragment_container) == null) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, new NumberListFragment())
                .commit();}
    }

    @Override
    public void onClickReport(ArrayList<Integer> ArrayNumberList) {
        FragmentManager fragManeg=getSupportFragmentManager();
        NumberListFragment ChangingFragment=(NumberListFragment)fragManeg.findFragmentById(R.id.fragment_container);
        if(ArrayNumberList.isEmpty()){
            ArrayNumberList.add(1);
            ChangingFragment.NumberList.getAdapter().notifyItemInserted(0);
        }
        else{
            ArrayNumberList.add(ArrayNumberList.get(ArrayNumberList.size()-1)+1);
            ChangingFragment.NumberList.getAdapter().notifyItemInserted(ArrayNumberList.size()-1);


        }
    }

    @Override
    public void onClickInListReport(int position) {

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container,new TextFragment(position));
        transaction.addToBackStack(null);
        transaction.commit();
    }
}