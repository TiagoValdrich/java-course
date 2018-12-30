package course;

import java.util.Locale;

public class Exercise_01 {

	public static void main(String[] args) {
		
		String product1 = "Computer";
		String product2 = "Office Desk";
		
		int age = 30;
		int code = 5290;
		char gender = 'F';
		
		double price1 = 2100.0;
		double price2 = 650.50;
		double measure = 53.234567;
		
		System.out.println("Products:");
		System.out.printf("%s, which price is R$ %.2f%n", product1, price1);
		System.out.printf("%s, which price is R$ %.2f%n", product2, price2);
		System.out.println("");
		
		System.out.printf("%d years old, code %d and gender: %c%n", age, code, gender);
		System.out.println("");
		
		System.out.printf("Measure with decimal places: %f%n", measure);
		System.out.printf("Rounded (three decimal places): %.3f%n", measure);
		
		// TROCANDO O LOCALE PARA MOSTRAR NO FORMATO DOS EUA.
		Locale.setDefault(Locale.US);
		System.out.printf("US decimal point: %.3f", measure);
		

	}

}
