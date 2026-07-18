import java.util.Scanner;

public class Main {
	
	String[][] students = new String[20][3];
	int size = 0;
	int unique_ids = 0;
	
	Scanner rd = new Scanner(System.in);
	
	public static void main(String[] args) {
		Main main = new Main();
		
		int in;
		while(true) {
		System.out.println("[1] Add New Student Record");
		System.out.println("[2] Display All Student Records");
		System.out.println("[3] Search Student Record");
		System.out.println("[4] Update Recorded Student Grade");
		System.out.println("[5] Remove Student Record");
		
		System.out.print("Select Action to Perform: ");
		try {
		in = Integer.parseInt(main.rd.nextLine());
		} catch(NumberFormatException e)  {
		in = 0;	
		}
		switch(in) {
		case 1: main.AddStudent(); break;
		case 2: main.DisplayStudents(); break;
		case 3: main.SearchStudent(); break;
		case 4: main.UpdateGrade(); break;
		case 5: main.DeleteStudent(); break;
		default: System.out.println("Action not recognised."); break;
		
		}
		System.out.println("\n");
		}
	}
	
	
	void AddStudent() {
		if(size >= 20) {
			System.out.print("Database is full.");
			return;
		}
		int id = unique_ids++;
		String name;
		int grades;
		System.out.print("Set Student's Name:");
		name = rd.nextLine();
		
		while(true) {
		System.out.print("Set Student's Final Grade: ");
		try {
			grades = Integer.parseInt(rd.nextLine());
			break;
		} catch(NumberFormatException e) {
			grades = 0;
			System.out.println("Invalid Input.");
		}
		}
		students[size][0] = String.valueOf(id);   //ID
		students[size][1] = name; //Name
		students[size][2] = String.valueOf(grades); // Grades
		
		System.out.print("New Student Record successfully created for " + name);
		size++;
		
	}
	
	void DisplayStudents() {
		
		for(int r = 0; r < size; r++) {
			for(int c = 0; c < 3; c++) {
				
				System.out.print(students[r][c] + "     ");
				
			}
			
			System.out.println();
		}
		
	}
	
	void SearchStudent() {
		int id = InputValidation();
		if(id == -1) return;
		
		int result = BinarySearch(id);
		if(result == -1) {
			System.out.println("No matching record found.");
			return;
		}
		System.out.println("Matching Student Record found for \"" + id + "\":");
		System.out.println("Student Name: " + students[result][1] + "\n" +
							"Student Grades: " + students[result][2]);
		
	}
	
	
	
	void UpdateGrade() {

		int id = InputValidation();
		if(id == -1) return;
		
		int result = BinarySearch(id);
		if(result == -1) {
			System.out.println("No matching record found.");
			return;
		}
		System.out.print("Input New Grade Record: ");
		while(true) {
			System.out.print("Enter Student Record ID: ");
			try {
			id = Integer.parseInt(rd.nextLine());
			break;
			} catch(NumberFormatException e) {
				System.out.println("Invalid Input.");
			}
			}
		students[result][2] = String.valueOf(id);
		System.out.println("Record Updated successfully");
	}
	
	
	
	void DeleteStudent() {
		
		int id = InputValidation();
		if(id == -1) return;
		
		int result = BinarySearch(id);
		if(result == -1) {
			System.out.println("No matching record found.");
			return;
		}
		for(int i = result; i < 20; i++) {
			if(i != 19) {
				students[i][0] = students[i + 1][0];
				students[i][1] = students[i + 1][1];
				students[i][2] = students[i + 1][2];	
			}
			else {
				students[i][0] = null;
				students[i][1] = null;
				students[i][2] = null;	
				
			}
			
			
			
		}
		size--;
		System.out.println("Record Deleted successfully.");
	}
	
	int BinarySearch(int id) {
		int low = 0;
		int high = size;
		int mid = 0;
		int lastMidPoint = -1;
		while(true) {
			if(lastMidPoint == mid) return -1;
			lastMidPoint = mid;
			mid = (low + high) / 2;
			int query = Integer.parseInt(students[mid][0]);
			if(id == query) break;
			else if (id > query) low = mid + 1;
			else if (id < query) high = mid - 1;
			}
		return mid;
		
	}
	
	int InputValidation() {
		
		if(size == 0) {
			System.out.print("Database is empty.");
			return -1;
		}
		int id;
		while(true) {
		System.out.print("Enter Student Record ID: ");
		try {
		id = Integer.parseInt(rd.nextLine());
		break;
		} catch(NumberFormatException e) {
			System.out.println("Invalid Input.");
		}
		}
		
		if(id >= size) {
			
			System.out.print("Data entry not found.");
			return -1;
			
		}
		return id;
		
	}
	
}
