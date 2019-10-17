package classes;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws SQLException, IOException {

		Archivo miArchivo = new Archivo();
		BBDD miBBDD = new BBDD();
		utils.AccesoHibernate miHibernate = new utils.AccesoHibernate();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Elija una opción: ");
		System.out.println("1: Leer archivo");
		System.out.println("2: Leer base de datos");
		System.out.println("3: Escribir archivo por consola");
		System.out.println("4: Escribir base de datos por consola");
		System.out.println("5: Escribir archivo desde base de datos");
		System.out.println("6: Escribir base de datos desde archivo");
		System.out.println("7: Leer base de datos con Hibernate");
		System.out.println("8: Escribir base de datos con Hibernate");
		System.out.println("9: Borrar base de datos con Hibernate");
		String choice = scanner.nextLine();

		switch (choice) {
		case "1":
			miArchivo.leer();
			break;
		case "2":
			miBBDD.leer();
			break;
		case "3":
			Map<String, String> auxiliar3 = new HashMap<>();
			System.out.print("Nº de entradas a añadir: ");
			Integer entradas = Integer.parseInt(scanner.nextLine());
			for (int i = 1; i <= entradas; i++) {
				Scanner scanner1 = new Scanner(System.in);
				System.out.println("Introduzca el ID");
				auxiliar3.put("ID", scanner1.nextLine());
				System.out.println("Introduzca el Nombre");
				auxiliar3.put("Nombre", scanner1.nextLine());
				System.out.println("Introduzca la Raza");
				auxiliar3.put("Raza", scanner1.nextLine());
				System.out.println("Introduzca el Color");
				auxiliar3.put("Color", scanner1.nextLine());
			}
			miArchivo.escribir(auxiliar3);
			break;
		case "4":
			Map<String, String> auxiliar4 = new HashMap<>();
			Scanner scanner1 = new Scanner(System.in);
			System.out.println("Introduzca el ID");
			auxiliar4.put("ID", scanner1.nextLine());
			System.out.println("Introduzca el Nombre");
			auxiliar4.put("Nombre", scanner1.nextLine());
			System.out.println("Introduzca la Raza");
			auxiliar4.put("Raza", scanner1.nextLine());
			System.out.println("Introduzca el Color");
			auxiliar4.put("Color", scanner1.nextLine());
			miBBDD.escribir(auxiliar4);
			break;
		case "5":
			miArchivo.escribir(miBBDD.leer());
			break;
		case "6":
			miBBDD.escribirTodos(miArchivo.leer());
			break;
		case "7":
			miHibernate.consultaGato();
			miHibernate.cerrarSesion();
			break;
		case "8":
			Scanner scanner2 = new Scanner(System.in);
			System.out.println("Introduzca el Nombre");
			String nombre = scanner2.nextLine();
			System.out.println("Introduzca la Raza");
			String raza = scanner2.nextLine();
			System.out.println("Introduzca el Color");
			String color = scanner2.nextLine();
			miHibernate.insertarGato(nombre, raza, color);
			miHibernate.cerrarSesion();
			break;
		case "9":
			miHibernate.borrarDatos();
			miHibernate.cerrarSesion();
			break;
		}

	}
}