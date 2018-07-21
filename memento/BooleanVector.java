package memento;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;


public final class BooleanVector {

	@SuppressWarnings("unused")
	private static final int MAX_UNDO_STEPS = 10;
	private boolean[] vector;
	private Deque<Memento> mementoUndoList = new LinkedList<>();
	private Deque<Memento> mementoRedoList = new LinkedList<>();

	public BooleanVector(boolean[] inputValues) {
		this.vector = inputValues;
	}

	/**
	 * (TRUE,FALSE,FALSE) invert returns: (FALSE,TRUE,TRUE) <br/>
	 * (TRUE,TRUE,TRUE) invert returns: (FALSE,FALSE,FALSE)
	 */
	public void invert() 
	{
		InverterOriginator inverter = new InverterOriginator(vector);
		mementoUndoList.add(inverter.saveToMemento());
		inverter.execute();	
		mementoRedoList.add(inverter.saveToMemento());
	}

	/**
	 * (TRUE,FALSE,FALSE) shift left returns: (FALSE,FALSE,TRUE) <br/>
	 * (FALSE,TRUE,FALSE) shift left returns: (TRUE,FALSE,FALSE)
	 */
	public void shiftLeft() 
	{
		ShiftLeftOriginator shiftLeft = new ShiftLeftOriginator(vector);
		mementoUndoList.add(shiftLeft.saveToMemento());
		shiftLeft.execute();	
		mementoRedoList.add(shiftLeft.saveToMemento());
		
	}

	/**
	 * (TRUE,FALSE,FALSE) shift right returns: (FALSE,TRUE,FALSE) <br/>
	 * (FALSE,FALSE,TRUE) shift right returns: (TRUE,FALSE,FALSE)
	 */
	public void shiftRight() 
	{
		ShiftRightOriginator shiftRight = new ShiftRightOriginator(vector);
		mementoUndoList.add(shiftRight.saveToMemento());
		shiftRight.execute();	
		mementoRedoList.add(shiftRight.saveToMemento());
	}

	@Override
	// do not change
	public String toString() {
		return Arrays.toString(this.vector);
	}

	@Override
	// do not change
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (!(obj instanceof BooleanVector)) return false;
		BooleanVector otherVector = (BooleanVector) obj;
		return Arrays.equals(this.vector, otherVector.vector);
	}

	public void undo() 
	{
		if(mementoUndoList.size() > MAX_UNDO_STEPS) {throw new IllegalStateException("Nothing to undo");}		
		this.vector =  mementoUndoList.pop().getMemento();		
	}

	public void redo() 
	{
		if(mementoRedoList.size() > MAX_UNDO_STEPS) {throw new IllegalStateException("Nothing to redo");}
		this.vector = mementoRedoList.pop().getMemento();		
	}
}
