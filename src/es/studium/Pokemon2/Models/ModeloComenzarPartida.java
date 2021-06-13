package es.studium.Pokemon2.Models;

import java.awt.Choice;

public class ModeloComenzarPartida {

	// lista de pokemons
		private String[] nombresPokemons = {"Chansey","Bulbasaur","Charmander","Pidgeotto","Squirtle"};
		
		private void llenarChoicePokemon(Choice ch) {
			// rellena los Choices segun los datos de nombresPokemon
			for(int i = 0; i < nombresPokemons.length; i++) {
				ch.addItem(nombresPokemons[i]);
			}
		}
	
}
