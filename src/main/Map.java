package main;

import java.util.HashMap;

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
