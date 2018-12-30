package application;

import java.util.Scanner;

import entities.Estudante;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Estudante[] rooms = new Estudante[10];
		
		System.out.print("Enter the quantitiy of students that will rent the rooms: ");
		int numberOfStudents = sc.nextInt();
		
		for (int i = 0; i < numberOfStudents; i++) {
			
			sc.nextLine();
			
			System.out.print("Enter the name of the student: ");
			String name = sc.nextLine();
			
			System.out.print("Enter the student e-mail: ");
			String email = sc.nextLine();
			
			System.out.print("Number of the room: ");
			int room = sc.nextInt();
			
			rooms[room] = new Estudante(name, email);
		}
		
		for(int j = 0; j < rooms.length; j++) {
			
			if (rooms[j] != null) {
				System.out.println(j + ": " + rooms[j].getName() + ", " + rooms[j].getEmail());
			}
			
		}
		
		sc.close();

	}

}
