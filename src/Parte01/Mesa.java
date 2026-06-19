package Parte01;

import Parte02.*;

import java.util.ArrayList;

public class Mesa {
    private ArrayList<Jugador> listaJugadores;
    private ArrayList<Cartas> cartasEnSuelo;
    public Mesa() {
        this.listaJugadores = new ArrayList<>();
        this.cartasEnSuelo = new ArrayList<>();}
    public ArrayList<Jugador> getListaJugadores() {return listaJugadores;}
    public ArrayList<Cartas> getCartasEnSuelo() {return this.cartasEnSuelo;}

    public void agregarJugador(Jugador jugador) {
        this.listaJugadores.add(jugador);
    }
    public void devolverCartasABaraja(Baraja barajaDelJuego) {
        System.out.println("Recogiendo las cartas del juego");

        for (Jugador jugador : listaJugadores) {
            barajaDelJuego.recibirCartasDevueltas(jugador.mazo);

            jugador.vaciarMazo();
            System.out.println("Parte01.Cartas devueltas y mazo limpiado para: " + jugador.Nombre);
        }
    }
}