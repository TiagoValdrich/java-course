package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		 
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many employees will be registered? ");
		int numberOfEmployees = sc.nextInt();
		
		System.out.println("");
		
		List<Employee> list = new ArrayList<>();
		
		for(int i = 0; i < numberOfEmployees; i++) {
			
			System.out.println("Employee #" + (i + 1));
			
			System.out.print("Id: ");
			int id = sc.nextInt();
			
			sc.nextLine();
			
			System.out.print("Name: ");
			String name = sc.nextLine();
			
			System.out.print("Salary: ");
			double salary = sc.nextDouble();
			
			Employee employee = new Employee(id, name, salary);
			list.add(employee);
			
			System.out.println("");
			
			
		}
		
		System.out.print("Enter the employee id that will have salary increase: ");
		int employeeId = sc.nextInt();
		
		Employee employee = list.stream().filter(x -> x.getId() == employeeId).findFirst().orElse(null);
		
		if (employee != null) {			
			
			System.out.print("Enter the percentage: ");
			double percentage = sc.nextDouble();
			
			employee.increaseSalary(percentage);
			
		} else {
			
			System.out.println("This id does not exist!");
			
		}
		
		System.out.println("");
		
		for(Employee emp : list) {
			
			System.out.println(emp);
			
		}
		
		sc.close();

	}

}
