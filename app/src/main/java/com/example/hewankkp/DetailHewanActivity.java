package com.example.hewankkp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailHewanActivity extends AppCompatActivity {

    String strJenisExtras = "";
    static int listPeliharaanImg[] = {R.drawable.kucing, R.drawable.kelinci};
    static int listPeliharaanSound[] = {R.raw.suara_kucing, R.raw.};
    static String listPeliharaanStr[] = {"KUCING", "KELINCI"};
    static int listLiarImg[] = {R.drawable.singa, R.drawable.harimau};
    static String listLiarStr[] = {"SINGA", "HARIMAU"};
    int listHewanShow[];
    String listHewanShowStr[];
    Integer current;
    ImageView imgHewanExtras;
    TextView txNamaHewanExtras;
    Button btNext, btSound;
    private MediaPlayer mediaPlayer = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hewan);
        listHewanShow = listPeliharaanImg;
        getExtras();
        initComponent();
        initAction();
    }

    private void initComponent(){
        btNext = findViewById(R.id.btNext);
        btSound = findViewById(R.id.btSound);
        imgHewanExtras = findViewById(R.id.imgHewanExtras);
        txNamaHewanExtras = findViewById(R.id.txHewanExtras);
        imgHewanExtras.setImageResource(listHewanShow[current]);
        txNamaHewanExtras.setText("NAMA HEWAN INI ADALAH\n"+ listHewanShowStr[current]);
    }

    private void initAction(){
        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                current++;
                if(current >= listHewanShow.length) current = 0;
                System.out.println("bt next setOnClickListener -> "+listHewanShowStr[current]);
                imgHewanExtras.setImageResource(listHewanShow[current]);
                txNamaHewanExtras.setText("NAMA HEWAN INI ADALAH\n"+ listHewanShowStr[current]);
            }
        });

        btSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.suara_kucing);
                try {
                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        public void onPrepared(MediaPlayer player) {
                            player.start();
                        }
                    });
                    mediaPlayer.prepare();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        public void onCompletion(MediaPlayer mp) {
                            mediaPlayer.stop();
                            mediaPlayer.reset();
                            mediaPlayer.release();
                            mediaPlayer = new MediaPlayer();
                        }
                    });
                } catch (Exception e) {
                    // make something
                }
            }
        });
    }

    private void getExtras(){
        if(getIntent() != null){
            Bundle bundle=getIntent().getExtras();
            if(bundle != null){
                strJenisExtras = bundle.getString("jenisHewan");
                System.out.println("jenis hewan = "+strJenisExtras);
                if("peliharaan".equals(strJenisExtras)){
                    listHewanShow = listPeliharaanImg;
                    listHewanShowStr = listPeliharaanStr;
                    current = 0;
                } else if("liar".equals(strJenisExtras)){
                    listHewanShow = listLiarImg;
                    listHewanShowStr = listLiarStr;
                    current = 0;
                }
            }
        }
    }

}