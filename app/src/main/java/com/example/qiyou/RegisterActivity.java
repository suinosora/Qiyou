package com.example.qiyou;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.io.IOException;
import android.os.Message;
import android.os.Handler;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private Button regs;
    private EditText count_name;
    private EditText pass_wd;
    private TextView regst;
    private android.os.Handler handler;



    @SuppressLint("HandlerLeak")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        handler=new Handler(){
            @Override
            public void handleMessage(Message msg){
                super.handleMessage(msg);
                Bundle bundle = msg.getData();
                String value = bundle.getString("value");
                Log.e("tes2", value);
                if(value.equals("注册成功")){
                    Toast ts = Toast.makeText(getBaseContext(),"注册成功",Toast.LENGTH_SHORT);
                    ts.show();

                }else if(value.equals("账户已存在")){
                    Toast ts = Toast.makeText(getBaseContext(),"账户已存在",Toast.LENGTH_SHORT);
                    ts.show();
                }

            }
        };
        regs=(Button) findViewById(R.id.button_register1);
        count_name=(EditText) findViewById(R.id.editText_user1);
        pass_wd=(EditText) findViewById(R.id.editText_password1);
        regs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String res_name=count_name.getText().toString().trim();
                String res_pass=pass_wd.getText().toString().trim();
                if(res_name != null && res_name.length() != 0&& res_pass!=null&&res_pass.length()!=0) {
                    depends dp0 = new depends(handler);
                    String message = dp0.create_message_for_client(res_name, "123456", res_pass, "register", "Y", "");
                    try {
                        dp0.start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //finish();
                }else{
                    Toast ts = Toast.makeText(getBaseContext(),"账户或密码不能为空",Toast.LENGTH_SHORT);
                    ts.show();
                }
            }
        });
    }
}

