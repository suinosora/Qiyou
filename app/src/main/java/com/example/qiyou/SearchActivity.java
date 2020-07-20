package com.example.qiyou;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.example.qiyou.tools.SearchAdapter;


public class SearchActivity extends AppCompatActivity {

    //private
    private AutoCompleteTextView auto_search;
    private AutoCompleteTextView auto_search2;
    private Button quit_search;
    private String jieguo="caoniam";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        quit_search=(Button)findViewById(R.id.button_quitsearch);
        auto_search =(AutoCompleteTextView) findViewById(R.id.autoCompleteTextView_search);
        //Context context_tmp = this.getActivity();
        //ArrayAdapter<String> adapter_s = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, str);
        address add=new address();
        SearchAdapter<String> adapter_s =new SearchAdapter<String>(SearchActivity.this,android.R.layout.simple_list_item_1,add.str,SearchAdapter.ALL);
        auto_search.setAdapter(adapter_s);

        auto_search.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                parent.getItemAtPosition(position).toString();
                Log.i("d1s", "onCreate: " + parent.getItemAtPosition(position).toString());
                jieguo = parent.getItemAtPosition(position).toString();
                Log.i("d1s", "onCreate: " + jieguo);
                Intent intent = new Intent();
                intent.putExtra("dest",jieguo);
                setResult(1,intent);
            }
        });
        quit_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //auto_search2=(AutoCompleteTextView)findViewById(R.id.autoCompleteTextView_search);



        //finish();
    }


    /*
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case ;
        }
    }

     */

}
