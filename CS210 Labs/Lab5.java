import java.util.*;
public class Lab5 
{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter base 1: ");
        int base1 = sc.nextInt();
        System.out.println("Enter base 2: ");
        int base2 = sc.nextInt();
        System.out.println("Enter number N");
        String N = sc.next();
        sc.close();

        int base10 = Integer.parseInt(N, base1); //Put N to base1 and store into 'base10' using parseInt(decimal number)
        String result = convertToBase(base10, base2);
        System.out.println("Result: " + result);
    }

    //Method to convert N to another base.
    public static String convertToBase(int number, int base)
    {
        if(number == 0)
        {
            return "0"; //0 in any base is still 0.
        }

        //To determine the length of the result in base
        int length = (int) (Math.log(number) / Math.log(base)) + 1; //Logarithm formula.
        char [] remainders = new char[length];
        int index = length - 1; //Start to the end of the array.

        while(number > 0)
        {   //Get least significant to most significant (right to left).
            int remainder = number % base; //Get remainder.
            remainders[index--] = convertDigitToChar(remainder); //Go backwards/go left in the array.
            number /= base; //Get digit before .
        }

        return new String(remainders, index + 1, length - index - 1);
    }

    //Method to convert digits to chars
    public static char convertDigitToChar(int digit)
    {
        if(digit < 10)
        {
            return (char) ('0' + digit);
        }

        else
        {
            return (char) ('a' + (digit - 10));
        }
    }
}
