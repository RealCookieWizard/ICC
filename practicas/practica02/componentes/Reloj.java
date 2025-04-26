package Reloj_con_mas_clases.componentes;

public class Reloj {
    private Manecilla horas;
    private Manecilla minutos;
    private Manecilla segundos;

    public Reloj(int h, int m, int s) {
        this.horas = new Manecilla(24);
        this.minutos = new Manecilla(60);
        this.segundos = new Manecilla(60);
        this.horas.setValor(h);
        this.minutos.setValor(m);
        this.segundos.setValor(s);
    }

    public void incrementarSegundo() {
        segundos.incrementar();
        if (segundos.getValor() == 0) {
            incrementarMinuto();
        }
    }

    public void incrementarMinuto() {
        minutos.incrementar();
        if (minutos.getValor() == 0) {
            incrementarHora();
        }
    }

    public void incrementarHora() {
        horas.incrementar();
    }

    public String obtenerHora() {
        return String.format("%02d:%02d:%02d", horas.getValor(), minutos.getValor(), segundos.getValor());
    }
}
