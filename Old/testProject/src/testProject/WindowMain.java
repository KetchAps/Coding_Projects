package testProject;
//CTRL+SHIFT+O for ez importing of packages 
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class WindowMain {
	//Declare the variables for the various parts of the programme.
	private JFrame window; //Main Container
	private JPanel panelMain; //Contains the Title label
	private JPanel panelButtons; //Contains the singular button on the programme
	private JLabel label; //Title Label
	private JLabel resultSignifier; //The Winner/Loser thing in the middle
	public int results; //I forgot what this is but Im afraid to delete it.
	private Timer timer; //Timer used for the win effects
	private Timer animFPS;
	public int val;
	public int animCurrFrame;
	public int winETimer; //Timer for the colour change of the win effect.
	//public boolean playerWin = false; OBSOLETE
	public Timer value;
	public ImageIcon animFrame01 = new ImageIcon ("JokeDisplay_Anim_01.png");
	public ImageIcon animFrame02 = new ImageIcon ("JokeDisplay_Anim_02.png");
	public ImageIcon animFrame03 = new ImageIcon ("JokeDisplay_Anim_03.png");
	
	//TODO: Organise code properly, can't read shit
	
	public WindowMain() {
		
		//Functions related to the main Frame Container
		
		window = new JFrame("yayeeka"); //Sets the variable as a new instance of JFrame or something
		//window.setTitle("Extremely Fancy Roulette: Won't Delete System32!");
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		/*!!IMPORTANT: This sets the Close Button's behaviour. Make sure its
		 * DISPOSE_ON_CLOSE or you'll have to close the programme through task manager!!
		*/
		window.setSize(800, 500);
		window.setLocationRelativeTo(null); //'null' value centres the window.
		window.getContentPane().setBackground(new Color(191, 166, 255)); //Recolours the Frame BG
		
		//Panels Stuff
		panelMain = new JPanel();
		panelButtons = new JPanel();
		panelMain.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));
		
		panelMain.setBackground(new Color(94, 60, 153));
		panelMain.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		panelMain.setPreferredSize(new Dimension(150, 150));
		label = new JLabel("Very Fancy Roulette");
		
		label.setForeground(Color.WHITE); 
		
		label.setFont(new Font("Oswald", Font.BOLD, 40));
		//End Main Panel Stuff
		
		
		resultSignifier = new JLabel("[Start Rolling!] ");
		System.out.println(val);
		resultSignifier.setHorizontalAlignment(SwingConstants.CENTER); //Centres the object
		resultSignifier.setFont(new Font("Oswald", Font.BOLD, 35));
		
		
		//Related to the button's graphics
		Button button1 = new Button("Roll");
		button1.setFont(new Font("Comic Sans", Font.BOLD, 40));
		button1.setFocusable(false);
		button1.setBackground(new Color(94, 60, 153));
		button1.setForeground(Color.WHITE);
		//Sets Button Behaviours
		button1.addActionListener(new ActionListener() {
			//Executes when the button is clicked
			@Override
			public void actionPerformed(ActionEvent e) {
				int gambleResults;
				gambleResults = Gamble(results); //Calls the Gamble Method and sets the variable's value according to the output
				
				System.out.println(gambleResults); //Debugging related. prints out the output of the RNG
				
				if(gambleResults == 1) {
					//Changes the text
					resultSignifier.setText("[WINNER!]");
					
					winEffects(); //Calls the WinEffect method(executes)
					timer.start(); //Start the timer in WinEffects()
					button1.setEnabled(false); // Disables button. Prevents the user from rolling again.
					try {
						//Attempt to open the link
						Desktop.getDesktop().browse(java.net.URI.create("https://youtu.be/dQw4w9WgXcQ?si=pAF46w0SGyYjS8iU"));
					} catch (IOException e1) {
						//Executes if the link couldnt be opened
						System.out.println("Error: Failed to open Link!");
						
					}
					
				} else {
					//What happens if the RNG didnt produce a value equal to 1
					resultSignifier.setText("[LOSER!]");
					
				}
			}
			
		});
		
		faceAnimation();
		animFPS.start();
		panelMain.add(label); //Displays the Title Label in the panel
		panelButtons.add(button1); 
		window.add(panelMain, BorderLayout.NORTH); //Makes panelMain visible to the north in the window
		window.add(panelButtons, BorderLayout.SOUTH); //Makes panelButtons visible to the south in the window
		window.add(resultSignifier, FlowLayout.CENTER); //Makes resultSignifier visible on the centre in the window
		
		
		
		
		
	}
	
	
	


	//This gets called by the Launcher file. Basically just opens a window where all the things take place
	public void show() {
		
		window.setVisible(true);
	}
	
	//Related: Action Performed
	//Very basic Random-Number Generator
	public int Gamble(int result) {
		int min = 1; //Minimum value that can be generated
		int max = 5; //Maximum value that can be generated
		int range = max - min + 1;
		result = (int)(Math.random() * range) + 1; //Actual calculation
		
	return result;
	}
	
	
	public void winEffects() {
		//Uses swing timer package instead of a wonky variable-based timer
		timer = new Timer(1000, new ActionListener() {
			//Every 1000 miliseconds(1 second), the code within the action listener method is executed
			@Override
			public void actionPerformed(ActionEvent e) {
				winETimer++; // Count up by 1
				System.out.println("Timer: " + winETimer);
				if(winETimer == 1) resultSignifier.setForeground(Color.RED);
				if(winETimer == 2) resultSignifier.setForeground(Color.BLUE);
				if(winETimer == 3) resultSignifier.setForeground(Color.GREEN);
				if(winETimer == 4) resultSignifier.setForeground(Color.YELLOW);
				if(winETimer == 5) {
					resultSignifier.setForeground(Color.WHITE);
					winETimer = 0;
				}
				
			}});
	}
	
	public void faceAnimation() {
		
		animFPS = new Timer(500, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				animCurrFrame++;
				if(animCurrFrame == 1) label.setIcon(animFrame01);
				//if(animCurrFrame == 2) label.setIcon(animFrame02);
				if(animCurrFrame == 2) label.setIcon(animFrame03);
				if(animCurrFrame == 2) animCurrFrame = 0;
				
			}});
		
	}
	
	
	
		
		
	}
	
