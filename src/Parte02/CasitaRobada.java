package Parte02;
import Parte01.*;
import java.util.ArrayList;

public class CasitaRobada extends Juego{

    //Asignamos el nombre y las reglas de manera predefinida al juego

    public CasitaRobada() {
        setNombre("Casita Robada");
        setReglas(new Reglas_Casita_Robada());
    }

}
