/*import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);
		int studentScore;
		char studentGrade = 'F';
		System.out.print("Enter Student Score: ");
		studentScore = reader.nextInt();
		
		if( studentScore <= 100) { // Check if input is valid in the first place.
			
			if(studentScore == 100) studentGrade = 'A';	
			else if(studentScore >= 90 && studentScore < 100) studentGrade = 'B';
			else if(studentScore >= 80 && studentScore < 90)  studentGrade = 'C';
			else if(studentScore >= 70 && studentScore < 80)  studentGrade = 'D';
			else if(studentScore >= 60 && studentScore < 70)  studentGrade = 'E';
			else if(studentScore < 60) studentGrade = 'F';
			
			System.out.println("Student Final Grade Rating: " + studentGrade);
		
		} else { // Run if invalid input.
			System.out.println("Invalid Input.");
		}
		reader.close();
		System.out.println("Programme End.");
	}
	
}

*/
