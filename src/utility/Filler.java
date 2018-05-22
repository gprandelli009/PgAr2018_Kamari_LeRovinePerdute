//package utility;
//
//public class Filler {
//
//	private static String tagCorrente, msgCorrente, documentoCorrente;
//	private static Contenitore ultimoOggetto;
//
//	public static String getTagCorrente() {
//		return tagCorrente;
//	}
//
//	public static String getMsgCorrente() {
//		return msgCorrente;
//	}
//
//	public static ArrayList<Calendar_dates> getCalendars_dates() {
//		return calendars_dates;
//	}
//
//	public static ArrayList<Stop_times> getStop_times() {
//		return stop_times;
//	}
//
//	public static ArrayList<Trips> getTrips() {
//		return trips;
//	}
//
//	public static void setDocumentoCorrente(String documentoCorrente) {
//		//prendo solo le lettere prima dell`estensione
//		documentoCorrente = documentoCorrente.split("[.]")[0];
//		documentoCorrente = documentoCorrente.toLowerCase();
//		Filler.documentoCorrente = documentoCorrente;
//	}
//
//	public static void setTagCorrente(String tagCorrente) {
//		Filler.tagCorrente = tagCorrente;
//		if (tagCorrente.equals("row")) { //Quando trovo un tag row creo un nuovo oggetto di quella classe
//			switch (documentoCorrente) {
//				case "agency":
//					Agency a = new Agency();
//					ultimoOggetto = a;
//					agencies.add(a);
//					break;
//				case "calendar":
//					Calendar c = new Calendar();
//					ultimoOggetto = c;
//					calendars.add(c);
//					break;
//			}
//		}
//	}
//
//
//}
//
