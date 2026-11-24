package com.example.ver1;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class AgregarActivity extends AppCompatActivity
        implements View.OnClickListener {

    ArrayList<Datitos> Alistito = new ArrayList<>();
    Button botoncito;
    Clasesita oclas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);
        oclas = new Clasesita();

        botoncito = findViewById(R.id.boton);
        botoncito.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        oclas.agregar();
        Alistito = oclas.regresar();

        Basesita admin = new Basesita(this, "administra", null, 1);
        SQLiteDatabase basesita = admin.getWritableDatabase();

        for (int i = 0; i < Alistito.size(); ++i) {
            int clavesita = Alistito.get(i).getClave();
            String puestito = Alistito.get(i).getPuesto();
            String deptito = Alistito.get(i).getDepto();
            int sueldito = Alistito.get(i).getSueldo();

            ContentValues registro = new ContentValues();
            registro.put("clave", clavesita);
            registro.put("puesto", puestito);
            registro.put("depto", deptito);
            registro.put("sueldo", sueldito);
            basesita.insert("empleaditos", null, registro);
        }
        basesita.close();
        Toast.makeText(this, "son " + Alistito.size(),
                Toast.LENGTH_SHORT).show();
    }
}