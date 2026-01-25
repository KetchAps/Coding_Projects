import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner rd = new Scanner(System.in);
		int input = 0;
		int globalCounter = 0;
		
		// • Might be possible to compress into one for-loop
		
		while(input <= 0) {
		System.out.print("> Enter the height of each tree tier: ");
		try {
		input = Integer.parseInt(rd.nextLine());
		}
		catch (NumberFormatException e) { input = 0;}
		
		if(input <= 0) System.out.println("> Programme only accepts positive integers.");
		}
		
		//START BUILDING FANCY TREE
		// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
		// FIRST TIER
		// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
		for (int i = 0; i <= input; i++) {

			//Blank Spaces
			for (int sp = input + 1; sp > i - 2; sp--) {
				System.out.print(" ");
			}
			//X marks the spot where a character is drawn.
			for (int x = 0; x <= i - 1; x++) {
				globalCounter++;
				if (globalCounter % 3 == 0) {
					System.out.print("0");
				} else if (globalCounter % 5 == 0) {
					System.out.print("@");
				} else {
					System.out.print("*");
				}
			}
			// 2nd Part - X marks the spot where a character is drawn.
			for (int x2 = 0; x2 <= i - 2; x2++) {
				globalCounter++;
				if (globalCounter % 3 == 0) {
					System.out.print("0");
				} else if (globalCounter % 5 == 0) {
					System.out.print("@");
				} else {
					System.out.print("*");
				}
			}
			globalCounter = 0;
			if (i <= input - 1)System.out.println(""); // Don't make space before loop ends
		}

		// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
		// SECOND TIER
		// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
		System.out.println("");
		for (int i = 0; i <= input - 1; i++) {
			//Create blank spaces until sp matches i
			for (int sp = input; sp > i - 1; sp--) {
				System.out.print(" ");
			}

			//X marks the spot where a character is drawn.
			for (int x = 0; x <= i + 2; x++) {
				globalCounter++;
				if (globalCounter % 3 == 0) {
					System.out.print("0");
				} else if (globalCounter % 5 == 0) {
					System.out.print("@");
				} else {
					System.out.print("*");
				}
			}
			// 2nd Part - X marks the spot where a character is drawn.
			for (int x2 = 0; x2 <= i - 1; x2++) {
				globalCounter++;
				if (globalCounter % 3 == 0) {
					System.out.print("0");
				} else if (globalCounter % 5 == 0) {
					System.out.print("@");
				} else {
					System.out.print("*");
				}
			}
			globalCounter = 0;
			if (i <= input - 1)
				System.out.println(""); // Removes Space
		}

		// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
		// SECOND TIER
		// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
		for (int i = 0; i <= input - 1; i++) {
			//Create blank spaces until sp matches i
			for (int sp = input; sp > i; sp--) {
				System.out.print(" ");
			}
			//X marks the spot where a character is drawn.
			for (int x = 0; x <= i + 4; x++) {
				globalCounter++;
				if (globalCounter % 3 == 0) {
					System.out.print("0");
				} else if (globalCounter % 5 == 0) {
					System.out.print("@");
				} else {
					System.out.print("*");
				}
			}
			// 2nd Part
			for (int x2 = 0; x2 <= i - 1; x2++) {
				globalCounter++;
				if (globalCounter % 3 == 0) {
					System.out.print("0");
				} else if (globalCounter % 5 == 0) {
					System.out.print("@");
				} else {
					System.out.print("*");
				}
			}
			globalCounter = 0;
			if (i <= input - 1)System.out.println(""); // Removes Space
		}

		// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
		// TREE TRUNK
		// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
		for (int i = 0; i <= input; i++) {
			//Centre
			for (int sp = 0; sp <= input; sp++) {
				System.out.print(" ");
			}

			for (int x = 1; x <= 3 ; x++) {
			System.out.print("*");
				
			}
			System.out.println("");
		}
		
		rd.close();
	}

}
