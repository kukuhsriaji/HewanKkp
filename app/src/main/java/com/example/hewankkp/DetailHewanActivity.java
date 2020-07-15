package com.example.hewankkp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailHewanActivity extends AppCompatActivity {

    String strHewanExtras = "";
    ImageView imgHewanExtras;
    TextView txNamaHewanExtras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hewan);
        getExtras();
        initComponent();
    }

    private void initComponent(){
        imgHewanExtras = findViewById(R.id.imgHewanExtras);
        txNamaHewanExtras = findViewById(R.id.txHewanExtras);
        if("kucing".equals(strHewanExtras)){
            imgHewanExtras.setImageResource(R.drawable.kucing);
            txNamaHewanExtras.setText("NAMA HEWAN INI ADALAH\nKUCING");
        } else if("singa".equals(strHewanExtras)){
            imgHewanExtras.setImageResource(R.drawable.singa);
            txNamaHewanExtras.setText("NAMA HEWAN INI ADALAH\nSINGA");
        } else if("kelinci".equals(strHewanExtras)){
            imgHewanExtras.setImageResource(R.drawable.kelinci);
            txNamaHewanExtras.setText("NAMA HEWAN INI ADALAH\nKELINCI");
        } else if("harimau".equals(strHewanExtras)){
            imgHewanExtras.setImageResource(R.drawable.harimau);
            txNamaHewanExtras.setText("NAMA HEWAN INI ADALAH\nHARIMAU");
        }
    }

    private void getExtras(){
        if(getIntent() != null){
            Bundle bundle=getIntent().getExtras();
            if(bundle != null){
                strHewanExtras = bundle.getString("jenisHewan");
                System.out.println("jenis hewan = "+strHewanExtras);
            }
        }
    }

}