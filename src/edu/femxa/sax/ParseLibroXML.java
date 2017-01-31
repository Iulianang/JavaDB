package edu.femxa.sax;


import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.sun.xml.internal.fastinfoset.util.LocalNameQualifiedNamesMap;

import sun.util.resources.cldr.LocaleNames;


public class ParseLibroXML extends DefaultHandler{
	private Libro libro;
	private List<Libro> libros;
	private String valor_actual;

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		//super.startDocument();
		this.libro = new Libro();
		libros = new ArrayList<>();
		
	}
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		//super.startElement(uri, localName, qName, attributes);
		System.out.println("Start element: "+localName);
		
		if (localName.equals("libro"))
		{
			libro = new Libro();
			String valor_isbn = attributes.getValue("isbn");
			this.libro.setIsbn(valor_isbn);
		}
	}
	
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		//super.endElement(uri, localName, qName);
		System.out.println("End element: "+ localName);
		
		if (localName.equals("titulo"))
		{
			libro.setTitulo(valor_actual);
		}
		else if (localName.equals("autor"))
			{
				libro.setAutor(valor_actual);
			}
				else if (localName.equals("anyo"))
				{
					libro.setAnyo(valor_actual);
				}
				else if (localName.equals("editorial"))
				{
					libro.setEditorial(valor_actual);
				}else if(localName.equals("libro"))
				{
					libros.add(libro);
				}
		
		
		
				
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		//super.characters(ch, start, length);
		
//		System.out.println("Start[] = "+start);
//		System.out.println("Lenght[] = "+length);
		String str = new String(ch, start, length);
//		System.out.println("Char[] = "+str);
		valor_actual = str;
	}
	
	
	
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		//super.endDocument();
		
//		System.out.println("Info libro");
//		System.out.println("ISBN = "+libro.getIsbn());
//		System.out.println("Autor ="+libro.getAutor());
//		System.out.println("Anyo ="+libro.getAnyo());
//		System.out.println("Titulo: "+libro.getTitulo());
//		System.out.println("Editorial: "+libro.getEditorial());
		
		for (Libro libro : libros)
		{
			System.out.println("\nInfo libro");
			System.out.println("ISBN = "+libro.getIsbn());
			System.out.println("Autor ="+libro.getAutor());
			System.out.println("Anyo ="+libro.getAnyo());
			System.out.println("Titulo: "+libro.getTitulo());
			System.out.println("Editorial: "+libro.getEditorial());
		}
		
	}
		
	
}
