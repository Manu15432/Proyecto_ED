package com.mycompany.towerdefense;

public class Entidad {
    private String nombre;
    private int vidaCastillo;
    private Tropa[] listaTropas;

    public Entidad(String nombre, int vidaCastillo) {
        this.nombre = nombre;
        this.vidaCastillo = vidaCastillo;
        this.listaTropas = null;
    }

    public void enviarTropas() {
        System.out.println("Enviando tropas...");
        for (int i = 0; i < listaTropas.length; i++) {
            if (listaTropas[i] != null) {
                System.out.println(listaTropas[i].getTipo());
            }
        }
    }

    public void recibirDanio(int danio) {
        vidaCastillo -= danio;
        if (vidaCastillo < 0) {
            vidaCastillo = 0;
        }

        System.out.println(nombre + " ha recibido " + danio + " de daño. Vida restante del castillo: " + vidaCastillo);
    }

    public void enviarTropasACamino(ColaTropas camino, String nombreCamino) {
        if (getListaTropas() == null || getListaTropas().length == 0) {
            System.out.println(getNombre() + " no tiene tropas para enviar al camino " + nombreCamino);
            return;
        }

        System.out.println("\n" + getNombre() + " envía sus tropas al camino " + nombreCamino + ":");
        for (int i = 0; i < getListaTropas().length; i++) {
            Tropa t = getListaTropas()[i];
            if (t.getCamino().equalsIgnoreCase(nombreCamino)) {
                camino.encolar(t);
                System.out.println((i + 1) + "." + t.getTipo());
            }
        }
    }

    public boolean castilloTieneVida() {
        return vidaCastillo > 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVidaCastillo() {
        return vidaCastillo;
    }

    public void setVidaCastillo(int vidaCastillo) {
        this.vidaCastillo = vidaCastillo;
    }

    public Tropa[] getListaTropas() {
        return listaTropas;
    }

    public void setListaTropas(Tropa[] listaTropas) {
        this.listaTropas = listaTropas;
    }

}
