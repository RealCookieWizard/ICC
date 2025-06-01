package Pickaperro;

import java.util.Random;

public class ListaCartas {
    private Nodo inicio;
    private int tamaño;
    

    private class Nodo {
        Carta carta;
        Nodo siguiente;

        Nodo(Carta carta) {
            this.carta = carta;
            this.siguiente = null;
        }
    }

    public ListaCartas() {
        this.inicio = null;
        this.tamaño = 0;
    }

    public void agregarAlFinal(Carta carta) {
        Nodo nuevo = new Nodo(carta);
        if (inicio == null) {
            inicio = nuevo;
        } else {
            Nodo actual = inicio;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        tamaño++;
    }

    public Carta obtener(int indice) {
        if (indice < 0 || indice >= tamaño) {
            throw new IndexOutOfBoundsException("Índice fuera de rango.");
        }
        Nodo actual = inicio;
        for (int i = 0; i < indice; i++) {
            actual = actual.siguiente;
        }
        return actual.carta;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void vaciar() {
        inicio = null;
        tamaño = 0;
    }

    public boolean estaVacia() {
        return tamaño == 0;
    }

    public void imprimir() {
        Nodo actual = inicio;
        int i = 1;
        while (actual != null) {
            System.out.println(i + ". " + actual.carta);
            actual = actual.siguiente;
            i++;
        }
    }

    public boolean contiene(Carta carta) {
        Nodo actual = inicio;
        while (actual != null) {
            if (actual.carta.equals(carta)) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    public Carta getUltima() {
        if (estaVacia()) return null;
        Nodo actual = inicio;
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }
        return actual.carta;
    }
    public void barajar(Random rand) {
        if (tamaño <= 1) return;

        Carta[] arreglo = new Carta[tamaño];
        Nodo actual = inicio;
        for (int i = 0; i < tamaño; i++) {
            arreglo[i] = actual.carta;
            actual = actual.siguiente;
        }

        for (int i = tamaño - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            Carta temp = arreglo[i];
            arreglo[i] = arreglo[j];
            arreglo[j] = temp;  
        }

        actual = inicio;
        for (int i = 0; i < tamaño; i++) {
            actual.carta = arreglo[i];
            actual = actual.siguiente;
        }
    }

        public Carta extraerAlInicio() {
        if (inicio == null) return null;

        Carta carta = inicio.carta;
        inicio = inicio.siguiente;
        tamaño--;

        return carta;
    }

    public int longitud() {
        return tamaño;
    }

}
