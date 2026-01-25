package FiestaProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*public class NewMain {
	public static void main(String[] args) throws IOException {
		// BufferedReader
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		// User Input Variables
		String input; // Global storage for raw Input
		String pickedItem = "Item Picked"; //Global Temporary Storage for displayable values.
		
		int redScore = 0;
		int blueScore = 0;
		int scoreDifference = 0;
		
		
		// Processing Variables
		int selectInput = 0; // Used for all conversion processes of the raw input.
		int store = 0;
		int quantityInput = 0;
		
		
		// Raffle Prizes
		String[] miniPrizes = { "I can just subtract one on finalInput but this is funnier", "Free Candy", "Fiesta Hat",
				"Discount Coupon", "Keychain", "Free Pancit", "Free Lechon Bones", "Rice Cooker", "Electric Fan",
				"Meeting with God" };
		
		// XXX: The method is a final topic too much risk must be removed
		
		//XXX: 1-4 is more readable than 0-3. Always subtract one on the input for arrays

		// Welcome the user, by asking their name and Greeting Them
		// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
		// >>>>> ----------------- WELCOME SCREEN ----------------- <<<<<
		// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
		System.out.println("-------------------------------------------");
		System.out.println("<<->> ❤️ - Maligayang pagdalo sa - ❤️ <<->>");
		System.out.println("<<<>>>>> 🏆 - Aninag Festival - 🏆 <<<<<>>>");
		System.out.println("-------------------------------------------");
		// Ask the user their name
		System.out.print("Enter your name: ");
		String name = reader.readLine();
		// Greet the user :3
		System.out.println("-------------------------------------------");
		System.out.println("<<->> - Maligayang Pagdalo " + name + "! - <<->>");
		System.out.println("-------------------------------------------");

		// TODO: To make it fun i will add like a short transition using
		// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
		// >>>>> ------------------- COUNTDOWN ------------------- <<<<<
		// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
		System.out.println("> - Press Enter To Begin The Countdown - <");
		reader.readLine();
		System.out.println("  >>>>>>>>>> ------ 3 ------ <<<<<<<<<<   ");
		reader.readLine();
		System.out.println("  >>>>>>>>>> ------ 2 ------ <<<<<<<<<<   ");
		reader.readLine();
		System.out.println("  >>>>>>>>>> ------ 1 ------ <<<<<<<<<<   ");
		reader.readLine();
		System.out.println("-------------------------------------------");
		System.out.println("^^^^^^^^^ - THE FIESTA BEGINS - ^^^^^^^^^^");
		System.out.println("-------------------------------------------");

		// FIXME: The fiesta map doesn't work so i will remove it - ken

		// TODO: To make it fun i will add like a short transition using
		// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
		// >>>>> ------------------- TRANSITION ------------------- <<<<<
		// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
		System.out.println("- But before we dive into the GAMES and FUN -");
		System.out.println("-------------------------------------------");
		System.out.print("         <-> - (Press Enter) - <->   ");
		reader.readLine();
		System.out.println("-------------------------------------------");
		System.out.println("> Why don't we visit the FOOD STALL to grab <");
		System.out.println("     - you a delicious snack to enjoy! -     ");
		System.out.println("-------------------------------------------");
		System.out.print("         <-> - (Press Enter) - <->   ");
		reader.readLine();
		System.out.println("-------------------------------------------");

		// TODO:
		// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
		// >>>>> ------------------- FOOD STALL ------------------- <<<<<
		// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
		// Welcome the user
		System.out.println(">>>>> - Welcome to the Food Stall - <<<<<");
		System.out.println(" - Are you ready to choose your meal? -");
		// Show the menu of foods available
		System.out.println("-------------------------------------------");
		System.out.println("^^^^^^^^^^ - Food Stall Menu - ^^^^^^^^^^^^");
		System.out.println("-------------------------------------------");
		System.out.println(">>>>> - What would you like to buy? - <<<<<");
		System.out.println("..... - [1] Lechon     ||     ₱120  - .....");
		System.out.println("..... - [2] Pancit     ||     ₱80   - .....");
		System.out.println("..... - [3] Lumpia     ||     ₱15   - .....");
		System.out.println("..... - [4] Puto       ||     ₱10   - .....");
		System.out.println("-------------------------------------------");
		// Ask the user what food they would like
		System.out.print("Enter the number of your choice: ");
		input = reader.readLine();

		try {
			selectInput = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.out.println("-------------------------------------------");
			System.out.println(">> - Invalid Input! Let me pick for you! - <<");
			// Set input to the most expensive item.
			selectInput = 4;
		}

		// Makes sure that the user's input doesn't trigger an array
				// If input is below minimum, set to minimum value
				selectInput = (selectInput <= 0) ? 1 : selectInput;
				// If input is above maximum value, set to maximum value
				selectInput = (selectInput > 4) ? 4 : selectInput;
				
		//1st Ternary sets the displayed name to the item name. 2nd sets the value to the item's.
		pickedItem = (selectInput == 1) ? "Lechon" : pickedItem ; store = (selectInput == 1) ? 120 : store;
		pickedItem = (selectInput == 2) ? "Pancit" : pickedItem ; store = (selectInput == 2) ? 80 : store;
		pickedItem = (selectInput == 3) ? "Lumpia" : pickedItem ; store = (selectInput == 3) ? 15 : store;
		pickedItem = (selectInput == 4) ? "Puto" : pickedItem ; store = (selectInput == 4) ? 10 : store;
		
		System.out.println("-------------------------------------------");
		System.out.println("^^^^^^ - You picked " + pickedItem + "! - ^^^^^^");
		System.out.println("-------------------------------------------");

		// Ask the user how much they would buy
		System.out.print("How much would you like: ");
		input = reader.readLine();
		try {
			quantityInput = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.out.println("-------------------------------------------");
			System.out.println("That doesn't seem to be a number! Defaulting to 1!");
			// Set input to the most expensive item.
			quantityInput = 1;

		}
		store = quantityInput * store;

		System.out.println("-------------------------------------------");
		System.out.println("Successfully purchased " + quantityInput + " " 
		+ pickedItem + " for ₱" + store);
		System.out.println("-------------------------------------------");
		System.out.println("Please wait for your order on the counter!");
		System.out.println("-------------------------------------------");
		System.out.print("         <-> - (Press Enter) - <->   ");
		reader.readLine();
		System.out.println("-------------------------------------------");

		// TODO: Ask the user if they want a drinks
		// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
		// >>>>> ------------------- DRINKS STALL ------------------- <<<<<
		// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
		System.out.println(">>>>> - Would you like to order some drinks? - <<<<<");
		System.out.println("-------------------------------------------");
		System.out.println("^^^^^^^^^^^^^ - Beverage Stall - ^^^^^^^^^^^^^^");
		System.out.println("-------------------------------------------");
		System.out.println(">>>>> - What would you like to buy? - <<<<<");
		System.out.println("..... - [1] Iced Tea     ||     ₱25    - .....");
		System.out.println("..... - [2] Mineral Water||     ₱20    - .....");
		System.out.println("..... - [3] Softdrinks   ||     ₱15    - .....");
		System.out.println("..... - [4] Buko Juice   ||     ₱10    - .....");
		System.out.println("-------------------------------------------");
		// Ask the user what drinks they would like
		System.out.print("Enter the number of your choice: ");
		input = reader.readLine();

		try {
			selectInput = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.out.println("-------------------------------------------");
			System.out.println("That doesn't seem to be a number! Let me pick for you!");
			// Set input to the most expensive item.
			selectInput = 1;

		}
				// Makes sure that the user's input doesn't trigger an array
				// If input is below minimum, set to minimum value
				selectInput = (selectInput <= 0) ? 1 : selectInput;
				// If input is above maximum value, set to maximum value
				selectInput = (selectInput > 4) ? 4 : selectInput;

				//1st Ternary sets the displayed name to the item name. 2nd sets the value to the item's.
		pickedItem = (selectInput == 1) ? "Iced Tea" : pickedItem ; store = (selectInput == 1) ? 25 : store;
		pickedItem = (selectInput == 2) ? "Mineral Water" : pickedItem ; store = (selectInput == 2) ? 20 : store;
		pickedItem = (selectInput == 3) ? "Softdrinks" : pickedItem ; store = (selectInput == 3) ? 15 : store;
		pickedItem = (selectInput == 4) ? "Buko Juice" : pickedItem ; store = (selectInput == 4) ? 10 : store;
		System.out.println("-------------------------------------------");
		System.out.println("^^^^^^ - You picked " + pickedItem + "! - ^^^^^^");
		System.out.println("-------------------------------------------");

		// Ask the user how much they would buy
		System.out.print("How much would you like: ");
		input = reader.readLine();
		try {
			quantityInput = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.out.println("-------------------------------------------");
			System.out.println("That doesn't seem to be a number! Defaulting to 1!");
			// Set input to the most expensive item.
			quantityInput = 1;

		}

		store = quantityInput * store;

		System.out.println("-------------------------------------------");
		System.out.println(
				"Successfully purchased " + quantityInput + " " + pickedItem + " for ₱" + store);
		System.out.println("-------------------------------------------");
		System.out.println("Please wait for your order on the counter!");
		System.out.println("-------------------------------------------");
		System.out.print("          <-> - (Press Enter) - <->   ");
		reader.readLine();
		System.out.println("-------------------------------------------");

		// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
		// >>>>> ------------------- TRANSITION ------------------- <<<<<
		// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
		System.out.println(">>>>> - Did everyone enjoy the food? - <<<<<");
		System.out.print("          <-> - (Press Enter) - <->   ");
		reader.readLine();
		System.out.println("-------------------------------------------");
		System.out.println(">>>>> - Now that our stomach are full, - <<<<<");
		System.out.println("  - Let's get ready for the Sports Event!- ");
		System.out.print("          <-> - (Press Enter) - <->   ");
		reader.readLine();
		System.out.println("-------------------------------------------");
		
		// TODO: ask the user their sports
		// TODO: ask the user the team 1 score
		// TODO: ask the user the team 2 score
		// TODO: display the result
		// TODO: Transition to raffle or small mini game -ken2025 R.I.P
		// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
		// >>>>> ------------------- SPORTS EVENT ------------------- <<<<<
		// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
		System.out.println(">>>>> - Welcome to the Sports Event - <<<<<");
		System.out.println("- Pick the sport to begin with our fiesta game -");
		// Show the list of available sports
		System.out.println("-------------------------------------------");
		System.out.println("^^^^^^^^^^ - Sports Menu - ^^^^^^^^^^^^");
		System.out.println("-------------------------------------------");
		System.out.println(">>>>> - Choose A Sport - <<<<<");
		System.out.println("..... - [1] Basketball [1] - .....");
		System.out.println("..... - [2] Volleyball [2] - .....");
		System.out.println("..... - [3] Badminton  [3] - .....");
		System.out.println("..... - [4] Tennis     [4] - .....");
		System.out.println("-------------------------------------------");
		
		input = reader.readLine();
		try {
			selectInput = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.out.println("-------------------------------------------");
			System.out.println("[Placeholder]");
			// Set to a valid value.
			selectInput = 1;

		}
		// Makes sure that the user's input doesn't trigger an array
		// If input is below minimum, set to minimum value
		selectInput = (selectInput <= 0) ? 1 : selectInput;
		// If input is above maximum value, set to maximum value
		selectInput = (selectInput > 4) ? 4 : selectInput;
		
		
		pickedItem = (selectInput == 1) ? "Basketball" : pickedItem;
		pickedItem = (selectInput == 2) ? "Volleyball" : pickedItem;
		pickedItem = (selectInput == 3) ? "Badminton" : pickedItem; 
		pickedItem = (selectInput == 4) ? "Tennis" : pickedItem;
		
		System.out.println("-------------------------------------------");
		System.out.println("^^^^^^ - The teams will play " + pickedItem + "! - ^^^^^^");
		System.out.println("-------------------------------------------");
		
		
		
		System.out.println("-------------------------------------------");
		/*System.out.println("^^^^^^^^^^ - " + sports[selectInput - 1] + " - ^^^^^^^^^^^^");
		System.out.println("-------------------------------------------");
		System.out.print(">> How many scores did Team Red get? ");
		System.out.println("-------------------------------------------");
		
		input = reader.readLine();
		try {
			selectInput = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.out.println("-------------------------------------------");
			System.out.println("Not a number. This team's score is now zero, scrub. Hope you're happy.");
			// Set to a valid value.
			selectInput = 1;
		}
		
		redScore = selectInput;
		System.out.println("Team Red scored " + redScore + "!");
		System.out.println("-------------------------------------------");
		System.out.print(">> How many scores did Team Blue get? ");
		System.out.println("-------------------------------------------");
		
		input = reader.readLine();
		try {
			selectInput = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.out.println("-------------------------------------------");
			System.out.println("Not a number. This team's score is now zero, scrub. Hope you're happy.");
			// Set to a valid value.
			selectInput = 0;
		}
		
		blueScore = selectInput;
		System.out.println("Team Blue scored " + blueScore + "!");
		System.out.println("-------------------------------------------");
		System.out.println("          <-> - (Press Enter) - <->   ");
		reader.readLine();
		
		scoreDifference = redScore - blueScore;
		//Check if the value is negative(I.E: Blue got more score than Red) and change it to positive.
		scoreDifference = (scoreDifference < 0) ? -scoreDifference : scoreDifference;
		System.out.println("-------------------------------------------");
		System.out.println(">>>>> - "+ pickedItem +" to the Sports Event - <<<<<");
		System.out.println("-------------------------------------------");
		System.out.println((redScore == blueScore) ? "The match was a draw!" 
				: (redScore > blueScore) ? "Red Team Won the " +  pickedItem + " game with a " + scoreDifference + " lead!" :
					"Blue Team Won the " + pickedItem + " game with a " + scoreDifference + " point lead!" );
		System.out.println("-------------------------------------------");
		System.out.println("          <-> - (Press Enter) - <->   ");
		reader.readLine();
		
		// TODO : Add other activities HERE
		// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
		// >>>>> ------------------- RAFFLE ------------------- <<<<<
		// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
		System.out.println(" - You are eligible for a raffle prize! - ");
		System.out.println("-------------------------------------------");
		System.out.println(">>>>> - Select a raffle ticket(1-9) - <<<<<");
		System.out.println("-------------------------------------------");
		System.out.print("Pick a number : ");
		input = reader.readLine();
		try {
			selectInput = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			// Set to a valid value.
			selectInput = 1;
		}
		
		// Makes sure that the user's input doesn't trigger an array
		// If input is below minimum, set to minimum value
		selectInput = (selectInput <= 0) ? 1 : selectInput;
		// If input is above maximum value, set to maximum value
		selectInput = (selectInput > 4) ? 4 : selectInput;
		
		pickedItem = (selectInput == 1) ? "Free Candy" : pickedItem;
		pickedItem = (selectInput == 2) ? "Free Puto" : pickedItem;
		pickedItem = (selectInput == 3) ? "Fiesta Hat" : pickedItem;
		pickedItem = (selectInput == 4) ? "Electric Fan" : pickedItem;
		pickedItem = (selectInput == 5) ? "Authorization to use Arrays" : pickedItem;
		pickedItem = (selectInput == 6) ? "Authorization to use Methods" : pickedItem;
		pickedItem = (selectInput == 7) ? "Meeting with God" : pickedItem;
		pickedItem = (selectInput == 8) ? "Fan Campaigning the Mayor for re-election" : pickedItem;
		pickedItem = (selectInput == 9) ? "Questionably Edible Egg" : pickedItem;
		
		System.out.println("-------------------------------------------");
		System.out.println("🎁 You won a " + pickedItem + "!");
		System.out.println("-------------------------------------------");
		reader.readLine(); // just pause

		// >>>>> ------------------- EXIT ------------------- <<<<<
		System.out.println("🎉 Maraming salamat sa lahat ng dumalo! 🎉");
		System.out.println("❤️ Kita-kits sa susunod na Fiesta! ❤️");
		System.out.println("Sponsored by Mayor Losamia!");
	}
}
*/
