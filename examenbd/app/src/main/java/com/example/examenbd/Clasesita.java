package com.example.examenbd;

import java.util.ArrayList;

public class Clasesita {

    int clave[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    String puesto[] = {"secretaria", "director", "programador", "capturista", "tester",
            "carpintero", "electricista", "albañil", "azulejos", "pintor"};

    String depto[] = {"programacion", "programacion", "programacion", "programacion", "programacion",
            "conservacion", "conservacion", "conservacion", "conservacion", "conservacion"};

    int sueldo[] = {10000, 50000, 30000, 12000, 15000, 5000, 5000, 5000, 5000, 5000};

    public ArrayList<Empleado> obtenerDatos() {
        ArrayList<Empleado> lista = new ArrayList<>();
        for (int i = 0; i < clave.length; i++) {
            lista.add(new Empleado(clave[i], puesto[i], depto[i], sueldo[i]));
        }
        return lista;
    }
}