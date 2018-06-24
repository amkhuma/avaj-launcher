package launcher.writer;

import java.io.*;
import launcher.aircraft.*;
import launcher.weather.*;

/*
	creating and writing to file, still dont know why we couldnt just use the terminal stdout for this -_-
*/

public class WriteToFile {
	private static File file = null;
    private static FileWriter fileWriter = null;
    private static BufferedWriter output = null;
    
	public WriteToFile() 
	{
		try{
			file = new File("Output.txt");
			fileWriter = new FileWriter(file);
			output = new BufferedWriter(fileWriter);
		} catch (IOException e)
		{ }
	}

	public void	writetofile(String str) {
		try {
			output.write(str);
			output.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void closeFile() {
		try {
			if (output != null)
				output.close();
		} catch (Exception ex) {
			System.out.println("Error in closing the file");
		}
	}
}