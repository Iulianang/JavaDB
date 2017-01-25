package edu.femxa.basedatos;

public class Consultas {

	public static final String CONSULTA_EMPLEADOS_SALARIO_ASC = "SELECT E.FIRST_NAME, E.EMPLOYEE_ID, E.SALARY, E.DEPARTMENT_ID, D.DEPARTMENT_NAME from EMPLOYEES E, DEPARTMENTS D where E.DEPARTMENT_ID = D.DEPARTMENT_ID ORDER BY E.SALARY DESC";
	public static final String CONSULTA_SUELDOS_HISTORICO = "SELECT SSALARIO_ID, SALARIO_ANTERIOR, SALARIO_POSTERIOR, FECHA_SUBIDA, EMPLOYEES_ID from SUBIDA_SALARIO where TO_DATE (FECHA_SUBIDA, 'DD/MM/YYYY') = TO_DATE (sysdate, 'DD/MM/YYYY')";
	public static final String SUBIDA_SUELDO_DPTO = "UPDATE EMPLOYEES SALARY SET SALARY=round(SALARY*1.2) WHERE DEPARTMENT_ID=60 OR DEPARTMENT_ID=10";
//	public static final String SUBIDA_SUELDO_DPTO = "UPDATE EMPLOYEES SET salary = (salary * 1.2)"
//			+ "where department_id IN "
//			+ "(SELECT department_id FROM "
//			+ "DEPARTMENTS WHERE department_name = "
//			+ "'Administration' or "
//			+ "department_name = 'IT')";
}
