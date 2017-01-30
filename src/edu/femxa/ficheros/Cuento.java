package edu.femxa.ficheros;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Cuento {
	
	public static void main(String[] args) throws IOException {

		System.out.println(args[0]);
		String start = args[0];
		Properties fichero_propiedades = null;
		fichero_propiedades = new Properties();
		FileReader fr = null;

		switch (start) {
		case "it":
		fr = new FileReader("story_it.properties");
		break;
		case "en":
		fr = new FileReader("story_en.properties");
		break;
		case "es":
		fr = new FileReader("story_es.properties");
		break;
		default:
		System.out.println("dato no válido");
		break;
		}

		fichero_propiedades.load(fr);

		fichero_propiedades.load(fr);

		String inicio = fichero_propiedades.getProperty("start");

		String cuerpo = fichero_propiedades.getProperty("body");

		String desenlace = fichero_propiedades.getProperty("end");

		System.out.println(inicio);
		System.out.println(cuerpo);
		System.out.println(desenlace);
}


}
