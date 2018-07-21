package composite;


public class Sin extends Term
{
	private Term term1;
	public Sin(Term term1){this.term1 = term1;}
    @Override
	public double berechnen()
    {
    	double radian = Math.toRadians(term1.berechnen());
    	return  Math.sin(radian);
    }
	public Term getTerm1() {return term1;}
	public void setTerm1(Term term1) {this.term1 = term1;}


}
