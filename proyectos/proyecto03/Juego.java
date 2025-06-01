package Pickaperro;

import java.util.Random;
import java.util.Scanner;

public class Juego {
    private ListaCartas mazo;
    private Carta[][] mesa;
    Jugador jugadorHumano;
    Jugador jugadorArtificial;
    private Random random;
    private boolean juegoTerminado = false;



    public Juego(long semilla) {
        random = new Random(semilla);
        jugadorHumano = new Jugador("Usuario", false);
        jugadorArtificial = new Jugador("Bot", true);
        inicializarMazo();
        barajarMazo();
        inicializarMesa();
        repartirCartasIniciales();
    }

    private void inicializarMazo() {
        mazo = new ListaCartas();
        for (int t = 0; t < 2; t++) {
            for (int c = 0; c < 2; c++) {
                for (boolean b : new boolean[]{true, false}) {
                    for (boolean g : new boolean[]{true, false}) {
                        for (boolean p : new boolean[]{true, false}) {
                            Carta carta = new Carta(t, c, b, g, p);
                            for (int i = 0; i < 3; i++) {
                                mazo.agregarAlFinal(carta);
                            }
                        }
                    }
                }
            }
        }
    }

    private void barajarMazo() {
        mazo.barajar(random);
    }

    private void inicializarMesa() {
        mesa = new Carta[5][6];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                mesa[i][j] = mazo.extraerAlInicio();
            }
        }
    }

    private void repartirCartasIniciales() {
        jugadorHumano.nuevaCartaGuia(mazo.extraerAlInicio());
        jugadorArtificial.nuevaCartaGuia(mazo.extraerAlInicio());
    }

    public void mostrarEstado() {
        System.out.println("\nCartas disponibles en la mesa:");
        for (int i = 0; i < mesa.length; i++) {
            for (int j = 0; j < mesa[i].length; j++) {
                if (mesa[i][j] != null) {
                    System.out.printf("[%d,%d]: %-12s", i, j, mesa[i][j] != null ? mesa[i][j].toString() : "(vacía)");

                } else {
                    System.out.print("[" + i + "," + j + "]: (vacía)  ");
                }
            }
            System.out.println();
        }

    }

    private int verificarSecuencia(Jugador jugador) {
        ListaCartas secuencia = jugador.getSecuencia();
        if (secuencia.longitud() == 0) {
            return 0;
        }

        Carta anterior = secuencia.obtener(0);
        for (int i = 1; i < secuencia.longitud(); i++) {
            Carta actual = secuencia.obtener(i);
            if (!anterior.esCompatible(actual)) {
                System.out.println("Falló entre: " + anterior + " y " + actual);
                return 0;
            }
            anterior = actual;
        }

        return secuencia.longitud();
    }

    public ListaCartas cartasValidasParaExtender(Jugador jugador) {
        ListaCartas validas = new ListaCartas();
        Carta ultima = jugador.getSecuencia().getUltima();
        if (ultima == null) return validas;

        for (int i = 0; i < mesa.length; i++) {
            for (int j = 0; j < mesa[i].length; j++) {
                Carta c = mesa[i][j];
                if (c != null && (ultima.diferencias(c) == 0 || ultima.diferencias(c) == 1)) {
                    validas.agregarAlFinal(c);
                }
            }
        }
        return validas;
    }

    public void turnoJugador() {
        System.out.println("Carta guía: " + jugadorHumano.getCartaGuia());
        jugadorHumano.imprimirSecuencia();

        System.out.println("Selecciona una carta escribiendo fila y columna (ej: 2 3), o escribe 'pasar' para terminar la ronda:");

        while (true) {
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine().trim();

            if (input.equalsIgnoreCase("pasar")) {
                ListaCartas posibles = cartasValidasParaExtender(jugadorHumano);

                if (posibles.longitud() > 0) {
                    System.out.println("¡Error! Podías tomar cartas pero decidiste pasar. Pierdes automáticamente.");
                    System.out.println("El Bot gana la partida.");
                    juegoTerminado = true;
                    return;
                } else {
                    System.out.println("El jugador pasó correctamente (sin opciones válidas).");
                    finalizarRonda();
                    juegoTerminado = true;
                    return;
                }
}

            String[] partes = input.split(" ");
            if (partes.length != 2) {
                System.out.println("Entrada inválida. Escribe dos números (fila columna) o 'pasar'.");
                continue;
            }

            try {
                int fila = Integer.parseInt(partes[0]);
                int col = Integer.parseInt(partes[1]);

                if (fila < 0 || fila >= mesa.length || col < 0 || col >= mesa[0].length) {
                    System.out.println("Coordenadas fuera de rango. Intenta de nuevo.");
                    continue;
                }

                Carta seleccionada = mesa[fila][col];
                if (seleccionada == null) {
                    System.out.println("Esa posición está vacía. Intenta otra.");
                    continue;
                }

                Carta ultima = jugadorHumano.getSecuencia().getUltima();
                int dif = ultima.diferencias(seleccionada);
                System.out.println("Última en secuencia: " + ultima);
                System.out.println("Carta seleccionada: " + seleccionada);
                System.out.println("Diferencias: " + dif);

                if (dif > 1) {
                    System.out.println("La carta no cumple con la regla de diferencia máxima de 1. Intenta otra.");
                    continue;
                }

                jugadorHumano.jugarCarta(seleccionada);
                mesa[fila][col] = null; 
                System.out.println("Jugaste la carta: " + seleccionada);
                jugadorHumano.imprimirSecuencia();
                return; 

            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Escribe dos números (fila columna) o 'pasar'.");
            }
        }
    }


    public boolean turnoBot() {
        Carta ultima = jugadorArtificial.getSecuencia().getUltima();
        PosicionCarta jugada = jugadorArtificial.escogerCartaValida(mesa, ultima);

        if (jugada != null) {
            jugadorArtificial.jugarCarta(jugada.carta);
            mesa[jugada.fila][jugada.columna] = null; 
            System.out.println("Bot jugó carta: " + jugada.carta + " en [" + jugada.fila + "," + jugada.columna + "]");
            return true;
        } else {
            return false; 
        }
    }


    private void finalizarRonda() {
        if (jugadorHumano.getSecuencia().getTamaño() > 1) {
            jugadorHumano.agregarPuntosDeSecuencia();
            System.out.println("El jugador humano gana " + jugadorHumano.getSecuencia().getTamaño() + " puntos esta ronda.");
        }
        if (jugadorArtificial.getSecuencia().getTamaño() > 1) {
            jugadorArtificial.agregarPuntosDeSecuencia();
            System.out.println("El bot gana " + jugadorArtificial.getSecuencia().getTamaño() + " puntos esta ronda.");
        }

        jugadorHumano.resetSecuencia();
        jugadorArtificial.resetSecuencia();
        
        jugadorHumano.nuevaCartaGuia(mazo.extraerAlInicio());
        jugadorArtificial.nuevaCartaGuia(mazo.extraerAlInicio());
    }

    public void jugar() {
        juegoTerminado = false;
        Scanner sc = new Scanner(System.in);

        while (!juegoTerminado) {
            System.out.println("Turno del jugador: Usuario");
            mostrarEstado();
            turnoJugador();
            if (juegoTerminado) return;

            if (mazo.estaVacia()) {
                juegoTerminado = true;
                break;
            }

            System.out.println("Turno del bot: Bot");
            boolean botJugo = turnoBot();  
            if (juegoTerminado) break;


            if (!botJugo) {
                System.out.println("El bot decide pasar.");
                juegoTerminado = true;
                break;
            }

            if (mazo.estaVacia()) {
                juegoTerminado = true;
                break;
            }
        }
    }


    public void imprimirMesa() {
        System.out.println("Mesa actual:");
        for (int i = 0; i < mesa.length; i++) {
            for (int j = 0; j < mesa[i].length; j++) {
                if (mesa[i][j] != null) {
                    System.out.print(mesa[i][j] + "  ");
                } else {
                    System.out.print("[ Vacío ]  ");
                }
            }
            System.out.println();
        }
    }

}
