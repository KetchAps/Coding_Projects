import java.io.*;
public class DiscountChecker {

	public void Discount() throws IOException{
	String input;
	double spent;
	double subtracted;
	double discount;
	BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
	
	System.out.print("Input Purchase amount: ");
	
	input = scanner.readLine();
	
	try {
		
		spent = Double.parseDouble(input);
		
	} catch(NumberFormatException e) {
		
		System.out.println("Invalid Number.");
		spent = 0;
		
	} 
	
	if(spent >= 1000 ) {
		
		System.out.println("Is the customer a Registered Member?");
		System.out.print("[Y] / [N]: ");
		
		input = scanner.readLine();
		
		if(input.equals("Y") || input.equals("y")) {
			
			System.out.println("Customer is a Registered Member -- Applying 20% Discount.");
			discount = 0.20;
		} else if(input.equals("N") || input.equals("n")) {
			
			System.out.println("Customer is NOT a Registered Member -- Applying 10% Discount.");
			discount = 0.10;
		} 
		
		else {
			
			System.out.println("Invalid Input.");
			System.out.println("Customer status is unknown -- Applying 10% Discount.");
			discount = 0.10;
		}
		
		subtracted = spent * discount;
		spent -= subtracted;
		
	}
		
		System.out.println("Total Spent: " + spent);
		System.out.println("Thank you for purchase.");
	
}

	
}
