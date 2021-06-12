package es.studium.Pokemon2.Models;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import conexion.BaseDatos;
import es.studium.Pokemon2.Views.VistaJuego;


public class ModeloJuego {


	private VistaJuego vistaJuego;
	public ModeloJuego(VistaJuego vistaJuego) {
		this.vistaJuego = vistaJuego;
	} 
	

	public int turnos = 0;
	double daño = 0;
	double potenciador = 0;
	
	// cuando haces click en algún botón de ataque
	public void clickAtaque(int i) {

		String audio = "";
		
		// daño de 5 a 20 de manera aletorio
		daño = 5 + (Math.random() * 15); 

		
		// según que turno sea, se le quita daño a un pokemón u otro
		if(vistaJuego.turno == true) {
			
			// segun el tipo del pokemon del turno, se le pone un audio
			audio = vistaJuego.tipoPokemon1;
			
			// detectar potenciador
			// con tipo agua haces más daño a fuego, y con fuego haces más daño a Planta
			if(vistaJuego.tipoPokemon1 == "AGUA" && vistaJuego.tipoPokemon2 == "FUEGO") {
				potenciador = 0.20;
			} else if(vistaJuego.tipoPokemon1 == "FUEGO" && vistaJuego.tipoPokemon2 == "PLANTA") {
				potenciador = 0.10;
			} else {
				potenciador = 0;
			}
			
			// aplicar daño
			daño = daño + (daño*potenciador);
			vistaJuego.pokemon2Vida = vistaJuego.pokemon2Vida - ((int)daño);
			
			// cambiar turno
			vistaJuego.turno = false;
			
		} else {
			
			// segun el tipo del pokemon del turno, se le pone un audio
			audio = vistaJuego.tipoPokemon2;
			
			// detectar potenciador
			// con tipo agua haces más daño a fuego, y con fuego haces más daño a Planta
			if(vistaJuego.tipoPokemon1 == "FUEGO" && vistaJuego.tipoPokemon2 == "AGUA") {
				potenciador = 0.20;
			} else if(vistaJuego.tipoPokemon1 == "PLANTA" && vistaJuego.tipoPokemon2 == "FUEGO") {
				potenciador = 0.10;
			} else {
				potenciador = 0;
			}
			
			// aplicar daño
			daño = daño + (daño*potenciador);
			vistaJuego.pokemon1Vida = vistaJuego.pokemon1Vida - ((int)daño);
			
			// cambiar turno
			vistaJuego.turno = true;
			
		}
		
		turnos = turnos+1;
		
		// no números negativos
		if(vistaJuego.pokemon1Vida < 0)
		{
			vistaJuego.pokemon1Vida = 0;
		}
		if(vistaJuego.pokemon2Vida < 0)
		{
			vistaJuego.pokemon2Vida = 0;
		}
		
		
		
		// hacer que suene el sonido elegido
		File sf = new File("./sonidos/"+audio+".wav");

		try {
			//cargar el audio y hacerlo sonar
			AudioFileFormat audioFileFormat = AudioSystem.getAudioFileFormat(sf);
			AudioInputStream ais = AudioSystem.getAudioInputStream(sf);
			AudioFormat af = audioFileFormat.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, ais.getFormat(), ((int) ais.getFrameLength() * af.getFrameSize()));
			Clip ol = (Clip) AudioSystem.getLine(info);
			ol.open(ais);
			ol.loop(1);

			// Damos tiempo para que el sonido sea escuchado
			Thread.sleep(1500);
			ol.close();

		} catch (UnsupportedAudioFileException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (LineUnavailableException LUE) {
			System.out.println(LUE.getMessage());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// pintamos para actualizar los datos, turno y vidas.
		vistaJuego.repaint();
		
		// si gana el juegador 1
		if(vistaJuego.pokemon1Vida <= 1) {
			
			// insertar en la base de datos la partida
			insertarPartida(vistaJuego.nombreP2, vistaJuego.nombreP1, vistaJuego.nombrePokemon2, (int) vistaJuego.pokemon2Vida);
			
			vistaJuego.lblGanador.setText(vistaJuego.nombreP2 + " ha ganado!");
			vistaJuego.ganar.setVisible(true);
			
		}
		// si gana el jugador 2
		if(vistaJuego.pokemon2Vida <= 0) {
			
			// insertar en la base de datos la partida
			insertarPartida(vistaJuego.nombreP1, vistaJuego.nombreP2, vistaJuego.nombrePokemon1, (int) vistaJuego.pokemon1Vida);
			
			vistaJuego.repaint();
			vistaJuego.lblGanador.setText(vistaJuego.nombreP1 + " ha ganado!");
			vistaJuego.ganar.setVisible(true);
			
		}
		
	}
	
	BaseDatos con = new BaseDatos();
	// insertar en la base de datos la partida
	private void insertarPartida(String nombreGanador, String nombrePerdedor, String nombrePokemon, int tipoPokemon) {
		System.out.println("ola");
		try {

			String sentencia = "INSERT INTO partidas VALUES(NULL, '" + nombreGanador + "' , '" + nombrePerdedor + "' , " + turnos + " , '" + nombrePokemon + "' , " + tipoPokemon + "  )";
			System.out.println(sentencia);
			
			// conectamos a la base de datos
			con.connection = con.conectar();
			con.statement = con.connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			con.statement.executeUpdate(sentencia);

		} catch (SQLException sqle) {
			System.out.println("Error 2-" + sqle.getMessage());
		} finally {
			con.desconectar();
		}
	}
	



}
