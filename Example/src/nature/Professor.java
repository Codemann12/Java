package nature;

public class Professor extends Human{
	
	
	public String specialisation;
	public Professor(String specialisation) {
		super(getName());
		this.specialisation=specialisation;
	}

	
	public String getSpecialisation(){
		return specialisation;
	}
	
	public static void main(String[] args){
		AnimalAndHuman cat = new Animal();
		cat.eat();
		new Human("Cedric");
		Student student = new Student(102015);
		student.eat();
	}
}
