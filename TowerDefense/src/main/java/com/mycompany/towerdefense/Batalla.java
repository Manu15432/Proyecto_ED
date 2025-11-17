package com.mycompany.towerdefense;

public class Batalla {

    public void iniciarBatalla(String nombreCamino, ColaTropas tropasJugador, ColaTropas tropasCPU) {
        System.out.println("\n--- Inicio de batalla ---  por ahora en el camino: " + nombreCamino);

        while (!tropasJugador.estaVacia() && !tropasCPU.estaVacia()) {
            Tropa tJugador = tropasJugador.verFrente();
            Tropa tCPU = tropasCPU.verFrente();

            System.out.println("\n" + tJugador.getTipo() + " (Jugador) VS " + tCPU.getTipo() + " (CPU)");

            double danioJugador = tJugador.calcularDanioContra(tCPU);
            double danioCPU = tCPU.calcularDanioContra(tJugador);

            tCPU.setVida(tCPU.getVida() - danioJugador);
            tJugador.setVida(tJugador.getVida() - danioCPU);

            System.out.println("Daño del jugador: " + danioJugador);
            System.out.println("Daño del CPU: " + danioCPU);
            System.out.println("Vida restante de la tropa del jugador: " + tJugador.getVida());
            System.out.println("Vida restante de la tropa del CPU: " + tCPU.getVida());

            if (tJugador.getVida() <= 0) {
                System.out.println("Tropa del jugador eliminada");
                tropasJugador.desencolar();
            }
            if (tCPU.getVida() <= 0) {
                System.out.println("Tropa del CPU eliminada");
                tropasCPU.desencolar();
            }
        }

        if (tropasJugador.estaVacia() && tropasCPU.estaVacia()) {
            System.out.println("Camino vacio");
        } else if (!tropasJugador.estaVacia()) {
            System.out.println("\nEl jugador logro avanzar hacia el castillo enemigo");
        } else {
            System.out.println("\nEl CPU logro avanzar hacia el castillo del jugador");
        }
    }
}
