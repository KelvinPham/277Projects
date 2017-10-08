import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * program has the user perform whats on task list
 * @author Kelvin
 */
public class Tasklist {
	public static void main(String args[]) {
		Heap<Job> tasklist = new Heap<Job>();
		try {
			Scanner read = new Scanner(new File("taskList.txt"));
			do {
				String in = read.nextLine();
				Scanner splitTask = new Scanner(in);
				splitTask.useDelimiter(",");
				String taskName = splitTask.next();
				String date = splitTask.next();
				String timeOfDay = splitTask.next();
				String dueDate = date + "," + timeOfDay;
				Job j = new Job(taskName, dueDate);
				tasklist.add(j);
				System.out.println("");
			} while (read.hasNext());
			read.close();
		} catch (FileNotFoundException fnf) {
			System.out.println("File not Found");
		}
		int current = 0;
		boolean on = true;
		Job currentTask = tasklist.getTAt(current);
		do {
			System.out.println("What do you want to do? ");
			System.out.println("1) Display all task");
			System.out.println("2) Display current task ");
			System.out.println("3) Add task");
			System.out.println("4) Do next task ");
			System.out.println("5) Change Due Date of next task");
			System.out.println("6) Quit");
			int option = checkInput(1, 6);
			switch (option) {
			case 1:
				displayTask(tasklist);
				break;
			case 2:
				displayCurrentTask(currentTask);
				break;
			case 3:
				addNewTask(tasklist);
				currentTask = tasklist.getTAt(current);
				break;
			case 4:
				if (!tasklist.isEmpty()) {
					currentTask = nextTask(tasklist, currentTask);
				}
				if (currentTask == null) {
					System.out.println("Task list is empty");
				} else {
					displayCurrentTask(currentTask);
				}
				break;
			case 5:
				postPoneDueDate(tasklist);
				break;
			case 6:
				on = false;
				break;
			}
		} while (on);
	}

	/**
	 * display the task list
	 * @param tasklist list of tasks
	 */
	public static void displayTask(Heap tasklist) {
		tasklist.printHeap();
	}

	/**
	 * displays the current job to be done
	 * @param currentTask task that is currently in progress
	 */
	public static void displayCurrentTask(Job currentTask) {
		System.out.println(currentTask);
	}

	/**
	 * adds a new task into the list
	 * @param tasklist list of task
	 */
	public static void addNewTask(Heap tasklist) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter name of task");
		String taskName = input.nextLine();
		System.out.println("Enter the month");
		int month = checkInput(1, 12);
		System.out.println("Enter the day");
		int day = checkInput(1, 31);
		System.out.println("Enter the year");
		int year = checkInput(0, 2015);
		System.out.println("Enter the hour");
		int hour = checkInput(0, 23);
		System.out.println("Enter the minute");
		int minute = checkInput(0, 59);
		String dueDate = month + "/" + day + "/" + year + "," + hour + ":"
				+ minute;
		tasklist.add(new Job(taskName, dueDate));
	}

	/**
	 * delete the current task to do the next task
	 * @param tasklist list of task
	 * @param currentTask task to be done
	 * @return the task to be done
	 */
	public static Job nextTask(Heap<Job> tasklist, Job currentTask) {
		tasklist.removeMin();
		if (!tasklist.isEmpty()) {
			currentTask = tasklist.getTAt(0);
			return currentTask;
		}
		return null;
	}

	/**
	 * changes the due date of task
	 * @param tasklist list of all task
	 */
	public static void postPoneDueDate(Heap<Job> tasklist) {
		Scanner input = new Scanner(System.in);
		String name = tasklist.getTAt(0).getTaskName();
		tasklist.removeMin();
		System.out.println("Input new month");
		int month = checkInput(1, 12);
		System.out.println("Input new day");
		int day = checkInput(1, 31);
		System.out.println("Input new year");
		int year = checkInput(0, 2015);
		System.out.println("Input new hours");
		int hours = checkInput(0, 23);
		System.out.println("Input new minutes");
		int minutes = checkInput(0, 59);
		String date = month + "/" + day + "/" + year;
		String timeOfDay = hours + ":" + minutes;
		String dueDate = date + "," + timeOfDay;
		tasklist.add(new Job(name, dueDate));
	}

	/**
	 * checks if input is in bounds 
	 * @param low lower bound
	 * @param high higher bound
	 * @return user input
	 */
	public static int checkInput(int low, int high) {
		Scanner input = new Scanner(System.in);
		boolean valid = false;
		int option = 0;
		while (!valid) {
			if (input.hasNextInt()) {
				option = input.nextInt();
				if (option >= low && option <= high) {
					valid = true;
				} else {
					System.out.println("Invalid input. Try Again. ");
				}
			} else {
				input.next();
				System.out.println("Invalid input. Try Again. ");

			}
		}
		return option;
	}
}
