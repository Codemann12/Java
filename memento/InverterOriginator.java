package memento;

public class InverterOriginator 
{
	private boolean[] vector;
	
	public InverterOriginator(boolean[] vector) {this.vector = vector;}
	
	public void execute()
	{
		for (int i = 0; i < this.vector.length; i++) {
			this.vector[i] = !this.vector[i];
		}
	}	
	
	public Memento saveToMemento() {return new Memento(vector);}

}
