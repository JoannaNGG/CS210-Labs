import java.util.*;

public class LabOne 
{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        boolean continueLoop = true;

        while(continueLoop)
        {
            System.out.println("Please select an option:");
            System.out.println("1: Check if prime \n2: List prime numbers in a range \n3: Exit");

            int option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Please enter the number to check: ");
                    int toCheck = sc.nextInt();
                    isPrime(toCheck);
                    break;
                
                case 2:
                    System.out.println("Please specify the range: ");
                    int begin = sc.nextInt();
                    int end = sc.nextInt();

                    ArrayList<Integer> primeNumbers = new ArrayList<Integer>();

                    for(int i = begin; i <= end; i++)
                    {
                        if(listPrime(i))
                        {
                            primeNumbers.add(i);
                        }
                    }
                    System.out.println("Prime numbers: " + primeNumbers);
                    break;
                
                    case 3:
                        System.out.println("Exiting...");
                        continueLoop = false;
                        break;
                    
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        sc.close();
    }    

    public static void isPrime(int number)
    {
        if(number <= 1)
        {
            System.out.println(number + " is not a prime number.");
            return;
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

    public static boolean listPrime (int number)
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
