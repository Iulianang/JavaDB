package edu.femxa.json;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Arrays;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.corba.se.pept.transport.Connection;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;


public class MainRecado {

	public static String getJSON(String urlToRead) throws Exception {
	      StringBuilder result = new StringBuilder();
	      URL url = new URL(urlToRead);
	      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	      conn.setRequestMethod("GET");
	      BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	      String line;
	      while ((line = rd.readLine()) != null) {
	         result.append(line);
	      }
	      rd.close();
	      return result.toString();
	   }

	public static void main(String[] args) throws Exception
	   {
	     String joson = getJSON("http://elrecadero-ebtm.rhcloud.com/ObtenerListaRecados");
	     Gson gson = new Gson();
	     List<Recado> l = gson.fromJson(joson, new TypeToken<List<Recado>>(){}.getType());
	     Recado r = l.get(1);
	     System.out.println(r.toString());
	     System.out.println(l.size());
	     //ordenado por numero de telefono
//	     Recado rec = new Recado();
//	     String telefono= null;
//	     telefono = rec.getTelefono();
//	     
//	     char[] letras = new char[telefono.length()]; 
//
//	     for (int i = 0; i < letras.length; i++) 
//	     letras[i] = telefono.charAt(i); 
//
//	     Arrays.sort(letras); 
//
//	     for (int i = 0; i < letras.length; i++) 
//	     System.out.print(letras[i]); 
//
//	     System.out.println(); 
	     //TODO
	     
		
	     
	   }

}
