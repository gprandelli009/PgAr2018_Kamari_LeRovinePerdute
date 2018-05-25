package main;

import java.util.HashMap;

/**
 * Mappa con chiave id e valore l'oggetto città.
 * 
 * @since 2018-05-25
 */
public class Map {
	private HashMap<Integer,City> cities = new HashMap<>();

	public HashMap<Integer, City> getMap() {
		return cities;
	}

	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<cities.size();i++){
			sb.append(cities.get(i).toString());
		}
		return sb.toString();
	}


}
