package main;

import utility.InputDati;
import utility.Read;

public class MainRovine {
	private static final String[] sceltaFile
			= {"1_PgAr_Map_5","2_PgAr_Map_12","3_PgAr_Map_50","4_PgAr_Map_200","5_PgAr_Map_2000","6_PgAr_Map_10000"};
	public static void main(String[] args) {
		int scelta;
		for(int i=0;i<sceltaFile.length;i++){
			System.out.println(sceltaFile[i]);
		}
		scelta = InputDati.leggiIntero("Inserisci il numero del file da leggere",1,6);
		Read r = new Read();
		r.explore(sceltaFile[scelta]);
	}

}
