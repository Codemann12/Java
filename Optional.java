
public class Optional {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int j = 0;
            j = args.length;
        for(int i = 0; i< args.length; i++){
            
            if (j == 1) {
               System.out.println(args[i]); 
            }else  {
                System.out.println(args[i]+",");
                j--;
            }
            
            
        }

    }

}
