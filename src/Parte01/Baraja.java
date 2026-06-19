package Parte01;

import java.util.ArrayList;
import java.util.Collections;

public class Baraja {
    private ArrayList<Cartas> listaDeCartas;
    private ArrayList<Cartas> cartasSacadas;

    public Baraja(){
        this.listaDeCartas = new ArrayList<>();
        this.cartasSacadas = new ArrayList<>();
        crearCartas();
    }

    public void crearCartas(){
        String[] palos = {"Espada", "Basto", "Oro", "Copa"};
        for (int i = 0; i < 4; i++){
            String paloActual = palos[i];

            for (int y = 1; y <= 12; y++){
                if (y != 8 && y != 9){
                    Cartas nuevaCarta = new Cartas(y, paloActual);
                    this.listaDeCartas.add(nuevaCarta);
                }
            }
        }
    }

    public void barajar(){
        Collections.shuffle(this.listaDeCartas);
    }

    public void recorrerBaraja(){
        System.out.println("\nParte01.Cartas en el mazo:");
        for (Cartas carta : listaDeCartas) {
            System.out.println("La carta es el "+ carta.getNumero() +" de "+carta.getPalo());
        }
    }

    public void recorrerCartasSacadas(){
        System.out.println("\nParte01.Cartas sacadas:");
        if(cartasSacadas.isEmpty()) {
            System.out.println("todavia no se sacan cartitas");
        }
        for (Cartas carta : cartasSacadas) {
            System.out.println("Ya se sacó el "+ carta.getNumero() +" de "+carta.getPalo());
        }
    }
    public Cartas sacarSiguiente() {
        if (this.listaDeCartas.isEmpty()) {
            System.out.println("\nNo quedan más cartas en la baraja.");
            return null;
        }else{
            Cartas carta = listaDeCartas.remove(0);
            cartasSacadas.add(carta);
            System.out.println("La carta es el "+ carta.getNumero() +" de "+carta.getPalo());
            return carta;
        }

    }

    public void repartirMano(ArrayList<Jugador> jugadoresEnMesa, int cartasPorJugador) {
        for (Jugador jugadorcito : jugadoresEnMesa) {
            System.out.println("\nRepartiendo cartas a: " + jugadorcito.Nombre);

            for (int i = 0; i < cartasPorJugador; i++) {
                Cartas cartaSacada = this.sacarSiguiente();

                if (cartaSacada != null) {
                    jugadorcito.aniadirCarta(cartaSacada);
                } else {
                    System.out.println("Se acabaron las cartas de la baraja mi pai");
                    return;
                }
            }
        }
    }

    public void recibirCartasDevueltas(ArrayList<Cartas> cartasDevueltas) {
        this.listaDeCartas.addAll(cartasDevueltas);
        this.cartasSacadas.clear();
    }
    public boolean isVacia() {
        return this.listaDeCartas.isEmpty();
    }

}
