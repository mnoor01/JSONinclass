package com.example.c4q.jsoninclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String message;
    private String statement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Success success = new Success();
        JSONObject jObject = new JSONObject();
        try {
            jObject = new JSONObject(Constant.Values);


        } catch (JSONException e) {
            e.printStackTrace();
        }
        List<String> messages= messageFromSuccess(Constant.Values);
        for (String s: messages) {
            Log.d("MainActivity",s);
        }
    }

    public List<String> messageFromSuccess(String messages) {
        List<String> addingToList = new ArrayList<>();
        JSONObject jObject = null;
        try {
            jObject = new JSONObject(Constant.Values);
            JSONArray successArray = jObject.getJSONArray("message");
            for (int i = 0; i < successArray.length(); i++) {
                addingToList.add(successArray.get(i).toString());
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return addingToList;


    }
}

