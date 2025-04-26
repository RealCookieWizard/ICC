package Esteganografia;

import java.util.Scanner;

public class Metodos {
    
    public String mensaje;

    public String descifraNuloN(String original, int n) {
        
        StringBuilder descrifrado = new StringBuilder();
        Scanner sc = new Scanner(original);

        while (sc.hasNext()) {
            String palabra = sc.next();
            if (palabra.length() >= n) {
                descrifrado.append(palabra.charAt(n-1));
            }
        }
        sc.close();
        return descrifrado.toString();
    }       
    
    public String descifraNulo(String original) {
        StringBuilder descrifrado = new StringBuilder();
        Scanner sc = new Scanner(original);
        int n = original.length() - original.trim().length();

        while (sc.hasNext()) {
            String palabra = sc.next();
            if (palabra.length() >= n) {
                descrifrado.append(palabra.charAt(n));
            }
        }
        sc.close();
        return descrifrado.toString();
    }
    
    public boolean contieneNombre(String mensaje, String nombre) {
        String mensajeLimpio = mensaje.replaceAll("[^a-zA-Z]", "").toLowerCase();
        String nombreLimpio = nombre.replaceAll("[^a-zA-Z]", "").toLowerCase();
        return mensajeLimpio.contains(nombreLimpio);
    }

    public String descifraPalabrasMarcadas (String m, String e) {
        Scanner sc1 = new Scanner(m);
        Scanner sc2 = new Scanner(e);
        StringBuilder descifrado = new StringBuilder();

        while (sc1.hasNext() && sc2.hasNext()) {
            String palabraM = sc1.next();
            String palabraE = sc2.next();
            if (!palabraM.equals(palabraE)) {
                descifrado.append(palabraM);
            }
        }
        sc1.close();
        sc2.close();
        return descifrado.toString();
    }

    public String descifraLetrasMarcadas(String m, String e) {
        Scanner sc1 = new Scanner(m);
        Scanner sc2 = new Scanner(e);
        StringBuilder descifrado = new StringBuilder();
    
        while (sc1.hasNext() && sc2.hasNext()) {
            String palabraM = sc1.next();
            String palabraE = sc2.next();
            if (palabraM.length() == palabraE.length()) {
                for (int i = 0; i < palabraM.length(); i++) {
                    if (palabraM.charAt(i) != palabraE.charAt(i)) {
                        descifrado.append(palabraM.charAt(i));
                    }
                }
            }
        }
        sc1.close();
        sc2.close();
        return descifrado.toString();
    }


}
