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
        if (mesa.getListaJugadores().size() < 2) {
            System.out.println("Necesita 2 o más jugadores para comenzar el juego.");
            return;
        }
        //mezclamos la baraja
        System.out.println("\n Mezclamos la baraja...");
        this.baraja.barajar();
        //reparto inicial
        for (int i = 0; i < 4; i++) {
            Cartas carta = baraja.sacarSiguiente();
            if (carta != null) {
                mesa.getCartasEnSuelo().add(carta);
            }
        }
        baraja.repartirMano(mesa.getListaJugadores(), 3);

        for (int i = 0; i < turnos; i++) {
            boolean todasLasManosVacias = true;
            for (Jugador j : mesa.getListaJugadores()) {
                if (!j.mazo.isEmpty()) {
                    todasLasManosVacias = false;
                    break;
                }
            }
            if (todasLasManosVacias && !baraja.isVacia()) {
                System.out.println("\n--- Las manos se vaciaron. Repartiendo 3 cartas nuevas a todos ---");
                baraja.repartirMano(mesa.getListaJugadores(), 3);
            }
            for (Jugador jugador : mesa.getListaJugadores()) {
                this.turno(jugador);
            }
        }
        System.out.println("\nPartida finalizada. ¡A contar las casitas!");}

    public void turno(Jugador jugador) {
        ArrayList<Cartas> mano = jugador.mazo;

        if (mano.isEmpty()){
            System.out.println("\n" + jugador.getNombre() + " no tiene cartas en la mano");
            return;
        }

        System.out.println("\n --------------------------------");
        System.out.println("Turno de: " + jugador.getNombre().toUpperCase());

        System.out.println("Tus cartas disponibles son: ");
        for (int i = 0; i< mano.size(); i++){
            System.out.println(i + " - " + mano.get(i));
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el numero de la carta que desea jugar: ");
        int indiceElegido = scanner.nextInt();

        while (indiceElegido < 0 || indiceElegido >= mano.size()){
            System.out.println("Opcion invalida. Elija un numero valido.");
            indiceElegido = scanner.nextInt();
        }

        Cartas cartaJugada = mano.remove(indiceElegido);
        System.out.println("\n Has jugado el " + cartaJugada);

        this.menu(jugador, cartaJugada);
    }
    public void menu(Jugador jugadorActual, Cartas cartaJugada){
        Scanner scanner = new Scanner(System.in);

        Jugador rival = null;
        for (Jugador j : mesa.getListaJugadores()){
            if (!j.equals(jugadorActual)){
                rival = j;
                break;
            }
        }
        boolean puedeRobarCasita = false;
        Cartas topeCasitaRival = null;

        if(rival != null && rival.getCasita() != null && !rival.getCasita().isEmpty()){
            topeCasitaRival = rival.getCasita().get(rival.getCasita().size() - 1);
            if (topeCasitaRival.getNumero() == cartaJugada.getNumero()) {
                puedeRobarCasita = true;
            }
        }
        ArrayList<Cartas> suelo = mesa.getCartasEnSuelo();
        ArrayList<Integer> indicesMesaCoincidentes = new ArrayList<>();

        for (int i = 0; i < suelo.size(); i++) {
            if (suelo.get(i).getNumero() == cartaJugada.getNumero()) {
                indicesMesaCoincidentes.add(i);
            }
        }
        boolean puedeRobarMesa = !indicesMesaCoincidentes.isEmpty();
        if (puedeRobarCasita && puedeRobarMesa) {
            System.out.println("\n¡OPCIONES DISPONIBLES! Tu carta coincide con la mesa y con la casita rival:");
            System.out.println("1 - Robar la CASITA completa de " + rival.getNombre());
            System.out.println("2 - Robar una carta coincidente de la MESA");
            System.out.print("Ingrese el número de la opción que prefiere (1 o 2): ");

            int eleccion = scanner.nextInt();
            while (eleccion != 1 && eleccion != 2) {
                System.out.print("Opción inválida. Ingrese 1 o 2: ");
                eleccion = scanner.nextInt();
            }

            if (eleccion == 1) {
                ejecutarRoboCasita(jugadorActual, rival, cartaJugada);
            } else {
                ejecutarRoboMesa(jugadorActual, suelo, indicesMesaCoincidentes, cartaJugada);
            }
        }
        else if (puedeRobarCasita) {
            ejecutarRoboCasita(jugadorActual, rival, cartaJugada);
        }
        else if (puedeRobarMesa) {
            ejecutarRoboMesa(jugadorActual, suelo, indicesMesaCoincidentes, cartaJugada);
        }
        else {
            suelo.add(cartaJugada);
            System.out.println("No hubo coincidencias. Colocaste el " + cartaJugada + " en la mesa.");
        }
    }
    private void ejecutarRoboCasita(Jugador ladron, Jugador victima, Cartas cartaJugada) {
        System.out.println("\n¡¡ROBO DE CASITA!! Te quedaste con el mazo de " + victima.getNombre().toUpperCase());

        ladron.getCasita().add(cartaJugada);
        ladron.getCasita().addAll(victima.getCasita());
        victima.getCasita().clear();
    }
    private void ejecutarRoboMesa(Jugador jugador, ArrayList<Cartas> suelo, ArrayList<Integer> indicesCoincidentes, Cartas cartaJugada) {
        Scanner sc = new Scanner(System.in);
        int indiceRemover = indicesCoincidentes.get(0);

        if (indicesCoincidentes.size() > 1) {
            System.out.println("\nHay más de una carta igual en la mesa. Elija cuál llevarse:");
            for (int i = 0; i < indicesCoincidentes.size(); i++) {
                System.out.println(i + " - " + suelo.get(indicesCoincidentes.get(i)));
            }
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();
            while (opcion < 0 || opcion >= indicesCoincidentes.size()) {
                System.out.print("Opción inválida: ");
                opcion = sc.nextInt();
            }
            indiceRemover = indicesCoincidentes.get(opcion);
        }
        Cartas cartaMesa = suelo.remove(indiceRemover);
        jugador.getCasita().add(cartaJugada);
        jugador.getCasita().add(cartaMesa);
        System.out.println("Te llevaste el " + cartaMesa + " de la mesa.");
    }
}