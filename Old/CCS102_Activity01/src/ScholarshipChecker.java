import java.io.*;
public class ScholarshipChecker {

	public void Scholar() throws IOException {

		String input;
		int gpa;
		int attendance;
		BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("Input Student GPA: ");
		try {
			
			gpa = Integer.parseInt(scanner.readLine());
			
		} catch(NumberFormatException e) {
			
			System.out.println("Invalid Number.");
			gpa = 0;
			
		} 
		
		if(gpa >= 85 ) {
			
			System.out.print("Input Student Attendance Percentage: ");
			try {
				
				attendance = Integer.parseInt(scanner.readLine());
				
			} catch(NumberFormatException e) {
				
				System.out.println("Invalid Number.");
				attendance = 0;
				
				
			} 
			
			
			if(attendance >= 75) {
				
				System.out.println("Student is Eligible for a Scholarship");
				
			}
			else {
				System.out.println("Student is not Eligible for Scholarship.");
				
			}
			
			
			
		} else {
			
			System.out.println("Student is not Eligible for Scholarship.");
			
		}
		
		

	}

} 
