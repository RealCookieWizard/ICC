package Pickaperro;

public class Carta {
    private int tamaño;        
    private int color;         
    private boolean tieneDosBrazos;
    private boolean tieneGafas;
    private boolean tienePalomitas;

    public Carta(int tamaño, int color, boolean tieneDosBrazos, boolean tieneGafas, boolean tienePalomitas) {
        this.tamaño = tamaño;
        this.color = color;
        this.tieneDosBrazos = tieneDosBrazos;
        this.tieneGafas = tieneGafas;
        this.tienePalomitas = tienePalomitas;
    }

    public int diferencias(Carta otra) {
        int diferencias = 0;
        if (this.tamaño != otra.tamaño) diferencias++;
        if (this.color != otra.color) diferencias++;
        if (this.tieneDosBrazos != otra.tieneDosBrazos) diferencias++;
        if (this.tieneGafas != otra.tieneGafas) diferencias++;
        if (this.tienePalomitas != otra.tienePalomitas) diferencias++;
        return diferencias;
    }

    @Override
    public String toString() {
        String tam = (tamaño == 0) ? "P" : "G";
        String colorStr = (color == 0) ? "C" : "O";
        String brazos = tieneDosBrazos ? "2B" : "1B";
        String gafas = tieneGafas ? "L" : "SL";
        String palomitas = tienePalomitas ? "P" : "SP";

        return "[" + tam + " " + colorStr + " " + brazos + " " + gafas + " " + palomitas + "]\t";
    }

    public boolean esCompatible(Carta otra) {
        return this.diferencias(otra) <= 1;
    }

}
