import java.util.ArrayList;

public class Project {
	
	private String projectTitle;
	
	public ArrayList<Project>TaskRegister = new ArrayList<Project>();
	
	
	public Project(String projectTitle) {
		this.projectTitle = projectTitle;
	}
	
	public String getProjecttitle() {
		return projectTitle;
	}

	public void setProjecttitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public ArrayList<Project> getTaskRegister() {
		return TaskRegister;
	}

	public void setTaskRegister(ArrayList<Project> TaskRegister) {
		this.TaskRegister = TaskRegister;
	}

    public String toString() {
    	
    	return  "Project Title: " + this.getProjecttitle() + " " + "TaskRegister: " + this.getTaskRegister();
    	
      }	
}


