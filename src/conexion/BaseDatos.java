package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDatos
{

	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/pokemon?serverTimezone=UTC";
	String login = "root";
	String password = "Studium2020;"; 
		
	public Connection connection = null;
	public Statement statement;
	public ResultSet rs;
	
	public BaseDatos(){}
	
	public Connection conectar()
	{
		try
		{
			//Cargar los controladores para el acceso a la BD
			Class.forName(driver);
			//Establecer la conexión con la BD Empresa
			connection = DriverManager.getConnection(url, login, password);
		}
		catch (ClassNotFoundException cnfe)
		{
			System.out.println("Error 1-"+cnfe.getMessage());
		}
		catch (SQLException sqle)
		{
			System.out.println("Error 2-"+sqle.getMessage());
		}
		return connection;
	}
	public void desconectar()
	{
		try {
			if(rs != null) {
				rs.close();
			}
			statement.close();
			connection.close();
		} catch(SQLException sqle) {
			System.out.println("Error al cerrar la conexion: "+sqle.getMessage());
		}
	}
}
