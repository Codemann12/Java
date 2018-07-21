package commando;


public class ShiftLeftCommando implements ICommando
{
    
	private boolean[] vector;
	
	public ShiftLeftCommando (boolean[] inputValues) {this.vector = inputValues;}
	
	
	@Override
	public void undo() {
		final boolean lastValue = this.vector[vector.length - 1];
		for (int i = this.vector.length - 1; i > 0; i--) this.vector[i] = this.vector[i - 1];
		this.vector[0] = lastValue;
				
	}

	@Override
	public void redo() {
		final boolean firstValue = this.vector[0];
		for (int i = 1; i < this.vector.length; i++) this.vector[i - 1] = this.vector[i];
		this.vector[vector.length - 1] = firstValue;
	}

}
