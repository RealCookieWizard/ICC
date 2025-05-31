package FiguraGeometrica;

public class Rectangulo extends FiguraGeometrica {

    public Rectangulo(double base, double altura) {
        super(4, base, altura);
    }

    @Override
    public double calcularArea() {
        return base * altura;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * base + 2 * altura;
    }

    @Override
    public String toString() {
        return "Rectángulo [base = " + base + ", altura = " + altura + ", área = " + calcularArea() + ", perímetro = " + calcularPerimetro() + "]";
    }
}