package edu.femxa.basedatos;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class EmpleadosDAO {
	
	public List<EmpleadosDTO> consultaAllEmpleados () throws Exception
	{
		List<EmpleadosDTO> lista_e = null;
		lista_e = new ArrayList<EmpleadosDTO>();
		int employee_id = 0;
		String first_name = null;
		String last_name = null;
		int salary = 0;
		int department_id= 0;
		EmpleadosDTO consultaE = null;
		Connection con = null;
		ResultSet rs = null;
		Statement st = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			con = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe", "HR", "paswword");
			st = con.createStatement();
			rs = st.executeQuery(Consultas.CONSULTA_EMPLEADOS);
			
			while(rs.next())
			{
				employee_id = rs.getInt("EMPLOYEE_ID");
				first_name= rs.getString("FIRST_NAME"); 
				last_name = rs.getString("LAST_NAME");
				salary = rs.getInt("SALARY");
				department_id = rs.getInt("DEPARTMENT_ID");
				consultaE = new EmpleadosDTO(employee_id, first_name, salary, department_id);
				lista_e.add(consultaE);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally
		{
			if (rs != null) 	{ try { rs.close(); } catch (Exception e2) { e2.printStackTrace(); }}
			if (st != null)	{ try {	st.close(); } catch (Exception e2) { e2.printStackTrace(); }}
			if (con != null) 	{ try { con.close(); } catch (Exception e3) { e3.printStackTrace(); }}
		}
		return lista_e;
	}
	
	
}

