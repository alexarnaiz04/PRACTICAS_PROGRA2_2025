package aplicacion;

import java.util.Scanner;
import dominio.Mates;

/**
 * Clase principal de la aplicación.
 * <p>
 * Se encarga de solicitar al usuario el número de lanzamientos (o "dardos") 
 * y muestra por pantalla la aproximación del número PI calculado por la clase {@link Mates}.
 */
public class Principal {

    /**
     * Método principal que inicia la ejecución del programa.
     *
     * @param args Argumentos de la línea de comandos (no se utilizan en este programa).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introducir número de dardos: ");
        int numeroPasos = scanner.nextInt();

        Mates mates = new Mates();
        double aproximacionPI = mates.numeropi(numeroPasos);

        System.out.println("El número pi es " + aproximacionPI);

        scanner.close();
    }
}