package com.example.senamit.fragmentdynamicpractice2;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  implements Communicator{


    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);






         fragmentManager = getFragmentManager();

        fragmentAdding();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.add(R.id.main_linear_layout_one, fragment1, "f1");
//        fragmentTransaction.add(R.id.main_linear_layout_two,fragment2,"f2");
//        fragmentTransaction.commit();

        Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                FragmentTwoActivity fragment2 = new FragmentTwoActivity();
                fragmentTransaction.replace(R.id.main_linear_layout_one, fragment2, "f2");
                fragmentTransaction.commit();


            }
        });


        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                FragmentOneActivity fragment1 = new FragmentOneActivity();
                fragmentTransaction.replace(R.id.main_linear_layout_one, fragment1);
                fragmentTransaction.commit();


            }
        });


    }

    public void fragmentAdding() {

        FragmentTwoActivity fragment2;
        FragmentOneActivity fragment1;

        fragment1 = new FragmentOneActivity();
        fragment2 = new FragmentTwoActivity();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.main_linear_layout_one, fragment1, "f1");
        fragmentTransaction.add(R.id.main_linear_layout_two,fragment2,"f2");
        fragmentTransaction.commit();
    }

    @Override
    public void dataTransfer(int data) {



//        fragment2.changeText(data);

    }






    }

