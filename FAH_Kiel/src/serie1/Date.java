package date;

public class Date 
{
   private int day;
   private int month;
   private int year;
   
   
   public Date(int d, int m, int y)
   {
	   
	   this.day = d;
	   this.month = m;
	   this.year = y;
	  
   }
   
  // Vorgabe 01.01.1900
   public Date()
   {
	   
	   this.day = 1;
	   this.month = 1;
	   this.year = 1900;
	  
   }
   
   
   public Date(Date date)
   {
	   
	   this.day = date.getDay();
	   this.month = date.getMonth();
	   this.year = date.getYear();
	  
   }
   
   public void setDay(int d)
   {	   
	   if(d <= 31 && d >= 28 )
		   this.day = d;
	   else
		   System.out.println("Wrong date");
	   
   }
   
   public void setMonth(int m)
   {
	   switch (m) {
       case 1:  if(this.day > 31)
    	           System.out.println("Wrong date");
                else
                	this.month = m;
                break;
       case 2:  if(this.day > 29)
                  System.out.println("Wrong date");
               else
        	    this.month = m;
                break;
       case 3:  if(this.day > 31)
                  System.out.println("Wrong date");
               else
        	      this.month = m;
               break;
       case 4: if(this.day > 30)
                  System.out.println("Wrong date");
               else
 	              this.month = m;
               break;
       case 5:  if(this.day > 31)
                  System.out.println("Wrong date");
               else
        	     this.month = m;
                break;
       case 6:  if(this.day > 30)
                 System.out.println("Wrong date");
                else
                 this.month = m;
                break;
       case 7:  if(this.day > 31)
                 System.out.println("Wrong date");
                else
        	     this.month = m;
                break;
       case 8:  if(this.day > 30)
                 System.out.println("Wrong date");
                else
                 this.month = m;
                break;
       case 9:  if(this.day > 31)
                 System.out.println("Wrong date");
                else
        	      this.month = m;
                break;
       case 10:  if(this.day > 30)
                  System.out.println("Wrong date");
                 else
                  this.month = m;
                 break;
       case 11: if(this.day > 31)
                 System.out.println("Wrong date");
                else
        	     this.month = m;
                break;
       case 12: if(this.day > 30)
                  System.out.println("Wrong date");
                else
                  this.month = m;
                break;
       default:  System.out.println("Wrong date");
                break;
   }

   }
   
   public void setYear(int y)
   {
	   if(!(y%4 == 0 && y%100 != 0) && !(y % 400 == 0))
	   {
		   if(this.month == 2 && this.day == 29)
			   System.out.println("Wrong date");
	   }
	   
	  if(y >= 0)
		   this.year = y;
	   else
		  System.out.println("Wrong date");
   }
   
   public int getDay()
   {
	   return this.day;
   }
   
   public int getMonth()
   {
	   return this.month;
   }
   
   public int getYear()
   {
	   return this.year;
   }
   

   public String prettyPrinter() 
   {   
	   if(this.getDay() <= 9 && this.getMonth() <= 9)
	   { 
		   String goodFormatDay = String.format("%02d", this.getDay());
		   String goodFormatMonth = String.format("%02d", this.getMonth());
		   return goodFormatDay +"." + goodFormatMonth +"."+this.getYear();
	   }
	   
      if (this.getMonth() <= 9)
      {
    	  String goodFormatMonth = String.format("%02d", this.getMonth());
	   	   return this.getDay() +"." + goodFormatMonth +"."+this.getYear();
       }
      
      if (this.getDay() <= 9)
      {
    	  String goodFormatDay= String.format("%02d", this.getDay());
	   	   return goodFormatDay +"." + this.getMonth() +"."+this.getYear();
       }
      
      return this.getDay() +"."+ this.getMonth()+"."+this.getYear();
   }
   
   
  public boolean monatsultimo()
  {
	  switch (this.month) {
      case 1:  return (this.day == 31);
               
   	           
      case 2:  if((this.year%4 == 0 && this.year%100 != 0) || (this.year % 400 == 0))
                 return this.day == 29;
              else
            	 return this.day == 28;
               
      case 3: return (this.day == 31);
              
      case 4: return (this.day == 30);
              
      case 5: return (this.day == 31);
      		 
      case 6: return (this.day == 30);
              
      case 7: return (this.day == 31);
              
      case 8: return (this.day == 30);
              
      case 9: return (this.day == 31);
              
      case 10:return (this.day == 30);
              
      case 11:return (this.day == 31);
              
      case 12:return (this.day == 30);
              
      default:  System.out.println("Wrong date");
               return false;
    }
  }


public static void main( String[] args)
{
	Date today = new Date(28,2,2018);
	//today.setYear(2020);
	Date date = new Date();
	System.out.println(date.prettyPrinter());
	System.out.println(today.prettyPrinter());
	System.out.println(today.monatsultimo());
	
}


}
