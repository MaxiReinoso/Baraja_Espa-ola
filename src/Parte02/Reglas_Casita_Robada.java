package Parte02;

public class Reglas_Casita_Robada extends ReglasJuego{

    @Override
    public void mostrarReglas(){
        System.out.println("---- REGLAS | CASITA ROBADA ----\n");
        System.out.println("--------------------------------\n");

        System.out.println("\n---- OBJETIVO DEL JUEGO: ----");
        System.out.println("Acumular la mayor cantidad de cartas posible.\n");
        System.out.println("Gana el jugador que acumule mas cartas al final de la partida");

        System.out.println("\n---- JUGADORES ----");
        System.out.println("Pueden jugar un minimo 2 personas");

        System.out.println("\n---- REPARTO ----");
        System.out.println("Se reparten 3 cartas a cada jugador");
        System.out.println("Se colocan 4 cartas boca arriba en la mesa (La casita).");
        System.out.println("Cuando los jugadores se quedan sin cartas en la mano,");
        System.out.println("el repartidor da 3 cartas nuevas a cada uno del mazo original.");

        System.out.println("\n---- TURNO DE JUEGO ----");
        System.out.println("En su turno, cada jugador busca una pareja entre sus cartas de la mano y las del centro de la mesa");
        System.out.println("El jugador tiene las siguientes opciones:");
        System.out.println("1- Formar Pareja (Casita): Si tenes en la mano una carta del mismo numero o valor que una del centro,");
        System.out.println("   la bajas, la unes a esa carta y formas tu propia 'Casita' boca arriba a tu lado.");
        System.out.println("2- Descartar: Si no tienes una carta que coincida con las del centro, debes tirar una de tus");
        System.out.println("   cartas al centro boca arriba, la cual podra ser levantada por otro jugador en su turno.");

        System.out.println("\n--- MECANICA DE ROBAR ---");
        System.out.println("3- Robar al rival: Si en tu turno tienes una carta que coincide con la carta superior de la casita");
        System.out.println("   de otro jugador, puedes robar todo su monton y sumarlo al tuyo, creando tu propia 'Casita Robada'");
        System.out.println("4- Robar la mesa: Si un jugador tira una carta que coincide exactamente con el numero de la");
        System.out.println("   ultima carta expuesta en el centro, se lleva todas las cartas acumuladas en esa pila central.");

        System.out.println("\n--- FIN DE LA PARTIDA ---");
        System.out.println("La partida termina cuando se acaban todas las cartas del mazo");
        System.out.println("y los jugadores no tienen más cartas en la mano.");
        System.out.println("Las cartas que queden en la mesa se las lleva el último jugador que haya capturado cartas.");

        System.out.println("\n--- PUNTAJE ---");
        System.out.println("Cada carta capturada vale 1 punto.");
        System.out.println("Robar la casita otorga 1 punto extra por cada robo logrado.");
        System.out.println("Gana quien tenga mayor puntaje al finalizar la partida.");
    }
}
