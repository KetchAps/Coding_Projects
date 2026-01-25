package SabongManok;

import java.io.IOException;
public class SabongGame {
	
	String input;
	
	//Player Economy
	int playerMoney = 20;
	int fightResult; // 1 - WIN / 2 - LOSE - 3 DRAW
	//Player Stats
	boolean activeChicken = false;
	String playerName;
	int currentHP = 50;
	int maxHP = 50;
	int defence = 2;
	int attack = 5;
	int speed = 2;
	int critRate = 10;
	int critDamage = 2; //Multiplier
	int[] actionChance = {50, 80, 100}; //ATK / DEFEND / HEAL / 
	int playerVitality = 2;
	float difficultyMultiplier = .10f;
	//Game
	
	
	
		
	public void Game() throws IOException, InterruptedException {
		if(!activeChicken) ChickenCreation();
		
		System.out.println("\n");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Chicken Lobby");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Chickoins: " + playerMoney + "");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println(playerName + " Stats: Max HP: " + maxHP +
				" | DEF: " + defence + " | ATK: " + attack + " | SPD: " + speed +
				" | Crit Rate: " + critRate + " | Crit Damage Multiplier: " + critDamage + "x");
		System.out.println("--------------------------------------------------------------------------------");
	
		System.out.println("[1] Arena :: Fight for chickoins and fame. At the expense of the chicken.");
		System.out.println("[2] Store :: Train.");
		System.out.print("Enter Command: ");
		
		input = Main.sc.nextLine();
		switch(input) {
		
		case "1": ChickenFightLobby();
		break;
		case "2": ChickenStore();
		break;
		
		default: Game();
		}
	}
	
	public void ChickenStore() throws IOException, InterruptedException {
		System.out.println("\n");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Chicken Store");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Chickoins: " + playerMoney + "");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println(playerName + " Stats: Max HP: " + maxHP +
				" | DEF: " + defence + " | ATK: " + attack + " | SPD: " + speed +
				" | Crit Rate: " + critRate + " | Crit Damage Multiplier: " + critDamage + "x");
		System.out.println("--------------------------------------------------------------------------------");
		
		System.out.println("             Item                      ||                     Price              ");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("[1] Endurance Enhancing Feed  (+5 HP)  ::                 15 Chickoins			");
		System.out.println("[2] Feather Polish            (+1 DEF) ::                 10 Chickoins			");
		System.out.println("[3] Talon Sharpener           (+2 ATK) ::                 10 Chickoins			");
		System.out.println("[4] Adrenaline                (+1 SPD) ::                 10 Chickoins			");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("[5] Exit Store");
		System.out.print(">> ");
		input = Main.sc.nextLine();
		switch(input) {
		// HP
		case "1": if(playerMoney >= 15) {
			System.out.println(">> Successfully purchased Endurance Enhancing Feed! (+5 HP)");
			playerMoney -= 15;
			maxHP += 5;
		} else {
			System.out.println(">> Not enough Chickoins.");
		}
		break;
		// DEF
		case "2": if(playerMoney >= 10) {
			System.out.println(">> Successfully purchased Feather Polish! (+1 DEF)");
			playerMoney -= 10;
			defence += 1;
		} else {
			System.out.println(">> Not enough Chickoins.");
		}
		break;
		// ATK
		case "3": if(playerMoney >= 10) {
			System.out.println(">> Successfully purchased Talon Sharpener! (+2 ATK)");
			playerMoney -= 10;
			attack += 2;
		} else {
			System.out.println(">> Not enough Chickoins.");
		}
		break;
		// SPD
		case "4": if(playerMoney >= 10) {
			System.out.println(">> Successfully purchased Adrenaline! (+1 SPD)");
			playerMoney -= 10;
			speed += 1;
		} else {
			System.out.println(">> Not enough Chickoins.");
		}
		break;
		
		case "5":
			System.out.println(">> Exiting Store...");
			Game();
			break;
		}
		
		//Call Self
		ChickenStore();
		
	}
	
	
	
	
	
	public void ChickenFightLobby() throws IOException, InterruptedException {
		System.out.println();
	
		//BEGIN FIGHT
		ChickenFightHandler fight = new ChickenFightHandler();
		//Manually set all stats.
		fight.playerName = playerName;
		fight.playerCurrentHP = currentHP;
		fight.playerMaxHP = maxHP;
		fight.playerDefence = defence;
		fight.playerAttack = attack;
		fight.playerSpeed = speed;
		fight.playerCritRate = critRate;
		fight.playerCritDamage = critDamage; //Multiplier
		fight.playerVitality = playerVitality;
		fight.multiplier = difficultyMultiplier;
		fightResult = fight.PreFight();
		
		if(fightResult == 1) {
			
			int reward = (int)((Math.random() * 10) + 1) * fight.difficulty + (int)(((Math.random() * 5) + 1) * difficultyMultiplier);
			playerMoney += reward;
			System.out.println("You received " + reward + " coins for your victory!");
			difficultyMultiplier += .01;
			Game();
			
		} else if(fightResult == 2) {
			
			System.out.println("Your Chicken Died. Shame on you.");
			activeChicken = false;
			difficultyMultiplier = .05f; //Pity
			Game();
		} else if(fightResult == 3) {
			
			System.out.println("The fight ended in a draw. You will receive no compensation for failure.");
			Game();
		}
	}
	
	
	public void ChickenCreation() {
		activeChicken = true;
		System.out.println("Sabong Simulator 2025");
		
		//NAME PLAYER
		System.out.print("Name your Chicken: ");
		input = Main.sc.nextLine();
		
		System.out.println("Chicken name set! Welcome to the world, " + input + "!");
		playerName = input;
		
		currentHP = 50;
		maxHP = 50;
		defence = 2;
		attack = 5;
		speed = 2;
		critRate = 10;
		critDamage = 2; //Multiplier
		playerVitality = 2;
		
		
	}
	
	
	
	
}
