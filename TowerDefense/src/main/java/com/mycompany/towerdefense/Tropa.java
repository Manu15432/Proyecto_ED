package com.mycompany.towerdefense;

public class Tropa {
    private String tipo;
    private String fortaleza;
    private String debilidad;
    private double danio;
    private double vida;
    private String camino;
    private int posicion;

    public Tropa(String tipo, String fortaleza, String debilidad, double danio, double vida, String camino) {
        this.tipo = tipo;
        this.fortaleza = fortaleza;
        this.debilidad = debilidad;
        this.danio = danio;
        this.vida = vida;
        this.camino = camino;
        this.posicion = 0;
        
    }

    public double calcularDanioContra(Tropa enemigo) {
        double danioFinal = danio;

        if (enemigo.getTipo().equalsIgnoreCase(fortaleza)) {
            danioFinal *= 1.5;
            System.out.println(tipo + " tiene ventaja sobre " + enemigo.getTipo());
        } else if (enemigo.getTipo().equalsIgnoreCase(debilidad)) {
            danioFinal *= 0.5; 
            System.out.println(tipo + " tiene desventaja contra " + enemigo.getTipo());
        } else {
            System.out.println(tipo + " ataca sin ventaja ni desventaja contra " + enemigo.getTipo());
        }

        return danioFinal;
    }

    public void avanzar() {
        if (posicion < 2){
            posicion++;
        }
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFortaleza() {
        return fortaleza;
    }

    public void setFortaleza(String fortaleza) {
        this.fortaleza = fortaleza;
    }

    public String getDebilidad() {
        return debilidad;
    }

    public void setDebilidad(String debilidad) {
        this.debilidad = debilidad;
    }

    public double getDanio() {
        return danio;
    }

    public void setDanio(double danio) {
        this.danio = danio;
    }

    public double getVida() {
        return vida;
    }

    public void setVida(double vida) {
        this.vida = vida;
    }

    public String getCamino() {
        return camino;
    }

    public void setCamino(String camino) {
        this.camino = camino;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    

}
