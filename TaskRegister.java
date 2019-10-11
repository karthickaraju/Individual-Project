
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class TaskRegister {

	private ArrayList<Task> taskList = new ArrayList<Task>();
//	private Task task = null;

	public TaskRegister() {
	}

	public ArrayList<Task> getTaskList() {
		return taskList;
	}

	public void setTaskList(ArrayList<Task> taskList) {
		this.taskList = taskList;
	}

	public void createtask() {     

		Scanner scan = new Scanner(System.in);
		
		
		System.out.println("Enter the Task Title: ");
		String taskTitle = scan.next();
		
		System.out.println("Enter the Project Name: ");
		String projectName = scan.next();
		
		System.out.println("Enter the Status: ");
		String status = scan.next();
		
		DateFormat dft = new SimpleDateFormat("MM/dd/yyyy");
		System.out.println("Enter the Due date in the format (MM/dd/yyyy) :");
		String dateStr = scan.next();
		
		Date date = null;
		
		try {
		date = dft.parse(dateStr);
       
		}catch(ParseException e) {
			e.printStackTrace();
		}
		
//		Project project = new Project(projectName);
		
	    Task task = new Task(taskTitle,date,projectName);
		writeToFile(task);
	
	}
	
	
	public void add(Task task) {
		this.getTaskList().add(task);
	}
	
	public Task search(int taskid) {
		for (Task tsk: taskList) {
			if (tsk.getTaskid() == (taskid)) {
				
				return tsk;
			}	
		}
		return null;
	}
	
	public void remove(int taskid) {
		
		Task tmpTask;
		tmpTask = this.search(taskid);
		taskList.remove(tmpTask);

	}
	
	/* public void update(int taskid) {
		
		Task tsk = this.search(taskid);
        tsk.settasktitle(title);                   // use boolean true or false by set
											
	} **/

	public void writeToFile(Task task) {
		
		try{
            // Create new file
        	
			
			Date date = task.getDuedate();
			DateFormat DateFor = new SimpleDateFormat("MM/dd/yyyy");
            
            String path="/Users/karthickaraju/IndividualProject/Read.txt";
            File file = new File(path);

            
            // If file doesn't exists, then create it
            
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(fw);
            String dateStr = DateFor.format(date);
            // Write in file
            bw.write(task.getTaskid());
            bw.write(task.getTasktitle());
            bw.write(dateStr);
            bw.write(task.getProject());
            bw.write(task.getStatus());
      

            // Close connection
            bw.close();
        }
            catch(Exception e){
            System.out.println(e);
        }
    }
	
	public void readFromFile() {
		
		final String FILENAME = "/Users/karthickaraju/IndividualProject/Read.txt";

		  try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {

		   String strCurrentLine;

		   while ((strCurrentLine = br.readLine()) != null) {
		    System.out.println(strCurrentLine);
		   }

		  } catch (IOException e) {
		   e.printStackTrace();
	 }
   }
}
