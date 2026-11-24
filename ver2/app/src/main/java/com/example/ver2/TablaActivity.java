package com.example.ver2;

import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class TablaActivity extends AppCompatActivity
        implements View.OnClickListener {

    TableLayout visita;
    int clave[] = {1,2,3,4,5,6,7,8,9,10};
    String puesto[] = {"secretaria", "director", "programador", "capturista", "tester",
            "carpintero", "electricista", "albañil", "azulejos", "pintor"};
    String depto[] = {"programacion", "programacion", "programacion", "programacion", "programacion",
            "conservacion", "conservacion", "conservacion", "conservacion", "conservacion"};
    int sueldo[] = {10000,50000,30000,12000,15000,5000,5000,5000,5000,5000};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabla);

        visita = findViewById(R.id.tablita);

        for (int i = 0; i < 10; i++) {
            TableRow fila = new TableRow(this);
            TextView txt1 = new TextView(this);
            TextView txt2 = new TextView(this);
            TextView txt3 = new TextView(this);
            TextView txt4 = new TextView(this);

            txt3.setOnClickListener(this);
            txt1.setText(String.valueOf(clave[i]));
            txt2.setText(puesto[i]);
            txt3.setText(depto[i]);
            txt4.setText(String.valueOf(sueldo[i]));

            fila.addView(txt1);
            fila.addView(txt2);
            fila.addView(txt3);
            fila.addView(txt4);

            visita.addView(fila);
        }
    }

    @Override
    public void onClick(View v) {
        TextView visitiaaa = (TextView) v;
        Toast.makeText(this, visitiaaa.getText(), Toast.LENGTH_SHORT).show();
    }
}