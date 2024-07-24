import java.util.*;
public class LabTwo 
{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the card number to check:");
        
        String card = sc.nextLine(); //Take in the card as a string.

        int[] cardArray = new int[card.length()]; //Store the string into an array.
        for(int i = 0; i < card.length(); i++)
        {
            cardArray[i] = Character.getNumericValue(card.charAt(i));
        }

        int sum = addNum(cardArray); //Call the method to get the sum.

        if(sum % 10 == 0)
        {
            System.out.println("VALID");
        }
        else
        {
            System.out.println("INVALID");
        }

        sc.close();
    }
    

    public static int addNum(int[] array)
    {
        int sum = 0;
        for(int i = array.length - 1; i >= 0; i--)
        {
            int num = array[i];
            if((array.length - i) % 2 == 0) //Check if the position is every second digit from the right.
            {
                num *= 2;

                if(num > 9)
                {
                    num -= 9; //Subtract 9 if digit is greater than 9.
                }
            }
            sum += num; //Add the processed number to the sum
        }
        return sum;
    }
}
