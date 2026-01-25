import java.io.*;
public class BankChecker {

	public static void main(String[] args) throws IOException {
		int balance;
		int withdraw;
		BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("Input Current Balance: ");
		try {
			
			balance = Integer.parseInt(scanner.readLine());
			
		} catch(NumberFormatException e) {
			
			System.out.println("Invalid Number. Default Set.");
			balance = 100;
			
		}
		
		
		System.out.println("Current Balance: " + balance);
		
		System.out.print("Input Amount to Withdraw: ");
		try {
			
			withdraw = Integer.parseInt(scanner.readLine());
			
		} catch(NumberFormatException e) {
			
			System.out.println("Invalid Number.");
			withdraw = 0;
			
		}
		
		if(withdraw <= balance) {
			
			
			if(withdraw >= 100 && withdraw % 100 == 0) {
				
				System.out.println("Successfully Withdrew " + withdraw + ".");
				
			} else { //Not 100 multiple
				
				System.out.println("Withdrawals must be multiples of 100.");
				
			}
			
			
		} else { //If withdraw amount is higher than balance
			
			System.out.println("Unable to withdraw more than your account's balance.");
		}
		
		
		
	}

}
