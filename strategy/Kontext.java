package strategy;

public class Kontext 
{
	private Strategy strat;
	private int[] x;
	
	public void setStrategy(Strategy strat){this.strat = strat;	}
	
	public void arbeite()
	{
		if(strat != null)
			strat.sort(x);
	}

	public void setX(int[] x) {this.x = x;}

}
