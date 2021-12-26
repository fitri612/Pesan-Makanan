package com.example.pesanmakanan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MenuMakanan extends AppCompatActivity {

    ListView lv;
    String[] Nama = {"Nasi Goreng", "Mie Goreng", "Mie Rebus", "Soto",
            "Sate Ayam", "Sate Kambing", "Lontong", "Bakso", "Mie Ayam", "Ayam Bakar"
    };

    String[] Harga = {"Rp 10.000", "Rp 10.000", "Rp 12.000", "Rp 8.000",
            "Rp 13.000", "Rp 17.000", "Rp 8.000", "Rp 12.000", "Rp 14.000", "Rp 15.000"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_makanan);
        this.setTitle("Menu Makanan");
        lv = findViewById(R.id.listmakanan);
        ListAdapter listAdapter = new ListAdapter(this,Nama, Harga);
        lv.setAdapter(listAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),
                        "Menu " + Nama[position]+ " Dengan Harga " +Harga[position],
                        Toast.LENGTH_SHORT).show();

            }
        });

    }


}