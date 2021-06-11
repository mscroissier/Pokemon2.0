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


public class VistaPrincipal extends Frame
{
	//Menu principal
	private static final long serialVersionUID = 1L;
	Label lblMenuPrincipal = new Label("Menú Principal", 1);
	Panel pnlBotones = new Panel();
	Panel pnlBtnSalir = new Panel();
	public Button btnPartidaNueva = new Button("Partida Nueva");
	public Button btnRanking = new Button("Ranking");
	Button btnAyuda = new Button("Ayuda");
	public Button btnSalir = new Button("Salir");

	//Partida Nueva
	/*
	Dialog pedirNombreJugador1 = new Dialog(this, "Pokemon: Partida Nueva", true);
	Dialog pedirNombreJugador2 = new Dialog(this, "Pokemon: Partida Nueva", true);
	Dialog pedirDatosJ1Nuevo = new Dialog(this, "Pokemon: Partida Nueva", true);
	Dialog pedirDatosJ2Nuevo = new Dialog(this, "Pokemon: Partida Nueva", true);

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
	Choice choJugador = new Choice();
	Button btnNuevo = new Button("Soy Nuevo");
	Button btnContinuar = new Button("Continuar"); //solo para jugador 1
	Button btnComenzar = new Button("Comenzar Partida");
*/

	public VistaPrincipal()
	{
		setTitle("Pokemon");

		setLayout(new GridLayout(3,2));
		add(lblMenuPrincipal);
		pnlBotones.setLayout(new GridLayout(3,1));

		pnlBotones.add(btnPartidaNueva);
		pnlBotones.add(btnRanking);
		pnlBotones.add(btnAyuda);
		add(pnlBotones,"Center");
		pnlBtnSalir.add(btnSalir);
		add(pnlBtnSalir,"South");

		setSize(400,200);
		setLocationRelativeTo(null);
		setResizable(false);
		MostrarPrincipal();


		/*
		setTitle("Pokemon: Comenzar partida");
	//Jugador1 antiguo
		pedirNombreJugador1.setLayout(new FlowLayout());
		pedirNombreJugador1.setSize(240,200);
		pedirNombreJugador1.setLocationRelativeTo(null);
		pedirNombreJugador1.setResizable(false);

		pedirNombreJugador1.add(lblEtiqueta1);
		pedirNombreJugador1.add(lblSeleccion);
		pedirDatosJ2Nuevo.add(choJugador);
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
		this.MostrarDialogNombreJugador2(); 

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
		this.MostrarDialogNuevoJ1(); 
		
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
		this.MostrarDialogNuevoJ2(); 
		*/
	}

	public void MostrarPrincipal()
	{
		this.setVisible(true);
	}
	public void OcultarPrincipal()
	{
		this.setVisible(false);	
	}
	
	/*
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

*/
	
}

