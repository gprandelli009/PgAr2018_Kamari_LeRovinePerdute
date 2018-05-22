package utility;

import java.io.FileInputStream;
import java.io.FileWriter;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

public class Read {
	public Read() {

	}

	public void explore(String filename) {
		try {

			XMLInputFactory xmlif = XMLInputFactory.newInstance();
			XMLStreamReader xmlr = xmlif.createXMLStreamReader(filename,
					new FileInputStream(filename));
			while (xmlr.hasNext()) {
				switch (xmlr.getEventType()) {
					case XMLStreamConstants.START_DOCUMENT:
						System.out.println("Start Read Doc " + filename);
						break;
					case XMLStreamConstants.START_ELEMENT:
						System.out.println("Tag " + xmlr.getLocalName());

						String nCities = xmlr.getAttributeValue(null , "size");
						if(nCities != null)
							System.out.println(nCities);

						String id = xmlr.getAttributeValue(null , "id");
						if(id != null)
							System.out.println(id);
						String name = xmlr.getAttributeValue(null , "name");
						if(name != null)
							System.out.println(name);
						String x = xmlr.getAttributeValue(null , "x");
						if(x != null)
							System.out.println(x);
						String y = xmlr.getAttributeValue(null , "y");
						if(y != null)
							System.out.println(y);
						String h = xmlr.getAttributeValue(null , "h");
						if(h != null)
							System.out.println(h);

						String to = xmlr.getAttributeValue(null , "to");
						if(to != null)
							System.out.println(to);
						break;
					case XMLStreamConstants.NOTATION_DECLARATION:
						System.out.println("Inside " + xmlr.getText());
						break;
					case XMLStreamConstants.CHARACTERS:
						if (xmlr.getText().trim().length() > 0)
							System.out.println("-> " + xmlr.getText());
						break;
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
