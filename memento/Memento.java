package memento;

import java.util.Arrays;

public class Memento
{
	private final boolean[] vectorState;
	public Memento(boolean[] vector) { vectorState = Arrays.copyOf(vector, vector.length);}
	boolean[] getMemento() { return vectorState;}

}
