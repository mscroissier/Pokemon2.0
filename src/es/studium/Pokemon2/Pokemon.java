package es.studium.Pokemon2;

import es.studium.Pokemon2.Controllers.ClaseControlador;
import es.studium.Pokemon2.Views.VistaComenzarPartida;
import es.studium.Pokemon2.Views.VistaPrincipal;

public class Pokemon {

	public static void main(String[] args) {
		VistaPrincipal Vista = new VistaPrincipal();
	
		
		new ClaseControlador(Vista); 


	}

}
