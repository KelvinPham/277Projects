import java.util.Scanner;
/**
 * class creates a job
 * @author Kelvin
 */
public class Job implements Comparable<Job> {
	/**
	 * name of task
	 */
	private String taskName;
	/**
	 * date to do task by
	 */
	private String dueDate;

	/**
	 * constructor for job
	 * @param taskName name of task
	 * @param dueDate due date of task
	 */
	public Job(String taskName, String dueDate) {
		this.taskName = taskName;
		this.dueDate = dueDate;
	}

	/**
	 * accessor for task name
	 * @return name of task
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * accessor for the date 
	 * @return the duedate
	 */
	public String getDueDate() {
		return dueDate;
	}

	/**
	 * formats the job accordingly
	 */
	public String toString() {
		return this.taskName + "," + this.dueDate;
	}

	/**
	 * compares the different jobs based on the date with the earliest date
	 * going first
	 */
	@Override
	public int compareTo(Job o) {
		String date = this.getDueDate();
		String[] seperateElements = date.split(",");

		String[] seperateDate = seperateElements[0].split("/");
		String[] seperateTimeOfDay = seperateElements[1].split(":");

		int month = Integer.parseInt(seperateDate[0]);
		int day = Integer.parseInt(seperateDate[1]);
		int year = Integer.parseInt(seperateDate[2]);

		int hour = Integer.parseInt(seperateTimeOfDay[0]);
		int minutes = Integer.parseInt(seperateTimeOfDay[1]);

		String[] seperateElements2 = o.getDueDate().split(",");
		String[] seperateDate2 = seperateElements2[0].split("/");
		String[] seperateTimeOfDay2 = seperateElements2[1].split(":");

		int month2 = Integer.parseInt(seperateDate2[0]);
		int day2 = Integer.parseInt(seperateDate2[1]);
		int year2 = Integer.parseInt(seperateDate2[2]);
		int hour2 = Integer.parseInt(seperateTimeOfDay2[0]);
		int minutes2 = Integer.parseInt(seperateTimeOfDay2[1]);
		if (year == year2) {
			if (month == month2) {
				if (day == day2) {
					if (hour == hour2) {
						if (minutes == minutes2) {
							return 0;
						} else if (minutes > minutes2) {
							return 1;
						} else {
							return -1;
						}
					} else if (hour > hour2) {
						return 1;
					} else {
						return -1;
					}
				} else if (day > day2) {
					return 1;
				} else {
					return -1;
				}
			} else if (month > month2) {
				return 1;
			} else {
				return -1;
			}

		} else if (year > year2) {
			return 1;
		} else {
			return -1;
		}

	}

}
