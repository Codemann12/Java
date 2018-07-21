package strategy;

public class Quicksort extends Strategy {

	@Override
	public void sort(int x[]){qSort(x, 0, x.length-1);}
		    
	public void qSort(int x[], int links, int rechts)
	{
		if (links < rechts) {
		  int i = partition(x,links,rechts);
		  qSort(x,links,i-1);
	      qSort(x,i+1,rechts);
	     }
	 }
		    
	public int partition(int x[], int links, int rechts)
	{
		int pivot, i, j, help;
		pivot = x[rechts];               
		i     = links;
		j     = rechts-1;
		while(i<=j) {
		if (x[i] > pivot) {     
		   help = x[i]; 
		   x[i] = x[j]; 
		   x[j] = help;                             
		   j--;
		 } else i++;            
		  }
		 help      = x[i];
		 x[i]      = x[rechts];
		 x[rechts] = help;
		 return i;
	  }
	
}
