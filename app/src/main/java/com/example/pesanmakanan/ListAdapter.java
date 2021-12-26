package com.example.pesanmakanan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ListAdapter extends ArrayAdapter {

//    private int[] Icon;
//    private String[] Headline;
//    private String[] Subhead;

    private String[] Nama;
    private String[] Harga;
    private Context context;

//    ListAdapter(@NonNull Context context, int[] icon, String[] headline, String[] subhead) {
//        super(context, R.layout.custom_listview, headline);
//        this.Icon = icon;
//        this.Headline = headline;
//        this.Subhead = subhead;
//        this.context = context;
//    }

    ListAdapter(@NonNull Context context, String[] nama, String[] harga) {
        super(context, R.layout.list_makanan, nama);
        this.Nama = nama;
        this.Harga = harga;
        this.context = context;
    }

//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        LayoutInflater layoutInflater = (LayoutInflater) context
//                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View view = layoutInflater.inflate(R.layout.custom_listview, null, true);
//        ImageView icon = view.findViewById(R.id.imageList);
//        TextView headline = view.findViewById(R.id.text_headline);
//        TextView subhead = view.findViewById(R.id.text_subhead);
//
//        icon.setImageResource(Icon[position]);
//        headline.setText(Headline[position]);
//        subhead.setText(Subhead[position]);
//        return view;
//    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.list_makanan, null, true);
        TextView nama = view.findViewById(R.id.nama);
        TextView harga = view.findViewById(R.id.harga);

        nama.setText(Nama[position]);
        harga.setText(Harga[position]);
        return view;
    }
}
