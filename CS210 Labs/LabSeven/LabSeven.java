package LabSeven;

import java.io.*;

class FileIO {
    public String[] load(String file) {
        File aFile = new File(file);
        StringBuffer contents = new StringBuffer();
        BufferedReader input = null;
        try {
            input = new BufferedReader(new FileReader(aFile));
            String line = null;
            while ((line = input.readLine()) != null) {
                contents.append(line);
                contents.append(System.getProperty("line.separator"));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Can't find the file -are you sure the file is in this location: " + file);
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Input output exception while processing file");
            ex.printStackTrace();
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
            } catch (IOException ex) {
                System.out.println("Input output exception while processing file");
                ex.printStackTrace();
            }
        }
        String[] array = contents.toString().split("\n");
        for (String s : array) {
            s.trim();
        }
        return array;
    }

    public void save(String file, String[] array) throws FileNotFoundException, IOException {
        File aFile = new File(file);
        Writer output = null;
        try {
            output = new BufferedWriter(new FileWriter(aFile));
            for (int i = 0; i < array.length; i++) {
                output.write(array[i]);
                output.write(System.getProperty("line.separator"));
            }
        } finally {
            if (output != null)
                output.close();
        }
    }
}

public class LabSeven 
{
    public static void main(String[] args) 
    {
        FileIO reader = new FileIO();
        String[] input = reader.load("C:\\Users\\Joann\\Desktop\\CS210 Labs\\LabSeven\\stack.txt"); // Reading the File as a String array

        //Create instance for Stack
        Stack myStack = new Stack();

        for(String line : input)
        {
            if(line != null)
            {
                String [] command = line.split("\t");
                if(command[0].equals("PUSH"))
                {
                    myStack.push(command[1]);
                }
                else if(command[0].equals("POP"))
                {
                    myStack.pop();
                }
            }
        }
        
        System.out.println("Result of peek: " + myStack.peek());
    }
}


class Stack
{
    private String [] stackArray;
    private int top;

    public Stack()
    {   
        stackArray = new String[100];
        top = -1;
    }

    public void push(String value)
    {
        if(top < 99)
        {
            // top++;
            // stackArray[top] = value;
            //pre increment top, then insert 'value'
            stackArray[++top] = value;
            System.out.println("Pushed: " + value);
        }
        else
        {
            System.out.println("Stack is full, cannot push: " + value);
        }
    }

    public String pop()
    {
        if(top >= 0)
        {   
            System.out.println("Popped: " + top);
            return stackArray[top--];
            
        }
        else
        {
            System.out.println("Stack is empty, cannot pop.");
            return null;
        }
    }

    public String peek()
    {
        if(top >= 0)
        {
            return stackArray[top];
        }
        else
        {
            System.out.println("Stack is empty, nothing to peek.");
            return null;
        }
    }
}