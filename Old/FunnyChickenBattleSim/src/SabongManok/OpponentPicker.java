package SabongManok;

import java.util.Scanner;
public class OpponentPicker {
	
	Scanner reader = new Scanner(System.in);
	String input;
	
	public int difficulty = 0;
	public int[] easy = new int[7];
	public int[] medium = new int[7];
	public int[] hard = new int[7];
	
	public int container;
	public String[] name = {"Buckson", "Bob the Chicken", "Heinrich von Roostberg", "Lord Chickquad", "Warchief",
			"Varock Saurpeck", "Pippin", "Ruffle Featherskin", "Chica the Chicken", "Felony", "Artbochnis", "Cluckrrigan",
			""};
	
	
	public int[] EnemyMaker(double multiplier) {
		
		//Generate Easy Enemy Stat Block
		container = (int)((Math.random() * 8) + 1) * 10;
		easy[0] = container + (int)(container * multiplier); // EnemyHP
		container = (int)((Math.random() * 2) + 1);
		easy[1] = container + (int)(container * multiplier); //DEF
		container = (int)((Math.random() * 10) + 1);
		easy[2] = container + (int)(container * multiplier); //ATK
		container = (int)((Math.random() * 3) + 1);
		easy[3] = container + (int)(container * multiplier); //SPD
		container = (int)((Math.random() * 10) + 1);
		easy[4] = container + (int)(container * multiplier); //CRITRATE
		container = (int)((Math.random() * 3) + 1);
		easy[5] = container + (int)(container * multiplier); //CRITDMG MULTIPLIER
		container = (int)((Math.random() * 2) + 1);
		easy[6] = container + (int)(container * multiplier); //VITALITY
		
		//Generate Medium Enemy Stat Block
		container = (int)((Math.random() * 12) + 1) * 10;
		medium[0] = container + (int)(container * multiplier); // EnemyHP
		container = (int)((Math.random() * 10) + 1);
		medium[1] = container + (int)(container * multiplier); //DEF
		container = (int)((Math.random() * 15) + 1);
		medium[2] = container + (int)(container * multiplier); //ATK
		container = (int)((Math.random() * 6) + 1);
		medium[3] = container + (int)(container * multiplier); //SPD
		container = (int)((Math.random() * 20) + 1);
		medium[4] = container + (int)(container * multiplier); //CRITRATE
		container = (int)((Math.random() * 3) + 1);
		medium[5] = container + (int)(container * multiplier); //CRITDMG MULTIPLIER
		container = (int)((Math.random() * 5) + 1);
		medium[6] = container + (int)(container * multiplier); //VITALITY
		
		//Generate Hard Enemy Stat Block
		container = (int)((Math.random() * 30) + 1) * 10;
		hard[0] = container + (int)(container * multiplier); // EnemyHP
		container = (int)((Math.random() * 25) + 1);
		hard[1] = container + (int)(container * multiplier); //DEF
		container = (int)((Math.random() * 30) + 1);
		hard[2] = container + (int)(container * multiplier); //ATK
		container = (int)((Math.random() * 15) + 1);
		hard[3] = container + (int)(container * multiplier); //SPD
		container = (int)((Math.random() * 55) + 1);
		hard[4] = container + (int)(container * multiplier); //CRITRATE
		container = (int)((Math.random() * 6) + 1);
		hard[5] = container + (int)(container * multiplier); //CRITDMG MULTIPLIER
		container = (int)((Math.random() * 6) + 1);
		hard[6] = container + (int)(container * multiplier); //VITALITY
		
		System.out.println(">> Pick Opponent");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("••••••••••••••••••••••••• - [1] Nameless Chicken - •••••••••••••••••••••••••••••");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Max Health: " + easy[0]);
		System.out.println("Defence: " + easy[1]);
		System.out.println("Attack: " + easy[2]);
		System.out.println("speed: " + easy[3]);
		System.out.println("Crit Rate: " + easy[4]);
		System.out.println("Crit Damage: " + easy[5]);
		System.out.println("Vitality: " + easy[6]);
		
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("•••••••••••••••••••••••••• - [2] Experienced Chicken - •••••••••••••••••••••••••");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Max Health: " + medium[0]);
		System.out.println("Defence: " + medium[1]);
		System.out.println("Attack: " + medium[2]);
		System.out.println("speed: " + medium[3]);
		System.out.println("Crit Rate: " + medium[4]);
		System.out.println("Crit Damage: " + medium[5]);
		System.out.println("Vitality: " + medium[6]);
		
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("•••••••••••••••••••••••••••• - [3] Renowned Chicken - ••••••••••••••••••••••••••");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Max Health: " + hard[0]);
		System.out.println("Defence: " + hard[1]);
		System.out.println("Attack: " + hard[2]);
		System.out.println("speed: " + hard[3]);
		System.out.println("Crit Rate: " + hard[4]);
		System.out.println("Crit Damage: " + hard[5]);
		System.out.println("Vitality: " + hard[6]);
		System.out.println("--------------------------------------------------------------------------------");
		
		System.out.println("•••••••••••••••••••••••••••••••• - [4] Reroll - ••••••••••••••••••••••••••••••••");
		System.out.print("Pick Enemy: ");
		input = reader.nextLine();
		
		switch(input) {
		
		case "1":
			System.out.println(">> You picked a Nameless Chicken to do battle against.");
			difficulty = 1;
			return easy;
		case "2":
			System.out.println(">> You picked an Experienced Chicken to do battle against.");
			difficulty = 2;
			return medium;
		case "3":
			System.out.println(">> You picked a Renowned Chicken to do battle against.");
			difficulty = 3;
			return hard;
		default:
			return EnemyMaker(multiplier);
		
		}
		
	}
	
	public String EnemyNamer() {
		int picked = (int)(Math.random() * name.length) + 1;
		
		return name[picked - 1];
		
	}
	
}
