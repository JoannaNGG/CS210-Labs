import java.util.Random;

public class Lab4PartOne 
{
    public static void main(String[] args) 
    {
        int iterations = 1000; //Number of times the entire process will be repeated
        double actualE = 2.718281828459045235360;

        double estimatedE = estimateE(iterations); //Call the method.
        System.out.println("Estimated Value of e: " + estimatedE);

        System.out.println("Absolute Error: " + Math.abs(actualE - estimatedE));
    }

    public static double estimateE(int iterations)
    {
        Random random = new Random(); //Call to use Random.
        double sum = 0; //Store final value from each iteration to calculate average.

        //Perform the simulation for the given number of iterations.
        for (int i = 0; i < iterations; i++) 
        {
            double currentSum = 0;
            int count = 0;

            //Generate random numbers until their sum exceeds 1
            while (currentSum < 1) 
            {
                currentSum += random.nextDouble();
                count++;
            }

            //Add the count to the sum
            sum += count;
        }

        //Calculate the average of the counts to estimate e
        return sum / iterations;
    }
}
