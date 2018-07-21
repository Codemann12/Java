package commando;

import java.util.*;

public final class BooleanVector{

	@SuppressWarnings("unused")
	private static final int MAX_UNDO_STEPS = 10;

	private final boolean[] vector;
    private Deque<ICommando> undoDeque = new LinkedList<>();
    private Deque<ICommando> redoDeque = new LinkedList<>();
    
	public BooleanVector(boolean[] inputValues) {
		this.vector = inputValues;
	}

	/**
	 * (TRUE,FALSE,FALSE) invert returns: (FALSE,TRUE,TRUE) <br/>
	 * (TRUE,TRUE,TRUE) invert returns: (FALSE,FALSE,FALSE)
	 */
	public void invert() {
		ICommando command = new InvertCommando(vector);
		command.redo();

		undoDeque.add(command);
		if(undoDeque.size() > MAX_UNDO_STEPS) undoDeque.removeFirst();
		redoDeque.clear();
	}

	/**
	 * (TRUE,FALSE,FALSE) shift left returns: (FALSE,FALSE,TRUE) <br/>
	 * (FALSE,TRUE,FALSE) shift left returns: (TRUE,FALSE,FALSE)
	 */
	public void shiftLeft()	{
		ICommando command = new ShiftLeftCommando(vector);
		command.redo();

		undoDeque.add(command);
		if(undoDeque.size() > MAX_UNDO_STEPS) undoDeque.removeFirst();
		redoDeque.clear();
	}

	/**
	 * (TRUE,FALSE,FALSE) shift right returns: (FALSE,TRUE,FALSE) <br/>
	 * (FALSE,FALSE,TRUE) shift right returns: (TRUE,FALSE,FALSE)
	 */
	public void shiftRight() {
		ICommando command = new ShiftRightCommando(vector);
		command.redo();

		undoDeque.add(command);
		if(undoDeque.size() > MAX_UNDO_STEPS) undoDeque.removeFirst();
		redoDeque.clear();
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

	public void undo() {
		if(undoDeque.isEmpty())	throw new IllegalStateException("Nothing to undo");
		ICommando cmd = undoDeque.removeLast();
		cmd.undo();
		redoDeque.add(cmd);
	}

	public void redo() {
		if(redoDeque.isEmpty())	throw new IllegalStateException("Nothing to redo");
		ICommando cmd = redoDeque.removeLast();
		cmd.redo();
		undoDeque.add(cmd);
			
	}

}
