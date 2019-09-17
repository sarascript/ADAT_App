import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class ConexionBBDD {

	static String bd = "gatos";
	static String login = "root";
	static String pwd = "";
	static String url = "jdbc:mysql://localhost/" + bd
			+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	static Connection conexion;
	static Statement stmt;
	static ResultSet rset;
	
	public static void conectar() {
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection(url, login, pwd);
			// Quitamos esta instrucción: conexion.close();
			System.out.println(" - Conexión con MySQL establecida -");
			
			String query = "SELECT * FROM `gatos`";
			stmt = conexion.createStatement();
			rset = stmt.executeQuery(query);
			
		} catch (Exception e) {
			System.out.println(" – Error de Conexión con MySQL -");
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		conectar();
	}

}