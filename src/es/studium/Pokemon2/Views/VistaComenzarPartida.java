package es.studium.Pokemon2.Views;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.util.ArrayList;

import es.studium.Pokemon2.Models.ModeloJugador;


public class VistaComenzarPartida extends Frame
{
	private static final long serialVersionUID = 1L;

	//Partida Nueva
	
	Dialog pedirNombreJugador1 = new Dialog(this, "Pokemon: Partida Nueva", true);
	Dialog pedirNombreJugador2 = new Dialog(this, "Pokemon: Partida Nueva", true);
	Dialog pedirDatosJ1Nuevo = new Dialog(this, "Pokemon: Partida Nueva", true);
	Dialog pedirDatosJ2Nuevo = new Dialog(this, "Pokemon: Partida Nueva", true);


	static ModeloJugador  jugador1 ;
	
	//Para los nuevos jugadores:	
	String[] nombresJugadores = null;

	TextField txfNombre1 = new TextField(15);
	Label lblEtiqueta1 = new Label("Jugador 1: ");
	

	TextField txfNombre2 = new TextField(15);
	Label lblEtiqueta2 = new Label("Jugador 2: ");
	
	Label lblNombre = new Label("Ingresa tu nombre: ");
	
	Label lblPokemon = new Label("Elige Pokemon: ");
	Choice choPokemon = new Choice();

	//Para antiguos jugadores:

	Label lblSeleccion = new Label("Selecciona jugador: ");
	public static  Choice choJugador = new Choice();
	Button btnNuevo = new Button("Soy Nuevo");
	public static Button btnContinuar = new Button("Continuar"); //solo para jugador 1
	Button btnComenzar = new Button("Comenzar Partida");

	

	public VistaComenzarPartida()
	{
		
		setTitle("Pokemon: Comenzar partida");
		
	//Jugador1 antiguo
		pedirNombreJugador1.setLayout(new FlowLayout());
		pedirNombreJugador1.setSize(240,200);
		pedirNombreJugador1.setLocationRelativeTo(null);
		pedirNombreJugador1.setResizable(false);

		pedirNombreJugador1.add(lblEtiqueta1);
		pedirNombreJugador1.add(lblSeleccion);
		
		ModeloJugador modelo = new ModeloJugador();
		
		ArrayList<ModeloJugador> listaJugadores = modelo.getAllPLayers(); 	
		
		for( ModeloJugador j :listaJugadores) {
			choJugador.addItem(j.getNombre());
		}
	
		
		pedirNombreJugador1.add(choJugador);
		pedirNombreJugador1.add(btnNuevo);
		pedirNombreJugador1.add(btnContinuar);
		
		this.MostrarDialogNombreJugador1(); 

		
	//Jugador2 antiguo
		pedirNombreJugador2.setLayout(new FlowLayout());
		pedirNombreJugador2.setSize(240,200);
		pedirNombreJugador2.setLocationRelativeTo(null);
		pedirNombreJugador2.setResizable(false);

		pedirNombreJugador2.add(lblEtiqueta2);
		pedirNombreJugador2.add(lblSeleccion);
		pedirDatosJ2Nuevo.add(choJugador);
		pedirNombreJugador2.add(btnNuevo);
		pedirNombreJugador2.add(btnComenzar);		
	//	this.MostrarDialogNombreJugador2(); 

	//Jugador1 Nuevo
		pedirDatosJ1Nuevo.setLayout(new FlowLayout());
		pedirDatosJ1Nuevo.setSize(240,200);
		pedirDatosJ1Nuevo.setLocationRelativeTo(null);
		pedirDatosJ1Nuevo.setResizable(false);

		pedirDatosJ1Nuevo.add(lblNombre);
		txfNombre1.selectAll();
		txfNombre1.setText("");
		pedirDatosJ1Nuevo.add(txfNombre1);
		pedirDatosJ1Nuevo.add(lblPokemon);
		pedirDatosJ2Nuevo.add(choPokemon);
		pedirDatosJ1Nuevo.add(btnContinuar);		
		//this.MostrarDialogNuevoJ1(); 
		
	//Jugador1 Nuevo
		pedirDatosJ2Nuevo.setLayout(new FlowLayout());
		pedirDatosJ2Nuevo.setSize(240,200);
		pedirDatosJ2Nuevo.setLocationRelativeTo(null);
		pedirDatosJ2Nuevo.setResizable(false);

		pedirDatosJ2Nuevo.add(lblNombre);
		txfNombre2.selectAll();
		txfNombre2.setText("");
		pedirDatosJ2Nuevo.add(txfNombre2);
		pedirDatosJ2Nuevo.add(lblPokemon);
		pedirDatosJ2Nuevo.add(choPokemon);
		pedirDatosJ2Nuevo.add(btnContinuar);		
		//this.MostrarDialogNuevoJ2(); 
		
	}

	public void MostrarPrincipal()
	{
		this.setVisible(true);
	}
	public void OcultarPrincipal()
	{
		this.setVisible(false);	
	}
	
	
	//Antiguos jugadores
	public void MostrarDialogNombreJugador1()
	{
		pedirNombreJugador1.setVisible(true);
	}
	public void OcultarDialogNombreJugador1()
	{
		pedirNombreJugador1.setVisible(false);
	}

	public void MostrarDialogNombreJugador2()
	{
		pedirNombreJugador2.setVisible(true);
	}
	public void OcultarDialogNombreJugador2()
	{
		pedirNombreJugador2.setVisible(false);
	}

	
	//Nuevos jugadores
	public void MostrarDialogNuevoJ1()
	{
		pedirDatosJ1Nuevo.setVisible(true);
	}
	public void OcultarDialogNuevoJ1()
	{
		pedirDatosJ1Nuevo.setVisible(false);
	}

	public void MostrarDialogNuevoJ2()
	{
		pedirDatosJ2Nuevo.setVisible(true);
	}
	public void OcultarDialogNuevoJ2()
	{
		pedirDatosJ2Nuevo.setVisible(false);
	}


	
	public static ModeloJugador getJugador1() {
		
		String nombreJugador1 = choJugador.getSelectedItem();
		ModeloJugador  jugador = new ModeloJugador();
		jugador1  =  jugador.getJugadorPorNombre(nombreJugador1);
		return jugador1;
		
	}
}

