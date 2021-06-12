package es.studium.Pokemon2.Views;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;


public class VistaComenzarPartida extends Frame
{
	private static final long serialVersionUID = 1L;
	
	// cosas para el Jugador1
	Panel pnlJugador1 = new Panel();
	Label lblNombreJugador1 = new Label("Nombre jugador 1:");
	public TextField tfNombreJugador1 = new TextField(20);	
	Label lblPokemonJugador1 = new Label("Pokemon jugador 1:");
	public Choice choPokemonJugador1 = new Choice();
	
	// cosas para el Jugador2
	Panel pnlJugador2 = new Panel();
	Label lblNombreJugador2 = new Label("Nombre jugador 2:");
	public TextField tfNombreJugador2 = new TextField(20);
	Label lblPokemonJugador2 = new Label("Pokemon jugador 2:");
	public Choice choPokemonJugador2 = new Choice();
	
	public Button btnJugar = new Button("JUGAR!");

	
	public VistaComenzarPartida()
	{
		
		setTitle("Pokemon: Comenzar partida");
		setLayout(new FlowLayout());
		setSize(240,420);
		setLocationRelativeTo(null);
		setResizable(false);
		setBackground(new Color(250, 250, 250));
		
		
		// llenar los choices y añadir los TextFields y Choices
		// la función setPreferredSize(), le da un tamaño a Componentes como botones
		// se el pasa por argumento la clase Dimenison, y esta tiene el ancho y alto
		llenarChoicePokemon(choPokemonJugador1);
		pnlJugador1.setBackground(new Color(240, 240, 240));
		pnlJugador1.setPreferredSize(new Dimension(200, 160));
		pnlJugador1.add(lblNombreJugador1);
		pnlJugador1.add(tfNombreJugador1);
		pnlJugador1.add(lblPokemonJugador1);
		pnlJugador1.add(choPokemonJugador1);
		add(pnlJugador1);
		
		llenarChoicePokemon(choPokemonJugador2);
		pnlJugador2.setBackground(new Color(240, 240, 240));
		pnlJugador2.setPreferredSize(new Dimension(200, 160));
		pnlJugador2.add(lblNombreJugador2);
		pnlJugador2.add(tfNombreJugador2);
		pnlJugador2.add(lblPokemonJugador2);
		pnlJugador2.add(choPokemonJugador2);
		add(pnlJugador2);
		
		// le damos un tamaño al botón
		btnJugar.setPreferredSize(new Dimension(200, 40));
		add(btnJugar);
		
		setVisible(true);
		
	}
	
	// lista de pokemons
	private String[] nombresPokemons = {"Chansey","Bulbasaur","Charmander","Pidgeotto","Squirtle"};
	
	private void llenarChoicePokemon(Choice ch) {
		// rellena los Choices segun los datos de nombresPokemon
		for(int i = 0; i < nombresPokemons.length; i++) {
			ch.addItem(nombresPokemons[i]);
		}
	}
	
}

