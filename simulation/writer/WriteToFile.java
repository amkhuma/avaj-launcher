package simulation.writer;

import java.io.*;
import simulation.aircraft.*;
import simulation.weather.*;

public class WriteToFile {
    private static WriteToFile writeToFile = null;
	private static File file = null;
    private static FileWriter fileWriter = null;
    private static BufferedWriter output = null;
    
	private WriteToFile() {
	}

	public static WriteToFile	getFile() {
		if (writeToFile == null) {
			try{
				writeToFile = new WriteToFile();
				file = new File("Output.txt");
				fileWriter = new FileWriter(file);
				output = new BufferedWriter(fileWriter);
			} catch (IOException ioe) {}
		}
		return writeToFile;
	}

	public void	writetofile(String str) {
		try {
			output.write(str);
			output.newLine();
		} catch (IOException ioe) {
			ioe.printStackTrace();
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