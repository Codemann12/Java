package memento;

public class ShiftRightOriginator
{
	private boolean[] vector;
	
	public ShiftRightOriginator(boolean[] vector) {this.vector = vector;}
	
	public void execute()
	{
		final boolean lastValue = this.vector[vector.length - 1];
		for (int i = this.vector.length - 1; i > 0; i--) {
			this.vector[i] = this.vector[i - 1];
		}
		this.vector[0] = lastValue;
	}	
	
	public Memento saveToMemento() {return new Memento(vector);}
	
}
