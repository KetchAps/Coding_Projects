package SabongManok;

import java.util.Timer;
import java.util.TimerTask;

public class ChickenFightHandler {
	//Game Control
	int turnCounter;
	final int maxTurns = 50;
	int difficulty;
	float multiplier;
	//Player Stats
		int battleResult = 0;
		boolean battleFinish = false;
		String playerName = "Sir Bucksalot";
		int playerCurrentHP = 50;
		int playerMaxHP = 50;
		int playerDefence = 2;
		int playerAttack = 5;
		int playerSpeed = 2;
		int playerCritRate = 10;
		int playerCritDamage = 2; //Multiplier
		int[] actionChance = {50, 80, 100}; //ATK / DEFEND / HEAL / 
		int playerTempDef;
		int playerVitality = 2;
		
		int[] statBlock = new int[7];
		//Enemy Stats
		String enemyName;
		int enemyCurrentHP = 50;
		int enemyMaxHP = 50;
		int enemyDefence = 2;
		int enemyAttack = 5;
		int enemySpeed = 2;
		int enemyCritRate = 10;
		int enemyCritDamage = 2;
		int[] enemyActionChance = {50, 80, 100}; //ATK / DEFEND / HEAL / 
		int enemyTempDef;
		int enemyVitality = 2;
		
		Timer actionInterval = new Timer();
		String chickenName;
		TimerTask combat = new TimerTask() {
			
			@Override
			public void run() {
			ChickenBattle();}
			};
		
			public synchronized int PreFight() throws InterruptedException {
				// Import Stats
				OpponentPicker enemyPick = new OpponentPicker();
				statBlock = enemyPick.EnemyMaker(multiplier);
				enemyName = enemyPick.EnemyNamer();
				difficulty = enemyPick.difficulty;
				enemyCurrentHP = statBlock[0];
				enemyMaxHP = statBlock[0];
				enemyDefence = statBlock[1];
				enemyAttack = statBlock[2];
				enemySpeed = statBlock[3];
				enemyCritRate = statBlock[4];
				enemyCritDamage = statBlock[5];
				enemyVitality = statBlock[6];
				
				System.out.println("Enemy Stats - " + enemyName);
				System.out.println("------------------------------");
				System.out.println("Max Health: " + statBlock[0]);
				System.out.println("Defence: " + statBlock[1]);
				System.out.println("Attack: " + statBlock[2]);
				System.out.println("speed: " + statBlock[3]);
				System.out.println("Crit Rate: " + statBlock[4]);
				System.out.println("Crit Damage: " + statBlock[5]);
				System.out.println("Vitality: " + statBlock[6]);
				System.out.println("------------------------------");
				System.out.println("   <<Press Enter to Begin>>   ");
				Main.sc.nextLine();
				actionInterval.scheduleAtFixedRate(combat, 0, 1000);
				while(battleFinish == false) {
					wait();
				}
				System.out.println("Battle Finish");
				return battleResult;
			}
	public synchronized void ChickenBattle() {
		turnCounter++;
		System.out.println("------------------------------------------------------------");
		System.out.print("Turn [" + turnCounter + "] || ");
		System.out.println(playerName + " Health Points: " + playerCurrentHP + "|| " +enemyName + " Health Points: " + enemyCurrentHP);
		System.out.println("------------------------------------------------------------");
		
		//Turn - Action
		
		if(turnCounter < maxTurns) {
			
		if(enemyCurrentHP > 0 || playerCurrentHP > 0) {
			
			int playerTurnSpd = (int)(Math.random() * 5) + playerSpeed;
			int enemyTurnSpd = (int)(Math.random() * 5) + enemySpeed;
			
			if(playerTurnSpd >= enemyTurnSpd) { PlayerActionPicker(); EnemyActionPicker();}
			else  							  { EnemyActionPicker(); PlayerActionPicker();}
		}
		
		if(enemyCurrentHP <= 0) { // PLAYER WIN
			actionInterval.cancel();
			System.out.println("------------------------------------------------------------");
			System.out.println(playerName + " won the fight with " + playerCurrentHP + " HP left!");
			System.out.println("------------------------------------------------------------");
			battleResult = 1;
			battleFinish = true;
			notifyAll();
			
		}
		
		if(playerCurrentHP <= 0) { // PLAYER LOSE
			actionInterval.cancel();
			System.out.println(enemyName + " won the fight with " + enemyCurrentHP + " HP left!");
			battleResult = 2;
			battleFinish = true;
			notifyAll();
			}
		
		} else {//If Max Turn Reached - DRAW
			actionInterval.cancel();
			System.out.println("Neither " + enemyName + " or " + enemyCurrentHP + " dealt enough damage to their enemies! The fight ends in a draw!");
			battleResult = 3;
			battleFinish = true;
			notifyAll();
			
			
				}
		
		}
	
	// MAIN BATTLE CODE
	public void PlayerActionPicker() {
		int atkDMG;
		
		
		int actionPicked = (int)(Math.random() * 100) + 1;
		if(actionPicked <= actionChance[0]) { // Attack
			int critRoll = (int)(Math.random() * 100) + 1;
			
			if(critRoll <= playerCritRate) { // Crit Procced
				atkDMG = ((int)((Math.random() * 10) * playerCritDamage) + playerAttack) - (enemyTempDef + enemyDefence);
				if(atkDMG <= 0) atkDMG = 0;
				enemyCurrentHP -= atkDMG;
				System.out.println(">> " + playerName + " CRITICALLY wounds " + enemyName + ", dealing " + atkDMG + " points of damage!");
				
			} else { //Didn't Crit
				atkDMG = (int)((Math.random() * 10) + playerAttack) - enemyDefence;
				if(atkDMG <= 0) atkDMG = 0;
				enemyCurrentHP -= atkDMG;
				System.out.println(">> " + playerName + " attacks " + enemyName + ", dealing " + atkDMG + " points of damage!");
			}
		}
		else if (actionPicked <= actionChance[1]) { //DEFEND 
			playerTempDef = 2;
			
			System.out.println(">> " + playerName + " takes a defensive stance!");
		}
		else if (actionPicked <= actionChance[2]) { //HEAL
			
			int healthRegened = (int)((Math.random() * 3) + 1) * playerVitality;
			if(healthRegened > 10) healthRegened /= 2;
			playerCurrentHP += healthRegened;
			if(playerCurrentHP > playerMaxHP) playerCurrentHP = playerMaxHP;
			System.out.println(">> " + playerName + " takes a moment to rest, restoring " + healthRegened + " health!");
			
		}
		
		//Reset Temporary Stats
		enemyTempDef = 0;
	}
	
	public void EnemyActionPicker() {
		int atkDMG;
		playerTempDef = 0;
		
		int actionPicked = (int)(Math.random() * 100) + 1;
		if(actionPicked <= enemyActionChance[0]) { // Attack
			int critRoll = (int)(Math.random() * 100) + 1;
			
			if(critRoll <= enemyCritRate) { // Crit Procced
				atkDMG = ((int)((Math.random() * 5) * enemyCritDamage) + enemyAttack) - (playerTempDef + playerDefence);
				if(atkDMG <= 0) atkDMG = 0;
				playerCurrentHP -= atkDMG;
				System.out.println(">> " + enemyName + " CRITICALLY wounds " + playerName + ", dealing " + atkDMG + " points of damage!");
				
			} else { //Didn't Crit
				atkDMG = (int)((Math.random() * 5) + enemyAttack) - playerDefence;
				if(atkDMG <= 0) atkDMG = 0;
				playerCurrentHP -= atkDMG;
				System.out.println(">> " + enemyName + " attacks " + playerName + ", dealing " + atkDMG + " points of damage!");
			}
		}
		else if (actionPicked <= enemyActionChance[1]) { //DEFEND 
			enemyTempDef = 2;
			
			System.out.println(">> " + enemyName + " takes a defensive stance!");
		}
		else if (actionPicked <= enemyActionChance[2]) { //HEAL
			int healthRegened = (int)((Math.random() * 3) + 1) * enemyVitality;
			if(healthRegened > 10) healthRegened /= 2;
			enemyCurrentHP += healthRegened;
			if(enemyCurrentHP > enemyMaxHP) enemyCurrentHP = enemyMaxHP;
			System.out.println(">> " + enemyName + " takes a moment to rest, restoring " + healthRegened + " health!");
			
		}
		//Reset Temporary Stats
		playerTempDef = 0;
	}
	
	
	
}
