package Controller;

import Model.Logica;
import processing.core.PApplet;

public class PantallaController {

	private Logica logica;

	public PantallaController(PApplet app) {

		logica = new Logica(app);

	}
	public void pintar() {
		logica.pintar();
	}
	
	public void sortList(char c) {
		logica.sortList(c);
		
	}

}
