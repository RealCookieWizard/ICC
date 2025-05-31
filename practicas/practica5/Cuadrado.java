package FiguraGeometrica;

public class Cuadrado extends FiguraGeometrica {

    public Cuadrado(double lado) {
        super(4, lado, lado);
    }

    @Override
    public double calcularArea() {
        return base * base;
    }

    @Override
    public double calcularPerimetro() {
        return 4 * base;
    }

    @Override
    public String toString() {
        return "Cuadrado [lado = " + base + ", área = " + calcularArea() + ", perímetro = " + calcularPerimetro() + "]";
    }       
}