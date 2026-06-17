package Parte02;

import Parte01.*;

public abstract class Juego {

    protected Jugador ganador;

    protected Baraja baraja;

    protected Mesa mesa;

    protected String nombre;

    protected ReglasJuego reglas;

    public void setGanador(Jugador ganador) {
        this.ganador = ganador;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setReglas(ReglasJuego reglas) {
        this.reglas = reglas;
    }

    public void setBaraja(Baraja baraja) {
        this.baraja = baraja;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public void mostrarJuego(String nombre, ReglasJuego reglas){

        System.out.println("En esta mesa se está jugando: " + this.nombre);

        reglas.mostrarReglas();

    }

}
