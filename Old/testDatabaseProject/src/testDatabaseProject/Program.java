package testDatabaseProject;

import java.util.ArrayList;
import java.util.Scanner;

//Project 1- Computer Programming 1 Concept

public class Program {
	Scanner scanner = new Scanner(System.in);
	ArrayList<String> items = new ArrayList<>();
	ArrayList<Integer> itemValue = new ArrayList<>();
	boolean seeList = true;
	
	
	
	int totalCosts = 0;
	
	public Program() {
		
		Game();
		
	}
		
	public void Game() {
		 System.out.print("\033[H\033[2J");
	        System.out.flush();
		int tempTotalCost = 0;
		for(int i = 0; i < itemValue.size(); i++) {
			if(itemValue.get(i) != null) {
			 tempTotalCost += itemValue.get(i);
			}
		}
		totalCosts = tempTotalCost;
		System.out.println("----------------------------------------------------------------");
		System.out.println("");
		System.out.println("Total Cost: " + totalCosts + "  || Budget: null  || List Size: " + items.size());
		System.out.println("1 - New Item \n2 - Modify Items\n3 - Toggle List View\n5 - Refresh");
		
		if(seeList) SeeList();
		System.out.print("Enter Command: ");
		String input = scanner.nextLine();
		
		switch(input) {
			
		case "1":
		CreateItem();
			break;
			
		case "2":
			ModifyItem();
			
		case "3": 
			//Toggles List View
			seeList = seeList == true ? false : true;
			
		default:
			System.out.println("Invalid Input");
			Game();
			
		}
		
		
		
	}
	
	public void CreateItem() {
		
		System.out.println("Input Item Name: ");
		
		String itemNameIn = scanner.nextLine();	
		
	System.out.println("Set Item Value: ");
	
		String itemValueIn = scanner.nextLine();
		int itemValueFinal = 0;
		try {
			
			itemValueFinal = Integer.parseInt(itemValueIn);
			
		}
		catch(NumberFormatException e) {
			System.out.println("----------------------------------------------------------------");
			System.out.println("Invalid Value!");
			System.out.println("----------------------------------------------------------------");
			Game();
			
		}
		
	
				 items.add(itemNameIn);
				 itemValue.add(itemValueFinal);
				 System.out.println("----------------------------------------------------------------");
				 System.out.println("");
				 System.out.println("ITEM CREATION SUCCESSFUL");
				 System.out.println("Item Entry Index: " + items.size());
				 System.out.println("Item Name: " + itemNameIn + "\nItem Value: " + itemValueIn);
				 System.out.println("");
				 System.out.println("----------------------------------------------------------------");
				 			 
				 
	
		Game();
		
	}
	
	public void ModifyItem() {
		int itemValueFinal = 0;
		if(items.size() <= 0) {
			
			System.out.println("No Items to Modify!");
			Game();
			
		} else {
			
		
		System.out.println("Select Item to Modify: ");
		for(int i = 0; i < items.size(); i++) {
			
			if(items.get(i) != null) {
				System.out.println("[" + i + "]" + "•" + items.get(i) + " || " + itemValue.get(i));
				continue;
			} else break;
		}}
		
		String selectInput = scanner.nextLine();
		try {
			
			itemValueFinal = Integer.parseInt(selectInput);
			
		}
	catch(NumberFormatException e) {
		System.out.println("----------------------------------------------------------------");
		System.out.println("Invalid Value!");
		System.out.println("----------------------------------------------------------------");
		Game();
		
	}
		if((itemValueFinal + 1) > items.size()) {
			
			System.out.println("Item Index [" + itemValueFinal + "] Does not exist.");
			
			Game();
			return;
		}
		System.out.println("Item Index [" + itemValueFinal + "] selected.");
		
		System.out.println("Choose modification to perform.");
		System.out.println("1 - Change Item Name \n2 - Change Item Value");
		String selectActionIn = scanner.nextLine();
		
		switch(selectActionIn) {
		
		case "1":
			System.out.println("Set New Item Name: ");
			String newName = scanner.nextLine();
			items.set(itemValueFinal, newName);
			System.out.println("Item Index" + itemValueFinal + " Name successfully changed!");
			
			Game();
			
		case "2":
			System.out.println("Set New Item Value: ");
			String newValueSet = scanner.nextLine();
			int newValue = 0;
			try {
				
				newValue = Integer.parseInt(newValueSet);
				
			}
		catch(NumberFormatException e) {
			System.out.println("----------------------------------------------------------------");
			System.out.println("Invalid Value!");
			System.out.println("----------------------------------------------------------------");
			Game();
			
		}
			
			itemValue.set(itemValueFinal, newValue);
			System.out.println("Item Index" + itemValueFinal + " Value successfully changed!");
			
			Game();
		
			
		default:
				System.out.println("Invalid Input");
				Game();
			
		
		}
		
		
		
		Game();
		
	}
	
	
	public void SeeList() {
		if(items.size() <= 0) {
			
			System.out.println("Item List is Empty!");
			System.out.println("----------------------------------------------------------------");
			
			
		} else {
			System.out.println("");
			System.out.println("----------------------------------------------------------------");
			System.out.println("ITEM LIST");
			System.out.println("Item Name  ||  Cost");
		for(int i = 0; i < items.size(); i++) {
			if(items.get(i) != null) {
			System.out.println("[" + i + "]" + "•" + items.get(i) + " || " + itemValue.get(i));
			}
		}
		System.out.println("----------------------------------------------------------------");
		System.out.println("");
		
		}
	}
	
	
	
}
