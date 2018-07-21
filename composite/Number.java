package composite;

public class Number extends Term
{
	private double number;
	

	public Number(double number){this.number = number;}

	@Override
	public double berechnen() {	return this.number;}
	
	

	public double getNumber() {	return number;}
	public void setNumber(double number) {this.number = number;	}

}
