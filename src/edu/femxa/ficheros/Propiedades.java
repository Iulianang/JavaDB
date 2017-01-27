package edu.femxa.ficheros;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

public class Propiedades {

	public static void main(String[] args) throws Exception 
	{
		
		Properties fichero_propiedades = null;
		fichero_propiedades = new Properties();
		FileReader fr =null;
		fr = new FileReader("db.properties");
		String valor_driver = null;
		String cadena_conexion = null;
		String usuario = null;
		String pass = null;
		fichero_propiedades.load(fr);
		valor_driver = fichero_propiedades.getProperty("driver");
		cadena_conexion = fichero_propiedades.getProperty("cadena_conexion");
		usuario = fichero_propiedades.getProperty("user");
		pass = fichero_propiedades.getProperty("password");
		
		System.out.println(valor_driver+" "+cadena_conexion+" "+usuario+" "+pass);
		
		fr.close();
		
	}
}
