import java.util.Scanner;

public class Main {
	
	static Scanner rd = new Scanner(System.in);
	static String shiftSchedule[][][] = new String[10][3][6];
	static char timeSlotHeader[] = {'M', 'A', 'E'};
	static String employees[][];
	static int days; // faces
	static final int timeSlot = 3; //
	static int shifts; // columns
	
	public static void main(String[] args) {
		Initialisation();
		SeeList(0);
		
	}
	
	public static void SeeList(int sheetIndex) {
			System.out.println("");
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("SHIFT SCHEDULE : DAY " + (sheetIndex+1));
			
			for (int row = 0; row < shiftSchedule[sheetIndex].length; row++) {
				
				String index = shiftSchedule[sheetIndex][row][0];
				System.out.print("[" + timeSlotHeader[row] + "]");
				if (index != null) {
					for (int column = 0; column < shiftSchedule[sheetIndex][row].length; column++) {
						String item = (column != 0) ? shiftSchedule[sheetIndex][row][column - 1] : ""; //Take the last column's string length
						int spaceVariance[] = {0, 12, 18, 18};
						int spaceLength = spaceVariance[1] - item.length();
						
							
						for (int space = 1; space <= spaceLength; space++) { // e2 start
							System.out.print(" ");
						} // e1 loop end
						
						
						System.out.print(shiftSchedule[sheetIndex][row][column]);

					} // column loop end
					
				}
				System.out.println();
			}
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("");
		
		return;
	}
	
	public static void Initialisation() {
		
		System.out.println("Welcome to Generic Shift Scheduling Manager !© 2026 .");
		System.out.println("\n\n<<Press Enter to Begin Setup Process>>");
		
		rd.nextLine();
		
		System.out.print("Set the amount of days to record: ");
		days = Integer.parseInt(rd.nextLine());
		shiftSchedule = new String[days][timeSlot][];
		
		System.out.println(">> The Programme will record " + days + " days worth of shift schedules" +
						"\n\n<<Press Enter to Continue>>");
		
		System.out.println("Set the amount of shift slots for each time slots for each day: ");
		System.out.println("M = Morning, A = Afternoon, E = Evening");
		for(int day = 0; day < days; day++) {
			
			for(int time = 0; time < timeSlot; time++) {
				System.out.print("Set Shift Slots for day " + (day + 1) + ", " + timeSlotHeader[time] + " slot: ");
				while(true) {
					try {
					shiftSchedule[day][time] = new String[Integer.parseInt(rd.nextLine())];	
					break;
					} catch(NumberFormatException e) {
						System.out.println("> Error: Invalid Input! ");
					}
				}
			}
		}	
				// Fill all slots with placeholder text.
				for (int s = 0; s < shiftSchedule.length; s++) {
					for (int r = 0; r < shiftSchedule[s].length; r++) {
						for (int c = 0; c < shiftSchedule[s][r].length; c++) {
					
							shiftSchedule[s][r][c] = "-";
					}
				}
			}
	}
}
