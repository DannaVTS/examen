package com.example.ver1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemClickListener {

    String titulos[] = {"Tabla de empleados", "Agregar registros", "Altas, bajas y cambios"};
    String comentarios[] = {"Muestra un TableLayout",
            "Inserta 10 empleados en la base", "CRUD de la tabla cinito"};
    int imagenes[] = {R.drawable.carreras, R.drawable.correr, R.drawable.fucho};

    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = findViewById(R.id.vistitas);
        listview.setOnItemClickListener(this);

        Adaptador adaptadorcito = new Adaptador(getApplicationContext(),
                titulos, comentarios, imagenes);
        listview.setAdapter(adaptadorcito);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view,
                            int position, long id) {
        Intent intent;
        if (position == 0) {
            intent = new Intent(this, TablaActivity.class);       // 1° TableLayout
        } else if (position == 1) {
            intent = new Intent(this, AgregarActivity.class);     // 2° baseagregegadinregs
        } else {
            intent = new Intent(this, BasesitaActivity.class);    // 3° basesita
        }
        startActivity(intent);
    }
}