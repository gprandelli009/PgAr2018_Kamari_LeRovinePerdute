package utility;

import main.City;
import main.MetztliTeam;
import main.TonatiuhTeam;

import java.io.FileWriter;
import java.util.Map;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

public class Write {
	private Map<Integer, City> map;

	public Write(Map<Integer, City> map) {
		this.map = map;
	}

	public boolean write(String filename) {
		System.out.println("Scrittura su file");
		XMLOutputFactory output = XMLOutputFactory.newInstance();
		XMLStreamWriter writer;
		try {
			writer = output.createXMLStreamWriter(new FileWriter(filename));

			writer.writeStartDocument("utf-8", "1.0");
			writer.writeStartElement("route");
			writer.writeAttribute("team", TonatiuhTeam.getNomeTeam());
			writer.writeAttribute("cost", "" + TonatiuhTeam.getCostoPercorso());
			writer.writeAttribute("cities", "" + TonatiuhTeam.getPercorso().size());
			for (Integer i : TonatiuhTeam.getPercorso()) {
				writer.writeStartElement("city");
				writer.writeAttribute("id", "" + i);
				writer.writeAttribute("name", map.get(i).getNome());
				writer.writeEndElement();
			}
			writer.writeEndElement(); // End Route

			writer.writeStartElement("route");
			writer.writeAttribute("team", MetztliTeam.getNomeTeam());
			writer.writeAttribute("cost", "" + MetztliTeam.getCostoPercorso());
			writer.writeAttribute("cities", "" + MetztliTeam.getPercorso().size());
			for (Integer i : MetztliTeam.getPercorso()) {
				writer.writeStartElement("city");
				writer.writeAttribute("id", "" + i);
				writer.writeAttribute("name", map.get(i).getNome());
				writer.writeEndElement();
			}
			writer.writeEndElement(); // End Route
			writer.writeEndDocument(); //End Document
			writer.flush();
			writer.close();
			System.out.println("End!");
		} catch (Exception e) {
			System.out.print("Vecchio, problema!");
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
