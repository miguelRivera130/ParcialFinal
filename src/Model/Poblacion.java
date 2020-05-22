package Model;

import processing.core.PApplet;

public class Poblacion implements Comparable<Poblacion>, Runnable {

	private PApplet app;
	private float posX, posY;
	private int rad = 7;
	private int r, g, b;
	protected String tipo;
	private int dir;
	private boolean cambio;
	private String color;
	private int cant;

	public Poblacion(float posX, float posY, String tipo, int cant, PApplet app) {

		this.posX = posX;
		this.posY = posY;
		this.tipo = tipo;
		this.dir = 2;
		this.cambio = false;
		this.color = color;
		this.cant = cant;

		switch (tipo) {
		case "sana":
			this.r = 0;
			this.g = 200;
			this.b = 0;
			this.color = "verde";
			break;
		case "enferma":
			this.r = 200;
			this.g = 0;
			this.b = 0;
			this.color = "rojo";
			break;
		case "recuperada":
			this.r = 0;
			this.g = 0;
			this.b = 200;
			this.color = "azul";
			break;

		}

	}

	@Override
	public void run() {
		mover();
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public void dibujar() {

		app.fill(r, g, b);
		app.noStroke();
		app.ellipse(posX, posY, rad, rad);

	}

	private void mover() {

		posX += dir;
		posY += dir;
		
		if(this.cambio == true) {
			
			dir=dir*-1;
			
		}

	}

	public PApplet getApp() {
		return app;
	}

	public void setApp(PApplet app) {
		this.app = app;
	}

	public float getPosX() {
		return posX;
	}

	public void setPosX(float posX) {
		this.posX = posX;
	}

	public float getPosY() {
		return posY;
	}

	public void setPosY(float posY) {
		this.posY = posY;
	}

	public int getRad() {
		return rad;
	}

	public void setRad(int rad) {
		this.rad = rad;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}

	public boolean isCambio() {
		return cambio;
	}

	public void setCambio(boolean cambio) {
		this.cambio = cambio;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getCant() {
		return cant;
	}

	public void setCant(int cant) {
		this.cant = cant;
	}

	@Override
	public int compareTo(Poblacion proxPob) {
		return this.cant - proxPob.getCant();
	}


}
