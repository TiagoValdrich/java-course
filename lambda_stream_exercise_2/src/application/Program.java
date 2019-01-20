package application;

import entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the file path: ");
        String filePath = sc.nextLine();

        System.out.print("Enter the salary: ");
        Double salary = sc.nextDouble();

        try (BufferedReader br = new BufferedReader( new FileReader(filePath))) {

            List<Employee> employeeList = new ArrayList<>();

            String line = br.readLine();

            while (line != null) {

                String[] fields         = line.split(",");
                String employeeName     = fields[0];
                String employeeEmail    = fields[1];
                Double employeeSalary   = Double.parseDouble(fields[2]);

                Employee employee = new Employee(employeeName, employeeEmail, employeeSalary);
                employeeList.add(employee);

                line = br.readLine();

            }

            System.out.println("Email of people whose salary is more than 2000.00:");

            Comparator<String> comp = (s1, s2) -> s1.toLowerCase().compareTo(s2.toLowerCase());

            List<String> filteredEmails = employeeList.stream()
                    .filter(e -> e.getSalary() > salary)
                    .map(e -> e.getEmail())
                    .sorted(comp)
                    .collect(Collectors.toList());

            filteredEmails.forEach(System.out::println);

            double sumOfSalary = employeeList.stream()
                    .filter(e -> e.getName().charAt(0) == 'M')
                    .map(e -> e.getSalary())
                    .reduce(0.0, (x, y) -> x + y);

            System.out.println("Sum of salary of people whose name starts with 'M': " + sumOfSalary);

        } catch (IOException e) {

            System.out.println("Error: " + e.getMessage());

        } finally {

            sc.close();

        }

    }

}
