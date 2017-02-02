package edu.femxa.json;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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
		   List <Recado> lista_recados = gson.fromJson(joson, new TypeToken<List<Recado>>(){}.getType());
		
		   int pos = 4;
		   
		   for(Recado r : lista_recados)
		   {
			   r.setN_recado(pos);
			   pos = pos-1;
		   }
		   
		   imprimirLista(lista_recados);
		   Collections.sort(lista_recados);
		   System.out.println("		LISTA ORDENADA");
		   imprimirLista(lista_recados);
	   }
	   
	   public static void imprimirLista(List<Recado> lista_recados){
		   
		   for (Recado recado : lista_recados)
		   {
			   System.out.println("Numero recado: "+recado.getN_recado()+".Cliente: " + recado.getNombre_cliente()+
			   " telefono: "+recado.getTelefono()) ;
		   }
	   }
}
