/*
    Use Monte Carlo simulation to estimate the value of PI.
    Generate points within a square and determine the ratio of
    points that fall within the inscribed circle to the total number of
    points. This ratio is used to estimate PI.
    Input:
    The number of random points to generate (N)
    Output:
    The estimated value of PI
 */

import java.util.Random;
public class Lab4PartTwo 
{
    public static void main(String [] args) 
    {
        int totalPoints = 10000; //Total points to plot.
        int insideCircle = 0; //Start with nothing inside the circle.
    
        Random random = new Random(); //Initialize to generate random values to plot.
        for(int i = 0; i < totalPoints; i++)
        {
            double x = random.nextDouble() * 2 - 1; //Randomly generate x values in the range [-1,1]
            double y = random.nextDouble() * 2 - 1; //Randomly generate y values in the range [-1,1]
    
            if(x*x + y*y <= 1)
            {
                insideCircle++;
            }
        }    

        double PI = 4.0 * insideCircle / totalPoints;

        System.out.println("Estimated value of PI: " + PI);
    }
}