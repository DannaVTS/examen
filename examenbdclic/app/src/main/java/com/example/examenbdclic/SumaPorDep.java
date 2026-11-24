package com.example.examenbdclic;

public class SumaPorDep {

    /*

    Opción 1: solo cambia el botón pero la tabla no la muestra completa

    public void desplegarSuma(View v) {
    guardar();
    mostrar("select '', '', depto, sum(sueldo) from chalancitos group by depto", true);
    }

    Opción 2: tabla completa con un subtotal por depto

    int sumaProg = 0, sumaCons = 0;
    while (fila.moveToNext()) {
        agregarFila(fila.getString(0), fila.getString(1),
                fila.getString(2), fila.getString(3));

        if (fila.getString(2).equals("programacion")) {
            sumaProg += fila.getInt(3);
        } else {
            sumaCons += fila.getInt(3);
        }
    }
    fila.close();
    bd.close();

    if (conSuma) {
        agregarFila("", "Total programacion", "", String.valueOf(sumaProg));
        agregarFila("", "Total conservacion", "", String.valueOf(sumaCons));
    }

    */

}
