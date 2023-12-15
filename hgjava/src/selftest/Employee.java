package selftest;

public class Employee {
	private String empNumber;
	private String empName;
	private String empPhone;
	private String empDate;
	private int empSalary;
	
	Employee(){
		
	}

	public Employee(String empNumber, String empName, String empPhone, String empDate, int empSalary) {
		this.empNumber = empNumber;
		this.empName = empName;
		this.empPhone = empPhone;
		this.empDate = empDate;
		this.empSalary = empSalary;
	}
	
	//메소드 정의
	void showDateInfo() {
		System.out.println(empNumber + empName + empDate);
	}

	void shoPhoneInfo() {
		System.out.println(empNumber + empName + empPhone);
	}
	
	void setEmpNumber(String empNumber) {
		this.empNumber = empNumber;
	}

	void setEmpName(String empName) {
		this.empName = empName;
	}

	void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}

	void setEmpDate(String empDate) {
		this.empDate = empDate;
	}

	void setEmpSalary(int empSalary) {
		this.empSalary = empSalary;
	}

	String getEmpNumber() {
		return empNumber;
	}

	String getEmpName() {
		return empName;
	}

	String getEmpPhone() {
		return empPhone;
	}

	String getEmpDate() {
		return empDate;
	}

	int getEmpSalary() {
		return empSalary;
	}
	
	
}
