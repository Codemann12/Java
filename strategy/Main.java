package strategy;
import java.util.*;

public class Main {

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Give the List you want to sort.");
				
		String input = in.nextLine();
		String [] strings = input.split(" ");
		int [] x = new int [strings.length];
		for(int i = 0; i < strings.length; i++) {
			x[i] = Integer.parseInt(strings[i]);
		}
		
		
		Kontext kontext = new Kontext();
		kontext.setX(x);
		
		System.out.println("How do you want to sort the given List?"
				+ " Give  bubble for bubblesort or quick for quicksort.");
		String choice = in.nextLine();
		in.close();
		if(choice.equals("bubble")) {
			kontext.setStrategy(new Bubblesort());
			kontext.arbeite();
			System.out.println("List to be sort using bubblesort:");
			for(String str : strings) {
				System.out.print(str +", ");
			}
			System.out.println();
			System.out.println("sorted list:");
			for(int num : x) {
				System.out.print(num +", ");
			}
		}else if(choice.equals("quick")) {
			kontext.setStrategy(new Quicksort());
			kontext.arbeite();
			System.out.println("List to be sort using quicksort:");
			for(String str: strings) {
				System.out.print(str +", ");
			}
			System.out.println();
			System.out.println("sorted list:");
			for(int num : x) {
				System.out.print(num +", ");
			}			
			
		}else {
			System.out.println("The input was wrong"
					+ "Give  bubble for bubblesort or quick for quicksort.");
		}
	}
}
