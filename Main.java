import java.util.Scanner;

public class Main {
	private static TaskRegister taskList1;
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		taskList1 = new TaskRegister();
		UI as = new UI();

//	taskList1.sortProject();
//	as.printHeader();
//	taskList1.readFromFile();

		boolean quit = false;
		mainMenu();
		while (!quit) {
			System.out.println("Enter your choice");
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				addTask();
				break;
			case 2:
				listTask();
				break;
			case 3:
				editTask();
				break;
			case 4:
				// showMainMenu();
				break;
			case 5:
				quit = true;
				System.out.println("Exit from the Main Menu");
				break;
			}
		}

	}

	public static void mainMenu() {

		System.out.println("Available options: \n1 - Add New Task." + "\n2 - List Task" + "\n3 - Edit Task."
				+ "\n4 - Show Main Menu." + "\n5 - Quit.");

	}

	public static void addTask() {
		taskList1.createtask();
		System.out.println("Would you like to add a new task? (Yes/No)");
		Scanner input = new Scanner(System.in);
		String answer = input.next();

		while (answer.equals("yes")) {

			taskList1.createtask();
			System.out.println("Would you like to add another task? (yes/no");
			answer = input.next();
		}
	}

	public static void listTask() {

		System.out.println("Press 1 to list the task by Duedate");
		System.out.println("Press 2 to list the task by Project");
		int choice = scan.nextInt();
		switch (choice) {
		case 1:
			taskList1.sortByDuedate();
			break;
		case 2:
			taskList1.sortByProject();
			break;
		}
	}

	public static void editTask() {

		taskList1.updateTask();

	}

	public static void showMainMenu() {

		mainMenu();
	}

	int n;

	/*
	 * as.printHeader(); taskList1.printTasks();
	 * 
	 * Scanner scan = new Scanner(System.in); int option = scan.nextInt();
	 * 
	 * switch(option) { case 1: taskList1.updateTask(i);// pass parameters to the
	 * functions break; case 2: taskList1.updateStatus(i); break; }
	 * 
	 */
}
