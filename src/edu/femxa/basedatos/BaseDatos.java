package edu.femxa.basedatos;

//código de base de datos

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.plaf.synth.SynthScrollBarUI;

public class BaseDatos {
	
	public static void mostrarLista (ArrayList<Empleado> lemp){
		for(Empleado emp : lemp)
		{
			System.out.println("Id: "+emp.getId()+" "+"Nombre: "+emp.getNombre()+" "+"Salario: "+emp.getSalario()+" "+"Id.Dept: "+emp.getDepartamento()+" "+"Dept: "+emp.getnDepartamento());
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		
		
		Connection conn = null;
		ResultSet rset = null;
		Statement stmt = null;
		ArrayList<Empleado> lista_empleados = null;
		lista_empleados = new ArrayList<Empleado>();
		String nombre1 = null;
		int id1 = 0;
		int salario1 = 0;
		int departamento1 = 0;
		String nDepartamento = null;
		new Consultas();
		
		/*try
		{
			//registro el driver, en realidad, hago que se ejecuten unas pocas líneas de la clase OracleDriver
			Class.forName("oracle.jdbc.driver.OracleDriver"); //indica al driver manager que clase utilizar
			//DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());// método equivalente al anterior
			//Sea como sea, es, <<oye, si te piden una conexión, se la pides a esa clase!>>
			conn = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe", "HR", "paswword");
  	        stmt = conn.createStatement();
			//rset = stmt.executeQuery("select BANNER from SYS.V_$VERSION");
  	        rset = stmt.executeQuery("select * from EMPLOYEES ORDER BY SALARY ASC");
			while (rset.next())
			{
//			        System.out.print (rset.getString(1));  
//					System.out.println(rset.getString(2));
					String nombre = rset.getString("FIRST_NAME");
					int id = rset.getInt(1);
					System.out.println("Nombre = " +nombre + " ID = "+id);
				
		
			}
		}
		catch(Exception e)
		{ 
			e.printStackTrace();
		}
		finally //libero recursos, de "adentro a fuera" , ResultSet, Statment, Conexion
		{
			if (rset != null) 	{ try { rset.close(); } catch (Exception e2) { e2.printStackTrace(); }}
			if (stmt != null)	{ try {	stmt.close(); } catch (Exception e2) { e2.printStackTrace(); }}
			if (conn != null) 	{ try { conn.close(); } catch (Exception e3) { e3.printStackTrace(); }}
		  	   
		} */ 
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			conn = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe", "HR", "paswword");
  	        stmt = conn.createStatement();
  	        rset = stmt.executeQuery(Consultas.CONSULTA_EMPLEADOS_SALARIO_ASC);
  	      
  	        while (rset.next())
			{
				nombre1 = rset.getString("FIRST_NAME");
				id1 = rset.getInt(2);
				salario1 = rset.getInt("SALARY");
				departamento1 = rset.getShort("DEPARTMENT_ID");
				nDepartamento = rset.getNString(5);
				Empleado empleados = new Empleado(id1, nombre1, salario1, departamento1, nDepartamento);
				lista_empleados.add(empleados);
		
			}
			mostrarLista(lista_empleados);
		}
		catch(Exception e)
		{ 
			e.printStackTrace();
		}
		finally 
		{
			if (rset != null) 	{ try { rset.close(); } catch (Exception e2) { e2.printStackTrace(); }}
			if (stmt != null)	{ try {	stmt.close(); } catch (Exception e2) { e2.printStackTrace(); }}
			if (conn != null) 	{ try { conn.close(); } catch (Exception e3) { e3.printStackTrace(); }}
		  	   
		} 

	}

}
