import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BBDD implements AccesoDatos {
	
	public void escribir(Map<String, String> lista) throws SQLException {
		ConexionBBDD miConexion = new ConexionBBDD();
		miConexion.conectar();
		int r = 0;
		String cadSQL = null;
		cadSQL = "INSERT INTO gatos VALUES (" + lista.get("ID") + ", '" + lista.get("Nombre") + "', '" + lista.get("Raza") + "', '" + lista.get("Color") + "')";
		r = miConexion.stmt.executeUpdate(cadSQL);
		System.out.println(r + " registro agregado.");
	}

	public Map<String, String> leer() {
		Map<String, String> auxiliar = new HashMap<>();
		// Código concreto para leer datos de una BBDD
		Configuracion config = new Configuracion();
		ConexionBBDD connection = new ConexionBBDD();
		connection.conectar();
		try {
			while (connection.rset.next()) {
				auxiliar.put("ID", connection.rset.getString(1));
				auxiliar.put("Nombre", connection.rset.getString(2));
				auxiliar.put("Raza", connection.rset.getString(3));
				auxiliar.put("Color", connection.rset.getString(4));
				auxiliar.entrySet().forEach(entry->{
				    System.out.println(entry.getValue());  
				 });
				System.out.println("######");
				System.out.println();
			}
		} catch (SQLException s) {
			s.printStackTrace();
		}
		
		return auxiliar;
	}
}