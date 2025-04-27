package distancias;

/**
 * Proporciona métodos para calcular distancias entre cadenas de texto.
 * Actualmente, implementa el algoritmo de distancia de edición (Levenshtein modificado según Jurafsky).
 */
public class CalculadoraDistancias {
    
    public static int calcularDistancia(String s1, String s2){
        return calcularDistancia(s1, s2, true);
    }

    /**
     * Calcula la distancia de edición (variante de Levenshtein según Jurafsky) entre dos cadenas.
     * Se puede especificar si el cálculo es sensible o no a mayúsculas y minúsculas.
     *
     * @param s1 Primera cadena para comparar.
     * @param s2 Segunda cadena para comparar.
     * @param caseSensitive Indica si la comparación debe ser sensible a mayúsculas y minúsculas.
     *                      {@code true} para sensible; {@code false} para insensible.
     * @return Valor numérico que representa la distancia de edición entre las cadenas proporcionadas.
     */
    public static int calcularDistancia(String s1, String s2, boolean caseSensitive){
        int m = s1.length();
        int n = s2.length();

        if(!caseSensitive){
            s1 = s1.toLowerCase();
            s2 = s2.toLowerCase();
        }

        int[][] distancias = new int[m + 1][n + 1];

        // Inicialización del borde izquierdo de la matriz
        for(int i = 0; i <= m; i++){
            distancias[i][0] = i;
        }

        // Inicialización del borde superior de la matriz
        for(int j = 0; j <= n; j++){
            distancias[0][j] = j;
        }

        // Aplicación del algoritmo de Levenshtein modificado
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // Coste por diferencia de caracteres: 0 (iguales) o 2 (diferentes)
                int iguales = (s1.charAt(i - 1) != s2.charAt(j - 1)) ? 2 : 0;

                // Cálculo del mínimo entre inserción, borrado y sustitución
                int minVal = Math.min(distancias[i][j - 1] + 1, distancias[i - 1][j] + 1);
                minVal = Math.min(minVal, distancias[i - 1][j - 1] + iguales);

                distancias[i][j] = minVal;
            }
        }

        return distancias[m][n];
    }
}