package ListaLigada;

public class Main {
    public static void main(String[] args) {
        ListaLigada lista1 = new ListaLigada();   

        lista1.Insertar(10);
        lista1.Insertar(20);
        lista1.Insertar(30);

        System.out.println(lista1.toString());

        lista1.Insertar(40);
        lista1.Insertar(50);
        lista1.Insertar(60);
        lista1.Insertar(70);
        lista1.Insertar(80);
        
        System.out.println(lista1.toString());

        lista1.Eliminar(10);
        
        System.out.println(lista1.toString());

        lista1.Eliminar(50);

        System.out.println(lista1.toString());

        lista1.insertarIndice(52, 4);

        System.out.println(lista1.toString());

        lista1.insertarIndice(81, 21);

        System.out.println(lista1.toString());
    }   
}
