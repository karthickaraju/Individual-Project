

public class DemoWritingToFiles1 {
	
public static void main (String [] args) throws IOException {
		
		// File Class
		// FileWriter Class
		// PrintWriter Class
		
	/*
		File file = new File("Out1.txt");                // created a file object called file
		FileWriter fw = new FileWriter(file,true);      // created a FileWriter object called fw
		PrintWriter pw = new PrintWriter(fw);           // created a PrintWriter object called pw
		
		pw.println("Line A");
		pw.println("Line B");
		pw.println("Line C");
		
		pw.close();
		
	//*/
	
	     //parameter 1: The name of the file we are using.
	     //parameter 2: The text to be written to the file.
	     //parameter 3: false - delete the content, true - append the file.
		
        saveToFile("out2.txt","Hello Everyone", false);
        //saveToFile("out2.txt","This is Wonderful";true);
        
  }

}
