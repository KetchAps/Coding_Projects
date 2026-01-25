import java.util.Scanner;

public class Main {
	
	static Scanner rd = new Scanner(System.in);
	
	public static void main(String[] args) {
		int size;
		System.out.print("Enter array size: ");
		size = rd.nextInt();
		
		int[] numbers = new int[size];
		
		System.out.println("Enter array values:");
		for(int i = 0; i < numbers.length; i++) {
			System.out.print("Enter value [" + i +"]: ");
			numbers[i] = rd.nextInt();
		}
		
		System.out.print("Even Numbers: ");
		for(int o = 0; o < numbers.length; o++) {
			if(numbers[o] % 2 == 0) {
				System.out.print(numbers[o] + " ");
				}
		}
		System.out.print("\nOdd Numbers: ");
		for(int l = 0; l < numbers.length; l++) {
			if(numbers[l] % 2 != 0) {
				System.out.print(numbers[l] + "  "); 
			}
		}
//		System.out.println("Highest: " + highest);
//		System.out.println("Lowest: " + lowest);
		
	}

}
