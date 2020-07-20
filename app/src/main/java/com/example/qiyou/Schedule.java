package com.example.qiyou;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.qiyou.tools.ImageUtil;

public class Schedule extends AppCompatActivity {

    private ImageView imageView;//路线图
    private TextView textView_total;//总路线
    private Button button_add;//添加到我的行程
    private Button button_share;//分享行程
    private String route;
    private String s_to_d;
    private String img_yingjian;
    private int flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        Intent get_home =getIntent();
        route=get_home.getStringExtra("route");
        s_to_d=get_home.getStringExtra("s_to_d");

        Log.i("schedule_route", "onCreate: "+route);
        flag=get_home.getIntExtra("flag",0);
        if(flag==0)
            img_yingjian="http://39.98.209.180:8080/static/"+s_to_d+"_short.png";
        else if(flag==1)
            img_yingjian="http://39.98.209.180:8080/static/"+s_to_d+"_view.png";
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    Bitmap yingjianmap = ImageUtil.getImage(img_yingjian);
                    imageView.setImageBitmap(yingjianmap);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();

        imageView = findViewById(R.id.map);
        textView_total = findViewById(R.id.textView_schedule);
        textView_total.setText(route);
        button_add = findViewById(R.id.button_add);
        button_share = findViewById(R.id.button_share);

        imageView.setImageResource(R.drawable.test);
        /*
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_add = new Intent(Schedule.this,urltest.class);
                startActivity(intent_add);
            }
        });

         */

        button_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}