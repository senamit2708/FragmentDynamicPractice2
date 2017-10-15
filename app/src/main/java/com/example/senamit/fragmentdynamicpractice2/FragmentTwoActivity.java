package com.example.senamit.fragmentdynamicpractice2;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by senamit on 12/10/17.
 */

public class FragmentTwoActivity extends Fragment {

    TextView textView;
    int data;

    List<String> arrayList;





    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment2_layout, container, false);




        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        textView = getActivity().findViewById(R.id.textview2);
        arrayList = Arrays.asList(getResources().getStringArray(R.array.result));
        if (savedInstanceState==null){

        }else {
//            data= savedInstanceState.getString("data");
            data = savedInstanceState.getInt("data");
            TextView myText = (TextView)getActivity().findViewById(R.id.textview2);
            myText.setText(arrayList.get(data));

        }

    }

    public void changeText(int number){
        data=number;

        textView.setText("the item clicked is  "+ number + " value is "+arrayList.get(number));
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("data", data);
    }
}
