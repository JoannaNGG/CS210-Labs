import java.util.*;
public class LabFive 
{
    public static void main(String [] args)
    {
        //Reading the inputs.
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter base 1: ");
        int base1 = sc.nextInt();
        System.out.println("Enter base 2: ");
        int base2 = sc.nextInt();
        System.out.println("Enter number N: ");
        String N = sc.next();
        sc.close();

        //Convert number from base1 to base10.
        int Base10Num = Integer.parseInt(N, base1); //Interpret the string N in base1.
        //Convert from Base10 to Base2.
        String Base2Num = convertToBase(Base10Num, base2);

        System.out.println("Result: " + Base2Num);
    }

    //Method to convert base10 int N to specified base.
    public static String convertToBase(int N, int base)
    {
        //If N is 0, method returns 0 immediately because 0 in any base is still 0.
        if(N == 0)
        {
            return "0";
        }

        //Logarithms formula. 
        int estimateSize = (int)(Math.log(N) / Math.log(base)) + 1;
        //Store the digits of the result.
        char [] result = new char[estimateSize];
        //Last position of the array.
        int index = estimateSize - 1;

        while(N > 0)
        {
            int remainder = N % base; //To get the remainder.
            //Filling array from right to left from least to most significant.
            result[index--] = convertDigitToChar(remainder);
            N /= base; //To get the digit infront of the remainder.
        }

        return new String(result, index + 1, estimateSize - index - 1);
    }

    public static char convertDigitToChar(int digit)
    {
        //If digit is <10, convert the int to the corresponding character 0-9
        if(digit < 10)
        {
            return (char) ('0' + digit);
        }
        else
        {
            //If >10, convert to a - z correspondingly.
            return (char) ('a' + (digit - 10));
        }
    }
}
