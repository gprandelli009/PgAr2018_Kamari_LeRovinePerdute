package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PathFinder {
	private Map m;

	public PathFinder(Map m) {
		this.m = m;
	
	}
	
	public void algDijkstra(Map m){
		Set <Integer> cittaDaControllare = new HashSet <Integer>();
		ArrayList <Double> distanzaCart = new ArrayList <Double>();
		ArrayList <Double> altezze = new ArrayList <Double>();
		ArrayList <Integer> cittaAdiacenti;
		ArrayList <Integer>  precedente = new ArrayList <Integer>();
		
		//double distanzaCart = Double.POSITIVE_INFINITY;
		//double altezze = Double.POSITIVE_INFINITY;
		
		for (Integer i:m.getMap().keySet()) {
			//distanzaCart.add(Double.POSITIVE_INFINITY);
			altezze.add(Double.POSITIVE_INFINITY);
			precedente.add(null);  //unknown?
			cittaDaControllare.add(i);
		}
		
		altezze.set(0, 0.0);
		
		do {
			int t = 0;
			double temp = Double.POSITIVE_INFINITY;
			for (Integer i:cittaDaControllare) {
				if(altezze.get(i)< temp) {
					t = i;
					temp = altezze.get(i);
				}	
			}
			cittaDaControllare.remove(t);
			
			ArrayList <Integer> vicini = m.getMap().get(t).getNodi();
			for (Integer i :vicini) {
				if (!cittaDaControllare.contains(i))
					continue;
				
				double dist = altezze.get(t) + Math.abs(m.getMap().get(t).getH() - m.getMap().get(i).getH());
				if (dist < altezze.get(i)) {
					altezze.set(i, dist);
					precedente.set(i, t);
				}
			}
				
		}while(!cittaDaControllare.isEmpty());
		
		
	}
}
