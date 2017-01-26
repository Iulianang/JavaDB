package edu.femxa.basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.Date;

public class ConsultaSalario {
	
		
		public static void main(String[] args) throws Exception {
			
			
			Connection conn = null;
			ResultSet rset = null;
			int rset2 = 0;
			Statement stmt = null;
			int salario1 = 0;
			int empleado_id = 0;
			Savepoint savepoint = null;
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver"); 
				conn = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe", "HR", "paswword");
				conn.setAutoCommit(false); //normalmente esta a true y se hace commit siempre al cerrar la conexion de la db, pero se puede poner a false
	  	        stmt = conn.createStatement();
	  	        //rset = stmt.executeQuery("select * from EMPLOYEES where JOB_ID like 'AD%'");
	  	        rset = stmt.executeQuery(Consultas.CONSULTA_EMPLEADOS_SALARIO_ASC);
	  	        rset2 = stmt.executeUpdate(Consultas.SUBIDA_SUELDO_DPTO);
	  	        savepoint = conn.setSavepoint();
	  	        //rest = stmt.executeQuerry("select department_id from departments where department_name='administration');
	  	        //rset2 = stmt.executeUpdate("UPDATE EMPLOYEES SALARY SET SALARY=round(SALARY*1.2) WHERE DEPARTMENTS_ID=10");
	  	        //UPDATE EMPLOYEES SALARY SET SALARY=round(SALARY*1.2) WHERE DEPARTMENT_ID=10 OR SALARY.DEPARTMENT_ID=60; CONSULTA ANIDADA
	  	        consultaHistorico(conn);
	  	        while (rset.next())
				{	
//					salario1 = rset.getInt("SALARY");
					salario1 = rset.getInt(3);
					empleado_id = rset.getInt(2);
					conn.setAutoCommit(false);//normalmente esta a true y se hace commit siempre al cerrar la conexion de la db, pero se puede poner a false
			  	     
				}
			}
			catch(Exception e)
			{ 
				e.printStackTrace();
				if (savepoint!=null)
				{
					conn.rollback();
				}
				
			}
			finally 
			{
				conn.commit(); //para realizar el commit
				if (rset != null) 	{ try { rset.close(); } catch (Exception e2) { e2.printStackTrace(); }}
				if (stmt != null)	{ try {	stmt.close(); } catch (Exception e2) { e2.printStackTrace(); }}
				if (conn != null) 	{ try { conn.close(); } catch (Exception e3) { e3.printStackTrace(); }}
			  	   
			} 

			
		}
		
		public static void consultaHistorico (Connection conn) throws Exception
		{
			Connection conn2 = null;
			ResultSet rset = null;
			Statement stmt = null;
			int salario_anterior = 0;
			int salario_posterior = 0;
			int empleado_id = 0;
			Date fecha = null;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver"); 
				conn2 = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe", "HR", "paswword");
	  	        stmt = conn2.createStatement();
				rset = stmt.executeQuery(Consultas.CONSULTA_SUELDOS_HISTORICO);
				
				 while (rset.next())
					{	
				  	     salario_anterior = rset.getInt("SALARIO_ANTERIOR");
				  	     salario_posterior = rset.getInt("SALARIO_POSTERIOR");
				  	     fecha = rset.getDate("FECHA_SUBIDA");
				  	     empleado_id = rset.getInt("EMPLOYEES_ID");
					}
				 System.out.println("Los salarios modificados son del empleado: "+empleado_id+" con salario inicial de " +salario_anterior+" subido a "+salario_posterior+ " subido el dia de "+fecha);
			} catch (Exception e) {
				e.printStackTrace();
				throw e; //para que el error se mande al main y se haga el rollback 
			}
			
			finally{
					rset.close();
					stmt.close();
					}
		}
}
