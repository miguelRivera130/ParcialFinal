package View;

import Controller.PantallaController;
import processing.core.PApplet;

public class Main extends PApplet {

	private PantallaController controllerMain;

	public static void main(String[] args) {
		PApplet.main(Main.class.getName());
	}

	public void settings() {

		size(600, 600);

	}

	public void setup() {

		controllerMain = new PantallaController(this);
	}

	public void draw() {
		
		
		background(0);
		controllerMain.pintar();

	}

	public void keyPressed() {

		controllerMain.sortList(key);

	}
}