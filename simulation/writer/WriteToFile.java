package simulation.writer;

import java.io.*;

import simulation.aircraft.*;
import simulation.weather.*;

public class WriteToFile
{
    private File file = null; //
    private FileWriter fileWriter = null; //new FileWriter(file);
    private BufferedWriter output = null; //new BufferedWriter(fileWriter);
    

    public WriteToFile()
    {
        try {
            file = new File("Output.txt");
            fileWriter = new FileWriter(file);
            output = new BufferedWriter(fileWriter);
        } 
        catch (IOException e) 
        {
            System.out.println("error while creating file");
        }
    }

    public void PrintTofile(String message) 
    {
        try 
        {
            output.write(message);
            output.newLine();
        }
        catch (IOException e) 
        {
            System.out.println("error while writing to file");
        }
    }

}