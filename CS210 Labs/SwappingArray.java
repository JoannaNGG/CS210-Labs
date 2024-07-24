import java.util.*;
public class SwappingArray 
{
    public static void main(String [] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: " );
        int size = sc.nextInt();
        int [] myArray = new int[size];
        sc.close();

        System.out.println(""); //To put a break in the console
        System.out.print("Enter the values to populate the array of size " + size + ": ");
        
        for(int i = 0; i < size; i++)
        {
            myArray[i] = sc.nextInt(); //To populate the array with User Input.
        }

        for(int j = 0; j < size; j++)
        {
            int temp = myArray[j];
            int random = (int)(Math.random()*myArray[j]);
            myArray[j] = myArray[random];
            myArray[random] = temp;
        }

        //To print the contents of the array.
        System.out.println("Contents of the array, randomized: ");
        for(int i = 0; i <myArray.length; i++)
        {
            System.out.print(myArray[i]);
        }
    }
}
