package serie1;

public class Person
{
	private String anrede;
	private String name;
	private String vorname;
	private double groesse;
	private double gewicht;
	
	
	public Person(String anrede, String name, String vorname, double groesse, double gewicht )
	{
		this.anrede  = anrede;
		this.name    = name;
		this.vorname = vorname;
		this.groesse = groesse;
		this.gewicht = gewicht;
		
	}
	
	// beliebige bzw. vorgabe Person
	public Person()
	{
		this.anrede  = "Herr";
		this.name    = "Tsatia";
		this.vorname = "Cedric";
		this.groesse = 180;
		this.gewicht = 90d;
		
	}
	
	// copy
	Person(Person p)
	{
		this.anrede  = p.getAnrede();
		this.name    = p.getName();
		this.vorname = p.getVorname();
		this.groesse = p.getGroesse();
		this.gewicht = p.getGewicht();
		
	}
	
	public String getAnrede()
	{
		return this.anrede;
		
	}
	
	public String getName()
	{
		return this.name;
		
	}
	
	public String getVorname()
	{
		return this.vorname;
		
	}
	
	public double getGewicht()
	{
		return this.gewicht;
		
	}
	
	public double getGroesse()
	{
		return this.groesse;
		
	}
	
	public void setAnrede(String anrede)
	{
		this.anrede = anrede;
	}
	
	public void setname(String name)
	{
		this.name = name;
	}
	
	public void setVorname(String vorname)
	{
		this.vorname = vorname;
	}
		
	public void setGroesse(double gro)
	{
		if(gro > 2)
			System.out.println("Leute über 2m werden hier nicht zugelassen");
		else
			this.groesse = gro;
	}
		
	public void setGewicht(double ge)
	{ 
		if(ge > 180)
			System.out.println("Leute über 180kg werden hier nicht zugelassen");
		else
			this.gewicht = ge;
	}
	
	
	
	public String toString()
	{
		return this.getAnrede() + " " + this.getName() + " " + this.getVorname() + " "+
	           this.getGroesse() + " "+ this.getGewicht();
	}
	
	
	
	public static boolean isIdentical(Person p1, Person p2)
	{
		return p1.toString().equals(p2.toString());
	}
	
	
	
	
	public static void main(String[] args) 
	{
		Person cedric = new Person("Herr", "Tsatia", "Cedric", 51d, 48d);
		Person stanie = new Person("Herr", "Ngoufo", "Stanie", 1d, 4d);
		Person cedric1 = new Person(cedric);
		
		System.out.println("Comparing cedric and his copy: "+isIdentical(cedric, cedric1));
		System.out.println("Comparing cedric and his stanie: "+isIdentical(stanie, cedric1));

	}
	
	

}
