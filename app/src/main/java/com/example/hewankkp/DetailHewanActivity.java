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
    static int listPeliharaanImg[] = {R.drawable.kucing, R.drawable.kelinci, R.drawable.anjing,
    R.drawable.hamster, R.drawable.kakatua, R.drawable.kuda};
    static int listPeliharaanSound[] = {R.raw.suara_kucing, R.raw.suara_kelinci, R.raw.suara_anjing,
    R.raw.suara_hamster, R.raw.suara_kakatua, R.raw.suara_kuda};
    static String listPeliharaanStr[] = {"KUCING", "KELINCI", "ANJING","HAMSTER", "KAKAK TUA", "KUDA"};
    static String listPeliharaanDescStr[] = {"Kucing adalah salah satu hewan peliharaan terpopuler di dunia\nKucing disebut juga kucing domestik atau kucing rumah\n dan sejenis mamalia karnivora."
            ,"Kelinci adalah hewan mamalia yang dapat di temukan di banyak bagian bumi\nKelinci berkembang biak dengan cara beranak yang di sebut dengan vivipar."
            ,"Anjing adalah hewan pemangsa, memiliki gigi tajam dan rahang yang kuat untuk menggigit makanan\nAnjing tergolong binatang omnivora atau pemakan tumbuhan dan daging.\nAnjing berkembang biak dengan cara beranak"
            ,"Hamster adalah hewan mamalia yang berasal dari eropa dan biasa berkembang biak serta tinggal di padang pasir,padang rumput, serta di kandang sebagai hewan peliharaan.\nHamster merupakan hewan berjenis omnivora dan penggali lubang yang baik. "
            , "Burung kakak tua adalah jenis burung hias yang memiliki bulu yang indah dan memiliki suara yang nyaring.\nBurung kakaktua menghuni hutan yang tinggi bersemak, kakaktua dikenal sebagai burung yang setia."
            , "Kuda adalah hewan herbivora atau pemakan tumbuhan yang berkembang biak dengan cara beranak. Kuda memiliki berbagai macam warna dan jenis, kuda dapat digunakan untuk alat transportasi ataupun olahraga."};

    static int listLiarImg[] = {R.drawable.singa, R.drawable.harimau, R.drawable.buaya, R.drawable.ular,
    R.drawable.beruang, R.drawable.serigala};
    static int listLiarSound[] = {R.raw.suara_singa, R.raw.suara_harimau, R.raw.suara_buaya, R.raw.suara_ular,
    R.raw.suara_beruang, R.raw.suara_serigala};
    static String listLiarStr[] = {"SINGA", "HARIMAU","BUAYA","ULAR","BERUANG","SERIGALA"};
    static String ListLiarDescStr[] = {"Singa adalah hewan mamalia karnivora atau pemakan daging. Karena itu singa memiliki gigi dan cakar yang tajam untuk mengoyak mangsanya. Hewan ini hidup di padang pasir dan biasanya hidup berkelompok."
            , "Harimau adalah hewan karnivora atau pemakan daging, kelas mamalia. Harimau biasanya hidup di hutan yang memburu hewan kecil seperti landak. Harimau dikenal sebagai kucing terbesar, harimau berukuran seperti singa tetapi sedikit lebih berat."
            ,"buaya adalah hewan pemakan daging berkaki 4 yang cenderung untuk tinggal di sungai atau danau. Buaya memakan ikan, burung atau hewan lainnya dan mamalia sebagai makanan utama mereka."
            , "Ular adalah hewan yang tidak berkaki dan bertubuh panjang. Di habitat asliya, ular dapat hidup di pohon, tanah, sampai perairan tawar atau asin. Ular berkembang biak dengan cara bertelur dan ular dapat di temukan di seluruh dunia kecuali benua antartikaa."
            ,"Beruang adalah salah satu hewan mamalia terbesar yang di temukan di seluruh dunia. Beruang memiliki indera penciuman yang sangat baik dan mereka juga tergolong hewan pemanjat pohon yang sangat baik. Makanan favorite dari beruang adalah ikan dan tinggal di hutan dan daerah pegunungan."
            ,"Serigala adalah mamalia karnivora yang spesial. Serigala berkembang biak secara selektif agar sifat ganas yang tidak bertahan dalam jiwa hewan peliharaan. Serigala bisa tinggal di daerah kawasan hutan, gunung, padang rumput, dan gurun."};

    static int listLautImg[] = {R.drawable.singalaut, R.drawable.paus, R.drawable.anjinglaut};
    static int listLautSound[] = {R.raw.suara_singalaut, R.raw.suara_paus, R.raw.suara_anjinglaut};
    static String listLautStr[] = {"SINGA LAUT", "IKAN PAUS", "ANJING LAUT"};
    static String ListLautDescStr[] = {"Singa Laut adalah hewan mamalia laut amfibi. Singa laut dapat bertahan hidup di iklim berbeda dan memiliki struktur sosial yang berkembang biak yang baik. Singa laut itu cerdas, mereka bisa memahami bahasa isyarat yang belum sempurna."
            ,"Ikan Paus adalah ikan yang hidup di air laut yang berukuran besar dan merupakan ikan terbesar yang ada di dunia. ikan ini memakan ikan yang lebih kecil darinya. Paus merupakan hewan mamalia dan bernafas dengan paru-paru serta meahirkan anaknya tidak seperti ikan lainnya yang bertelur."
            ,"Anjing laut adalah mamalia besar dari ordo karnivora yang hidup di daerah sejuk. Anjing laut merupakan hewan vivipar atau hewan yang berkembang biak dengan cara melahirkan. Anjing laut tergolong dalam hewan karnivora atau hewan yang makanan utamanya berasal dari hewan. Adapun hewan yang dimaksud adalah ikan, cumi-cumi dan hewan lainnya."};

    int listHewanShowImg[];
    int listHewanShowSound[];
    String listHewanShowStr[];
    String listHewanShowDescStr[];

    Integer current;
    ImageView imgHewanExtras;
    TextView txNamaHewanExtras;
    TextView txNamaDescExtras;
    Button btNext, btSound;
    private MediaPlayer mediaPlayer = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hewan);
        listHewanShowImg = listPeliharaanImg;
        getExtras();
        initComponent();
        initAction();
    }

    private void initComponent(){
        btNext = findViewById(R.id.btNext);
        btSound = findViewById(R.id.btSound);
        imgHewanExtras = findViewById(R.id.imgHewanExtras);
        txNamaHewanExtras = findViewById(R.id.txHewanExtras);
        imgHewanExtras.setImageResource(listHewanShowImg[current]);
        txNamaHewanExtras.setText("NAMA HEWAN INI ADALAH\n"+ listHewanShowStr[current]);
        txNamaDescExtras = findViewById(R.id.txHewanDescExtras);
        txNamaDescExtras.setText(listHewanShowDescStr[current]);

    }

    private void initAction(){
        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopMediaPlayer();
                current++;
                if(current >= listHewanShowImg.length) current = 0;
                System.out.println("bt next setOnClickListener -> "+listHewanShowStr[current]);
                imgHewanExtras.setImageResource(listHewanShowImg[current]);
                txNamaHewanExtras.setText("NAMA HEWAN INI ADALAH\n"+ listHewanShowStr[current]);
                txNamaDescExtras.setText(listHewanShowDescStr[current]);

            }
        });

        btSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), listHewanShowSound[current]);
                try {
                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        public void onPrepared(MediaPlayer player) {
                            player.start();
                        }
                    });
                    mediaPlayer.prepare();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        public void onCompletion(MediaPlayer mp) {
                            stopMediaPlayer();
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
                    listHewanShowImg = listPeliharaanImg;
                    listHewanShowSound = listPeliharaanSound;
                    listHewanShowStr = listPeliharaanStr;
                    listHewanShowDescStr = listPeliharaanDescStr;
                    current = 0;
                } else if("liar".equals(strJenisExtras)){
                    listHewanShowImg = listLiarImg;
                    listHewanShowSound = listLiarSound;
                    listHewanShowStr = listLiarStr;
                    listHewanShowDescStr = ListLiarDescStr;
                    current = 0;
                } else if("laut".equals(strJenisExtras)){
                    listHewanShowImg = listLautImg;
                    listHewanShowSound = listLautSound;
                    listHewanShowStr = listLautStr;
                    listHewanShowDescStr = ListLautDescStr;
                    current = 0;
                }
            }
        }
    }

    private void stopMediaPlayer(){
        if(mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.reset();
            mediaPlayer.release();
            mediaPlayer = new MediaPlayer();
        }
    }
}