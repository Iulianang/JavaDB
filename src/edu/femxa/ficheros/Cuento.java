package edu.femxa.ficheros;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Cuento {
	
	
	
	 public static void main(String[] args) throws IOException {

		 System.out.println(args[0]);
		 String idioma = args[0];
		 Properties fichero_propiedades = null;
		 fichero_propiedades = new Properties();
		 FileReader fr = null;
		 FileWriter fw = null;
		 BufferedWriter bw = null;
		 

		 switch (idioma) {
		 case "it":
		 fr = new FileReader("story_it.properties");
		 fw = new FileWriter("story.txt");
		 break;
		 case "en":
		 fr = new FileReader("story_en.properties");
		 fw = new FileWriter("story.txt");
		 break;
		 case "es":
		 fr = new FileReader("story_es.properties");
		 fw = new FileWriter("cuento.txt");

		 break;
		 default:
		 System.out.println("dato no válido");
		 break;
		 }

		 fichero_propiedades.load(fr);

		 fichero_propiedades.load(fr);

		 bw = new BufferedWriter(fw);

		 bw.write(fichero_propiedades.getProperty("start"));
		 bw.newLine();
		 bw.write(fichero_propiedades.getProperty("body"));
		 bw.newLine();
		 bw.write(fichero_propiedades.getProperty("end"));

		 fr.close();
		 bw.close();
		 fw.close();
		 }
		 


}
