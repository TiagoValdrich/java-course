package course;

import java.util.Locale;
import java.util.Scanner;

public class Exercise_02 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		// Declaring variables
		String name;
		String lastName;
		int bedrooms;
		int age;
		double productPrice;
		double height;
		
		System.out.println("Enter your full name:");
		name = sc.nextLine();
		
		System.out.println("How many bedrooms are there in your house?");
		bedrooms = sc.nextInt();
		
		System.out.println("Enter product price:");
		productPrice = sc.nextDouble();
		
		System.out.println("Enter your last name, age and height (same line)");
		lastName = sc.next();
		age = sc.nextInt();
		height = sc.nextDouble();
		
		System.out.println(" ---------------------- * ----------------------");
		System.out.println(name);
		System.out.println(bedrooms);
		System.out.println(productPrice);
		System.out.println(lastName);
		System.out.println(age);
		System.out.println(height);
		
		sc.close();

	}

}
