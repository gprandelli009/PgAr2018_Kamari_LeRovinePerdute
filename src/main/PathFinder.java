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
	
	/** Dato uno dei 2 Team setta il percorso di quel team (dall'inizio all'arrivo) al suo percorso ottimo
	* @param team unico parametro di ingresso.
	*/
	public void algDijkstra(String team){
		Set <Integer> cittaDaControllare = new HashSet <Integer>();
		ArrayList <Double> distanza = new ArrayList <Double>();
		ArrayList <Integer>  precedente = new ArrayList <Integer>();
		
		//double distanzaCart = Double.POSITIVE_INFINITY;
		//double altezze = Double.POSITIVE_INFINITY;
		
		for (Integer i:m.keySet()) {
			distanza.add(Double.POSITIVE_INFINITY);
			precedente.add(null);  //unknown
			cittaDaControllare.add(i);
		}
		
		distanza.set(0, 0.0); 	//Imposto il costo del percorso per arrivare al campo base 0
		precedente.set(0,0); 	//Il precedente del campo base e` se stesso
		
		do {
			int t = 0;
			double temp = Double.POSITIVE_INFINITY;
			for (Integer i:cittaDaControllare) {
				if(distanza.get(i)< temp) {
					t = i;
					temp = distanza.get(i);
				}	
			}
			cittaDaControllare.remove(t);
			
			ArrayList <Integer> vicini = m.get(t).getNodi();
			for (Integer i :vicini) {
				if (!cittaDaControllare.contains(i))
					continue;
				double dist;

				//Calcolo costo per il team metzli
				if(team.equals(MetztliTeam.getNomeTeam())) {
					int h1 = m.get(t).getH();
					int h2 = m.get(i).getH();
					dist = distanza.get(t) + Math.abs(h1 - h2);
				}
				
				//Calcolo il costo per il team Tonatiuh
				else {
					int x1 = m.get(t).getX();
					int y1 = m.get(t).getY();
					int x2 = m.get(i).getX();
					int y2 = m.get(i).getY();
					dist = distanza.get(t) + Math.hypot(x2-x1,y2-y1);
				}
				if (dist < distanza.get(i)) {
					distanza.set(i, dist);
					precedente.set(i, t);
				}
			}
				
		}while(!cittaDaControllare.isEmpty());
		
		//Salvo nella classe static dei due team i relativi valori calcolati
		if(team.equals(MetztliTeam.getNomeTeam())) {
			MetztliTeam.setCostoPercorso(distanza.get(distanza.size()-1));
			MetztliTeam.setPercorso(ricavaPercorso(precedente));
		}
		else {
			TonatiuhTeam.setCostoPercorso(distanza.get(distanza.size()-1));
			TonatiuhTeam.setPercorso(ricavaPercorso(precedente));
		}
	}

	/** dato un ArrayList restituisce un ArrayList di Integer che ha come primo elemento l'ultimo
	 * elemento dell'ArrayList d'ingresso e come successivi elementi gli elementi a ritroso
	 * che formano il cammino minimo dall'elemento finale a quello iniziale.<br>
	 * <b>metodo privato.</b>
	*@param precedente. 
	*@return ArrayList ritorna un ArrayList di Integer. 
	*/
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
