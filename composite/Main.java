package composite;

public class Main 
{
	public static void main(String[] args)
	{
		// some leaves
		Number num10 = new Number(10);
		Number num8  = new Number(8);
		Number num7  = new Number(7);
		Number num90 = new Number(90);
		Number num0  = new Number(0);
		
		
		//Now Test the composite (10/8)-(7/90) - sin(90)
		try 
		{
			Division div1 = new Division(num10, num8);
			Division div2 = new Division(num7, num90);
			Substraction sub = new Substraction(div1, div2);
			Sin sin = new Sin(num90);
			Substraction result = new Substraction(sub, sin);
			
			System.out.println("10/8 = "+ div1.berechnen());
			System.out.println("7/90 = "+ div2.berechnen());
			System.out.println("(10/8) - (7/90) = "+ sub.berechnen());
			System.out.println("sin 90 = "+ sin.berechnen());
			System.out.println("(10/8) - (7/90)- sin(90) = "+result.berechnen());
			
			
			Division div0 = new Division(num10, num0);
			div0.berechnen();
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("Second argument of the division is 0.");
		}
		
		
	}

}
