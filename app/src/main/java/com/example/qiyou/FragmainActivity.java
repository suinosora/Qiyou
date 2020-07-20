package com.example.qiyou;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;



public class FragmainActivity extends AppCompatActivity {


    private MyspaceFragment fragment_myspace =new MyspaceFragment();
    private HomeFragment fragment_home =new HomeFragment();
    private HeatFragment fragment_heat =new HeatFragment();
    int flg=0;
    private String user_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragmain);

        Intent from_login=getIntent();
        user_name=from_login.getStringExtra("name");
        Bundle bundle_main =new Bundle();
        bundle_main.putString("name",user_name);


        ImageButton IB_search =(ImageButton) findViewById(R.id.imageButton_search);
        ImageButton IB_heat =(ImageButton)findViewById(R.id.imageButton_heats);
        ImageButton IB_myspace=(ImageButton) findViewById(R.id.imageButton_myspace);

        fragment_home.setArguments(bundle_main);
        fragment_heat.setArguments(bundle_main);

        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,fragment_home).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,fragment_heat).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,fragment_myspace).commit();
        getSupportFragmentManager().beginTransaction().hide(fragment_myspace).commit();
        getSupportFragmentManager().beginTransaction().hide(fragment_heat).commit();
        /*
        if(flg==0)
        {
            Intent intent_getdata =getIntent();
            String dest =intent_getdata.getStringExtra("name");
            Bundle bundle_to_home =new Bundle();
            bundle_to_home.putString("dest",dest);
            fragment_home.setArguments(bundle_to_home);
        }
*/
        //getSupportFragmentManager().beginTransaction().hide(fragment_home).commit();


        //getSupportFragmentManager().beginTransaction().hide(fragment_myspace).commit();
        //getSupportFragmentManager().beginTransaction().show(fragment_main).commit();

        IB_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flg!=0)
                {
                    getSupportFragmentManager().beginTransaction().hide(fragment_myspace).commit();
                    getSupportFragmentManager().beginTransaction().hide(fragment_heat).commit();
                    getSupportFragmentManager().beginTransaction().show(fragment_home).commit();
                }
                flg=0;

            }
        });

        IB_heat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flg!=1)
                {
                    getSupportFragmentManager().beginTransaction().hide(fragment_myspace).commit();
                    getSupportFragmentManager().beginTransaction().hide(fragment_home).commit();
                    getSupportFragmentManager().beginTransaction().show(fragment_heat).commit();
                }
                flg=1;
            }
        });

        IB_myspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flg!=2)
                {
                    getSupportFragmentManager().beginTransaction().hide(fragment_home).commit();
                    getSupportFragmentManager().beginTransaction().hide(fragment_heat).commit();
                    getSupportFragmentManager().beginTransaction().show(fragment_myspace).commit();
                }
                flg=2;
            }
        });


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
