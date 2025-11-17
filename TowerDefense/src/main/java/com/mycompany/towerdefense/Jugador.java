package com.mycompany.towerdefense;

public class Jugador extends Entidad {

    public Jugador(String nombre, int vidaCastillo) {
        super(nombre, vidaCastillo);
    }

    public void seleccionarTropas(String[] opciones, int numRonda) {
        int formula = numRonda + 1;

        if (opciones.length > formula) {
            System.out.println("Cantidad de tropas seleccionadas excede el límite permitido por ronda.");
            System.out.println("Solo se tomarán en cuanta las primeras " + formula + " tropas.");
        }

        int cantidadFinal = opciones.length;
        if (formula < cantidadFinal) {
            cantidadFinal = formula;
        }
        Tropa[] tropasSeleccionadas = new Tropa[cantidadFinal];

        for (int i = 0; i < cantidadFinal; i++) {
            String tipo = opciones[i];
            Tropa tropa = crearTropaPorTipo(tipo);
            tropasSeleccionadas[i] = tropa;
        }

        setListaTropas(tropasSeleccionadas);

        System.out.println("\nTropas seleccionadas por el jugador:");
        for (int i = 0; i < tropasSeleccionadas.length; i++) {
            Tropa t = tropasSeleccionadas[i];
            System.out.println((i + 1) + ". " + t.getTipo());
        }
    }

    public void asignarCamino(String caminoEscogido) {
        Tropa[] tropas = getListaTropas();
        if (tropas == null || tropas.length == 0) {
            System.out.println("No hay tropas seleccionadas para asignar camino.");
            return;
        }

        for (int i = 0; i < tropas.length; i++) {
            tropas[i].setCamino(caminoEscogido);
        }

        System.out.println("Camino asignado a las tropas del jugador: " + caminoEscogido);
    }

    private Tropa crearTropaPorTipo(String tipo) {
        if (tipo.equalsIgnoreCase("Arquero")) {
            return new Arquero("derecha");
        } else if (tipo.equalsIgnoreCase("Mago")) {
            return new Mago("derecha");
        } else if (tipo.equalsIgnoreCase("Caballero")) {
            return new Caballero("derecha");
        } else {
            System.out.println("Tipo de tropa desconocido: " + tipo);
            return null;
        }
    }

}
