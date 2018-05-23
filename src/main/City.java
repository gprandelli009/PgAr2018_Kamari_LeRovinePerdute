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
}
