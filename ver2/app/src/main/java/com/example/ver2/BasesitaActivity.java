package com.example.ver2;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class BasesitaActivity extends AppCompatActivity
        implements View.OnClickListener {

    EditText etcodigo, etdescripcion, etprecio;
    Button botoncitoa, botoncitob, botoncitoc, botoncitoco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basesita);

        etcodigo = findViewById(R.id.ecodigo);
        etdescripcion = findViewById(R.id.edescripcion);
        etprecio = findViewById(R.id.eprecio);

        botoncitoa = findViewById(R.id.altas);
        botoncitob = findViewById(R.id.bajas);
        botoncitoc = findViewById(R.id.cambios);
        botoncitoco = findViewById(R.id.consultas);

        botoncitoa.setOnClickListener(this);
        botoncitob.setOnClickListener(this);
        botoncitoc.setOnClickListener(this);
        botoncitoco.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String cadenita = ((Button) v).getText().toString();

        // ---------- ALTAS ----------
        if (cadenita.equals("altas"))
            ayuditaa();
        else if (cadenita.equals("agregar")) {
            Base admin = new Base(this, "administracion", null, 1);
            SQLiteDatabase basesita = admin.getWritableDatabase();
            int llavesita = Integer.parseInt(etcodigo.getText().toString());
            String titulito = etdescripcion.getText().toString();
            int costito = Integer.parseInt(etprecio.getText().toString());
            ContentValues registro = new ContentValues();
            registro.put("clave", llavesita);
            registro.put("descripcion", titulito);
            registro.put("precio", costito);
            basesita.insert("cinito", null, registro);
            ayuditaab();
        }

        // ---------- CONSULTAS ----------
        else if (cadenita.equals("consultas"))
            consu();
        else if (cadenita.equals("buscar")) {
            Base admin = new Base(this, "administracion", null, 1);
            SQLiteDatabase basededatos = admin.getReadableDatabase();
            String codigo = etcodigo.getText().toString();
            Cursor fila = basededatos.rawQuery(
                    "select descripcion, precio from cinito where clave = " + codigo, null);
            if (fila.moveToFirst()) {
                etcodigo.setEnabled(false);
                etdescripcion.setText(fila.getString(0));
                etprecio.setText(fila.getString(1));
            } else {
                Toast.makeText(this, "no existe el registro", Toast.LENGTH_LONG).show();
            }
            botoncitoco.setText("restaurar");
        }
        else if (cadenita.equals("restaurar"))
            restaura();

            // ---------- BAJAS ----------
        else if (cadenita.equals("bajas"))
            limpiabajas();
        else if (cadenita.equals("encontrar")) {
            Base admin = new Base(this, "administracion", null, 1);
            SQLiteDatabase basededatos = admin.getReadableDatabase();
            String codiguito = etcodigo.getText().toString();
            Cursor fila = basededatos.rawQuery(
                    "select descripcion, precio from cinito where clave = " + codiguito, null);
            if (fila.moveToFirst()) {
                etdescripcion.setText(fila.getString(0));
                etprecio.setText(fila.getString(1));

                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
                dialogo1.setTitle("importante");
                dialogo1.setMessage("deseas eliminar ?");
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogo1, int id) {
                        Base admin = new Base(getApplicationContext(), "administracion", null, 1);
                        SQLiteDatabase basededatos = admin.getWritableDatabase();
                        basededatos.delete("cinito", "clave=" + etcodigo.getText().toString(), null);
                        Toast.makeText(getApplicationContext(), "se elimino", Toast.LENGTH_SHORT).show();
                        limpiabajas2();
                    }
                });
                dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogo1, int id) {
                        Toast.makeText(getApplicationContext(), "no se elimina", Toast.LENGTH_LONG).show();
                        limpiabajas2();
                    }
                });
                dialogo1.show();
            } else {
                Toast.makeText(this, "no existe el registro", Toast.LENGTH_SHORT).show();
                limpiabajas2();
            }
        }

        // ---------- CAMBIOS ----------
        else if (cadenita.equals("cambios"))
            ayudacambios();
        else if (cadenita.equals("localizar")) {
            Base admin = new Base(this, "administracion", null, 1);
            SQLiteDatabase basededatos = admin.getReadableDatabase();
            String codiguito = etcodigo.getText().toString();
            Cursor fila = basededatos.rawQuery(
                    "select descripcion, precio from cinito where clave = " + codiguito, null);
            if (fila.moveToFirst()) {
                etdescripcion.setText(fila.getString(0));
                etprecio.setText(fila.getString(1));
                etcodigo.setEnabled(false);
                etdescripcion.setEnabled(true);
                etprecio.setEnabled(true);
                botoncitoc.setText("modificar");
            } else {
                Toast.makeText(this, "no existe el registro", Toast.LENGTH_LONG).show();
                limpiacambios();
            }
        }
        else if (cadenita.equals("modificar")) {
            Base admin = new Base(this, "administracion", null, 1);
            SQLiteDatabase basededatos = admin.getWritableDatabase();
            ContentValues registro = new ContentValues();
            registro.put("descripcion", etdescripcion.getText().toString());
            registro.put("precio", Integer.parseInt(etprecio.getText().toString()));
            basededatos.update("cinito", registro, "clave=" + etcodigo.getText().toString(), null);
            Toast.makeText(this, "se modifico", Toast.LENGTH_SHORT).show();
            limpiacambios();
        }
    }

    // ---------- MÉTODOS DE AYUDA ----------
    private void ayuditaa() {
        etcodigo.setEnabled(true);
        etdescripcion.setEnabled(true);
        etprecio.setEnabled(true);
        botoncitob.setEnabled(false);
        botoncitoc.setEnabled(false);
        botoncitoco.setEnabled(false);
        botoncitoa.setText("agregar");
    }

    private void ayuditaab() {
        etcodigo.setText("");
        etdescripcion.setText("");
        etprecio.setText("");
        etcodigo.setEnabled(false);
        etdescripcion.setEnabled(false);
        etprecio.setEnabled(false);
        botoncitob.setEnabled(true);
        botoncitoc.setEnabled(true);
        botoncitoco.setEnabled(true);
        botoncitoa.setText("altas");
        Toast.makeText(this, "agregado", Toast.LENGTH_SHORT).show();
    }

    private void consu() {
        botoncitoa.setEnabled(false);
        botoncitob.setEnabled(false);
        botoncitoc.setEnabled(false);
        etcodigo.setEnabled(true);
        etcodigo.requestFocus();
        botoncitoco.setText("buscar");
    }

    private void restaura() {
        etcodigo.setText("");
        etdescripcion.setText("");
        etprecio.setText("");
        etcodigo.setEnabled(false);
        etdescripcion.setEnabled(false);
        etprecio.setEnabled(false);
        botoncitoa.setEnabled(true);
        botoncitob.setEnabled(true);
        botoncitoc.setEnabled(true);
        botoncitoco.setText("consultas");
    }

    private void limpiabajas() {
        botoncitoa.setEnabled(false);
        botoncitoc.setEnabled(false);
        botoncitoco.setEnabled(false);
        etcodigo.setEnabled(true);
        etcodigo.requestFocus();
        botoncitob.setText("encontrar");
    }

    private void limpiabajas2() {
        etcodigo.setText("");
        etdescripcion.setText("");
        etprecio.setText("");
        etcodigo.setEnabled(false);
        botoncitoa.setEnabled(true);
        botoncitoc.setEnabled(true);
        botoncitoco.setEnabled(true);
        botoncitob.setText("bajas");
    }

    private void ayudacambios() {
        botoncitoa.setEnabled(false);
        botoncitob.setEnabled(false);
        botoncitoco.setEnabled(false);
        etcodigo.setEnabled(true);
        etcodigo.requestFocus();
        botoncitoc.setText("localizar");
    }

    private void limpiacambios() {
        etcodigo.setText("");
        etdescripcion.setText("");
        etprecio.setText("");
        etcodigo.setEnabled(false);
        etdescripcion.setEnabled(false);
        etprecio.setEnabled(false);
        botoncitoa.setEnabled(true);
        botoncitob.setEnabled(true);
        botoncitoco.setEnabled(true);
        botoncitoc.setText("cambios");
    }
}