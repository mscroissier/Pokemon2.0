package es.studium.Pokemon2.Views;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;

public class VistaRanking extends Frame
{

	private static final long serialVersionUID = 1L;

	Label lblRanking = new Label("Ranking");
	public TextArea taRanking = new TextArea(10,62);
	
	public VistaRanking() {
		
		setTitle("RANKING");

		setLayout(new FlowLayout());
		setBackground(new Color(250, 250, 250));
		
		add(lblRanking);
		add(taRanking);
		
		
		
		setSize(500,300);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
	}
	
}
