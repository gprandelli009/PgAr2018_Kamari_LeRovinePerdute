package main;

import java.util.ArrayList;

public class City {
	private int x,y,h;
	private String nome;
	ArrayList<Integer> nodi = new ArrayList<>();

	public City(int x, int y, int h, String nome) {
		this.x = x;
		this.y = y;
		this.h = h;
		this.nome = nome;
	}

	public void addiungiNodo(int id){
		nodi.add(id);
	}

	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Nome : ");
		sb.append(nome);
		sb.append("\n");
		sb.append("Coordinata x: ");
		sb.append(x);
		sb.append("\n");
		sb.append("Coordinata y: ");
		sb.append(y);
		sb.append("\n");
		sb.append("Coordinata h: ");
		sb.append(h);
		sb.append("\n");
		return sb.toString();
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getH() {
		return h;
	}

	public String getNome() {
		return nome;
	}
	public ArrayList<Integer> getNodi(){
		return nodi;
	}

}
