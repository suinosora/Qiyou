package com.example.qiyou;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class FragmainActivity extends AppCompatActivity {


    private MyspaceFragment fragment_myspace =new MyspaceFragment();
    private HomeFragment fragment_home =new HomeFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragmain);
        //MainFragment fragment_main =new MainFragment();
        //MyspaceFragment fragment_myspace =new MyspaceFragment();
        ImageButton IB_search =(ImageButton) findViewById(R.id.imageButton_search);

//        Button b_fragment_main = (Button) findViewById(R.id.button_mainfrag);
//        Button b_fragment_home = (Button) findViewById(R.id.button_userfrag);
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,fragment_myspace).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,fragment_home).commit();
        //getSupportFragmentManager().beginTransaction().hide(fragment_home).commit();


        //getSupportFragmentManager().beginTransaction().hide(fragment_myspace).commit();
        //getSupportFragmentManager().beginTransaction().show(fragment_main).commit();



        /*
        b_fragment_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //MainFragment fragment_main =new MainFragment();
                if(flag==0)
                {
                    getSupportFragmentManager().beginTransaction().remove(fragment_myspace).commit();
                    flag=1;
                    getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,fragment_main).commit();
                }
                //getSupportFragmentManager().beginTransaction().hide(fragment_myspace).commit();
                //getSupportFragmentManager().beginTransaction().show(fragment_main).commit();
            }
        });

        b_fragment_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(flag==1)
                {
                    getSupportFragmentManager().beginTransaction().remove(fragment_main).commit();
                    flag=0;
                    getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,fragment_myspace).commit();
                }
                //MyspaceFragment fragment_myspace =new MyspaceFragment();
                getSupportFragmentManager().beginTransaction().hide(fragment_main).commit();
                getSupportFragmentManager().beginTransaction().show(fragment_myspace).commit();
            }
        });
        */

    }
}
