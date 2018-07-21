package commando;

public class InvertCommando implements ICommando
{
    
	private boolean[] vector;
	
	public InvertCommando (boolean[] inputValues){this.vector = inputValues;}
	

	@Override
	public void undo() {
		for (int i = 0; i < this.vector.length; i++) {
			this.vector[i] = !this.vector[i];
		}						
	}

	@Override
	public void redo() {
		for (int i = 0; i < this.vector.length; i++) {
			this.vector[i] = !this.vector[i];
		}
	}

}

