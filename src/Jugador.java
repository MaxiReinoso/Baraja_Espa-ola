import java.util.ArrayList;

public class Jugador {
    public String Nombre;
    public ArrayList<Cartas> mazo;

    public String getNombre() {
        return Nombre;
    }
    public Jugador(String nombre) {
        Nombre = nombre;
        this.mazo = new ArrayList<>();
    }
    public void aniadirCarta(Cartas cartita){
        this.mazo.add(cartita);
    }
    public void vaciarMazo() {
        this.mazo.clear();
    }

}
