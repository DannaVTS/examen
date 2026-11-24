package com.example.examenbd;

public class Empleado {
    int clave;
    String puesto;
    String depto;
    int sueldo;

    public Empleado(int clave, String puesto, String depto, int sueldo) {
        this.clave = clave;
        this.puesto = puesto;
        this.depto = depto;
        this.sueldo = sueldo;
    }
}