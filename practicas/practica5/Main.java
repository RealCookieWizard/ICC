package FiguraGeometrica;

public class Main {
    public static void main(String[] args) {
        Triangulo t1 = new Triangulo(3, 4); 
        FiguraGeometrica t2 = new Triangulo(5, 6); 

        FiguraGeometrica c1 = new Cuadrado(4);
        FiguraGeometrica r1 = new Rectangulo(3, 5);

        System.out.println("Triángulo 1 -> " + t1.mostrarArea() + " | " + t1.mostrarPerimetro());
        System.out.println("Triángulo 2 (polimorfismo) -> " + t2.mostrarArea() + " | " + t2.mostrarPerimetro());

        System.out.println("Cuadrado -> " + c1.mostrarArea() + " | " + c1.mostrarPerimetro());
        System.out.println("Rectángulo -> " + r1.mostrarArea() + " | " + r1.mostrarPerimetro());

        System.out.println("\n--- Representaciones usando toString() ---");
        System.out.println(t1.toString());
        System.out.println(t2.toString());
        System.out.println(c1.toString());
        System.out.println(r1.toString());
    }
}
