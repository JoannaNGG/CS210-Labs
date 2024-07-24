import java.util.*;
public class Lab2 
{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter card number to check:");

        String card = sc.nextLine(); //Read the card in as a String.
        
        int[] cardArray = new int[card.length()]; //Store the digits into an array.
        for(int i = 0; i < card.length(); i++) //Read the digits as long as its < card length.
        {
            cardArray[i] = Character.getNumericValue(card.charAt(i)); //Populate the array with each numeric value that is read at the char at (i).
        }

        int sum = addSum(cardArray); //Call the array to calculate the given digits.

        if(sum % 10 == 0) //If it is dividable by 10, then it is valid.
        {
            System.out.println("VALID.");
        }
        else
        {
            System.out.println("INVALID.");
        }

        sc.close();
    }


    public static int addSum(int[] array) //Use int[] parameter because we'll need to call this method for an array. -> int sum = addNum(cardArray); 
    {
        int sum = 0; //Used to store the sum of every digit; currently empty.

        for(int i = array.length - 1; i >= 0; i--) //Reading the array given from right to left.
        {
            int num = array[i]; //Sets num to the value of whatever is at index i in array.
            if((array.length - i) % 2 == 0) //Check that the digit in the array is the an even one from right to left.
            {
                num*= 2; //If it's at an even position, double the digit.
                if(num > 9)
                {
                    num -= 9; //If it's greater than 9, subract 9 from the number. (Luhn's Algorithm)
                }
            }

            sum += num; //Add everything together.
        }
        return sum; //Return the final calculation.
    }
}
