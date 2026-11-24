package com.example.examenbdclic;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {

    TableLayout tabla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabla = findViewById(R.id.tabla);
    }

    // Botón 1: guarda y despliega (Figura 1)
    public void desplegar(View v) {
        guardar();
        mostrar("select clave, puesto, depto, sueldo from chalancitos order by clave", false);
    }

    // Botón 2: segundo desplegado con la suma de sueldos
    public void desplegarSuma(View v) {
        guardar();
        mostrar("select clave, puesto, depto, sueldo from chalancitos order by depto, puesto", true);
    }

    // Recibe el ArrayList de Clasesita y lo guarda en la BD "administra"
    private void guardar() {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administra", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        Clasesita c = new Clasesita();
        ArrayList<Empleado> lista = c.obtenerDatos();

        for (Empleado e : lista) {
            bd.execSQL("insert or ignore into chalancitos values(" + e.clave + ",'"
                    + e.puesto + "','" + e.depto + "'," + e.sueldo + ")");
        }
        bd.close();
    }

    // Lee la tabla y llena el TableLayout
    private void mostrar(String sql, boolean conSuma) {
        tabla.removeAllViews();
        agregarFila("Clave", "Puesto", "Depto", "Sueldo");

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administra", null, 1);
        SQLiteDatabase bd = admin.getReadableDatabase();
        Cursor fila = bd.rawQuery(sql, null);

        int suma = 0;
        while (fila.moveToNext()) {
            agregarFila(fila.getString(0), fila.getString(1),
                    fila.getString(2), fila.getString(3));
            suma += fila.getInt(3);
        }
        fila.close();
        bd.close();

        if (conSuma) {
            agregarFila("", "Total", "", String.valueOf(suma));
        }
    }

    // Crea un renglón con 4 TextView (igual que en tu ejemplo)
    private void agregarFila(String a, String b, String c, String d) {
        TableRow fila = new TableRow(this);
        TextView txt1 = new TextView(this);
        TextView txt2 = new TextView(this);
        TextView txt3 = new TextView(this);
        TextView txt4 = new TextView(this);

        txt3.setOnClickListener(this);   // ← la columna depto escucha el clic

        txt1.setText(a);
        txt2.setText(b);
        txt3.setText(c);
        txt4.setText(d);

        txt1.setPadding(10, 5, 10, 5);
        txt2.setPadding(10, 5, 10, 5);
        txt3.setPadding(10, 5, 10, 5);
        txt4.setPadding(10, 5, 10, 5);

        fila.addView(txt1);
        fila.addView(txt2);
        fila.addView(txt3);
        fila.addView(txt4);

        tabla.addView(fila);
    }

    // Se ejecuta al picar un depto: lo muestra abajo con un Toast
    @Override
    public void onClick(View v) {
        TextView seleccionado = (TextView) v;

        Toast.makeText(this,
                seleccionado.getText(),
                Toast.LENGTH_SHORT).show();
    }
}