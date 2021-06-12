package es.studium.Pokemon2.Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import es.studium.Pokemon2.Models.ModeloJuego;
import es.studium.Pokemon2.Views.VistaComenzarPartida;
import es.studium.Pokemon2.Views.VistaJuego;

public class ControladorComenzarPartida implements WindowListener, ActionListener {

	VistaComenzarPartida vistaComenzarPartida;
	public ControladorComenzarPartida(VistaComenzarPartida vista) {
		vistaComenzarPartida = vista;
		
		vistaComenzarPartida.addWindowListener(this);
		vistaComenzarPartida.btnJugar.addActionListener(this);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		Object btnPulsado = e.getSource();
		
		if (btnPulsado.equals(vistaComenzarPartida.btnJugar))
		{
			// a la vista le pasamos los datos de lo jugadores y sus pokemons
			VistaJuego vistaJuego = new VistaJuego(
					vistaComenzarPartida.tfNombreJugador1.getText(),
					vistaComenzarPartida.choPokemonJugador1.getSelectedItem(),
					vistaComenzarPartida.tfNombreJugador2.getText(),
					vistaComenzarPartida.choPokemonJugador2.getSelectedItem());
			// al ModeloJuego, le pasamos la vistaJuego, para que cambie datos de esta, como por ejemplo el turno
			// o la vida de los pokemons
			new ControladorJuego(vistaJuego, new ModeloJuego(vistaJuego)); 
		}
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		vistaComenzarPartida.setVisible(false);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}