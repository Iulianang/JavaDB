package edu.femxa.sax;

import java.io.File;
import java.io.FileInputStream;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.XMLReader;

public class MainSAX {
	
	public static void main(String[] args) throws Throwable {
		
	 XMLReader reader = XMLReaderFactory.createXMLReader();
	 ParseLibroXML parseLibro = null;
	 parseLibro = new ParseLibroXML();
	 reader.setContentHandler(parseLibro);
		
	 reader.parse(new InputSource(new FileInputStream("libros.xml")));
			 
	
	}

}
