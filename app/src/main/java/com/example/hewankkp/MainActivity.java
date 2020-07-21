package com.example.hewankkp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imgPeliharaan, imgLiar, imgLaut, imgprop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponent();
        initAction();
    }

    private void initComponent(){
        imgPeliharaan = findViewById(R.id.imgHewanPeliharaan);
        imgLiar = findViewById(R.id.imgHewanLiar);
        imgLaut = findViewById(R.id.imgHewanLaut);
        imgprop = findViewById(R.id.profil);
    }

    private void initAction(){
        imgPeliharaan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent a = new Intent(MainActivity.this, DetailHewanActivity.class);
                a.putExtra("jenisHewan", "peliharaan");
                startActivity(a);
            }
        });
        imgLiar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent a = new Intent(MainActivity.this, DetailHewanActivity.class);
                a.putExtra("jenisHewan", "liar");
                startActivity(a);
            }
        });
        imgLaut.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent a = new Intent(MainActivity.this, DetailHewanActivity.class);
                a.putExtra("jenisHewan", "laut");
                startActivity(a);
            }
        });
        imgprop.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,profil.class));
            }
        });
    }
}