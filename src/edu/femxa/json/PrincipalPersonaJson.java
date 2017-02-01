package edu.femxa.json;

import com.google.gson.Gson;

public class PrincipalPersonaJson {

	
	public static void main(String[] args) 
	{
		
		Gson gson = new Gson();
		Persona p = new Persona("Mikel", false, false, 4);
		String json_p= gson.toJson(p);
		System.out.println(json_p);
		
		Persona pp = gson.fromJson(json_p, Persona.class);
		
		System.out.println("Numero de hijos: "+pp.getN_hijos()+"\nNombre: "+pp.getNombre()+"\nCasado: "+pp.isCasado()+"\nParado: "+pp.isParado());
		
	}
}
