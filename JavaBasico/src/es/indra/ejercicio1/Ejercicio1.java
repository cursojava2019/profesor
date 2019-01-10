/**
 *
 */
package es.indra.ejercicio1;

import java.util.Scanner;

/**
 * @author CURSOJAVA
 *
 */
public class Ejercicio1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduzca un numero para ver si es divisible por 2");
		int leido = entrada.nextInt();
		if (leido % 2 == 0) {
			System.out.println("El numero leido " + leido + " es divisible por 2");
		} else {
			System.out.println("El numero leido " + leido + " NO es divisible por 2");
		}

	}

}
