package com.example.ver1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Adaptador extends BaseAdapter {
    Context contexto;
    String listatitulos[];
    String listacomentar[];
    int listaimagenes[];
    LayoutInflater inflater;

    public Adaptador(Context contexto, String[] listatitulos,
                     String[] listacomentar, int[] listaimagenes) {
        this.contexto = contexto;
        this.listatitulos = listatitulos;
        this.listacomentar = listacomentar;
        this.listaimagenes = listaimagenes;
        this.inflater = LayoutInflater.from(contexto);
    }

    @Override
    public int getCount() { return listatitulos.length; }

    @Override
    public Object getItem(int position) { return null; }

    @Override
    public long getItemId(int position) { return 0; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.basurita, null);
        TextView txtview = convertView.findViewById(R.id.textview);
        TextView txtview2 = convertView.findViewById(R.id.textview2);
        ImageView img = convertView.findViewById(R.id.imageicon);

        txtview.setText(listatitulos[position]);
        txtview2.setText(listacomentar[position]);
        img.setImageResource(listaimagenes[position]);
        return convertView;
    }
}