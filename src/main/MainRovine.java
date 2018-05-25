package main;

import utility.InputDati;
import utility.Read;
import utility.Write;

public class MainRovine {
	private static final String[] sceltaFile
			= {"PgAr_Map_5","PgAr_Map_12","PgAr_Map_50","PgAr_Map_200","PgAr_Map_2000","PgAr_Map_10000"};
	
	
	/**
	 * metodo main del programma RovinePerdute
	 * @param args Unused.
	 */
	public static void main(String[] args) {
		int scelta;
		for(int i=0;i<sceltaFile.length;i++){
			System.out.println("Inserire "+(i+1)+"_"+sceltaFile[i]);
		}
		scelta = InputDati.leggiIntero("Inserisci il numero del file da leggere : ",1,6);
		Map mappa = new Map();
		Read r = new Read(mappa.getMap()); //Riempie la mappa
		r.explore("src/resources/"+sceltaFile[scelta-1]+".xml");
//		System.out.println(mappa.toString());
		PathFinder ph = new PathFinder(mappa.getMap());
		ph.algDijkstra(MetztliTeam.getNomeTeam()); 		//Riempio la classe MetztliTeam con i costi percorso
		ph.algDijkstra(TonatiuhTeam.getNomeTeam());		//Riempio la classe tonatiuhTeam con i costi percorso
		Write wr = new Write(mappa.getMap());
		wr.write("Percorso.xml");						//Scrivo su file i risultati
	}

}
