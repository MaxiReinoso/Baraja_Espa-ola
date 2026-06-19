package Parte02;
import Parte01.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CasitaRobada extends Juego{

    //Asignamos el nombre y las reglas de manera predefinida al juego

    public CasitaRobada() {
        setNombre("Casita Robada");
        setReglas(new Reglas_Casita_Robada());
    }

    public void jugar(int turnos){

        if ((mesa.getListaJugadores().size()) < 2){

            System.out.println("Necesita 2 o más jugadores para comenzar el juego.");

        } else{

            for (int i = 0; i < turnos; i++) {

                for (Jugador jugador: mesa.getListaJugadores()){

                    this.turno(jugador);

                }

            }

        }

    }

    public void turno(Jugador jugador){

        ArrayList<Cartas> cartasJugador = jugador.mazo;

        Cartas primerCarta = cartasJugador.get(0);

        int numeroPrimerCarta = primerCarta.getNumero();

        System.out.println("La primer carta de su mazo es: " + numeroPrimerCarta);

        this.menu(numeroPrimerCarta);

    }

    public void menu(int numeroPrimerCarta){

        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Qué desea hacer a continuación?\n(Ingrese la letra correspondiente a la opción que desea elegir):");

        System.out.println("");

        System.out.println("Ingrese la opción que desee elegir:");

        String opcionElegida = scanner.nextLine();



    }

}
