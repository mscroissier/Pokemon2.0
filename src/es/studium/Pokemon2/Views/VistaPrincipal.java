package es.studium.Pokemon2.Views;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;


public class VistaPrincipal extends Frame
{
	//Menu principal
	private static final long serialVersionUID = 1L;
	Label lblMenuPrincipal = new Label("Menú Principal", 1);
	Panel pnlBotones = new Panel();
	Panel pnlBtnSalir = new Panel();
	public Button btnPartidaNueva = new Button("Partida Nueva");
	public Button btnRanking = new Button("Ranking");
	public Button btnAyuda = new Button("Ayuda");


	public VistaPrincipal()
	{
		setTitle("Pokemon");

		setLayout(new FlowLayout());
		add(lblMenuPrincipal);
		setBackground(new Color(250, 250, 250));
		//pnlBotones.setLayout(new GridLayout(3,1));
		
		// la clase Font, para añadirle formato al texto, como su Fuente, estilo y tamaño
		lblMenuPrincipal.setFont(new Font("Arial", 1, 24));
		
		// la función setPreferredSize(), le da un tamaño a Componentes como botones
		// se el pasa por argumento la clase Dimenison, y esta tiene el ancho y alto
		lblMenuPrincipal.setPreferredSize(new Dimension(300, 80));
		btnPartidaNueva.setPreferredSize(new Dimension(300, 40));
		btnRanking.setPreferredSize(new Dimension(300, 40));
		btnAyuda.setPreferredSize(new Dimension(300, 40));
		add(btnPartidaNueva);
		add(btnRanking);
		add(btnAyuda);

		setSize(400,300);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);


	}
}

