package es.indra.ejercicio1;

import java.util.Scanner;

public class Ejercicio1Main {
	private static Scanner entrada;
	private static Cuenta cuenta;

	public static void inicializar() {
		entrada = new Scanner(System.in);
		cuenta = null;
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
			opcion = entrada.nextInt();
			entrada.nextLine();
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
		if (cuenta != null) {
			System.out.println("Introduzca el saldo que desea retirar y pulse intro");
			Double saldo = entrada.nextDouble();
			entrada.nextLine();
			cuenta.retirar(saldo);
			System.out.println("El resultado de la operacion es: " + cuenta.toString());
		} else {
			System.out.println("Debe inicializar la cuenta antes de hacer un ingreso. ");
		}
		System.out.println("Pulse intro para continuar...");
		entrada.nextLine();
	}

	private static void aniadirSaldo() {
		if (cuenta != null) {
			System.out.println("Introduzca el saldo que desea añadir y pulse intro");
			Double saldo = entrada.nextDouble();
			entrada.nextLine();
			cuenta.ingresar(saldo);
			System.out.println("El resultado de la operacion es: " + cuenta.toString());
		} else {
			System.out.println("Debe inicializar la cuenta antes de hacer un ingreso. ");
		}
		System.out.println("Pulse intro para continuar...");
		entrada.nextLine();
	}

	private static void inicializarCuenta() {
		System.out.println("Introduzca el nombre del titular y pulse intro");
		String titular = entrada.nextLine();
		System.out.println("Introduzca el la cantidad del saldo");
		Double saldo = entrada.nextDouble();
		entrada.nextLine();
		cuenta = new Cuenta(titular, saldo);
		System.out.println("El resultado de la operacion es: " + cuenta.toString());
		System.out.println("Pulse intro para continuar...");
		entrada.nextLine();
	}

}
