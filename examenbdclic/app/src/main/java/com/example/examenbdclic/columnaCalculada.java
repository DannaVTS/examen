package com.example.examenbdclic;

public class columnaCalculada {

    /*

    private void agregarFila(String a, String b, String c, String d, String e) {
        TableRow fila = new TableRow(this);
        TextView txt1 = new TextView(this);
        TextView txt2 = new TextView(this);
        TextView txt3 = new TextView(this);
        TextView txt4 = new TextView(this);
        TextView txt5 = new TextView(this);

        txt3.setOnClickListener(this);

        txt1.setText(a);
        txt2.setText(b);
        txt3.setText(c);
        txt4.setText(d);
        txt5.setText(e);

        txt1.setPadding(10, 5, 10, 5);
        txt2.setPadding(10, 5, 10, 5);
        txt3.setPadding(10, 5, 10, 5);
        txt4.setPadding(10, 5, 10, 5);
        txt5.setPadding(10, 5, 10, 5);

        fila.addView(txt1);
        fila.addView(txt2);
        fila.addView(txt3);
        fila.addView(txt4);
        fila.addView(txt5);

        tabla.addView(fila);
    }

    private void mostrar(String sql, boolean conSuma) {
    tabla.removeAllViews();
    agregarFila("Clave", "Puesto", "Depto", "Sueldo", "Aumento");   // 5 encabezados

    AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administra", null, 1);
    SQLiteDatabase bd = admin.getReadableDatabase();
    Cursor fila = bd.rawQuery(sql, null);

    int suma = 0;
    while (fila.moveToNext()) {
        int sueldo = fila.getInt(3);
        int aumento = sueldo + (sueldo * 10 / 100);                 // LA OPERACION

        agregarFila(fila.getString(0), fila.getString(1),
                fila.getString(2), fila.getString(3),
                String.valueOf(aumento));                           // 5to dato
        suma += sueldo;
    }
    fila.close();
    bd.close();

    if (conSuma) {
        agregarFila("", "Total", "", String.valueOf(suma), "");     // 5 datos
    }
}


    OTRAS OPERACIONES

    Lo que pida	             L&iacute;nea
    Aumento del 10%	         int calc = sueldo + (sueldo * 10 / 100);
    Descuento del 16%	     int calc = sueldo - (sueldo * 16 / 100);
    Solo el impuesto (16%)	 int calc = sueldo * 16 / 100;
    Sueldo anual	         int calc = sueldo * 12;
    Sueldo quincenal	     int calc = sueldo / 2;
    Sueldo diario	         int calc = sueldo / 30;

    */

}
