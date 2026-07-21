import java.util.Scanner;

public class ObjectOrientedDatabase {
	
	Node[] students = new Node[20];
	int size = 0;
	int unique_ids = 0;
	
	Scanner rd = new Scanner(System.in);
	
	public static void main(String[] args) {
		ObjectOrientedDatabase main = new ObjectOrientedDatabase();
		
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
		students[size] = new Node(name, id, grades);
		
		System.out.print("New Student Record successfully created for " + name);
		size++;
		
	}
	
	void DisplayStudents() {
		System.out.println("ID\t|     Name       |   Grades");
		for(int r = 0; r < size; r++) {
			String name = students[r].GetName();
			int id = students[r].GetID();
			int grade = students[r].GetGrades();
				
				System.out.print(id);
				spaceMaker(String.valueOf(id), 10);
				System.out.print(name);
				spaceMaker(name, 20);
				System.out.print(grade);
				System.out.println();
			}
			
			
		}
		
	

	void spaceMaker(String spacer, int spaces) {
			int length = spaces - spacer.length();
			for(int s = length; s > 0; s--) System.out.print(" ");	
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
		System.out.println("Student Name: " + students[result].GetName() + "\n" +
							"Student Grades: " + students[result].GetGrades());
		
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
		students[result].SetGrades(id);
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
				students[i] = students[i + 1];
			}
			else {
				students[i] = null;
				
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
			int query = students[mid].GetID();
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
