package com.example.materiai_ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Home extends AppCompatActivity {
    ImageView anhDaiDien;
    Button btnPRF, btnDSM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnPRF = (Button) findViewById(R.id.buttonProfile);
        btnDSM = (Button) findViewById(R.id.buttonDSM);
        anhDaiDien = (ImageView) findViewById(R.id.imageViewAnhDaiDien);

        btnPRF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profile = new Intent(Home.this, Profile.class);
                startActivity(profile);
            }
        });

        btnDSM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent list = new Intent(Home.this, List.class);
                startActivity(list);
            }
        });

        anhDaiDien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profile = new Intent(Home.this, Profile.class);
                startActivity(profile);
            }
        });
    }
}