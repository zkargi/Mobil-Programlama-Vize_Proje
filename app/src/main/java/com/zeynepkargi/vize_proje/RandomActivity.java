package com.zeynepkargi.vize_proje;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.Random;

public class RandomActivity extends AppCompatActivity {
    EditText etadet,etmin,etmax;
    LinearLayout linearlayout;
    Button buton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);
        etadet=findViewById(R.id.et_adet);
        etmax=findViewById(R.id.et_maks);
        etmin=findViewById(R.id.et_min);
        linearlayout=findViewById(R.id.linear_layout);

    }
}