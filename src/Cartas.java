public class Cartas {
    public String palo;
    public int numero;

    public Cartas(int numero, String palo) {
        this.numero = numero;
        this.palo = palo;
    }
    @Override
    public String toString(){
        return numero + " de " + palo;
    }
}
