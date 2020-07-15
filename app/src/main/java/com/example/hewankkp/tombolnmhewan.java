package com.example.hewankkp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;

public class tombolnmhewan extends AppCompatActivity {
    CardView namahewan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tombolnmhewan);
        namahewan = findViewById(R.id.namahewan);

    }
}