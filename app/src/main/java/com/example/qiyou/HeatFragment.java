package com.example.qiyou;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HeatFragment extends Fragment {
    private String user_name;
    public HeatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(isAdded()){
            user_name=getArguments().getString("name");
        }
        View heat_view =inflater.inflate(R.layout.fragment_heat,container,false);
        LinearLayout llContent = heat_view.findViewById(R.id.ll_content);
        for(int i=0;i<30;i++) {
            LinearLayout linearLayout1 = new LinearLayout(getActivity());
            LinearLayout linearLayout2 = new LinearLayout(getActivity());
            LinearLayout linearLayout3 = new LinearLayout(getActivity());
            TextView textView_title = new TextView(getActivity());        //路线标题
            TextView textView_detail = new TextView(getActivity());       //路线详情
            ImageView imageView = new ImageView(getActivity());           //风景图
//下面是对每一条推荐的布局限制
            LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,300);
            layoutParams1.setMargins(54,0,54,20);
            linearLayout1.setLayoutParams(layoutParams1);

            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(400,300);
            layoutParams2.setMargins(14,0,0,20);
            linearLayout2.setLayoutParams(layoutParams2);

            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(600,300);
            layoutParams3.setMargins(14,0,0,20);
            linearLayout3.setLayoutParams(layoutParams3);

            linearLayout1.setOrientation(LinearLayout.HORIZONTAL);
            linearLayout3.setOrientation(LinearLayout.VERTICAL);
            linearLayout2.setGravity(Gravity.CENTER_VERTICAL);
            //这里是图片的背景色        linearLayout2.setBackgroundColor(MainActivity.this.getResources().getColor(R.color.colorAccent));
            imageView.setImageResource(R.drawable.test);//插入图片
            textView_title.setText("这是输入路线名称的地方");//插入文字
            textView_title.setGravity(Gravity.CENTER_HORIZONTAL);
            textView_detail.setText("这里是路线的详情");
            linearLayout3.addView(textView_title);
            linearLayout3.addView(textView_detail);
            linearLayout2.addView(imageView);
            linearLayout1.addView(linearLayout3);
            linearLayout1.addView(linearLayout2);
            llContent.addView(linearLayout1);
        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_heat, container, false);
    }

}
