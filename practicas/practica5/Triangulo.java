package FiguraGeometrica;

public class Triangulo extends FiguraGeometrica{

    public Triangulo(double base, double altura) {
        super(3, base, altura);
    }
    
    @Override
    public double calcularArea() { 
        return (base * altura) / 2;
    }
    
    @Override
    public double calcularPerimetro() { 
        double hipotenusa = Math.sqrt(base * base + altura * altura);
        return base + altura + hipotenusa;
    }

    @Override
    public String toString() {
        return "Triángulo [base = " + base + ", altura = " + altura + ", área = " + calcularArea() + ", perímetro = " + calcularPerimetro() + "]";
    }
}
