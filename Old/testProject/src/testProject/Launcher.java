package testProject;

import javax.swing.SwingUtilities;

public class Launcher {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() { //invokeLater() Makes the the program run on a single thread* Mandatory
			@Override
			//This creates a new instance of the actual programme.
			public void run() {
				 WindowMain main = new WindowMain();
				 main.show();
				
			}
			
			
		});

	}

}
