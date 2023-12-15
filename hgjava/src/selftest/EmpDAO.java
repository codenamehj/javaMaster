package selftest;

import java.util.ArrayList;

public class EmpDAO {
	private ArrayList<Employee> employees;
	
	EmpDAO(){
		employees = new ArrayList<Employee>();
	}
	
	boolean addEmployee(Employee employee) {
		return employees.add(employee);
	}
	
	ArrayList<Employee> getEmpList(){
		return employees;
	}
	
}
