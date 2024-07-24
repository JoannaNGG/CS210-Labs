import java.util.*;
public class LabThree 
{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the range: ");

        int lower = sc.nextInt();
        int upper = sc.nextInt();
        sc.close();

        int counter = 0; //Initial counter for number of prime no's.
        for(int i = lower; i <= upper; i++)
        {
            if(isPrime(i)) //Checks whether 'i' is a prime number.
            {
                counter++;
            }
        }
        System.out.println("Amount of prime numbers within the range: " + counter);

        if(counter == 0)
        {
            System.out.println("No prime numbers exist within this range.");
        }
    }


    //Method to check whether a number is prime or not
    public static boolean isPrime(int num)
    {
        if(num <= 1)
        {
            return false;
        }

        for(int i = 2; i * i <= num; i++)
        {
            if(num % i == 0)
            {
                return false;
            }
        }
        return true;
    }
}
