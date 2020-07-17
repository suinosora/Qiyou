package com.example.qiyou;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {
    private Button reg;
    private Button login;
    private EditText count;
    private EditText pwd;
    private TextView state;
    private TextView hint_res;
    private String name;
    private String passw;
/*
    private List<User> userList;
    private List<User> dataList = new ArrayList<>();
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reg =(Button) findViewById(R.id.button_register);
        login=(Button) findViewById(R.id.button_load);
        count= (EditText) findViewById(R.id.editText_user);
        pwd= (EditText) findViewById(R.id.editText_password);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go_res =new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(go_res);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name= count.getText().toString().trim();
                passw= pwd.getText().toString().trim();
                Log.d("this is password",passw);
                Log.i("this is name",name);
                depends dp=new depends();
                String message=dp.create_message_for_client(name,"123456",passw,"login","Y","");
                try {
                    dp.send_msg(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Intent go_main =new Intent(MainActivity.this,FragmainActivity.class);
                startActivity(go_main);
                finish();
            }
        });







    }
}
