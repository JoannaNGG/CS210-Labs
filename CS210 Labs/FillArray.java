//import java.util.*;
public class FillArray 
{
    public static void main(String [] args)
    {
        int [] randomArray = new int[5];

        for(int i = 0; i < randomArray.length; i++)
        {
            /*This will only generate ints from 0 to 10 because in Math.random() it only generates
              up to N-1 given N is the number it is multiplied by (in this case 11).
            */
           randomArray[i] = ((int)(Math.random()*11)); 
        }

        for(int i = 0; i < randomArray.length; i++)
        {
           System.out.println("Elements of the array: " + randomArray[i]);
        }
        
    }
}
