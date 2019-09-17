import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

public interface AccesoDatos {
	
	public Map<String, String> leer();

	public void escribir(Map<String, String> lista) throws SQLException, IOException;
	
}