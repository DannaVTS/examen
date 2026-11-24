package com.example.examenbd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

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
            // "or ignore" evita que truene si picas el botón dos veces (clave repetida)
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
            agregarFila("", "", "Total", String.valueOf(suma));
        }
    }

    // Crea un TableRow con 4 TextView
    private void agregarFila(String a, String b, String c, String d) {
        TableRow renglon = new TableRow(this);
        String datos[] = {a, b, c, d};
        for (String t : datos) {
            TextView tv = new TextView(this);
            tv.setText(t);
            tv.setPadding(10, 5, 10, 5);
            renglon.addView(tv);
        }
        tabla.addView(renglon);
    }
}