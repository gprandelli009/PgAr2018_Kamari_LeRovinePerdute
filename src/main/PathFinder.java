package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class PathFinder {
	private HashMap<Integer,City> m;

	public PathFinder(HashMap<Integer,City> m) {
		this.m = m;
	
	}
	
	public void algDijkstra(String team){
		Set <Integer> cittaDaControllare = new HashSet <Integer>();
		ArrayList <Double> distanzaCart = new ArrayList <Double>();
		ArrayList <Double> altezze = new ArrayList <Double>();
		ArrayList <Integer> cittaAdiacenti;
		ArrayList <Integer>  precedente = new ArrayList <Integer>();
		
		//double distanzaCart = Double.POSITIVE_INFINITY;
		//double altezze = Double.POSITIVE_INFINITY;
		
		for (Integer i:m.keySet()) {
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
			precedente.set(0,0);
			cittaDaControllare.remove(t);
			
			ArrayList <Integer> vicini = m.get(t).getNodi();
			for (Integer i :vicini) {
				if (!cittaDaControllare.contains(i))
					continue;
				double dist;

				if(team.equals(MetztliTeam.getNomeTeam())) {
					int h1 = m.get(t).getH();
					int h2 = m.get(i).getH();
					dist = altezze.get(t) + Math.abs(h1 - h2);
				}
				else {
					int x1 = m.get(t).getX();
					int y1 = m.get(t).getY();
					int x2 = m.get(i).getX();
					int y2 = m.get(i).getY();
					dist = altezze.get(t) + Math.hypot(x2-x1,y2-y1);
				}
				if (dist < altezze.get(i)) {
					altezze.set(i, dist);
					precedente.set(i, t);
				}
			}
				
		}while(!cittaDaControllare.isEmpty());
		if(team.equals(MetztliTeam.getNomeTeam())) {
			MetztliTeam.setCostoPercorso(altezze.get(altezze.size()-1));
			MetztliTeam.setPercorso(ricavaPercorso(precedente));
		}
		else {
			TonatiuhTeam.setCostoPercorso(altezze.get(altezze.size()-1));
			TonatiuhTeam.setPercorso(ricavaPercorso(precedente));
		}
	}

	private ArrayList<Integer> ricavaPercorso(ArrayList<Integer> precedente){
		int ultimo = precedente.get(precedente.size()-1);
		ArrayList<Integer> percorsoRitroso = new ArrayList<>();
		do{
			percorsoRitroso.add(ultimo);
			ultimo = precedente.get(ultimo);
		}while(ultimo!=0);
		percorsoRitroso.add(0);
		return percorsoRitroso;
	}
}
