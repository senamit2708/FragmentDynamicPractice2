package com.example.senamit.fragmentdynamicpractice2;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity  implements Communicator{

    FragmentTwoActivity fragment2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        FragmentOneActivity fragment1 = new FragmentOneActivity();
       fragment2 = new FragmentTwoActivity();


        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.main_linear_layout_one, fragment1, "f1");
        fragmentTransaction.add(R.id.main_linear_layout_two,fragment2,"f2");
        fragmentTransaction.commit();


    }

    @Override
    public void dataTransfer(int data) {

        fragment2.changeText(data);

    }
}
