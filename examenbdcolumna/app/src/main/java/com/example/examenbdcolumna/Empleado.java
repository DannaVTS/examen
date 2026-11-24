package com.example.examenbdcolumna;

public class Empleado {
    int clave;
    String turno;
    String puesto;
    String depto;
    int sueldo;

    public Empleado(int clave, String turno, String puesto, String depto, int sueldo) {
        this.clave = clave;
        this.turno = turno;
        this.puesto = puesto;
        this.depto = depto;
        this.sueldo = sueldo;
    }
}