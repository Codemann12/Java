package nature;

public class Human  implements AnimalAndHuman{
	
	private static String name;
	
	public Human (String name){
		this.setName(name);
	}

	public void eat() {
		System.out.println(getName()+ " is eating");
		
	}

	public void walk() {
		System.out.println(getName()+" is walking");
		
	}

	public static String getName() {
		return name;
	}

	public void setName(String name) {
		Human.name = name;
	}

}
