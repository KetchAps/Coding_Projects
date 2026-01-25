import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoginChecker {

	public void BadPassword() throws IOException {
		String input;
		int age;
		final String username = "admin";
		final String password = "1234";
		BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println(" - Login - ");
		System.out.print("Enter Username: ");
		input = scanner.readLine();
	
		if(input.equals(username)) {
			
			System.out.print("Enter Password: ");
			input = scanner.readLine();
			
			if(input.equals(password)) {
				System.out.println("Login Successful!");
			} else {
				
				System.out.println("Incorrect Password.");
				
			}
			
			
		} else {
			
			System.out.println("Username not found.");
			
		}
		
		
		
	}

}
