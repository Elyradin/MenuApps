package com.example.menuapps;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button makanan, minuman;
    EditText menu;
    TextView textMenu, textJumlah, Jumlah;

    public static final String MESSAGE_EXTRA = "MESSAGE_KEY";
    public  static  final String MESSAGE_TIPE = "TYPE_KEY";

    ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK){
                        String isian = result.getData().getStringExtra(HalamanDua.MESSAGE_OK);
                        Jumlah.setText(isian);
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Jumlah = findViewById(R.id.txt_isijml);
        menu = findViewById(R.id.edit_nama);
        makanan = findViewById(R.id.btn_makanan);
        minuman = findViewById(R.id.btn_minuman);


        makanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_mak = new Intent(view.getContext(), HalamanDua.class);
                String message = menu.getText().toString();
                intent_mak.putExtra(MESSAGE_EXTRA, message);
                intent_mak.putExtra(MESSAGE_TIPE, "makanan");
                launcher.launch(intent_mak);

            }
        });
        minuman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_min = new Intent(view.getContext(), HalamanDua.class);
                String message = menu.getText().toString();
                intent_min.putExtra(MESSAGE_EXTRA, message);
                intent_min.putExtra(MESSAGE_TIPE, "minuman");
                launcher.launch(intent_min);

            }
        });
    }
}