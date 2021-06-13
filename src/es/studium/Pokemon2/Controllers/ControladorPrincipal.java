package es.studium.Pokemon2.Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import es.studium.Pokemon2.Models.ModeloRanking;
import es.studium.Pokemon2.Models.ModeloJuego;
import es.studium.Pokemon2.Views.VistaComenzarPartida;
import es.studium.Pokemon2.Views.VistaPrincipal;
import es.studium.Pokemon2.Views.VistaRanking;


public class ControladorPrincipal implements WindowListener, ActionListener {

	VistaPrincipal vistaPrincipal;
	VistaComenzarPartida vistaComenzarPartida;
	
	ModeloJuego jugador1;
	ModeloJuego jugador2;
	
	
	public ControladorPrincipal(VistaPrincipal vista)
	{
		vistaPrincipal = vista;
		vistaPrincipal.addWindowListener(this);
		
		vistaPrincipal.btnPartidaNueva.addActionListener(this);
		vistaPrincipal.btnRanking.addActionListener(this);
		vistaPrincipal.btnAyuda.addActionListener(this);		
	}
	

	@Override
	public void actionPerformed(ActionEvent btn) {
		// TODO Auto-generated method stub
		Object btnPulsado = btn.getSource();
		
		// botón de Partida Nueva
		if (btnPulsado.equals(vistaPrincipal.btnPartidaNueva))
		{
			// nuevo Modelo Vista-Controlador para la asignación de nombres y pokemons
			new ControladorComenzarPartida(new VistaComenzarPartida()); 
		}
		
		// ranking 
		if (btnPulsado.equals(vistaPrincipal.btnRanking))
		{
			// nuevo Modelo Vista-Controlador para el ranking
			VistaRanking vistaRanking = new VistaRanking();
			ModeloRanking modeloRanking = new ModeloRanking();
			new ControladorRanking(vistaRanking, modeloRanking );
		}
		// ayuda
		if (btnPulsado.equals(vistaPrincipal.btnAyuda))
		{
			// esto abre el Manual de Usuario a modo de Ayuda
			try {
				Runtime.getRuntime().exec("hh.exe musuario.chm");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		
	}
	
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		System.exit(0);
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
