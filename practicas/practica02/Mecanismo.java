package Reloj_con_mas_clases;

public class Mecanismo {
    public void avanzarTiempo(Reloj reloj, int segundos) {
        for (int i = 0; i < segundos; i++) {
            reloj.incrementarSegundo();
        }
    }
}