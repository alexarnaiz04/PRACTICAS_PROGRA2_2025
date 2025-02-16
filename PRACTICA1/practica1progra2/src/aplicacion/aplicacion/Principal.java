package aplicacion;
import java.util.Scanner;

import mates.Matematicas;

public class Principal{
		public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
			System.out.println("Introducir número de dardos: ");
			int numeroPasos = sc.nextInt();

		System.out.println("El número pi es " + Matematicas.generarNumeroPiIterativo(numeroPasos));
		sc.close();
	}
}