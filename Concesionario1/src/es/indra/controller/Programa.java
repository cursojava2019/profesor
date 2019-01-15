package es.indra.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import es.indra.model.Concesionario;

public class Programa {
	public static String NOMBRE_FICHERO_CONCESIONARIO;
	private static Scanner ENTRADA;
	private static Concesionario concesionario = null;

	public static void init() throws ClassNotFoundException, IOException {
		ENTRADA = new Scanner(System.in);
		File file = new File(NOMBRE_FICHERO_CONCESIONARIO);
		try {
			FileInputStream fileInput = new FileInputStream(file);
			ObjectInputStream objecInput = new ObjectInputStream(fileInput);
			concesionario = (Concesionario) objecInput.readObject();
			objecInput.close();

		} catch (FileNotFoundException e) {
			concesionario = new Concesionario();
			System.out.println("El Concesionario se inicializa desde cero al no encontrar fichero");
		}

	}

	public static void fin() throws IOException {
		File file = new File(NOMBRE_FICHERO_CONCESIONARIO);
		file.delete();
		file.createNewFile();
		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream(file);

			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(concesionario);
			objectOut.flush();
			objectOut.close();
		} catch (IOException e) {
			System.out.println("Error guardando en disco. SE HA PERDIDO TODO");
		}

	}

	public static void main(String[] args) {
		try {
			init();
		} catch (ClassNotFoundException | IOException e1) {
			System.out.println("Error al iniciar de disco. Inicializamos el concesioinaro");
			concesionario = new Concesionario();
		}
		System.out.println("BIENVENIDO AL CONCESIONARIO");
		int opcion = 0;
		do {

			System.out.println("Introduzca la Operacion que desea Realizar");
			System.out.println("1. Añadir Propietario");
			System.out.println("2. Añadir Vehiculo");
			System.out.println("3. Lista Vehiculos disponibles");
			System.out.println("4. Lista Vehiculos por propietario");
			System.out.println("5. Introducir Venta");

			System.out.println("0. Finalizar");
			opcion = ENTRADA.nextInt();
			ENTRADA.nextLine();
			switch (opcion) {
			case 1:
				aniadirPropietario();
				break;
			case 2:
				aniadirVehiculo();
				break;
			case 3:
				listarVehiculosDisponibles();
				break;
			case 4:
				listarVehiculosPropietario();
				break;
			case 5:
				crearVenta();
				break;
			case 0:
				System.out.println("Fin del programa");
			default:
				break;
			}

		} while (opcion != 0);

		try {
			fin();
		} catch (IOException e) {
			System.out.println("NO SE HA PODIDO GUARDAR.  ERROR FATAL");
			e.printStackTrace();
		}
	}

	/*												*/

	public static void aniadirPropietario() {

	}

	public static void aniadirVehiculo() {

	}

	public static void listarVehiculosDisponibles() {

	}

	public static void listarVehiculosPropietario() {

	}

	public static void crearVenta() {

	}

}
