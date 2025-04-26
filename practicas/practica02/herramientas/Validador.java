package Reloj_con_mas_clases.herramientas;

import java.util.Scanner;

public class Validador {
    private Scanner scanner;

    public Validador() {
        scanner = new Scanner(System.in);
    }

    public int obtenerEntero(String mensaje) {
        int numero;
        while (true) {
            System.out.print(mensaje);
            if (scanner.hasNextInt()) {
                numero = scanner.nextInt();
                break;
            } else {
                System.out.println("Entrada inválida. Intente nuevamente.");
                scanner.next();
            }
        }
        return numero;
    }

    public void cerrarScanner() {
        scanner.close();
    }
}
