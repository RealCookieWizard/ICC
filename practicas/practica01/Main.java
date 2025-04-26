import java.lang.Math;

public class Main {
    
    public static void main(String[] args) {
        
        System.out.println("CALCULADORA\n");
        
        System.out.println("Elige tu operación presionando el número entre parentesis\n");
        System.out.println("Suma (1)\n");
        System.out.println("Resta (2)\n");
        System.out.println("Multiplicación (3)\n");
        System.out.println("División (4)\n");
        System.out.println("Logaritmo natural (5)\n");
        System.out.println("Módulo (6)\n");
        System.out.println("Raíz cuadrada (7)\n");
        System.out.println("Raíz cúbica (8)\n");
        System.out.println("Valor absoluto (9)\n");

        int opcion = Integer.parseInt(System.console().readLine());

        System.out.println("Ingrese el primer número");
        double num1 = Double.parseDouble(System.console().readLine());
        
        double num2 = 0;
        if (opcion != 5 && opcion != 7 && opcion != 8 && opcion != 9) {
            System.out.println("Ingrese el segundo número");
            num2 = Double.parseDouble(System.console().readLine());
        }

        double resultado = 0;

        if (opcion == 1) {
            resultado = num1 + num2;
            System.out.println("El resultado de la suma " + num1 + " + " + num2 + " = " + resultado);
        }
        else if (opcion == 2) {
            resultado = num1 - num2;
            System.out.println("El resultado de la resta " + num1 + " - " + num2 + " = " + resultado);
        }
        else if (opcion == 3) {
            resultado = num1 * num2;
            System.out.println("El resultado de la multiplicación " + num1 + " * " + num2 + " = " + resultado);
        }
        else if (opcion == 4) {
            if (num2 != 0) {
            resultado = num1 / num2;
            System.out.println("El resultado de la división " + num1 + " / " + num2 + " = " + resultado);
            }
            else {
            System.out.println("La división no esta definida para dividir cero");
            }
        }
        else if (opcion == 5) {
            if (num1 > 0) {
            resultado = Math.log(num1);
            System.out.println("El resultado del logaritmo natural " + num1 + " = " + resultado);
            }
            else {
                System.out.println("El logaritmo natural solo esta definido para numeros positivos");
            }
        }
        else if (opcion == 6) {
            resultado = num1 % num1;
            System.out.println("El resultado del módulo " + num1 + " % " + num2 + " = " + resultado);
        }
        else if (opcion == 7) {
            if (num1 >= 0) {
            resultado = Math.sqrt(num1);
            System.out.println("El resultado de la raíz cuadrada de " + num1 + " = " + resultado);
            }
            else {
                System.out.println("El logaritmo natural solo esta definido para numeros positivos");
            }
        }
        else if (opcion == 8) {
            resultado = Math.cbrt(num1);
            System.out.println("El resultado de la raíz cúbica de " + num1 + " = " + resultado);
        }
        else if (opcion == 9) {
            resultado = Math.abs(num1);
            System.out.println("El resultado del valor absoluto de " + num1 + " = " + resultado);
        }
        else { 
            System.out.println("Operación invalida");
        }
    }
}
