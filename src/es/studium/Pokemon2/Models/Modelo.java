package es.studium.Pokemon2.Models;

import java.awt.TextArea;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexion.BaseDatos;

public class Modelo {

	public Modelo(TextArea ta) {

		ta.setText("Cargando...");
		BaseDatos con = new BaseDatos();
		String texto = "Ganador\t Perdedor\t Turnos\t Pokemon\t Vida Restante\n";
		
		try {

			String sentencia = "SELECT * FROM partidas ORDER BY n_turnosPartida, vidaPartida DESC LIMIT 10;";
			con.connection = con.conectar();
			con.statement = con.connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			con.rs = con.statement.executeQuery(sentencia);

			while (con.rs.next()) {

				// añadimos al array los datos
				texto = texto + con.rs.getString("nombreJugadorGanaPartida") + "\t";
				texto = texto + con.rs.getString("nombreJugadorPierdePartida") + "\t";
				texto = texto + con.rs.getString("n_turnosPartida") + "\t";
				texto = texto + con.rs.getString("pokemonPartida") + "\t";
				texto = texto + con.rs.getString("vidaPartida") + "\n";

			}

		} catch (SQLException sqle) {
			System.out.println("Error 2-" + sqle.getMessage());
		} finally {
			ta.setText(texto);
			con.desconectar();
		}
		
	}
}
