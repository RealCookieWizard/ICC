package Reloj_con_mas_clases;


public class Menu {
    private Validador validador;
    private Simulador simulador;

    public Menu() {
        validador = new Validador();
        simulador = new Simulador(CrearReloj.crearRelojPredeterminado());
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Simular incremento 15s con for");
            System.out.println("2. Simular incremento 15m con while");
            System.out.println("3. Simular incremento 15h con do-while");
            System.out.println("0. Salir");
            opcion = validador.obtenerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    for (int i = 0; i < 15; i++) {
                        simulador.ejecutarSimulacionS(1);
                    }
                    break;
                case 2:
                    int i = 0;
                    while (i < 750) {
                        simulador.ejecutarSimulacionM(1);
                        i++;
                    }
                    break;
                case 3:
                    int j = 0;
                    do {
                        simulador.ejecutarSimulacionH(1);
                        j++;
                    } while (j < 60*60*15);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        } while (opcion != 0);
        validador.cerrarScanner();
    }
}