package nature;

public class Student extends Human {

	private double id;
	
	public Student(double id) {
		super(getName());
		this.id = id;
		
	}
	
	
	public double getId(){
		return id;
	}

}
