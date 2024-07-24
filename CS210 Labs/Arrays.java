import java.util.*;
public class Arrays 
{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();
        int [] myArray = new int[size];

        System.out.println("Enter the values:");
        for(int i = 0; i < size; i++)
        {
            myArray[i] = sc.nextInt();
        }
        
      System.out.println("This is the array: " + java.util.Arrays.toString(myArray));

        sc.close();
    }    
}
