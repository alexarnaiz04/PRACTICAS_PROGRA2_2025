package main;

import distancias.CalculadoraDistancias;

/**
 * Clase principal para la demostración del cálculo de distancias entre cadenas usando {@link CalculadoraDistancias}.
 */
public class Main {

    /**
     * Método principal que muestra ejemplos de cálculo de distancia entre dos cadenas.
     *
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {

        String palabra1 = "Alejandro";
        String palabra2 = "Alejandras";

        // Cálculo sensible a mayúsculas y minúsculas 
        int distancia = CalculadoraDistancias.calcularDistancia(palabra1, palabra2);
        System.out.println(distancia);

        // Cálculo insensible a mayúsculas y minúsculas
        int distancia2 = CalculadoraDistancias.calcularDistancia(palabra1, palabra2, false);
        System.out.println(distancia2);
    }
}
