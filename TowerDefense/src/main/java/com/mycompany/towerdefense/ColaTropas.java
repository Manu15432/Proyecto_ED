package com.mycompany.towerdefense;

public class ColaTropas {

    //------------------------------------------------------------------------------------------------------

    // ESTA CLASE SOLO SIRVE PARA MOSTRAR LO DE EL AVANCE 1, NO HAY QUE USARLA PARA LOS SIQUIENTES AVANCES

    //------------------------------------------------------------------------------------------------------


    private Tropa[] casillas;
    private int frente;
    private int fin;
    private int tamaño;

    public ColaTropas(int capacidad) {
        casillas = new Tropa[capacidad];
        frente = 0;
        fin = -1;
        tamaño = 0;
    }

    public boolean estaVacia() {
        return tamaño == 0;
    }

    public boolean estaLlena() {
        return tamaño == casillas.length;
    }

    public void encolar(Tropa tropa) {
        if (estaLlena()) {
            System.out.println("Camino lleno. No se puede agregar más tropas.");
            return;
        }
        fin++;
        if (fin == casillas.length) {
            fin = 0;
        }
        casillas[fin] = tropa;
        tamaño++;
    }

    public Tropa desencolar() {
        if (estaVacia()) {
            return null;
        }
        Tropa temp = casillas[frente];
        frente++;

        if (frente == casillas.length) {
            frente = 0;
        }

        tamaño--;
        return temp;
    }

    public Tropa verFrente() {
        if (estaVacia()) {
            return null;
        } else {
            return casillas[frente];
        }
    }

    public Tropa[] getCasillas() {
        return casillas;
    }

    public void setCasillas(Tropa[] casillas) {
        this.casillas = casillas;
    }

    public int getFrente() {
        return frente;
    }

    public void setFrente(int frente) {
        this.frente = frente;
    }

    public int getFin() {
        return fin;
    }

    public void setFin(int fin) {
        this.fin = fin;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

}
