package Recipiente;

public interface ServiciosRecipiente {
    double capacidad();
    double capacidadRestante();
    boolean estaVacio();
    boolean estaLleno();
    double rellena(double cantidad);
    double vacia();
    void vierte(Recipiente otro);
    boolean mismasDimensiones(Recipiente otro);
    boolean mismaCapacidad(Recipiente otro);
    boolean contieneMas(Recipiente otro);
    boolean cabeMas(Recipiente otro);
    Recipiente creaContenedorJusto();
    String muestra();
}
