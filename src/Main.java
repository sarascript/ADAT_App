import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws SQLException, IOException {

		Archivo miArchivo = new Archivo();
		BBDD miBBDD = new BBDD();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Elija una opción: ");
		System.out.println("1: Leer archivo");
		System.out.println("2: Leer base de datos");
		System.out.println("3: Escribir archivo por consola");
		System.out.println("4: Escribir base de datos por consola");
		System.out.println("5: Escribir archivo desde base de datos");
		System.out.println("6: Escribir base de datos desde archivo");
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
			
			miBBDD.escribir(auxiliar4);
			break;
		case "5":
			Map<String, String> auxiliar5 = new HashMap<>();
			miBBDD.leer();
			miArchivo.escribir(auxiliar5);
			break;
		case "6":
			Map<String, String> auxiliar6 = new HashMap<>();
			miArchivo.leer();
			miBBDD.escribir(auxiliar6);
			break;
		}

	}
}