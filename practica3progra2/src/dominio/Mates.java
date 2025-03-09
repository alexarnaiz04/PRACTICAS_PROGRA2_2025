package dominio;

import java.util.Random;
import java.util.function.LongFunction;
import java.util.stream.LongStream;

/**
 * Clase de utilidades matemáticas que proporciona métodos para el cálculo de aproximaciones numéricas,
 * en este caso para aproximar el valor de PI mediante el método de Montecarlo y la API de Streams.
 */
public class Mates {

    /**
     * Calcula una aproximación de PI usando el método de Montecarlo.
     * <p>
     * El método genera un número de puntos aleatorios (dardos) en el cuadrado unitario [0,1)x[0,1) 
     * y comprueba cuántos de ellos caen dentro del círculo unitario (x^2 + y^2 <= 1). 
     * A partir de esa proporción, se obtiene una aproximación de PI.
     *
     * @param pasos Número de dardos o puntos a generar.
     * @return Un valor aproximado de PI.
     */
    public double numeropi(int pasos) {

        // Definimos una función lambda que internamente utiliza Streams para calcular PI
        LongFunction<Double> numeropiLambda = (long pasosLambda) -> {
            double areaCuadrado = 4.0;  // El área del cuadrado unitario (en Montecarlo) se toma como 4, considerando todo el cuadrante
            Random random = new Random();

            // Generamos un LongStream desde 0 hasta pasosLambda-1, 
            // y contamos cuántas veces (x, y) caen dentro del círculo.
            long aciertos = LongStream.range(0, pasosLambda)
                    .filter(i -> {
                        double x = random.nextDouble();
                        double y = random.nextDouble();
                        return (x * x + y * y) <= 1;
                    })
                    .count();

            // Usamos la fórmula pi ≈ 4 * (aciertos / pasosLambda)
            return areaCuadrado * aciertos / pasosLambda;
        };

        // Aplicamos la función con el número de "pasos" (lanzamientos) recibidos.
        return numeropiLambda.apply(pasos);
    }
}