package edu.femxa.basedatos;

public class Empleado {
	
	private int id;
	private String nombre;
	private int salario;
	private int departamento;
	private String nDepartamento;
	
	
	
	public Empleado(int id, String nombre, int salario, int departamento, String nDepartamento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.salario = salario;
		this.departamento = departamento;
		this.nDepartamento = nDepartamento;
	}

	public String getnDepartamento() {
		return nDepartamento;
	}

	public void setnDepartamento(String nDepartamento) {
		this.nDepartamento = nDepartamento;
	}

	public Empleado(int id, String nombre, int salario, int departamento) {
		this.id = id;
		this.nombre = nombre;
		this.salario = salario;
		this.departamento = departamento;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getSalario() {
		return salario;
	}
	public void setSalario(int salario) {
		this.salario = salario;
	}
	public int getDepartamento() {
		return departamento;
	}
	public void setDepartamento(int departamento) {
		this.departamento = departamento;
	}

}
