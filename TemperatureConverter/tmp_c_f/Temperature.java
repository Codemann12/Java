package tmp_c_f;
import java.util.Scanner;

public class Temperature {

	public static void main(String[] args) 
	{
	  char stoppeur = 'o';
	  Scanner scanner = new Scanner(System.in);
	  while(stoppeur == 'o')
	   {
	      System.out.println("CONVERTISSEURS DEGRÉS CELCIUS ET DEGRÉS FAHRENHEIT");
	      System.out.println("--------------------------------------------------");
	      System.out.println("\nChoisissez le monde de conversion : ");
	      System.out.println("1 - Convertisseur Celcius - Fahrenheit");
	      System.out.println("2 - Convertisseur Fahrenheit - Celcius");
	  
	      
	      int choix  = scanner.nextInt();
	  	  
	      if(choix == 1)
	      {
		    System.out.println("Temperature à convertir : ");
		    double temp = scanner.nextDouble();
		    double resultat = (9*temp)/5 + 32;
		    System.out.println(temp+" °C correspond à : "+ resultat +" °F");
		    System.out.println("Souhaitez-vous convertir une autre temperature ? (o/n)");
		    scanner.nextLine();
		    String stopOrContinu = scanner.nextLine();
		    stoppeur = stopOrContinu.charAt(0);
		 }
	     else if(choix == 2)
	     {
			System.out.println("Temperature à convertir : ");
			double temp = scanner.nextDouble();
			double resultat = (temp - 32)*5 / 9;
			System.out.println(temp+" °F correspond à : "+ resultat +" °C");
			System.out.println("Souhaitez-vous convertir une autre temperature ? (o/n)");
			scanner.nextLine();
			String stopOrContinu = scanner.nextLine();
			stoppeur = stopOrContinu.charAt(0);
	    	  
	     }
	     else
	     {  System.out.println("Mauvais choix!");
	    	System.out.println("Souhaitez-vous  toujours convertir une temperature ? (o/n)");
			scanner.nextLine();
			String stopOrContinu = scanner.nextLine();
			stoppeur = stopOrContinu.charAt(0);
	     }		 
	  }
  scanner.close();
  System.out.println("Au revoir!");
   }
	
}
