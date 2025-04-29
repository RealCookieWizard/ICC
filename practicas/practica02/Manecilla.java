package Reloj_con_mas_clases;

public class Manecilla {
    private int valor;
    private int limite;

    public Manecilla(int limite) {
        this.limite = limite;
        this.valor = 0;
    }

    public void incrementar() {
        valor = (valor + 1) % limite;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        if (valor >= 0 && valor < limite) {
            this.valor = valor;
        }
        else { System.err.println("Error");
    }
    }
}