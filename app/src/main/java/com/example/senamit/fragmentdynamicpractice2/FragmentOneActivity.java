package com.example.senamit.fragmentdynamicpractice2;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * Created by senamit on 12/10/17.
 */

public class FragmentOneActivity extends Fragment implements ListView.OnItemClickListener {

    public static final String LOG_TAG =FragmentOneActivity.class.getSimpleName();

    Communicator communicator;
 int  count ;
    ListView listView;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment1_layout, container, false);


        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        communicator = (Communicator) getActivity();

        listView = getActivity().findViewById(R.id.listview);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("amit");
        arrayList.add("sen");
        arrayList.add("sonali");

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(getActivity().getBaseContext(), android.R.layout.simple_list_item_1, arrayList );

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);







//        Button button = getActivity().findViewById(R.id.button1);
//
//        Log.e(LOG_TAG, "the count is before onclick "+count);
//        button.setOnClickListener(this);

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
        Log.i(LOG_TAG, "Inside on saveinstance" +count);
        outState.putInt("counter",count);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Toast.makeText(view.getContext(), "clicked item is "+i , Toast.LENGTH_SHORT).show();
        communicator.dataTransfer(i);
        count=i;
        Log.i(LOG_TAG, "item clicked is "+i);


    }


//    @Override
//    public void onClick(View view) {
//
//        count++;
//
//        Log.i(LOG_TAG, "Onclick mehtod count is  "+count);
//        communicator.dataTransfer(Integer.toString(count));
//
//    }


}
