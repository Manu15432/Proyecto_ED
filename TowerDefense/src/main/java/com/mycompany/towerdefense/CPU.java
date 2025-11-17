package com.mycompany.towerdefense;

import java.util.Random;

public class CPU extends Entidad {

    public CPU(String nombre, int vidaCastillo) {
        super(nombre, vidaCastillo);
    }

    public void generarTropasAleatorias(int cantTropasJugador) {
        int cantidad = cantTropasJugador - 1;
        if (cantidad < 1) {
            cantidad = 1;
        }

        String[] tiposTropas = { "Arquero", "Caballero", "Mago" };
        Tropa[] tropasCPU = new Tropa[cantidad];
        Random random = new Random();

        for (int i = 0; i < cantidad; i++) {
            String tipo = tiposTropas[random.nextInt(3)];
            tropasCPU[i] = crearTropaPorTipo(tipo);
        }

        setListaTropas(tropasCPU);
        System.out.println("Tropas generadas por la CPU: ");
        for (int i = 0; i < tropasCPU.length; i++) {
            Tropa t = tropasCPU[i];
            System.out.println((i + 1) + ". " + t.getTipo());
        }
    }

    public void asignarCaminosAleatorios() {
        Tropa[] tropas = getListaTropas();
        if (tropas == null || tropas.length == 0) {
            System.out.println("No hay tropas generadas para asignar caminos.");
            return;
        }
        Random random = new Random();
        String[] caminos = { "Izquierdo", "Derecho" };
        int totalTropas = tropas.length;
        int maxPorCamino = (totalTropas * 75 + 99) / 100;
        boolean valido;
        do {
            int contIzquierdo = 0;
            int contDerecho = 0;
            for (int i = 0; i < totalTropas; i++) {
                String caminoAsignado = caminos[random.nextInt(2)];
                tropas[i].setCamino(caminoAsignado);

                if (caminoAsignado.equals("Izquierdo")) {
                    contIzquierdo++;
                } else {
                    contDerecho++;
                }
            }
            valido = contIzquierdo <= maxPorCamino && contDerecho <= maxPorCamino;
            if (!valido) {
                System.out.println("Más del 75% de las tropas asignadas a un mismo camino. Reasignando...");
            }
        } while (!valido);
        for (int i = 0; i < totalTropas; i++) {
            System.out.println(tropas[i].getTipo() + " asignada al camino: " + tropas[i].getCamino());
        }
        System.out.println("Camino asignado a las tropas de la CPU correctamente");
    }

    public void mostrarPrimerasTropas() {
        Tropa[] tropas = getListaTropas();
        System.out.println("\nPrimeras 3 tropas visibles del CPU:");
        for (int i = 0; i < tropas.length; i++) {
            if (i < 3) {
                System.out.println((i + 1) + ". " + tropas[i].getTipo());
            } else {
                System.out.println("----");
            }
        }
    }

    private Tropa crearTropaPorTipo(String tipo) {
        if (tipo.equalsIgnoreCase("Arquero")) {
            return new Arquero("Sin asignar");
        } else if (tipo.equalsIgnoreCase("Mago")) {
            return new Mago("Sin asignar");
        } else if (tipo.equalsIgnoreCase("Caballero")) {
            return new Caballero("Sin asignar");
        } else {
            System.out.println("Tipo de tropa desconocido: " + tipo);
            return null;
        }
    }
}
