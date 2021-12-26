package com.example.pesanmakanan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private LinearLayout btnMakanan, btnPesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Dashboard");

        btnMakanan = (LinearLayout) findViewById(R.id.menumakanan);
        btnPesan = (LinearLayout) findViewById(R.id.pesanmakanan);

        btnMakanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(MainActivity.this,MenuMakanan.class);
                startActivity(j);
            }
        });

        btnPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(MainActivity.this,MenuPesan.class);
                startActivity(j);
            }
        });
    }
}