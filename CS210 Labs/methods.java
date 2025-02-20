import java.util.*;
public class methods
{
    public static void main (String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();
        isPrime(num);
        scanner.close();
    }

    public static void isPrime(int number) 
    {
        if (number <= 1) 
        {
            System.out.println(number + " is not a prime number.");
            return;
        }

        for (int i = 2; i * i <= number; i++) 
        {
            if (number % i == 0) 
            {
                System.out.println(number + " is not a prime number.");
                return;
            }
        }

        System.out.println(number + " is a prime number.");
    }
}