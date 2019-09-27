import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Archivo implements AccesoDatos {

	public void escribir(Map<String, String> lista) throws IOException {
		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter("src/gatos.txt", true);
			pw = new PrintWriter(fichero);
			pw.println(lista.get("ID"));
			pw.println(lista.get("Nombre"));
			pw.println(lista.get("Raza"));
			pw.println(lista.get("Color"));
			pw.println("######");
			pw.println("");
			System.out.println("1 registro agregado.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Nuevamente aprovechamos el finally para
				// asegurarnos que se cierra el fichero.
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public Map<String, String> leer() {
		// Código concreto para leer datos de un fichero
		Configuracion config = new Configuracion();
		Map<String, String> auxiliar = new HashMap<>();
		FileReader fr = null;
		BufferedReader br = null;

		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			File archivo = new File("src/gatos.txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			// Lectura del fichero
			String linea = "";
			while ((linea = br.readLine()) != null) {
				auxiliar.put("ID", linea);
				auxiliar.put("Nombre", linea);
				auxiliar.put("Raza", linea);
				auxiliar.put("Color", linea);
				System.out.println(linea);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta
			// una excepcion.
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return auxiliar;
	}
}