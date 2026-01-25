import java.io.*;

public class ElectionChecker {

	
	public void Maaain() throws IOException{
		String input;
		int age;
		BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("Input age: ");
		
		input = scanner.readLine();
		
		try {
			
			age = Integer.parseInt(input);
			
		} catch(NumberFormatException e) {
			
			System.out.println("Invalid Number.");
			age = 0;
			
		} 
		
		if(age >= 18 ) {
			
			System.out.println("Are you a Registered Voter?");
			System.out.print("[Y] / [N]: ");
			
			input = scanner.readLine();
			
			if(input.equals("Y") || input.equals("y")) {
				
				System.out.println("You are eligible to vote.");
				
			} else if(input.equals("N") || input.equals("n")) {
				
				System.out.println("You must be registered to vote.");
				
			} 
			
			else {
				
				System.out.println("Invalid Input.");
				System.out.println("You are not eligible to vote.");
				
			}
			
			
			
		} else {
			
			System.out.println("You are not eligible to vote.");
			
		}
		
		
	}
	
}
