package main;

import java.util.ArrayList;

public class MetztliTeam {
	private static int costoPercorso;
	private static ArrayList<Integer> percorso;
	public static final String DESCRIZIONE_TEAM=
			"Il veicolo di questo team consuma carburante in base all'altitudine percorsa";
	private static final String NOME_TEAM="Metzli";

	public static int getCostoPercorso() {
		return costoPercorso;
	}

	public static void setCostoPercorso(int costoPercorso) {
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
