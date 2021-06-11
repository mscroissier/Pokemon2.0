package es.studium.Pokemon2.Models;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.BaseDatos;


public class ModeloJugador {


	public Connection con = null;

	public ResultSet rs = null;
	public Statement stmt = null;
	
	
	
	int id;
	String nombre;
	int idPokemon;
	int nPartidas;

	

	public ModeloJugador() {
		
	} 
	
	public  ArrayList<ModeloJugador> getAllPLayers(){
	
	
		
		ArrayList<ModeloJugador> listaJugadores = new ArrayList<ModeloJugador>() ; 		
	
		try
		{
			BaseDatos bd = new BaseDatos();
			// Conectar BD
			Connection connection = bd.conectar();

			//Crear una sentencia
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			//Crear un objeto ResultSet para guardar lo obtenido
			//y ejecutar la sentencia SQL
			String  sentencia = " SELECT * FROM Jugadores ";
			rs = statement.executeQuery(sentencia);
			while(rs.next())
			{
				ModeloJugador jugador = new ModeloJugador();
				jugador.setId(rs.getInt("idJugadores"));
				jugador.setNombre(rs.getString("nombreJugador"));
				jugador.setnPartidas(rs.getInt("n_partidasGanadas"));
				jugador.setIdPokemon(rs.getInt("idPokemonFK"));
				listaJugadores.add(jugador);				
			}
		}
		catch (SQLException sqle)
		{
			sqle.printStackTrace();
			System.out.println("Error 1-"+sqle.getMessage());

		}
		
		
		
		
		return listaJugadores;
	}
	
	
	
	public ModeloJugador getJugadorPorNombre(String nombre) {
		ModeloJugador jugador = null; 		
		
		try
		{
			BaseDatos bd = new BaseDatos();
			// Conectar BD
			Connection connection = bd.conectar();

			//Crear una sentencia
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			//Crear un objeto ResultSet para guardar lo obtenido
			//y ejecutar la sentencia SQL
			String  sentencia = " SELECT * FROM Jugadores WHERE nombreJugador LIKE "+" \" "+ nombre+ "\"" ;
			rs = statement.executeQuery(sentencia);
			while(rs.next())
			{
				jugador.setId(rs.getInt("idJugadores"));
				jugador.setNombre(rs.getString("nombreJugador"));
				jugador.setnPartidas(rs.getInt("n_partidasGanadas"));
				jugador.setIdPokemon(rs.getInt("idPokemonFK"));
							
			}
		}
		catch (SQLException sqle)
		{
			sqle.printStackTrace();
			System.out.println("Error 1-"+sqle.getMessage());

		}
		
	
		return jugador;
		
		
	}
	
	
	
	
	
	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public String getNombre() {
		return nombre;
	}





	public void setNombre(String nombre) {
		this.nombre = nombre;
	}





	public int getIdPokemon() {
		return idPokemon;
	}





	public void setIdPokemon(int idPokemon) {
		this.idPokemon = idPokemon;
	}





	public int getnPartidas() {
		return nPartidas;
	}





	public void setnPartidas(int nPartidas) {
		this.nPartidas = nPartidas;
	}





}
