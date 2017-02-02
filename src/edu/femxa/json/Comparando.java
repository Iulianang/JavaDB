package edu.femxa.json;

public class Comparando {

	public static void main(String[] args) {
		
		String t1 = "912037895";
		String t2 = "806222354";
		String t3 = "806222354";
		
		int resultado =t1.compareTo(t2);
		int resultado1 =t2.compareTo(t1);
		int resultado2 =t3.compareTo(t2);
		System.out.println(resultado);
		System.out.println(resultado1);
		System.out.println(resultado2);
		
	}
}
