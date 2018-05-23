package utility;

import main.City;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.HashMap;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

public class Read {
	private HashMap<Integer,City> cities;

	public Read(HashMap<Integer, City> cities) {
		this.cities = cities;
	}

	public void explore(String filename) {
		try {
			City c = null;
			int id = 0;

			XMLInputFactory xmlif = XMLInputFactory.newInstance();
			XMLStreamReader xmlr = xmlif.createXMLStreamReader(filename,
					new FileInputStream(filename));
			while (xmlr.hasNext()) {
				switch (xmlr.getEventType()) {
					case XMLStreamConstants.START_ELEMENT:
						if(xmlr.getLocalName().equals("city")){
							String idS = xmlr.getAttributeValue(null , "id");
							id = Integer.parseInt(idS);
							String name = xmlr.getAttributeValue(null , "name");
							String xS = xmlr.getAttributeValue(null , "x");
							int x = Integer.parseInt(xS);
							String yS = xmlr.getAttributeValue(null , "y");
							int y = Integer.parseInt(yS);
							String hS = xmlr.getAttributeValue(null , "h");
							int h = Integer.parseInt(hS);
							c = new City(x,y,h,name);
						}
						if(xmlr.getLocalName().equals("link")){
							String toS = xmlr.getAttributeValue(null , "to");
							int to = Integer.parseInt(toS);
							c.addiungiNodo(to); //Possibile errore se file xml diverso da consegna
						}
						break;
					case XMLStreamConstants.END_ELEMENT:
						if(xmlr.getLocalName().equals("city"))
							cities.put(id,c);
					default:
						break;
				}
				xmlr.next();
			}
		} catch (Exception e) {
			System.err.println("Error detected");
			System.err.println(e.getMessage());
		}
	}
}
