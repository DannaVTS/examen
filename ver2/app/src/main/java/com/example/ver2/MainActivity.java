package com.example.ver2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menusito, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.tablita) {
            startActivity(new Intent(this, TablaActivity.class));       // 1° TableLayout
        } else if (id == R.id.agregadita) {
            startActivity(new Intent(this, AgregarActivity.class));     // 2° baseagregegadinregs
        } else if (id == R.id.crudcito) {
            startActivity(new Intent(this, BasesitaActivity.class));    // 3° basesita
        }

        return super.onOptionsItemSelected(item);
    }
}