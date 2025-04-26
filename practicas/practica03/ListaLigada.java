package ListaLigada;

public class ListaLigada {
    
    private Nodo cabeza;
    private int longitudLista;

    public ListaLigada() {
        this.cabeza = null;
        this.longitudLista = 0;
    }

    public void Insertar(int Elemento) {
        Nodo nuevoNodo = new Nodo(Elemento, null);
        
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo auxiliar = cabeza;
            while (auxiliar.siguienteNodo != null) {
                auxiliar = auxiliar.siguienteNodo;
            }
            auxiliar.siguienteNodo = nuevoNodo;
        }
        longitudLista++;
    }

    public String toString() {
        if (cabeza == null) return "La lista está vacía.";

        StringBuilder listString = new StringBuilder();
        Nodo auxiliar = cabeza;
        
        while (auxiliar != null) {
            listString.append(auxiliar.Elemento).append(" -> ");
            auxiliar = auxiliar.siguienteNodo;
        }
        
        return listString.append("null").toString();
    }

    public void Eliminar(int Elemento) {
        System.out.println("Eliminando elemento: " + Elemento);
    
        if (cabeza == null) {
            System.out.println("La lista está vacía, no se pudo eliminar.");
            return;
        }
    
        if (cabeza.Elemento == Elemento) {
            cabeza = cabeza.siguienteNodo;
            longitudLista--;
            System.out.println("Se eliminó el elemento " + Elemento);
            return;
        }
    
        Nodo auxiliar = cabeza;
        while (auxiliar.siguienteNodo != null && auxiliar.siguienteNodo.Elemento != Elemento) {
            auxiliar = auxiliar.siguienteNodo;
        }
    
        if (auxiliar.siguienteNodo == null) {
            System.out.println("No se encontró " + Elemento + " en la lista.");
        } else {
            auxiliar.siguienteNodo = auxiliar.siguienteNodo.siguienteNodo;
            longitudLista--;
            System.out.println("Se eliminó el elemento " + Elemento);
        }
    }

    public void insertarIndice(int Elemento, int indice) {
        if (indice < 0 || indice > longitudLista) {
            System.out.println("Índice inválido. No se insertó el elemento.");
            return;
        }

        Nodo nuevoNodo = new Nodo(Elemento, null);

        if (indice == 0) { 
            nuevoNodo.siguienteNodo = cabeza;
            cabeza = nuevoNodo;
        } else {
            Nodo auxiliar = cabeza;
            for (int i = 0; i < indice - 1; i++) {
                auxiliar = auxiliar.siguienteNodo;
            }
            nuevoNodo.siguienteNodo = auxiliar.siguienteNodo;
            auxiliar.siguienteNodo = nuevoNodo;
        }

        longitudLista++;
        System.out.println("Se insertó " + Elemento + " en el índice " + indice);
    }
}
