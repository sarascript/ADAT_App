import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Configuracion {

	public static Map<String, String> Configuracion() {
		Map<String, String> config = new HashMap<>();
		Properties properties = new Properties();
		InputStream entry = null;

		try {
			File ini = new File("src/configuracion.ini");
			if (ini.exists()) {
				entry = new FileInputStream(ini);
				// cargamos el archivo de propiedades
				properties.load(entry);
				// obtenemos las propiedades
				config.put("bd", properties.getProperty("basedatos"));
				config.put("user", properties.getProperty("usuario"));
				config.put("pwd", properties.getProperty("clave"));
				config.put("file", properties.getProperty("fichero"));
			} else
				System.err.println("File not found");
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (entry != null) {
				try {
					entry.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(config);
		
		return config;	
	}

	public static void main(String[] args) {
		Configuracion();
	}
	
}