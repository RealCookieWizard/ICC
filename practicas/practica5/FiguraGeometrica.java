package FiguraGeometrica;

public abstract class FiguraGeometrica {
    protected int numero_de_lados;
    protected double base;
    protected double altura;

    public FiguraGeometrica(int numero_de_lados, double base, double altura){
        this.numero_de_lados = numero_de_lados;
        this.base = base;
        this.altura = altura;
    }
    public abstract double calcularArea();
    public abstract double calcularPerimetro();

    public String mostrarArea() {
        return "El área es: " + calcularArea();
    }

    public String mostrarPerimetro() {
        return "El perímetro es: " + calcularPerimetro();
    }

    public abstract String toString();
}
