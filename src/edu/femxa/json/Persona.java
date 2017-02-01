package edu.femxa.json;

public class Persona {

	private String nombre;
	private boolean casado;
	private boolean parado;
	private int n_hijos;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isCasado() {
		return casado;
	}
	public void setCasado(boolean casado) {
		this.casado = casado;
	}
	public Persona(String nombre, boolean casado, boolean parado, int n_hijos) {
		super();
		this.nombre = nombre;
		this.casado = casado;
		this.parado = parado;
		this.n_hijos = n_hijos;
	}
	public boolean isParado() {
		return parado;
	}
	public void setParado(boolean parado) {
		this.parado = parado;
	}
	public int getN_hijos() {
		return n_hijos;
	}
	public void setN_hijos(int n_hijos) {
		this.n_hijos = n_hijos;
	}
	
}
