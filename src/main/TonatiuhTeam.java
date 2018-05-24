package main;

import java.util.ArrayList;

public class TonatiuhTeam {
	private static double costoPercorso;
	private static ArrayList<Integer> percorso;
	public static final String DESCRIZIONE_TEAM=
			"Il veicolo di questo team consuma carburante in base alla distanza euclidea";
	private static final String NOME_TEAM="Tonatiuh";

	public static double getCostoPercorso() {
		return costoPercorso;
	}

	public static void setCostoPercorso(double costoPercorso) {
		TonatiuhTeam.costoPercorso = costoPercorso;
	}

	public static ArrayList<Integer> getPercorso() {
		return percorso;
	}

	public static void setPercorso(ArrayList<Integer> percorso) {
		TonatiuhTeam.percorso = percorso;
	}

	public static String getNomeTeam() {
		return NOME_TEAM;
	}
}
