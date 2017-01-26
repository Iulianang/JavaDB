package edu.femxa.basedatos;

import java.util.List;


public class Main {

	
	public static void main(String[] args) throws Exception  {
		
		EmpleadosDAO empDAO = new EmpleadosDAO();
		List<EmpleadosDTO> le = empDAO.consultaAllEmpleados();
		
		for (EmpleadosDTO empDTO : le)
		{
			System.out.println(empDTO.getDpto()+ " "+empDTO.getFirstName()+" "+empDTO.getSalary());
		}
		
	}
}
