import java.util.ArrayList;
import java.util.Collections;

public class Baraja {
    private ArrayList<Cartas> listaDeCartas;

    public Baraja(){
        this.listaDeCartas = new ArrayList<>();
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
}