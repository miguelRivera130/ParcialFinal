package Model;

import java.util.Collections;
import java.util.LinkedList;
import processing.core.PApplet;
import Model.Poblacion;

public class Logica extends PApplet {

	String[] txt;

	private LinkedList<Poblacion> listaPoblacion;
	private PApplet app;
	private PoblacionColorCompare poblacionColorCompare;

	private int tipos;

	public Logica(PApplet app) {

		poblacionColorCompare = new PoblacionColorCompare();

		this.app = app;
		listaPoblacion = new LinkedList<Poblacion>();

		this.tipos = 0;

		txt = app.loadStrings("../data/info.txt");
	}

	public void listaPoblacion() {
		for (int i = 0; i < txt.length; i++) {
			String[] lista = txt[i].split(",");
			int cantidad = Integer.parseInt(lista[1]);

			for (int j = 0; j < cantidad; j++) {

				if (lista[0] == "sana") {

					listaPoblacion
							.add(new Poblacion(app.random(500) + 50, app.random(500) + 50, "sana", cantidad, this));

					this.tipos = 1;

				}

				if (lista[0] == "infectada") {

					listaPoblacion.add(
							new Poblacion(app.random(500) + 50, app.random(500) + 50, "infectada", cantidad, this));

					this.tipos = 2;

				}

				if (lista[0] == "saludable") {

					listaPoblacion.add(
							new Poblacion(app.random(500) + 50, app.random(500) + 50, "saludable", cantidad, this));

					this.tipos = 3;

				}

				new Thread(listaPoblacion.get(j)).start();

			}
		}
	}

	public void pintar() {
		for (int i = 0; i < txt.length; i++) {
			String[] lista = txt[i].split(",");
			int cantidad = Integer.parseInt(lista[1]);
			for (int j = 0; j < cantidad; j++) {

				listaPoblacion.get(i).dibujar();

			}
		}

	}

	public void cambio() {

		for (int i = 0; i < listaPoblacion.size(); i++) {
			for (int j = 0; j < listaPoblacion.size(); j++) {

				if (PApplet.dist(listaPoblacion.get(i).getPosX(), listaPoblacion.get(i).getPosY(),
						listaPoblacion.get(j).getPosX(), listaPoblacion.get(j).getPosY()) < 50) {

					if (listaPoblacion.get(i).getTipo() == "sana" && listaPoblacion.get(j).getTipo() == "enferma") {

						listaPoblacion.get(i).setCambio(true);

					}
				}

			}
		}
	}

	public void sortList(char c) {
		switch (c) {
		case 'c':
			Collections.sort(listaPoblacion, poblacionColorCompare);
			break;
		}
	}

}