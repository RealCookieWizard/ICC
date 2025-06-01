package Pickaperro;

public class Jugador {
    private String nombre;
    private ListaCartas secuencia;
    private Carta cartaGuia;
    private boolean esArtificial;
    private int puntos;

    public Jugador(String nombre, boolean esArtificial) {
        this.nombre = nombre;
        this.esArtificial = esArtificial;
        this.secuencia = new ListaCartas();
        this.puntos = 0;
    }

    public void nuevaCartaGuia(Carta carta) {
        this.cartaGuia = carta;
        secuencia.vaciar();
        secuencia.agregarAlFinal(carta);
    }

    public Carta getCartaGuia() {
        return cartaGuia;
    }

    public ListaCartas getSecuencia() {
        return secuencia;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean esArtificial() {
        return esArtificial;
    }

    public int getPuntos() {
        return puntos;
    }

    public void agregarPuntosDeSecuencia() {
        puntos += secuencia.getTamaño();  
    }

    public void resetSecuencia() {
        secuencia.vaciar();
    }
    public void imprimirSecuencia() {
        System.out.println(nombre + " - Secuencia actual:");
        if (secuencia.estaVacia()) {
            System.out.println("  (vacía)");
        } else {
            secuencia.imprimir();
        }
    }

   
    public void jugarCarta(Carta carta) {
        secuencia.agregarAlFinal(carta);
    }

    public PosicionCarta escogerCartaValida(Carta[][] mesa, Carta ultimaCarta) {
        for (int i = 0; i < mesa.length; i++) {
            for (int j = 0; j < mesa[i].length; j++) {
                Carta c = mesa[i][j];
                if (c != null) {
                    int diferencias = (ultimaCarta != null) ? ultimaCarta.diferencias(c) : 0;
                    if (diferencias <= 1) {
                        return new PosicionCarta(c, i, j);
                    }
                }
            }
        }
        return null;
    }
}