package Recipiente;

public class Main {
    public static void main(String[] args) {
        Recipiente recipiente1 = new Recipiente(10, 5, 0);
        Recipiente recipiente2 = new Recipiente(10, 5, 0);

        System.out.println("Recipiente 1: " + recipiente1.muestra());
        System.out.println("Recipiente 2: " + recipiente2.muestra());

        double excedente = recipiente1.rellena(100);
        System.out.println("Recipiente 1 después de rellenar con 100: " + recipiente1.muestra());
        System.out.println("Excedente: " + excedente);

        recipiente1.vierte(recipiente2);
        System.out.println("Recipiente 1 después de verter: " + recipiente1.muestra());
        System.out.println("Recipiente 2 después de verter: " + recipiente2.muestra());

        double cantidadVaciada = recipiente2.vacia();
        System.out.println("Recipiente 2 después de vaciar: " + recipiente2.muestra());
        System.out.println("Cantidad vaciada: " + cantidadVaciada);

        Recipiente recipiente3 = recipiente1.creaContenedorJusto();
        System.out.println("Recipiente 3 (contenedor justo): " + recipiente3.muestra());

        System.out.println("¿Recipiente 1 y 2 tienen las mismas dimensiones? " + recipiente1.mismasDimensiones(recipiente2));
        System.out.println("¿Recipiente 1 y 2 tienen la misma capacidad? " + recipiente1.mismaCapacidad(recipiente2));
        System.out.println("¿Recipiente 1 contiene más líquido que recipiente 2? " + recipiente1.contieneMas(recipiente2));
        System.out.println("¿Recipiente 1 tiene más capacidad restante que recipiente 2? " + recipiente1.cabeMas(recipiente2));
    }
}
