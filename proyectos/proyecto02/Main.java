package Esteganografia;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Metodos metodos = new Metodos();

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Descifrar cifrado nulo con índice n");
            System.out.println("2. Descifrar cifrado nulo con espacios finales");
            System.out.println("3. Buscar un nombre oculto");
            System.out.println("4. Descifrar palabras marcadas");
            System.out.println("5. Descifrar letras marcadas");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el mensaje original: ");
                    String mensaje1 = scanner.nextLine();
                    System.out.print("Ingrese el índice n: ");
                    int n = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Mensaje oculto: " + metodos.descifraNuloN(mensaje1, n));
                    break;
                
                case 2:
                    System.out.print("Ingrese el mensaje original con espacios finales: ");
                    String mensaje2 = scanner.nextLine();
                    System.out.println("Mensaje oculto: " + metodos.descifraNulo(mensaje2));
                    break;

                case 3:
                    System.out.print("Ingrese el mensaje a analizar: ");
                    String texto = scanner.nextLine();
                    System.out.print("Ingrese el nombre a buscar: ");
                    String nombre = scanner.nextLine();
                    System.out.println("¿El nombre está oculto?: " + metodos.contieneNombre(texto, nombre));
                    break;

                case 4:
                    System.out.print("Ingrese el mensaje original: ");
                    String mensajeM = scanner.nextLine();
                    System.out.print("Ingrese el mensaje con palabras modificadas: ");
                    String mensajeE = scanner.nextLine();
                    System.out.println("Mensaje oculto: " + metodos.descifraPalabrasMarcadas(mensajeM, mensajeE));
                    break;

                case 5:
                    System.out.print("Ingrese el mensaje original: ");
                    String mensajeM2 = scanner.nextLine();
                    System.out.print("Ingrese el mensaje con letras modificadas: ");
                    String mensajeE2 = scanner.nextLine();
                    System.out.println("Mensaje oculto: " + metodos.descifraLetrasMarcadas(mensajeM2, mensajeE2));
                    break;

                case 6:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }
}
