package com.example.qiyou;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qiyou.tools.SearchAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private int flg=-1;
    private static final int REQUEST_CODE = 0x11;

    private Button time_min;
    private Button view_max;
    private ImageButton home_search;
    private String destiny;
    private String source;
    private Button select_destiny;
    private Button select_source;
    private TextView show_dest;
    private TextView show_sour;
    private int flag=0;
    private android.os.Handler handler;
    private String user_name;

    private String temp;



    public HomeFragment() {


        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //ImageButton IB_M_search =
        if(isAdded()){
            user_name=getArguments().getString("name");
        }
        View home_view =inflater.inflate(R.layout.fragment_home,container,false);
        time_min =home_view.findViewById(R.id.button_timemin);
        view_max =home_view.findViewById(R.id.button_viewmax);
        home_search=home_view.findViewById(R.id.imageButton_main_search);
        select_destiny=home_view.findViewById(R.id.button_search_destiny);
        select_source=home_view.findViewById(R.id.button_search_source);
        show_dest=home_view.findViewById(R.id.textView_destiny);
        show_sour=home_view.findViewById(R.id.textView_source);



        select_destiny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flg=0;
                Intent intent_des =new Intent(getActivity(),SearchActivity.class);
                startActivityForResult(intent_des,REQUEST_CODE);
                show_dest.setText(destiny);

            }
        });

        select_source.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flg=1;
                Intent intent_sou =new Intent(getActivity(),SearchActivity.class);
                startActivityForResult(intent_sou,REQUEST_CODE);
                show_sour.setText(source);
            }
        });

        handler=new Handler(){
            @Override
            public void handleMessage(Message msg){
                super.handleMessage(msg);
                Bundle bundle = msg.getData();
                String value = bundle.getString("value");

                Log.e("tes2", value);
                Intent go_schedule = new Intent(getActivity(),Schedule.class);
                Bundle bundle1=new Bundle();
                bundle1.putString("route",value);
                bundle1.putString("s_to_d",temp);
                bundle1.putInt("flag",flag);
                go_schedule.putExtras(bundle1);
                getActivity().startActivity(go_schedule);
            }
        };
        //search_source =(AutoCompleteTextView)home_view.findViewById(R.id.autoCompleteTextView_source);
        //Context context_tmp = this.getActivity();
        //SearchAdapter<String> adapter_s =new SearchAdapter<String>(HomeFragment.this,android.R.layout.simple_list_item_1,str);
        //ArrayAdapter<String> adapter_d =new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,str);

        time_min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("gees", "onClick: ghi");
                flag=0;

            }
        });
        view_max.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag=1;

            }
        });
        home_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp=source+"-"+destiny;
                Log.i("temp", "onClick: "+temp);
                if(source != null && source.length() != 0&& destiny!=null&&destiny.length()!=0){

                    depends dp=new depends(handler);
                    String message;
                    if(flag==0)
                        message=dp.create_message_for_client(user_name,"123456","123","short_path","Y",temp);
                    else if(flag==1)
                        message=dp.create_message_for_client(user_name,"123456","123","view_path","Y",temp);
                    try {
                        dp.start();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }else{
                    Toast ts = Toast.makeText(getActivity(),"账户或密码不能为空",Toast.LENGTH_SHORT);
                    ts.show();
                }

            }
        });





        return home_view;
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode != 1) {
                return;
            }
            if (data != null) {
                if(flg==0)
                    destiny = data.getStringExtra("dest");
                else if(flg==1)
                    source=data.getStringExtra("dest");
                Log.i("destiny", "onActivityResult: param:" + destiny);
                Log.i("source", "onActivityResult: param:" + source);
            }
            Log.i("fds", "onActivityResult: resultCode" + resultCode + ",requestCode:" + requestCode);
            show_dest.setText(destiny);
            show_sour.setText(source);
            //do something
        }
    }



    /*
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        destiny =((SearchActivity)getActivity()).getdesTitles();
        source =((SearchActivity)getActivity()).getsouTitles();
    }

*/
}
