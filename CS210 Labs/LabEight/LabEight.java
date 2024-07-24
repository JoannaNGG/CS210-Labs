package LabEight;

import java.util.*;
import java.io.*;

public class LabEight 
{
    public static void main(String [] args)
    {   
        //File reading.
        File file = new File("C:\\Users\\Joann\\Desktop\\CS210 Labs\\LabEight\\queue.txt");
        
        //Storing lines from the file.
        int inputSize = 1000;
        String [] input = new String[inputSize];
        try 
        {   //Read file line by line and store into input array.
            Scanner scan = new Scanner(file);
           
            for(int i = 0; i < inputSize; i++) 
            {
                input[i] = scan.nextLine();
            }
            scan.close();
        } 
        catch (Exception e) 
        {
            System.err.println(e);
        }

        //Create instance of PQ with 100 as max size.
        PQ myQueue = new PQ(100);
        for(int i = 0; i < inputSize; i++)
        {   //Divide string into prts based on tab (\t).
            //split("\t")[0]: Accesses the first part of the split array, which is the command.
            if(input[i].split("\t")[0].equals("INSERT"))
            {   //input[i].split("\t")[1]: Accesses the second part, which is the item to be inserted into priority queue.
                myQueue.insert(input[i].split("\t")[1]);
            }
            else if(input[i].split("\t")[0].equals("REMOVE"))
            {
                myQueue.remove();
            }
            else
            {   //If neither INSERT or REMOVE is read, assume it is PEEK
                System.out.println(myQueue.peekFront());
            }
        }
    }
}

//Class for priority queue.
class PQ
{
    private int maxSize; //Maximum size of the queue.
    private String[] queArray; //Array for storing the elements.
    private int nItems; //Number of items currently in the queue.

    //Constructor
    public PQ(int s)
    {
        maxSize = s;
        queArray = new String[maxSize];
        nItems = 0;
    }

    //Method to insert item into queue.
    public void insert(String item)
    {
        if(!isFull())
        {
            int j = nItems; //Start at the end of the queue.
            //Insertion posititon determined by countVowels method.
            while(j > 0 && countVowels(queArray[j - 1], item) == true)
            //If the new item is larger, do..
            {
                //Shift everything to the right.
                queArray[j] = queArray[j - 1];
                j--;
            }
            queArray[j] = item; //Insert.
            nItems++; //Account for the insertion.
        }
    }

    public boolean isFull() //Check wether queue is full.
    {
        return(nItems == maxSize);
    }

    public String remove() //Remove item from the front of queue.
    {
        if(isEmpty()) return null;
        String temp = queArray[nItems - 1]; //Remove.
        nItems--; //Account for removal.
        return temp;
    }

    public boolean isEmpty() //Check if queue is empty.
    {
        return(nItems == 0);
    }

    public String peekFront() //Peek what is ontop/infront.
    {
        if(isEmpty()) return null;
        return queArray[nItems - 1];
    
    }

    //Method to count the number of vowels in words.
    public boolean countVowels(String first, String second)
    {   //To keep track of num of vowels in two different words.
        int firstTotal = 0;
        int secondTotal = 0;
        //To check if the words contains these letters (vowels).
        char [] vowels = {'a', 'e', 'i', 'o', 'u'};
        //Loop until the whole word has been checked
        for(int i = 0; i < first.length(); i++)
        {   //Loop until all vowels have been checked.
            for(int j = 0; j < vowels.length; j++)
            {   //Checks char at i is equal to j.
                if(first.charAt(i) == vowels[j])
                {
                    firstTotal++; //If true, increment.
                }
            }
        }
        //Same thing for 2nd word.
        for(int i = 0; i < second.length(); i++)
        {
            for(int j = 0; j < vowels.length; j++)
            {
                if(second.charAt(i) == vowels[j])
                {
                    secondTotal++;
                }
            }
        }

        if(firstTotal > secondTotal)
        {
            return true;
        }
        else if(firstTotal < secondTotal)
        {
            return false;
        }
        //If firstTotal is equal to secondTotal, 
        //the method compares the two strings lexicographically using compareTo.
        if(first.compareTo(second) < 0)
        {
            return true;
        }
        return false;
    }
}
