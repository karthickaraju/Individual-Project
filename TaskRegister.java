
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
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class TaskRegister {

	private ArrayList<Task> taskList = new ArrayList<Task>();
	UI ui = new UI();
//	private Task task = null;
	Scanner scan = new Scanner(System.in);
	Scanner scan1 = new Scanner(System.in);
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
		
		DateFormat dft = new SimpleDateFormat("MM/dd/yyyy");
		System.out.println("Enter the Due date in the format (MM/dd/yyyy): ");
		String dateStr = scan.next();
		
		Date date = null;
		
		try {
		date = dft.parse(dateStr);
       
		}catch(ParseException e) {
			e.printStackTrace();
		}
		
//		Project project = new Project(projectName);
		
	    Task task = new Task(taskTitle,date,projectName);
	    taskList.add(task);
		writeToFile(task);
	
	}
	
	public Task searchTask(int taskid) {
		for (Task tsk: taskList) {
			if (tsk.getTaskid() == (taskid)) {
				
				return tsk;
			}	
		}
		return null;
	}
	
	public void remove(int taskid) {
		
		Task tmpTask;
		tmpTask = this.searchTask(taskid);
		taskList.remove(tmpTask);

	}
	
	public void updateStatus(int taskid) {
		
		searchTask(taskid).setStatus("Done");
	}   
											
	public void updateTask() {
		
		Task task;
	//	task = searchTask(taskId);
		
		ArrayList<String> filecontent = new ArrayList<String>();

		
	//	filecontent = readFromFile();
		System.out.println("Enter the task title to be updated :");
		String taskName = scan1.next();
		
		System.out.println("What would you like to update in the required Task? Choose below: ");
		System.out.println("*****************************************************************");
		System.out.println("1. Update Task Title\n2. Update the Due date\n3. Update the Project Title\n4. Update the status of the Task");
		
        int caseNum = scan.nextInt();
        switch (caseNum) {
        case 1: 
        	System.out.println(" Enter the new title for the task: ");
        	String title = scan.next();
        	//task.setTasktitle(title);
        }
	}

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
            bw.append("\t");
            
            bw.write(dateStr);
            bw.append("\t");

            bw.write(task.getProject());
            bw.append("\t");

            bw.write(task.getStatus());
            bw.append("\t");
            bw.append("\n");
      

            // Close connection
            bw.close();
        }
            catch(Exception e){
            System.out.println(e);
            
            } 			
    }
	
	public ArrayList<Task> readFromFile() {
		
		ArrayList<Task> filecontent = new ArrayList<Task>();
		
		final String FILENAME = "/Users/karthickaraju/IndividualProject/Read.txt";

		  try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {

		   String strCurrentLine;

		   while ((strCurrentLine = br.readLine()) != null) {
			   String[] arr = strCurrentLine.split("\t");
			   filecontent.add(new Task(arr[0],arr[1],arr[2],arr[3]));
		   }

		  } catch (IOException e) {
		   e.printStackTrace();
	 }
		  return filecontent;
   }
	
    Comparator<Task> compareByproject = new Comparator<Task>() {
    	@Override
        public int compare(Task t1, Task t2) {
            return t1.getProject().compareTo(t2.getProject());
        }
    };

    Comparator<Task> compareByDuedate = new Comparator<Task>() {
    	@Override
        public int compare(Task t1, Task t2) {
            return t1.getDuedate().compareTo(t2.getDuedate());
        }
    };
    
    
   public void sortByProject() {
	   List<Task> taskList = readFromFile();
	   Collections.sort(taskList, compareByproject);
	   printTasks(taskList);
   }
   
   public void sortByDuedate() {
	   List<Task> taskList = readFromFile();
	   Collections.sort(taskList, compareByDuedate);
	   printTasks(taskList);
   }
   
   public void printTasks(List<Task> taskList) {
	   System.out.println("TaskList displayed below ");
	   ui.printTaskList(taskList);
	   
   }
}
