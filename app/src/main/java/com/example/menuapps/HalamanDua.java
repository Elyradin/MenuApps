package com.example.menuapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HalamanDua extends AppCompatActivity {

    TextView makanan, tipe_menu;
    EditText isijumlah;
    Button oke;
    public static final String MESSAGE_OK = "OKE_KEY";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_dua);

        makanan = findViewById(R.id.btn_makanan);
        tipe_menu = findViewById(R.id.tipe);
        isijumlah = findViewById(R.id.edittext_jumlah);
        oke = findViewById(R.id.btn_oke);

        Intent intent_menu = getIntent();
        Intent intent_type = getIntent();
        String menu = intent_menu.getStringExtra(MainActivity.MESSAGE_EXTRA);
        String type = intent_type.getStringExtra(MainActivity.MESSAGE_TIPE);
        tipe_menu.setText(type);
        makanan.setText(menu);

        oke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                String amount = isijumlah.getText().toString();
                intent.putExtra(MESSAGE_OK, amount);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        //proses mengambil data dari page pertama
//        Intent intentmenu = getIntent();
//        Intent intenttipe = getIntent();
//        String menu = intentmenu.getStringExtra(MainActivity.MESSAGE_EXTRA);
//        String type = intenttipe.getStringExtra(MainActivity.MESSAGE_TIPE);
        //mendisplay data
//        makanan.setText(menu);
//        tipe_menu.setText(type);

        //operasi
//        oke.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //proses penyimpanan data
//                Intent buton_oke = new Intent();
//                String message = isijumlah.getText().toString();
//                buton_oke.putExtra(MESSAGE_OK, message);
//                setResult(RESULT_OK, buton_oke);
//                finish();

//            }
//        });
    }
}