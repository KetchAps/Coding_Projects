
public class Main {

	public static void main(String[] args) {
		for (int row = 0; row <= 5; row++) {
			for(int s = row; s < 5; s++) {
                System.out.print(" ");
            }
            for (int col = 0; col <= row; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
	}
	
}
	

