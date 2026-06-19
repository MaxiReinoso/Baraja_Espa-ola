package Parte01;

import java.util.ArrayList;

public class Jugador {
    public String Nombre;
    public ArrayList<Cartas> mazo;
    private ArrayList<Cartas> casita;

    public String getNombre() {
        return Nombre;
    }

    public Jugador(String nombre) {
        Nombre = nombre;
        this.mazo = new ArrayList<>();
        this.casita = new ArrayList<>(); // Inicialización ordenada en el constructor
    }
    public void aniadirCarta(Cartas cartita){
        this.mazo.add(cartita);
    }
    public void vaciarMazo() {
        this.mazo.clear();
    }
    public ArrayList<Cartas> getCasita() {return this.casita;}

}
