package es.studium.Pokemon2.Views;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;

public class VistaJuego extends Frame {

	private static final long serialVersionUID = 1L;
	
	Image bg, pokemon1, pokemon2;
	public String nombreP1, nombreP2;
	public String tipoPokemon1, tipoPokemon2;
	public String nombrePokemon1, nombrePokemon2;
	public double pokemon1Vida = 100;
	public double pokemon2Vida = 100;
	
	public boolean turno = true;
	
	Toolkit tk = getToolkit();

	String ataquesPidgeotto[] = {"Viento Afín","Danza Pluma","Tajo Aéreo","Vendaval"};
	String ataquesBulbasaur[] = {"Drenadoras","Látigo Cepa","Somnífero","Hoja Afilada"};
	String ataquesChansey[] = {"Doble Filo","Gruñido","Bomba Huevo","Doble Bofetón"};
	String ataquesCharmander[] = {"Colmillo Ígneo","Pirotecnia","Lanzallamas","Infierno"};
	String ataquesSquirtle[] = {"Pistola Agua","Hidropulso","Acua Cola","Hidrobomba"};
	
	public String ataquesP1[];
	public String ataquesP2[];
	
	
	
	public Dialog ganar = new Dialog(this, "FIN DE LA PARTIDA", false);
	public Label lblGanador = new Label();
	public Button btnSalir = new Button("Salir");
	public Button btnJugarDenuevo = new Button("Jugar de nuevo");

	
	
	/**
	 *  ==== Pidgeotto - AIRE =====
	 *  Viento Afín
	 *  Danza Pluma
	 *  Tajo Aéreo
	 *  Vendaval
	 * 
	 *  ==== Bulbasaur - PLANTA ====
	 *  Drenadoras
	 *  Látigo Cepa
	 *  Somnífero
	 *  Hoja Afilada
	 *  
	 *  ==== Chansey - NORMAL ====
	 *  Doble Filo
	 *  Gruñido
	 *  Bomba Huevo
	 *  Doble Bofetón
	 *  
	 *  ==== Charmander - FUEGO ====
	 *  Colmillo Ígneo
	 *  Pirotecnia
	 *  Lanzallamas
	 *  Infierno
	 *  
	 *  ==== Squirtle - AGUA ====
	 *  Pistola Agua
	 * 	Hidropulso
	 *  Acua Cola
	 *  Hidrobomba
	 * 
	 * MÁS DAÑO SI:
	 * 	Agua -> Fuego
	 * 	Fuego -> Planta
	 * 	
	 * 
	 */
	
	public VistaJuego(String nombreP1, String pokemonP1, String nombreP2, String pokemonP2)
	{
		
		this.nombreP1 = nombreP1;
		this.nombreP2 = nombreP2;
		this.nombrePokemon1 = pokemonP1;
		this.nombrePokemon2 = pokemonP2;
		
		
		// asignar tipos de pokemons
		// tambien se asignan los ataques de los pokemons
		switch (pokemonP1) {
	        case "Chansey":  tipoPokemon1 = "NORMAL"; ataquesP1 = ataquesChansey;
	        	break;
	        case "Bulbasaur":  tipoPokemon1 = "PLANTA"; ataquesP1 = ataquesBulbasaur;
	        	break;
	        case "Charmander":  tipoPokemon1 = "FUEGO"; ataquesP1 = ataquesCharmander;
	        	break;
	        case "Pidgeotto":  tipoPokemon1 = "AIRE"; ataquesP1 = ataquesPidgeotto;
	        	break;
	        case "Squirtle":  tipoPokemon1 = "AGUA"; ataquesP1 = ataquesSquirtle;
	        	break;
		}
		switch (pokemonP2) {
	        case "Chansey":  tipoPokemon2 = "NORMAL"; ataquesP2 = ataquesChansey;
	        	break;
	        case "Bulbasaur":  tipoPokemon2 = "PLANTA"; ataquesP2 = ataquesBulbasaur;
	        	break;
	        case "Charmander":  tipoPokemon2 = "FUEGO"; ataquesP2 = ataquesCharmander;
	        	break;
	        case "Pidgeotto":  tipoPokemon2 = "AIRE"; ataquesP2 = ataquesPidgeotto;
	        	break;
	        case "Squirtle":  tipoPokemon2 = "AGUA"; ataquesP2 = ataquesSquirtle;
	        	break;
		}
		
		
		setTitle("Dibujando...");
		setSize(1028, 670);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		
		// asignamos las imagenes de los pokemons
		// depende de que lado esté el pokeon, se elige una imagen en espejo o no
		bg = tk.getImage("bg1.jpg");
		pokemon1 = tk.getImage("pokemons/d-" + pokemonP1 + ".png");
		pokemon2 = tk.getImage("pokemons/i-" + pokemonP2 + ".png");
		
		// EL PANEL DE GAME OVER
		ganar.setLayout(new FlowLayout());
		ganar.add(lblGanador);
		ganar.add(btnSalir);
		ganar.add(btnJugarDenuevo);
		
		ganar.setSize(180, 100);
		ganar.setLocationRelativeTo(null);
		ganar.setResizable(false);
		
		
		
		
	}
	public void paint(Graphics g)
	{
		// rellenar todo de blanco/gris
		g.setColor(new Color(240,240,240));
		g.fillRect(0, 0, 1028, 670);
		// dibujar fondo imagen
		g.drawImage(bg, 0, 0, this);
		
		// dibujar pokemons
		g.drawImage(pokemon1, 140, 350, this);
		g.drawImage(pokemon2, 666, 150, this);
		
		// dibuja turno texto
		dibujarTurno(g);
		
		// dibujar barras de vida
		dibujarBarra(g, 100, 320, pokemon1Vida, nombreP1, tipoPokemon1);
		dibujarBarra(g, 600, 120, pokemon2Vida, nombreP2, tipoPokemon2);
		
		
		// dibujar botones de ataques
		if(turno == true) {
			dibujarAtaques(g, ataquesP1);
		} else {
			dibujarAtaques(g, ataquesP2);
		}
		
		//dibujar
		
	}
	
	// dibuja los 4 botones de ataques, segun el array de ataques asignado
	private void dibujarAtaques(Graphics g, String ataques[]) {
		Font font = new Font("Comic Sans", Font.PLAIN, 16);
		g.setFont(font);
		
		g.setColor(Color.black);
		g.fillRect(20, 590, 160, 60);
		g.setColor(Color.orange);
		g.fillRect(24, 594, 152, 52);
		g.setColor(Color.black);
		g.drawString(ataques[0], 40, 624);
		
		g.setColor(Color.black);
		g.fillRect(190, 590, 160, 60);
		g.setColor(Color.orange);
		g.fillRect(194, 594, 152, 52);
		g.setColor(Color.black);
		g.drawString(ataques[1], 210, 624);

		g.setColor(Color.black);
		g.fillRect(360, 590, 160, 60);
		g.setColor(Color.orange);
		g.fillRect(364, 594, 152, 52);
		g.setColor(Color.black);
		g.drawString(ataques[2], 380, 624);

		g.setColor(Color.black);
		g.fillRect(530, 590, 160, 60);
		g.setColor(Color.orange);
		g.fillRect(534, 594, 152, 52);
		g.setColor(Color.black);
		g.drawString(ataques[3], 550, 624);
	}

	// texto de qn es el turno
	private void dibujarTurno(Graphics g) {
		
		Font font = new Font("Comic Sans", Font.PLAIN, 30);
		g.setFont(font);
		g.setColor(Color.black);
		
		// segun el turno, se pone el nombre del jugador 1 o del 2
		if(turno == true) {
			g.drawString("Turno de: " + nombreP1, 30, 70);
		} else {
			g.drawString("Turno de: " + nombreP2, 30, 70);
		}
		
		
	}
	
	// se dibujan 2 circulos y luego un rectangulo entre estos dos. Todo en negro
	// se pinta lo mismo, pero más pequeño en blanco
	// se pinta la barra de vida según el porcentaje de vida
	private void dibujarBarra(Graphics g, int x, int y, double vida, String nombre, String tipoPokemon12) {
		// dibujar contorno
		g.setColor(new Color(50, 50, 50));
		g.fillOval(x, y, 20, 20);
		g.fillOval(x+300, y, 20, 20);
		g.fillRect(x+10, y, 300, 20);
		// zona blanca
		g.setColor(Color.white);
		g.fillRect(x+10, y+5, 300, 10);
		
		// si tiene poca vida se pone en rojo la barra
		g.setColor(Color.green);
		if(vida < 50)
		{
			g.setColor(Color.red);
		}
		// dibujar barra interior
		g.fillRect(x+10, y+5, (int)(300*(vida/100)), 10);
		
		// dibujar vida %
		// Creamos la fuente
		Font font = new Font("Comic Sans", Font.BOLD, 14);
		// Aplicamos la fuente
		g.setFont(font);
		g.setColor(new Color(50, 50, 50));
		g.drawString((vida)+"%", x+330, y + 15);
		
		// dibujar nombre
		font = new Font("Comic Sans", Font.PLAIN, 20);
		g.setFont(font);
		g.drawString(nombre + ": " + tipoPokemon12, x+25, y - 10);
		
	}

	
	
	

	
}
