package es.studium.Pokemon2.Models;

import java.sql.ResultSet;
import java.sql.SQLException;

import conexion.BaseDatos;

public class ModeloRanking {

	public ModeloRanking() 
	{
		
	}
	
	public String cargarRanking()
	{

		BaseDatos con = new BaseDatos();
		// parte de arriba de la tabla
		String texto = "Ganador\t Perdedor\t Turnos\t Pokemon\t Vida Restante\n";
		
		try {
			
			// selecciona según el que menos turnos y más vida tenga
			String sentencia = "SELECT * FROM partidas ORDER BY n_turnosPartida, vidaPartida DESC LIMIT 10;";
			con.connection = con.conectar();
			con.statement = con.connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			con.rs = con.statement.executeQuery(sentencia);

			// en un string añadimos los datos de cada fila de la tabla de la base de datos
			while (con.rs.next()) {

				// añadimos al array los datos
				texto = texto + con.rs.getString("nombreJugadorGanaPartida") + "\t";
				texto = texto + con.rs.getString("nombreJugadorPierdePartida") + "\t";
				texto = texto + con.rs.getString("n_turnosPartida") + "\t";
				texto = texto + con.rs.getString("pokemonPartida") + "\t";
				texto = texto + con.rs.getString("vidaPartida") + "\n";

			}

		} catch (SQLException sqle) 
		{
			System.out.println("Error 2-" + sqle.getMessage());
		} 
		finally 
		{
			con.desconectar();
		}
		return texto;
	}
	
}
