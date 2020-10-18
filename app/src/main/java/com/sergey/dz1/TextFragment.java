package com.sergey.dz1;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class TextFragment extends Fragment {
    String MyText;
    public TextFragment(){
        MyText="default_number";
    }
    public TextFragment(int number ){

        MyText=Integer.valueOf(number).toString();
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if(savedInstanceState!=null){
        MyText=savedInstanceState.getString("MyText");
        }

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View MyView=inflater.inflate(R.layout.fragment_second, container, false);
        TextView FocusedNumber=MyView.findViewById(R.id.number_focused);
        FocusedNumber.setText(MyText);
        if(Integer.valueOf(MyText)%2==0){

            FocusedNumber.setTextColor(Color.RED);
        }
        else {
            FocusedNumber.setTextColor(Color.BLUE);
        }
        return MyView;
    }
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("MyText",MyText);

    }
}
