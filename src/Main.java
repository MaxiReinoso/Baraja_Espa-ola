import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Inicializamos los objetos del juego
        Baraja baraja = new Baraja();
        Mesa mesa = new Mesa();

        // Barajeamos
        System.out.println("\n-> Barajando el mazo...");
        baraja.barajar();

        // Recorremos la baraja
        baraja.recorrerBaraja();

        System.out.println("\n---------SACAMOS DOS CARTAS PARA VER EL MÉTODO");

        //Vemos la carta siguiente disponible
        baraja.sacarSiguiente();
        baraja.sacarSiguiente();

        //Recorremos de nuevo la baraja (Ahora ya no van a estar las cartas que sacamos)
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

        System.out.println("\n-----------------Repartimos las cartas a todos los jugadores que estén en mesa");

        // Repartimos de forma dinámica según lo que ingresó el usuario
        baraja.repartirMano(mesa.getListaJugadores(), 4);

        // MOSTRAR LAS CARTAS QUE YA HAN SIDO REPARTIDAS (Historial)
        System.out.println("\n---------------CARTAS YA REPARTIDAS");
        baraja.recorrerCartasSacadas();

        // Consultamos las cartas que aún quedan en la baraja
        System.out.println("\n---------------Las cartas que quedaron son: ");
        baraja.recorrerBaraja();
    }
}
