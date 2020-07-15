package com.example.hewankkp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imgKucing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponent();
        initAction();
    }

    private void initComponent(){
        imgKucing = findViewById(R.id.imgKucing);
    }

    private void initAction(){
        imgKucing.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent a = new Intent(MainActivity.this, DetailHewanActivity.class);
                a.putExtra("jenisHewan", "kucing");
                startActivity(a);

            }
        });
    }
}