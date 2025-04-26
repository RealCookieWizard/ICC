package Recipiente;

public class Recipiente implements ServiciosRecipiente {
    private double altura;
    private double radio;
    private double cantidadActual;

    public Recipiente(double altura, double radio, double cantidadActual) {
        this.altura = altura;
        this.radio = radio;
        this.cantidadActual = cantidadActual;
    }
    public double getAltura() {
        return altura;
    }

    public double getRadio() {
        return radio;
    }

    public double getCantidadActual() {
        return cantidadActual;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public void setCantidadActual(double cantidadActual) {
        this.cantidadActual = cantidadActual;
    }

    @Override
    public double capacidad() {
        return 3.14 * radio * radio * altura;
    }

    @Override
    public double capacidadRestante() {
        return capacidad() - cantidadActual;
    }

    @Override
    public boolean estaVacio() {
        return cantidadActual == 0;
    }

    @Override
    public boolean estaLleno() {
        return cantidadActual == capacidad();
    }

    @Override
    public double rellena(double cantidad) {
        double capacidadRestante = capacidadRestante();
        if (cantidad <= capacidadRestante) {
            cantidadActual += cantidad;
            return 0;
        } else {
            cantidadActual = capacidad();
            return cantidad - capacidadRestante;
        }
    }

    @Override
    public double vacia() {
        double cantidadVaciada = cantidadActual;
        cantidadActual = 0;
        return cantidadVaciada;
    }

    @Override
    public void vierte(Recipiente otro) {
        double cantidadAVertir = Math.min(this.cantidadActual, otro.capacidadRestante());
        this.cantidadActual -= cantidadAVertir;
        otro.rellena(cantidadAVertir);
    }

    @Override
    public boolean mismasDimensiones(Recipiente otro) {
        return this.altura == otro.getAltura() && this.radio == otro.getRadio();
    }

    @Override
    public boolean mismaCapacidad(Recipiente otro) {
        return this.capacidad() == otro.capacidad();
    }

    @Override
    public boolean contieneMas(Recipiente otro) {
        return this.cantidadActual > otro.getCantidadActual();
    }

    @Override
    public boolean cabeMas(Recipiente otro) {
        return this.capacidadRestante() > otro.capacidadRestante();
    }

    @Override
        public Recipiente creaContenedorJusto() {
        double nuevaAltura = cantidadActual / (3.14 * radio * radio);
        return new Recipiente(nuevaAltura, radio, 0);
    }

    @Override
        public String muestra() {
            return "Recipiente [Altura: " + altura + ", Radio: " + radio + 
            ", Capacidad: " + capacidad() + ", Cantidad Actual: " + cantidadActual + "]";
    }
}
