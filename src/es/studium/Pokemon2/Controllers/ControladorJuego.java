package es.studium.Pokemon2.Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import es.studium.Pokemon2.Models.ModeloJuego;
import es.studium.Pokemon2.Views.VistaJuego;

public class ControladorJuego implements WindowListener, ActionListener, MouseListener {

	VistaJuego vistaJuego;
	ModeloJuego modeloJuego;
	
	public ControladorJuego(VistaJuego vista, ModeloJuego modeloJuego) {
		
		vistaJuego = vista;
		this.modeloJuego = modeloJuego;
		
		vistaJuego.btnSalir.addActionListener(this);
		vistaJuego.btnJugarDenuevo.addActionListener(this);
		vistaJuego.addWindowListener(this);
		vistaJuego.addMouseListener(this);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object btnPulsado = e.getSource();
		
		// botón de salir al ganar/perder
		if (btnPulsado.equals(vistaJuego.btnSalir))
		{
			System.exit(0);
		}
		// jugar de nuevo
		if (btnPulsado.equals(vistaJuego.btnJugarDenuevo))
		{
			vistaJuego.setVisible(false);
		}
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {

		int x = e.getX();
		int y = e.getY();
				
		// si hace click en algún de los 4 ataques del pokemon
		if( (x > 20 && x < 160) && (y > 590 && y < 650) ) 
		{
			modeloJuego.clickAtaque(0);
		}
		if( (x > 190 && x < 330) && (y > 590 && y < 650) ) 
		{
			modeloJuego.clickAtaque(1);
		}
		if( (x > 360 && x < 510) && (y > 590 && y < 650) ) 
		{
			modeloJuego.clickAtaque(2);
		}
		if( (x > 530 && x < 670) && (y > 590 && y < 650) ) 
		{
			modeloJuego.clickAtaque(3);
		}
		
		
	}
	
	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		vistaJuego.setVisible(false);
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


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
