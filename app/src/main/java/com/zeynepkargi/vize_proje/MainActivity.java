package com.zeynepkargi.vize_proje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnconvertor;
    Button btnsms;
    Button btnrandom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnconvertor=findViewById(R.id.btn_convertor);
        btnrandom=findViewById(R.id.btn_random);
        btnsms=findViewById(R.id.btn_sms);

        btnconvertor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ConvertorActivity.class);
                startActivity(intent);
            }
        });

        btnsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SmsActivity.class);
                startActivity(intent);
            }
        });

        btnrandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,RandomActivity.class);
                startActivity(intent);
            }
        });
    }
}