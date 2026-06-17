package Parte02;
import Parte01.*;
import java.util.ArrayList;

public class CasitaRobada extends Juego{

    //Asignamos el nombre y las reglas de manera predefinida al juego

    public CasitaRobada() {
        setNombre("Casita Robada");
        setReglas(new Reglas_Casita_Robada());
    }

    public void jugar(){

        if ((mesa.getListaJugadores().size()) < 2){

            System.out.println("Necesita 2 o más jugadores para comenzar el juego.");

        } else{

            

        }

    }

}
