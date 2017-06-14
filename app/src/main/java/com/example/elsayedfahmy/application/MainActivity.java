package com.example.elsayedfahmy.application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
 ListView lst;
    String []arr={"today - sunny - 88/30",
            "tomorrow - foggy - 87/30",
            "wed - cloudy - 72/40",
            "fri - sunny - 88/30",
            "aaa","asdd","fffff","jkjkjk"};
    ArrayAdapter<String>adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lst=(ListView)findViewById(R.id.lstview);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arr);
        lst.setAdapter(adapter);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               String data=adapter.getItem(i);

                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("data",data);
                startActivity(intent);
                Toast.makeText(MainActivity.this,"Done",Toast.LENGTH_LONG).show();
            }
        });


        /*
        HttpURLConnection urlConnection=null;
        BufferedReader reader=null;

        String forecastJsonstr=null;

        try {
            URL url=new URL(" ");
            urlConnection =(HttpURLConnection)url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();


            InputStream inputStream=urlConnection.getInputStream();

            StringBuffer stringBuffer=new StringBuffer();


            if (inputStream == null)
            {
               return ;
            }
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



        */


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();
        if (id==R.id.id_setting)
        {
            startActivity(new Intent(this,setting2.class));
            return  true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.setting,menu);


       //return super.onCreateOptionsMenu(menu);
       return  true;

    }
}
