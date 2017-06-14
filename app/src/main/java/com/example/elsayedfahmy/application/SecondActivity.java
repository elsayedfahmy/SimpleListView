package com.example.elsayedfahmy.application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
TextView txtview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txtview=(TextView)findViewById(R.id.txtview);
        Intent intent=getIntent();
        String i=intent.getStringExtra("data");
        txtview.setText(i);

    }
}
