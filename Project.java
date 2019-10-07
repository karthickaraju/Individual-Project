import java.util.ArrayList;

public class Project {
	
	private String projecttitle;
	
	public ArrayList<Project>tasklist = new ArrayList<Project>();
	

      public Project(String projecttitle) {
		this.projecttitle=projecttitle;}
	

	  public String getProjecttitle() {
		return projecttitle;}

	  public void setProjecttitle(String projecttitle) {
		this.projecttitle = projecttitle;}
	
	
      public String toString() {
    	
    	return  "Project Title: " + this.getProjecttitle();
    	
    }

      public ArrayList<Project> getTasklist() {
	   return tasklist;}


      public void setTasklist(ArrayList<Project> tasklist) {
	  this.tasklist = tasklist;
  }
	
}


