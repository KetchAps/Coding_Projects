package activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
		// User Input Variables
		String itemName = "<->";
		
		
		double price = 0;
		double discountedPrice = 0;
		double quantity = 0;
		double total = 0;
		double discount = 0;
		
		//NAME
		System.out.println("--------------------------------------------------");
		System.out.println("Item: " + itemName + " | Price: " + price +
				" | Quantity: " + quantity + " | Discount(%): " + discount + " | Total: " + total);
		System.out.println("--------------------------------------------------");
		System.out.print("Insert Item Name: ");
		
			itemName = scanner.readLine();
		
			//PRICE
		System.out.println("--------------------------------------------------");
		System.out.println("Item: " + itemName + " | Price: " + price +
				" | Quantity: " + quantity + " | Discount(%): " + discount + " | Total: " + total);
		System.out.println("--------------------------------------------------");
		
		
		System.out.print("Insert Item Price: ");
		
		try {
			price = Integer.parseInt(scanner.readLine());
		} catch (NumberFormatException e) {
			System.out.println("--------------------------------------------------");
			System.out.println("Invalid Value: Defaulting to 1");
			
			price = 1;
			
		}
		discountedPrice = price;
		
		//QUANTITY
		
		System.out.println("--------------------------------------------------");
		System.out.println("Item: " + itemName + " | Price: " + price +
				" | Quantity: " + quantity + " | Discount(%): " + discount + " | Total: " + total);
		System.out.println("--------------------------------------------------");
		
		System.out.print("Insert Quantity Bought: ");
		
		try {
			quantity = Integer.parseInt(scanner.readLine());
		} catch (NumberFormatException e) {
			System.out.println("--------------------------------------------------");
			System.out.println("Invalid Value: Defaulting to 1");
			
			quantity = 1;
		}
		
		
			total = quantity * price;
				
			//DISCOUNT
		System.out.println("--------------------------------------------------");
		System.out.println("RECEIPT UPDATED: Item: " + itemName + " | Price: " + price +
						" | Quantity: " + quantity + " | Discount(%): " + discount + " | Total: " + total);
		System.out.println("--------------------------------------------------");
				
		
		System.out.print("Insert Discount(%) (Leave empty if none): ");
		
		try {
			discount = Integer.parseInt(scanner.readLine());
		} catch (NumberFormatException e) {
				
			discount = 0;
		}
		//Turn value into decimal
		discount /= 100;
		//Apply discount
		discountedPrice *= discount;
		price -= discountedPrice;
		
		//Reassign value
		total = price * quantity;
		System.out.println("--------------------------------------------------");
		System.out.println("FINAL RECEIPT");
		System.out.println("--------------------------------------------------");
		System.out.println("Item: " + itemName + " | Price: " + price +
						" | Quantity: " + quantity + " | Discount(%): " + discount + " | Total: " + total);
		System.out.println("--------------------------------------------------");
	}

}
