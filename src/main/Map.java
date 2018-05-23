package main;

import java.util.HashMap;

public class Map {
	private HashMap<Integer,City> cities = new HashMap<>();

	public HashMap<Integer, City> getMap() {
		return cities;
	}

	public String toString(){
		return cities.toString();
	}
}
