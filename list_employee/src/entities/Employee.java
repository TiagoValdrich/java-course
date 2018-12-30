package entities;

public class Employee {

	private Integer id;
	private String name;
	private Double salary;
	
	public Employee() {
	}

	public Employee(Integer id, String name, Double salario) {
		this.id = id;
		this.name = name;
		this.salary = salario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}
	
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	public void increaseSalary(double percentage) {
		double result = this.getSalary() + ( this.getSalary() * (percentage / 100) );
		this.setSalary(result);
	}
	
	public String toString() {
		return this.getId() + ", " + this.getName() + ", " + String.format("%.2f", this.getSalary());
	}
	
}
