package com.example.ver1;

import java.util.ArrayList;

public class Clasesita {
    ArrayList<Datitos> ALempleaditos;

    public Clasesita() { this.ALempleaditos = new ArrayList<>(); }

    public void agregar() {
        int clave[] = {1,2,3,4,5,6,7,8,9,10};
        String puesto[] = {"secretaria", "director", "programador", "capturista", "tester",
                "carpintero","electricista","albañil","azulejos","pintor"};
        String depto[] = {"programacion","programacion","programacion","programacion","programacion",
                "conservacion","conservacion","conservacion","conservacion","conservacion"};
        int sueldo[] = {10000,50000,30000,12000,15000,5000,5000,5000,5000,5000};

        for (int i = 0; i < 10; ++i) {
            Datitos objetito = new Datitos();
            objetito.setClave(clave[i]);
            objetito.setPuesto(puesto[i]);
            objetito.setDepto(depto[i]);
            objetito.setSueldo(sueldo[i]);
            ALempleaditos.add(objetito);
        }
    }

    public ArrayList<Datitos> regresar() { return ALempleaditos; }
}