package strategy;

public class Bubblesort extends Strategy
{

	@Override
	public void sort(int[] x)
	{
	  boolean unsortiert=true;
	  int temp;
	     while (unsortiert){
	        unsortiert = false;
	         for (int i=0; i < x.length-1; i++) 
		        if (x[i] > x[i+1]) {                      
		          temp       = x[i];
		          x[i]       = x[i+1];
		          x[i+1]     = temp;
		          unsortiert = true;
		         }          
		      } 
		   }
	}

	
    
