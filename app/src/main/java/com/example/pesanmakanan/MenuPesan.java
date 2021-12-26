package com.example.pesanmakanan;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;

public class MenuPesan extends AppCompatActivity {

    private int antrian = 0, harga=0, total=0;
    private Spinner spnMenu;
    private TextView txtAntrian;
    private Button btnSimpan;
    private EditText edtNama,edtJumlah;
    private String nm_makanan;

    public String[] Makanan = {"Pilih Makanan","Nasi Goreng (Rp 10.000)", "Mie Goreng (Rp 10.000)", "Mie Rebus (Rp 12.000)", "Soto (Rp 8.000)",
            "Sate Ayam (Rp 13.000)", "Sate Kambing (Rp 17.000)", "Lontong (Rp 8.000)", "Bakso (Rp 12.000)", "Mie Ayam (Rp 14.000)","Ayam Bakar (Rp 15.000)"
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_pesan);
        this.setTitle("Menu Pesan Makanan");
        txtAntrian=(TextView) findViewById(R.id.antrian);
        btnSimpan=(Button) findViewById(R.id.pesan);

        spnMenu = (Spinner) findViewById(R.id.spmmenu);
        edtNama = (EditText) findViewById(R.id.edtnama);
        edtJumlah = (EditText) findViewById(R.id.edtjumlah);

        ArrayAdapter adapter = new ArrayAdapter(MenuPesan.this,R.layout.support_simple_spinner_dropdown_item,Makanan);
        spnMenu.setAdapter(adapter);
        txtAntrian.setText(Integer.toString(antrian));


        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPesan();
            }
        });
    }

    private void getPesan() {

        if(spnMenu.getSelectedItem().toString().equalsIgnoreCase("Pilih Makanan")){
            Toast.makeText(getApplicationContext(), "Mohon pilih makanan",Toast.LENGTH_SHORT).show();
        }
        else if(edtNama.getText().toString().isEmpty()){
            edtNama.setError("Tidak Boleh Kosong");
            edtNama.requestFocus();
        }
        else if(edtJumlah.getText().toString().isEmpty()){
            edtJumlah.setError("Tidak Boleh Kosong");
            edtJumlah.requestFocus();
        }
        else{
            OpenAlertDialog();

        }


    }

    private void OpenAlertDialog() {
        String no_antri = txtAntrian.getText().toString();
        String nama = edtNama.getText().toString();
        String makanan = spnMenu.getSelectedItem().toString();
        nm_makanan = "";

        if(spnMenu.getSelectedItem().toString().equalsIgnoreCase("Nasi Goreng (Rp 10.000)")){
            harga=10000;
            nm_makanan="Nasi Goreng";
        }
        if(spnMenu.getSelectedItem().toString().equalsIgnoreCase("Mie Goreng (Rp 10.000)")){
            harga=10000;
            nm_makanan="Mie Goreng";
        }
        if(spnMenu.getSelectedItem().toString().equalsIgnoreCase("Mie Rebus (Rp 12.000)")){
            harga=12000;
            nm_makanan="Mie Rebus";
        }
        if(spnMenu.getSelectedItem().toString().equalsIgnoreCase("Soto (Rp 8.000)")){
            harga=8000;
            nm_makanan="Soto";
        }
        if(spnMenu.getSelectedItem().toString().equalsIgnoreCase("Sate Ayam (Rp 13.000)")){
            harga=13000;
            nm_makanan="Sate Ayam";
        }
        if(spnMenu.getSelectedItem().toString().equalsIgnoreCase("Sate Kambing (Rp 17.000)")){
            harga=17000;
            nm_makanan="Sate Kambing";
        }
        if(spnMenu.getSelectedItem().toString().equalsIgnoreCase("Lontong (Rp 8.000)")){
            harga=8000;
            nm_makanan="Lontong";
        }
        if(spnMenu.getSelectedItem().toString().equalsIgnoreCase("Bakso (Rp 12.000)")){
            harga=12000;
            nm_makanan="Bakso";
        }
        if(spnMenu.getSelectedItem().toString().equalsIgnoreCase("Mie Ayam (Rp 14.000)")){
            harga=14000;
            nm_makanan="Mie Ayam";
        }
        if(spnMenu.getSelectedItem().toString().equalsIgnoreCase("Ayam Bakar (Rp 15.000)")){
            harga=15000;
            nm_makanan="Ayam Bakar";
        }




        String jlh = edtJumlah.getText().toString();
        int jumlah = Integer.parseInt(edtJumlah.getText().toString());
        total = jumlah * harga;

        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        String hrg = formatRupiah.format((double) harga);
        String t = formatRupiah.format((double) total);




        new AlertDialog.Builder(this)
                .setTitle("Hasil Pesan")
                .setMessage("Nomor Antrian : "+no_antri+
                        "\nNama : "+nama+
                        "\nMakanan : "+nm_makanan+
                        "\nHarga : "+hrg+
                        "\nJumlah Pesan : "+jlh+
                        "\nTotal Bayar : "+t)
                .setCancelable(false)
                .setPositiveButton("Oke", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        antrian = antrian +1;
                        txtAntrian.setText(Integer.toString(antrian));
                        edtNama.setText("");
                        edtJumlah.setText("");
                        spnMenu.setSelection(0);
                        Toast.makeText(getApplicationContext(), "Berhasil Memesan",Toast.LENGTH_SHORT).show();
                    }
                })
                .setNeutralButton("Batal",null)
                .setNegativeButton("", null)
                .show();
    }
}