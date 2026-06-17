package Parte02;

import Parte01.*;

public abstract class Juego {

    //Atributos del juego

    protected Jugador ganador;

    protected Baraja baraja;

    protected Mesa mesa;

    protected String nombre;

    protected ReglasJuego reglas;

    //Setters

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

    //Muestra el juego

    public void mostrarJuego(){

        System.out.println("En esta mesa se está jugando: " + this.nombre);

        reglas.mostrarReglas();

    }

}
