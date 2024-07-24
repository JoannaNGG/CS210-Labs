import java.util.*;
public class LabSix 
{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int numberOfWords = Integer.parseInt(sc.nextLine());
        String [] words = new String[numberOfWords];
        sc.close();

        //As long as i < the number inputted, keep taking words input.
        for(int i = 0; i < numberOfWords; i++)
        {
            words[i] = sc.nextLine();
        }
        //Call method.
        sortWords(words);
        //For each loop to list & print word.
        for(String word : words)
        {
            System.out.println(word);
        }
    }

    //Method for counting the scrabble score.
    public static int scrabbleScore(String word)
    {
        //Setting the values from a - z.
        int[] values = {
            1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10
        };

        //Score currenlty set to 0.
        int score = 0;
        for(char c : word.toCharArray())
        {
            c = Character.toLowerCase(c);
            //Using ASCII value to convert c to its corresponding index.
            if(c >= 'a' && c <= 'z')
            {
                //Calculate total score.
                score += values[c - 'a'];
            }
        }
        return score;
    }

    public static void sortWords(String [] words)
    {
        int n = words.length;
        for(int i = 0; i < n - 1; i++)
        {
            for(int j = 0; j < n - i - 1; j++)
            {
                if(shouldSwap(words[j], words [j+1]))
                {
                    String temp = words[j];
                    words[j] = words[j + 1];
                    words[j + 1] = temp;
                }
            }
        }
    }

    public static boolean shouldSwap(String first, String second)
    {
        int score1 = scrabbleScore(first);
        int score2 = scrabbleScore(second);

        if(score1 > score2)
        {
            return true;
        }
        else if(score1 < score2)
        {
            return false;
        }
        else
        {
            return first.compareTo(second) > 0;
        }
    }
}
