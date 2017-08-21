package com.bcardtest.android;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.bcardtest.android.Gson.Result;
import com.bcardtest.android.R;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

public class BCardre extends AppCompatActivity {

    private TextView nameText;
    private TextView titleText;
    private TextView compText;
    private TextView mobileText;
    private TextView webText;
    private TextView emailText;
    private TextView deptText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bcardre);
        Intent intent=getIntent();
        String responce=intent.getStringExtra("responce");
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }



        nameText = (TextView) findViewById(R.id.name);
        compText = (TextView) findViewById(R.id.comp);
        titleText= (TextView) findViewById(R.id.title);
        mobileText = (TextView) findViewById(R.id.mobile);
        webText = (TextView) findViewById(R.id.web);
        emailText=(TextView)findViewById(R.id.email);
        deptText=(TextView)findViewById(R.id.dept);

        parseJSON(responce);

    }


    public void parseJSON(String jsonData){
        JSON jsonGetText=new JSON(jsonData);
            nameText.setText(jsonGetText.getJSONText("name"));

            compText.setText(jsonGetText.getJSONText("comp"));

            titleText.setText(jsonGetText.getJSONText("title"));

            mobileText.setText(jsonGetText.getJSONText("mobile"));

            webText.setText(jsonGetText.getJSONText("web"));

            emailText.setText(jsonGetText.getJSONText("email"));

            deptText.setText(jsonGetText.getJSONText("dept"));
    }



    public void parseJSONWithGSON(String jsonData){
        Gson gson=new Gson();

        Result result=gson.fromJson(jsonData,Result.class);

        nameText.setText(result.getName());
        compText.setText(result.getComp());
        titleText.setText(result.getTitle());
        mobileText.setText(result.getMobile());
        webText.setText(result.getWeb());

    }
}
