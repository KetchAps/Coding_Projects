import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UI {

	private JFrame frame;


	
	private int a, b, m;
	private int maxIterations = 100;
	
	
	private JTextField txtA;
	private JTextField txtB;
	private JLabel lblNewLabel_1;
	private JTextField txtM;
	JTextArea feedBackArea;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI window = new UI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 11, 434, 239);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		JLabel lblInator = new JLabel("Find Divisable-inator");
		lblInator.setFont(new Font("Verdana", Font.BOLD, 25));
		lblInator.setBounds(71, 0, 295, 65);
		mainPanel.add(lblInator);
		
		txtA = new JTextField();
		txtA.setBounds(97, 76, 44, 20);
		mainPanel.add(txtA);
		txtA.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("x ≡");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(151, 79, 33, 14);
		mainPanel.add(lblNewLabel);
		
		txtB = new JTextField();
		txtB.setColumns(10);
		txtB.setBounds(184, 76, 44, 20);
		mainPanel.add(txtB);
		
		lblNewLabel_1 = new JLabel("(mod            )");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(238, 79, 108, 14);
		mainPanel.add(lblNewLabel_1);
		
		txtM = new JTextField();
		txtM.setBounds(283, 76, 44, 20);
		mainPanel.add(txtM);
		txtM.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(97, 148, 246, 80);
		mainPanel.add(scrollPane);
		
		feedBackArea = new JTextArea();
		scrollPane.setViewportView(feedBackArea);
		
		JButton btnNewButton = new JButton("Find divisble term");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				a = Integer.parseInt(txtA.getText());
				b = Integer.parseInt(txtB.getText());
				m = Integer.parseInt(txtM.getText());
				Calculation();
			}
		});
		btnNewButton.setBounds(151, 114, 145, 23);
		mainPanel.add(btnNewButton);
	}
	
	private void Calculation() {
		// ax = b(mod m)
		feedBackArea.setText("- " + a + "x ≡ " + b + " (mod " + m + ")");
		for(int i = 0; i <= maxIterations; i++)
		{
			int dividend = b + (m * i);
			int result = dividend % a;
			
			if(result != 0) {
				feedBackArea.append("\n(" + b + " + " + (m * 1) + "( " + m + " * " + i + ")) / " + a + " = " + (dividend / a) + ": false");
				
				continue;
			}
			feedBackArea.append("\n(" + b + " + " + (m * 1) + "( " + m + " * " + i + ")) / " + a + " = " + (dividend / a) + ": true");
			feedBackArea.append("\n------------------------------------------------------------------------------------------------");
			feedBackArea.append("\nValid Term Found:");
			feedBackArea.append("\n(" + b + " + " + "( " + m + " * " + i + ")) / " + a + " = " + (dividend / a) + "");
			feedBackArea.append("\n" + a +  "x ≡ " + "b = " + dividend + "( mod " + m + ")");
			return;
		}
		
		
	}
}
