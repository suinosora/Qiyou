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

public class RegisterActivity extends AppCompatActivity {
    private Button regs;
    private EditText count_name;
    private EditText pass_wd;
    private TextView regst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        regs=(Button) findViewById(R.id.button_register1);
        count_name=(EditText) findViewById(R.id.editText_user1);
        pass_wd=(EditText) findViewById(R.id.editText_password1);
        regs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String res_name=count_name.getText().toString().trim();
                String res_pass=pass_wd.getText().toString().trim();
                depends dp0=new depends();
                String message=dp0.create_message_for_client(res_name,"123456",res_pass,"register","Y","");
                try {
                    dp0.send_msg(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //finish();
            }
        });
    }
}
