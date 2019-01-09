package es.indra.ejercicio1;

import java.util.Scanner;

public class Ejercicio1Main {
	private static Scanner ENTRADA;
	private static Cuenta CUENTA;

	public static void inicializar() {
		ENTRADA = new Scanner(System.in);
		CUENTA = null;
	}

	public static void main(String[] args) {
		inicializar();
		int opcion = 0;
		do {
			System.out.flush();
			System.out.println("Introduzca la Operacion que desea Realizar");
			System.out.println("1. Inicilizar Cuenta");
			System.out.println("2. Añadir saldo");
			System.out.println("3. Retirar saldo");
			System.out.println("0. Finalizar");
			opcion = ENTRADA.nextInt();
			ENTRADA.nextLine();
			switch (opcion) {
			case 1:
				inicializarCuenta();
				break;
			case 2:
				aniadirSaldo();
				break;
			case 3:
				retirarSaldo();
				break;
			case 0:
				System.out.println("Fin del programa");
			default:
				break;
			}

		} while (opcion != 0);
	}

	private static void retirarSaldo() {
		if (CUENTA != null) {
			System.out.println("Introduzca el saldo que desea retirar y pulse intro");
			Double saldo = ENTRADA.nextDouble();
			ENTRADA.nextLine();
			CUENTA.retirar(saldo);
			System.out.println("El resultado de la operacion es: " + CUENTA.toString());
		} else {
			System.out.println("Debe inicializar la cuenta antes de hacer un ingreso. ");
		}
		System.out.println("Pulse intro para continuar...");
		ENTRADA.nextLine();
	}

	private static void aniadirSaldo() {
		if (CUENTA != null) {
			System.out.println("Introduzca el saldo que desea añadir y pulse intro");
			Double saldo = ENTRADA.nextDouble();
			ENTRADA.nextLine();
			CUENTA.ingresar(saldo);
			System.out.println("El resultado de la operacion es: " + CUENTA.toString());
		} else {
			System.out.println("Debe inicializar la cuenta antes de hacer un ingreso. ");
		}
		System.out.println("Pulse intro para continuar...");
		ENTRADA.nextLine();
	}

	private static void inicializarCuenta() {
		System.out.println("Introduzca el nombre del titular y pulse intro");
		String titular = ENTRADA.nextLine();
		System.out.println("Introduzca el la cantidad del saldo");
		Double saldo = ENTRADA.nextDouble();
		ENTRADA.nextLine();
		CUENTA = new Cuenta(titular, saldo);
		System.out.println("El resultado de la operacion es: " + CUENTA.toString());
		System.out.println("Pulse intro para continuar...");
		ENTRADA.nextLine();
	}

}
