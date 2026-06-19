package Parte02;

import Parte01.*;

public class Main {

    public static void main(String[] args){

        //creacion de cosas
        CasitaRobada casitaRobada = new CasitaRobada();
        Mesa mesa = new Mesa();
        Baraja baraja = new Baraja();
        //creacion de jugadores
        Jugador maxi = new Jugador("Maxi");
        Jugador xavi = new Jugador("Xavi");

        //ponemos jugadores en la mesa
        mesa.agregarJugador(maxi);
        mesa.agregarJugador(xavi);

        //conectamos todo
        casitaRobada.setMesa(mesa);
        casitaRobada.setBaraja(baraja);

        //arrancamos
        casitaRobada.mostrarJuego();
        System.out.println("Arranca la partidubi");
        casitaRobada.jugar(4);
    }
}
