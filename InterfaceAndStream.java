/*
 * This program is used to implement functional interface
 * and stream Api to manipulate the data set(employees data) 
 * 
 */
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Employee class
class Employee {
	int age;
	String name, department;
	float salary;
	public Employee(String name, int age, String department, float salary) {
		this.name = name;
		this.age = age;
		this.department = department;
		this.salary = salary;
	}
	// setters and getters
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return this.age;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDepartment() {
		return this.department;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public float getSalary() {
		return this.salary;
	}
}
@FunctionalInterface
interface generateNameAndDept {
	public String nameAndDept(Employee employee);
}
public class InterfaceAndStream implements generateNameAndDept {
	
	public static void main(String[] args) {
		// A list of employees
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee("Alice",25,"Computer Scicence",23000));
		employeeList.add(new Employee("John",35,"Biology",30000));
		employeeList.add(new Employee("Bob",42,"Software engineering",43000));
		employeeList.add(new Employee("Alex",22,"Artificial Intelligence",53000));
		employeeList.add(new Employee("Sam",38,"Data scinece",22000));
		
		// collection containing name and department of employees
		List<String> employeeInfo = employeeList.stream().map((employee) -> "Name: " + employee.getName() +
		" Department: " + employee.getDepartment()).collect(Collectors.toList());
//		System.out.println(employeeInfo);	
		
		// average salary of employees
		float totalSalary = employeeList.stream().map((employee) -> employee.getSalary()).reduce(0f, (a, b) -> a + b);
		float averageSalary = totalSalary / employeeList.size();
//		System.out.println(averageSalary);
				
		// filtering employees based on age(age >= 30)
		List<Integer> ageAboveThirty = employeeList.stream().map((employee) -> employee.getAge()).filter(age -> age >= 30).collect(Collectors.toList());
		System.out.println(ageAboveThirty);		
}

}

