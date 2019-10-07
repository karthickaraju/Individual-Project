 import java.io.*;                    //import java.io.File;
                                      //import java.io.FileWriter;
                                      //import java.io.PrintWriter;

public class DemoWritingToFiles {
	
	public static void main (String [] args) throws IOException {
		
		// File Class
		// FileWriter Class
		// PrintWriter Class
		
		File file = new File("Out1.txt");           // created a file object called file
		FileWriter fw = new FileWriter(file,true);      // created a FileWriter object called fw
		PrintWriter pw = new PrintWriter(fw);      // created a PrintWriter object called pw
		
		pw.println("Line A");
		pw.println("Line B");
		pw.println("Line C");
		
		pw.close();

	}

}
