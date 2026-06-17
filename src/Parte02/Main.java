package Parte02;

import Parte01.*;

public class Main {

    public static void main(String[] args){

        CasitaRobada casitaRobada = new CasitaRobada();

        Mesa mesa = new Mesa();

        Baraja baraja = new Baraja();

        casitaRobada.setMesa(mesa);

        casitaRobada.setBaraja(baraja);

        System.out.println("Poner acá el main después lol");

    }

}
