package com.example.qiyou;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
    private android.os.Handler handler;
/*
    private List<User> userList;
    private List<User> dataList = new ArrayList<>();
*/


    @SuppressLint("HandlerLeak")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        handler=new Handler(){
            @Override
            public void handleMessage(Message msg){
                super.handleMessage(msg);
                Bundle bundle = msg.getData();
                String value = bundle.getString("value");
                Log.e("tes2", value);
                if(value.equals("登录成功")){
                    Toast ts = Toast.makeText(getBaseContext(),"登录成功",Toast.LENGTH_SHORT);
                    ts.show();
                    Intent go_main = new Intent(MainActivity.this, FragmainActivity.class);
                    startActivity(go_main);
                }else if(value.equals("账户或密码错误")){
                    Toast ts = Toast.makeText(getBaseContext(),"账户或密码错误",Toast.LENGTH_SHORT);
                    ts.show();
                }

            }
        };
        reg =(Button) findViewById(R.id.button_register);
        login=(Button) findViewById(R.id.button_load);
        count= (EditText) findViewById(R.id.editText_user);
        pwd= (EditText) findViewById(R.id.editText_password);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent go_res = new Intent(MainActivity.this, RegisterActivity.class);
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
                if(name != null && name.length() != 0&& passw!=null&&passw.length()!=0){

                    depends dp=new depends(handler);

                    String message=dp.create_message_for_client(name,"123456",passw,"login","Y","");

                    try {
                        dp.start();


                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }else{
                    Toast ts = Toast.makeText(getBaseContext(),"账户或密码不能为空",Toast.LENGTH_SHORT);
                    ts.show();
                }




                // Intent go_main = new Intent(MainActivity.this, FragmainActivity.class);
                //   startActivity(go_main);

                //finish();
            }
        });



    }



}
