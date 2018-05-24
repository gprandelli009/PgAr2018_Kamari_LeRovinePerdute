package main;

import java.util.ArrayList;

public class MetztliTeam {
	private static double costoPercorso;
	private static ArrayList<Integer> percorso;
	public static final String DESCRIZIONE_TEAM=
			"Il veicolo di questo team consuma carburante in base all'altitudine percorsa";
	private static final String NOME_TEAM="Metzli";

	public static double getCostoPercorso() {
		return costoPercorso;
	}

	public static void setCostoPercorso(double costoPercorso) {
		MetztliTeam.costoPercorso = costoPercorso;
	}

	public static ArrayList<Integer> getPercorso() {
		return percorso;
	}

	public static void setPercorso(ArrayList<Integer> percorso) {
		MetztliTeam.percorso = percorso;
	}

	public static String getNomeTeam() {
		return NOME_TEAM;
	}
}
