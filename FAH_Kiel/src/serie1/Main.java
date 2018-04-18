package serie1;

import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Geben Sie eine Zahl gößer als 4!");
		int input = scanner.nextInt();
		while(input == 0 || input > 4) 
		{
			System.out.println("Geben Sie eine Zahl gößer als 4!");
			input = scanner.nextInt();
		}
		System.out.println("Eingabe liegt zwischen 1 und 4...bye bye");
		scanner.close();
			

	}

}
