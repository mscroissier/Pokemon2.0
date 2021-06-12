package es.studium.Pokemon2.Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import es.studium.Pokemon2.Models.Modelo;
import es.studium.Pokemon2.Models.ModeloJuego;
import es.studium.Pokemon2.Views.VistaComenzarPartida;
import es.studium.Pokemon2.Views.VistaPrincipal;
import es.studium.Pokemon2.Views.VistaRanking;


public class ClaseControlador implements WindowListener, ActionListener {

	VistaPrincipal vistaPrincipal;
	VistaComenzarPartida vistaComenzarPartida;
	
	ModeloJuego jugador1;
	ModeloJuego jugador2;
	
	
	public ClaseControlador(VistaPrincipal vista)
	{
		vistaPrincipal = vista;
		vistaPrincipal.addWindowListener(this);
		
		vistaPrincipal.btnPartidaNueva.addActionListener(this);
		vistaPrincipal.btnRanking.addActionListener(this);
		vistaPrincipal.btnSalir.addActionListener(this);		
	}
	

	@Override
	public void actionPerformed(ActionEvent btn) {
		// TODO Auto-generated method stub
		Object btnPulsado = btn.getSource();
		
		if (btnPulsado.equals(vistaPrincipal.btnPartidaNueva))
		{
			new ControladorDatos(new VistaComenzarPartida()); 
		}
		
	
		/*if (btnPulsado.equals(vistaComenzarPartida.btnContinuar))
		{
			
			ModeloJugador nombreJugador1 = VistaComenzarPartida.getJugador1();
			vistaComenzarPartida.OcultarDialogNombreJugador1();
			//vistaComenzarPartida.MostrarDialogNombreJugador2();
			
		}*/
		
		
		//Salir 
		if (btnPulsado.equals(vistaPrincipal.btnRanking))
		{
			VistaRanking vistaRanking = new VistaRanking();
			new ControladorRanking(vistaRanking, new Modelo(vistaRanking.taRanking) );
		}
		if (btnPulsado.equals(vistaPrincipal.btnSalir))
		{
			System.exit(0);
		}
		
		
	}

	public void eventsChoosePlayers() {
		
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
	
	public VistaComenzarPartida  getVistaContinuarPartida() {
		return this.vistaComenzarPartida;
	}
}
