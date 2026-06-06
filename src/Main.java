import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Inicializamos los objetos del juego
        Baraja baraja = new Baraja();
        Mesa mesa = new Mesa();

        // barajeamos
        System.out.println("\n-> Barajando el mazo...");
        baraja.barajar();
        // recorremos la baraja
        baraja.recorrerBaraja();

        System.out.println("---------SACAMOS DOS CARTAS PARA VER EL METDO");
        //vemos la carta siguiente disponible
        baraja.sacarSiguiente();
        baraja.recorrerBaraja();

        // Creamos un par de jugadores de prueba y los sentamos en la mesa
        Jugador j1 = new Jugador("Leoo");
        Jugador j2 = new Jugador("Maxi dou");
        Jugador j3 = new Jugador("Chadvier");
        Jugador j4 = new Jugador("Lauti God");
        mesa.agregarJugador(j1);
        mesa.agregarJugador(j2);
        mesa.agregarJugador(j3);
        mesa.agregarJugador(j4);

        System.out.println("-----------------REepartimos las cartas a todos los jugadores QUE esten en mesa");
        // Repartimos de forma dinámica según lo que ingresó el usuario
        baraja.repartirMano(mesa.getListaJugadores(), 4);

        // • MOSTRAR LAS CARTAS QUE YA HAN SEAN REPARTIDAS (Historial)
        System.out.println("---------------CARTAS YA REPARTIDAS");
        baraja.recorrerCartasSacadas();

        // • MOSTRAR LAS CARTAS QUE PERMANECEN DISPONIBLES EN LA BARAJA
        System.out.println("------------------CARTAS YA REPARTIDAS");
        baraja.recorrerBaraja();

        // Consultamos la cantidad final
        System.out.println("---------------Las cartas que quedaron son: ");
        baraja.recorrerBaraja();
    }
}
