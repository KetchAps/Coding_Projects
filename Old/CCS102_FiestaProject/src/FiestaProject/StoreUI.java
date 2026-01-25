package FiestaProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StoreUI {
 BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
	String[] foods = {"lechon", "pancit", "lumpia"};
	String[] shopcart = new String[10]; //Stores the items the user buys.
	 int totalSpent = 0;
	 String input;
	 
	public StoreUI() {
	Store();
	}
	
	public void Store() {
		
		 System.out.println("Fiesta Foods");
			System.out.println("[1]Lechon     ||     ₱5000");
			System.out.println("[2]Pancit     ||     ₱100");
			System.out.println("[3]Lumpia     ||     ₱50");
			System.out.println("----------------------------");
			System.out.print("Type the index of the Item to Purchase: ");
			try {
				
				 input = scanner.readLine();
				
			} catch (IOException e) {
				System.out.println("Invalid Input!");
				Store();
			}
			int store;
			store = (input == "3") ? (Integer)50: 0;
			System.out.print("store int " + store);
			store = (input == "2") ? (Integer)100: 0;
			System.out.print("store int " + store);
			store = (input == "1") ? (Integer)5000: 0;
			System.out.print("store int " + store);
			totalSpent =+ store;
			
			System.out.println("----------------------------");
			System.out.print("Successfully purchased. Spent: " + store + ", Total Spent: " + totalSpent);
			System.out.println("----------------------------");
			
			Store();
			
		
	}
	
	 
}
