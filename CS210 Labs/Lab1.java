import java.util.*;
public class Lab1
{
    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select an option:");
        System.out.println("1: Check if number is prime \n2: List prime numbers in a range \n3: Exit");
        int option = scanner.nextInt(); 

        if(option == 1)
        {
            System.out.print("Please enter a number to check: ");
            int toCheck = scanner.nextInt();
            isPrime(toCheck);
        }
        else if(option == 2)
        {
            System.out.println("Please specify the range: ");
            int begin = scanner.nextInt();
            int end = scanner.nextInt();

            ArrayList<Integer> primeNumbers = new ArrayList<Integer>();

            for(int i = begin; i <= end; i++)
            {
                if(listPrime(i))
                {
                    primeNumbers.add(i);
                }
            }

            System.out.println("Prime numbers in the range: " + primeNumbers);
        }
        else if(option == 3)
        {
            System.out.println("Exiting...");
        }
        scanner.close();
    }


    //Method to check if a number is Prime or not
    public static void isPrime(int number)
    {
        if(number <= 1)
        {
            System.out.println(number + " is not a prime number.");
            return; //this is to exit this block of code immediately if it is true.
        }

        for(int i = 2; i * i <= number; i++)
        {
            if(number % i == 0)
            {
                System.out.println(number + " is not a prime number.");
                return;
            }
        }
        
        System.out.println(number + " is a prime number.");
    }

    //Method to list prime numbers in a range
    public static boolean listPrime(int number)
    {   
        if(number <= 1)
        {
            return false;
        }

        for(int i = 2; i * i <= number; i++)
        {
            if(number % i == 0)
            {
                return false;
            }
        }

        return true;
    }
}