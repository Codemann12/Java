package composite;
import java.lang.IllegalArgumentException;

public class Division extends Term
{
	private Term term1;
	private Term term2;
	
	public Division(Term term1, Term term2) throws IllegalArgumentException
	{
		if(term2.berechnen() == 0)
			throw new IllegalArgumentException();
		this.term1 = term1;
		this.term2 = term2;
		
	}

	@Override
	public double berechnen() throws IllegalArgumentException
	{
		if(term2.berechnen() == 0)
			throw new IllegalArgumentException();
		return term1.berechnen() / term2.berechnen();
	}

	
	public Term getTerm1() {return term1;}
	public void setTerm1(Term term1) {this.term1 = term1;}
	public Term getTerm2() {return term2;}
	public void setTerm2(Term term2) {this.term2 = term2;}
	
	
}
