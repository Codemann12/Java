package memento;

public class ShiftLeftOriginator
{
	private boolean[] vector;
	
	public ShiftLeftOriginator(boolean[] vector) {this.vector = vector;}
	
	public void execute()
	{
		final boolean firstValue = this.vector[0];
		for (int i = 1; i < this.vector.length; i++) {
			this.vector[i - 1] = this.vector[i];
		}
		this.vector[vector.length - 1] = firstValue;
	}	
	
	public Memento saveToMemento() {return new Memento(vector);}
	
}
