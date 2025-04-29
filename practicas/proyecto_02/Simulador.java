package Reloj_con_mas_clases;

public class Simulador {
    private Reloj reloj;
    private Mecanismo mecanismo;
    private Esfera esfera;

    public Simulador(Reloj reloj) {
        this.reloj = reloj;
        this.mecanismo = new Mecanismo();
        this.esfera = new Esfera();
    }

    public void ejecutarSimulacionS(int segundos) {
        for (int i = 0; i < segundos; i++) {
            mecanismo.avanzarTiempo(reloj, 1);
            esfera.mostrarHora(reloj);
            try { Thread.sleep(1000); } catch (InterruptedException e) { }
        }
    }
    public void ejecutarSimulacionM(int segundos) {
        for (int i = 0; i < segundos; i++) {
            mecanismo.avanzarTiempo(reloj, 1);
            esfera.mostrarHora(reloj);
            try { Thread.sleep(10); } catch (InterruptedException e) { }
        }
    }
    public void ejecutarSimulacionH(int segundos) {
        for (int i = 0; i < segundos; i++) {
            mecanismo.avanzarTiempo(reloj, 1);
            esfera.mostrarHora(reloj);
            try { Thread.sleep(1); } catch (InterruptedException e) { }
        }
    }
}