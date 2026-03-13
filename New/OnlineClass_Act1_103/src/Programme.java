import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import java.awt.Label;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class Programme {

	private JFrame frame;
	private JTextField txtEspresso;
	private JTextField txtAmericano;
	private JTextField txtCappucino;
	private JTextField txtCaramel;
	private JTextField txtMocha;
	private JTextField txtTotalCost;
	private JTextField txt;
	private JTextField txtMatchaLatte;
	private JTextField textField_2;
	private JTextField txtHotChoco;
	private JTextField txtCinnamonRoll;
	private JTextField txtBananaBread;
	private JTextField txtBBMuffin;
	private JTextField txtChocoCroissant;
	private JTextField txtCroissant;
	private JTextField txtIceCream;
	private JTextField txtDonut;
	private JTextField txtBrownies;
	private JTextField txtChocoCake;
	private JTextField txtCheesecake;
	
	
	private ButtonGroup groupDiscount = new ButtonGroup();
	private JCheckBox grpCoffeeSelect[] = new JCheckBox[5]; //XXX: Suggestion: Add each checkbox and textfield to arrays(pairs have the same index) for easier state checking.
	private JTextField grpCoffeeAmount[] = new JTextField[5];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Programme window = new Programme();
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
	public Programme() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Cafe Management System");
		frame.setBounds(100, 100, 820, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel paneCoffees = new JPanel();
		paneCoffees.setBounds(10, 32, 280, 200);
		paneCoffees.setLayout(null);
		
		JCheckBox chckbxLatte = new JCheckBox("Espresso");
		chckbxLatte.setBounds(6, 16, 97, 23);
		paneCoffees.add(chckbxLatte);
		grpCoffeeSelect[0] = chckbxLatte;
		
		JCheckBox chckbxAmericano = new JCheckBox("Americano");
		chckbxAmericano.setBounds(6, 42, 97, 23);
		paneCoffees.add(chckbxAmericano);
		grpCoffeeSelect[1] = chckbxAmericano;
		
		JCheckBox chckbxCappucino = new JCheckBox("Cappuccino");
		chckbxCappucino.setBounds(6, 68, 97, 23);
		paneCoffees.add(chckbxCappucino);
		grpCoffeeSelect[2] = chckbxCappucino;
		
		JCheckBox chckbxCaramel = new JCheckBox("Caramel");
		chckbxCaramel.setBounds(6, 94, 97, 23);
		paneCoffees.add(chckbxCaramel);
		grpCoffeeSelect[3] = chckbxCaramel;
		
		JCheckBox chckbxMocha = new JCheckBox("Mocha");
		chckbxMocha.setBounds(6, 120, 97, 23);
		paneCoffees.add(chckbxMocha);
		grpCoffeeSelect[4] = chckbxMocha;
		
		JLabel lblCoffee = new JLabel("Coffee");
		lblCoffee.setBounds(108, 0, 46, 14);
		paneCoffees.add(lblCoffee);
		
		txtEspresso = new JTextField();
		txtEspresso.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {		
				
				if(Character.isLetter(e.getKeyChar())) e.consume();
			}
		});
		txtEspresso.setBounds(220, 17, 50, 20);
		paneCoffees.add(txtEspresso);
		txtEspresso.setColumns(10);
		grpCoffeeAmount[0] = txtEspresso;
		
		txtAmericano = new JTextField();
		txtAmericano.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				if(Character.isLetter(e.getKeyChar())) e.consume();
			}
		});
		txtAmericano.setColumns(10);
		txtAmericano.setBounds(220, 43, 50, 20);
		paneCoffees.add(txtAmericano);
		grpCoffeeAmount[1] = txtAmericano;
		
		txtCappucino = new JTextField();
		txtCappucino.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			
				if(Character.isLetter(e.getKeyChar())) e.consume();
				
			}
		});
		txtCappucino.setColumns(10);
		txtCappucino.setBounds(220, 69, 50, 20);
		paneCoffees.add(txtCappucino);
		grpCoffeeAmount[2] = txtCappucino;
		
		txtCaramel = new JTextField();
		txtCaramel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			
				if(Character.isLetter(e.getKeyChar())) e.consume();
				
			}
		});
		txtCaramel.setColumns(10);
		txtCaramel.setBounds(220, 95, 50, 20);
		paneCoffees.add(txtCaramel);
		grpCoffeeAmount[3] = txtCaramel;
		
		txtMocha = new JTextField();
		txtMocha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			
				if(Character.isLetter(e.getKeyChar())) e.consume();
				
			}
		});
		txtMocha.setColumns(10);
		txtMocha.setBounds(220, 121, 50, 20);
		paneCoffees.add(txtMocha);
		grpCoffeeAmount[4] = txtMocha;
		
		JPanel paneNonCoffees = new JPanel();
		paneNonCoffees.setBounds(300, 32, 280, 200);
		paneNonCoffees.setLayout(null);
		
		txt = new JTextField();
		txt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				if(Character.isLetter(e.getKeyChar())) e.consume();
			}
		});
		txt.setColumns(10);
		txt.setBounds(220, 96, 50, 20);
		paneNonCoffees.add(txt);
		
		txtMatchaLatte = new JTextField();
		txtMatchaLatte.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				if(Character.isLetter(e.getKeyChar())) e.consume();
			}
		});
		txtMatchaLatte.setColumns(10);
		txtMatchaLatte.setBounds(220, 44, 50, 20);
		paneNonCoffees.add(txtMatchaLatte);
		
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				if(Character.isLetter(e.getKeyChar())) e.consume();
			}
		});
		textField_2.setColumns(10);
		textField_2.setBounds(220, 70, 50, 20);
		paneNonCoffees.add(textField_2);
		
		txtHotChoco = new JTextField();
		txtHotChoco.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				if(Character.isLetter(e.getKeyChar())) e.consume();
			}
		});
		txtHotChoco.setColumns(10);
		txtHotChoco.setBounds(220, 18, 50, 20);
		paneNonCoffees.add(txtHotChoco);
		
		JCheckBox chckbxLemonade = new JCheckBox("Fresh Lemonade");
		chckbxLemonade.setBounds(6, 95, 124, 23);
		paneNonCoffees.add(chckbxLemonade);
		
		JCheckBox chckbxStrawberryMilk = new JCheckBox("Strawberry Milk");
		chckbxStrawberryMilk.setBounds(6, 69, 124, 23);
		paneNonCoffees.add(chckbxStrawberryMilk);
		
		JCheckBox chckbxMatchaLatte = new JCheckBox("Macha Latte");
		chckbxMatchaLatte.setBounds(6, 43, 97, 23);
		paneNonCoffees.add(chckbxMatchaLatte);
		
		JCheckBox chckbxHotChoco = new JCheckBox("Hot Chocolate");
		chckbxHotChoco.setBounds(6, 17, 107, 23);
		paneNonCoffees.add(chckbxHotChoco);
		
		JTabbedPane paneCoffeeSelect = new JTabbedPane(JTabbedPane.TOP);
		paneCoffeeSelect.setBounds(12, 32, 280, 180);
		frame.getContentPane().add(paneCoffeeSelect);
		paneCoffeeSelect.add(paneCoffees);
		paneCoffeeSelect.add(paneNonCoffees);
		
		JLabel lblNonCoffee = new JLabel("Non-Coffee");
		lblNonCoffee.setBounds(108, 0, 64, 14);
		paneNonCoffees.add(lblNonCoffee);
		paneCoffeeSelect.setTitleAt(1, "Non Coffee");
		paneCoffeeSelect.setTitleAt(0, "Coffee");
		
		JPanel paneNonCoffees_1 = new JPanel();
		paneNonCoffees_1.setLayout(null);
		paneCoffeeSelect.addTab("Extras", null, paneNonCoffees_1, null);
		
		JCheckBox chckbxExtraSyrup = new JCheckBox("Extra Syrup");
		chckbxExtraSyrup.setBounds(9, 21, 97, 23);
		paneNonCoffees_1.add(chckbxExtraSyrup);
		
		JCheckBox chckbxExtraShot = new JCheckBox("Extra Shot Espresso");
		chckbxExtraShot.setBounds(9, 51, 145, 23);
		paneNonCoffees_1.add(chckbxExtraShot);
		
		JLabel lblExtras = new JLabel("Extras");
		lblExtras.setBounds(108, 0, 46, 14);
		paneNonCoffees_1.add(lblExtras);
		
		JLabel lblNewLabel_1 = new JLabel("Total Cost");
		lblNewLabel_1.setBounds(29, 333, 73, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtTotalCost = new JTextField();
		txtTotalCost.setBounds(465, 330, 100, 20);
		frame.getContentPane().add(txtTotalCost);
		txtTotalCost.setEditable(false);
		txtTotalCost.setColumns(10);
		
		JTabbedPane paneFoods = new JTabbedPane(JTabbedPane.TOP);
		paneFoods.setBounds(290, 32, 280, 180);
		frame.getContentPane().add(paneFoods);
		
		JPanel panePastries = new JPanel();
		paneFoods.addTab("Pastries", null, panePastries, null);
		panePastries.setLayout(null);
		
		JCheckBox chckbxCroissant = new JCheckBox("Croissant");
		chckbxCroissant.setBounds(6, 16, 97, 23);
		panePastries.add(chckbxCroissant);
		
		JCheckBox chckbxChocoCroissant = new JCheckBox("Chocolate Croissant");
		chckbxChocoCroissant.setBounds(6, 42, 160, 23);
		panePastries.add(chckbxChocoCroissant);
		
		JCheckBox chckbxBBMuffin = new JCheckBox("Blueberry Muffin");
		chckbxBBMuffin.setBounds(6, 68, 121, 23);
		panePastries.add(chckbxBBMuffin);
		
		JCheckBox chckbxBananaBread = new JCheckBox("Banana Bread");
		chckbxBananaBread.setBounds(6, 94, 121, 23);
		panePastries.add(chckbxBananaBread);
		
		JCheckBox chckbxCinnamonRoll = new JCheckBox("Cinnamon Roll");
		chckbxCinnamonRoll.setBounds(6, 120, 121, 23);
		panePastries.add(chckbxCinnamonRoll);
		
		txtCinnamonRoll = new JTextField();
		txtCinnamonRoll.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				if(Character.isLetter(e.getKeyChar())) e.consume();
			}
		});
		txtCinnamonRoll.setColumns(10);
		txtCinnamonRoll.setBounds(220, 121, 50, 20);
		panePastries.add(txtCinnamonRoll);
		
		txtBananaBread = new JTextField();
		txtBananaBread.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				if(Character.isLetter(e.getKeyChar())) e.consume();
			}
		});
		txtBananaBread.setColumns(10);
		txtBananaBread.setBounds(220, 95, 50, 20);
		panePastries.add(txtBananaBread);
		
		txtBBMuffin = new JTextField();
		txtBBMuffin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				if(Character.isLetter(e.getKeyChar())) e.consume();
			}
		});
		txtBBMuffin.setColumns(10);
		txtBBMuffin.setBounds(220, 69, 50, 20);
		panePastries.add(txtBBMuffin);
		
		txtChocoCroissant = new JTextField();
		txtChocoCroissant.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				if(Character.isLetter(e.getKeyChar())) e.consume();
			}
		});
		txtChocoCroissant.setColumns(10);
		txtChocoCroissant.setBounds(220, 43, 50, 20);
		panePastries.add(txtChocoCroissant);
		
		txtCroissant = new JTextField();
		txtCroissant.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				if(Character.isLetter(e.getKeyChar())) e.consume();
			}
		});
		txtCroissant.setColumns(10);
		txtCroissant.setBounds(220, 17, 50, 20);
		panePastries.add(txtCroissant);
		
		JLabel lblPastries = new JLabel("Pastries");
		lblPastries.setBounds(105, 0, 61, 14);
		panePastries.add(lblPastries);
		
		JPanel paneDesserts = new JPanel();
		paneDesserts.setLayout(null);
		paneFoods.addTab("Desserts", null, paneDesserts, null);
		
		JCheckBox chckbxCheesecake = new JCheckBox("Cheesecake");
		chckbxCheesecake.setBounds(6, 16, 97, 23);
		paneDesserts.add(chckbxCheesecake);
		
		JCheckBox chckbxChocoCake = new JCheckBox("Chocolate Cake");
		chckbxChocoCake.setBounds(6, 42, 121, 23);
		paneDesserts.add(chckbxChocoCake);
		
		JCheckBox chckbxBrownies = new JCheckBox("Brownies");
		chckbxBrownies.setBounds(6, 68, 121, 23);
		paneDesserts.add(chckbxBrownies);
		
		JCheckBox chckbxDonut = new JCheckBox("Donut");
		chckbxDonut.setBounds(6, 94, 97, 23);
		paneDesserts.add(chckbxDonut);
		
		JCheckBox chckbxIceCream = new JCheckBox("Ice Cream");
		chckbxIceCream.setBounds(6, 120, 97, 23);
		paneDesserts.add(chckbxIceCream);
		
		txtIceCream = new JTextField();
		txtIceCream.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				if(Character.isLetter(e.getKeyChar())) e.consume();
			}
		});
		txtIceCream.setColumns(10);
		txtIceCream.setBounds(220, 121, 50, 20);
		paneDesserts.add(txtIceCream);
		
		txtDonut = new JTextField();
		txtDonut.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				if(Character.isLetter(e.getKeyChar())) e.consume();
			}
		});
		txtDonut.setColumns(10);
		txtDonut.setBounds(220, 95, 50, 20);
		paneDesserts.add(txtDonut);
		
		txtBrownies = new JTextField();
		txtBrownies.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				if(Character.isLetter(e.getKeyChar())) e.consume();
			}
		});
		txtBrownies.setColumns(10);
		txtBrownies.setBounds(220, 69, 50, 20);
		paneDesserts.add(txtBrownies);
		
		txtChocoCake = new JTextField();
		txtChocoCake.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				if(Character.isLetter(e.getKeyChar())) e.consume();
			}
		});
		txtChocoCake.setColumns(10);
		txtChocoCake.setBounds(220, 43, 50, 20);
		paneDesserts.add(txtChocoCake);
		
		txtCheesecake = new JTextField();
		txtCheesecake.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				if(Character.isLetter(e.getKeyChar())) e.consume();
			}
		});
		txtCheesecake.setColumns(10);
		txtCheesecake.setBounds(220, 17, 50, 20);
		paneDesserts.add(txtCheesecake);
		
		JLabel lblDesserts = new JLabel("Desserts");
		lblDesserts.setBounds(105, 0, 60, 14);
		paneDesserts.add(lblDesserts);
		
		JPanel paneActionMenu = new JPanel();
		paneActionMenu.setBounds(575, 11, 219, 339);
		frame.getContentPane().add(paneActionMenu);
		paneActionMenu.setLayout(null);
		
		JTextArea txtAreaReceipt = new JTextArea();
		txtAreaReceipt.setEditable(false);
		txtAreaReceipt.setBounds(10, 5, 199, 298);
		paneActionMenu.add(txtAreaReceipt);
		
		JButton btnCompute = new JButton("Compute");
		btnCompute.setBounds(10, 314, 89, 23);
		paneActionMenu.add(btnCompute);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(120, 314, 89, 23);
		paneActionMenu.add(btnClear);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 223, 564, 14);
		frame.getContentPane().add(separator);
		
		JLabel lblDiscount = new JLabel("Discount:");
		lblDiscount.setBounds(30, 235, 58, 14);
		frame.getContentPane().add(lblDiscount);
		
		JRadioButton rdbtnStudent = new JRadioButton("Student");
		rdbtnStudent.setBounds(216, 235, 73, 14);
		frame.getContentPane().add(rdbtnStudent);
		groupDiscount.add(rdbtnStudent);
		
		JRadioButton rdbtnSenior = new JRadioButton("Senior");
		rdbtnSenior.setBounds(327, 235, 73, 14);
		frame.getContentPane().add(rdbtnSenior);
		groupDiscount.add(rdbtnSenior);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(6, 325, 564, 14);
		frame.getContentPane().add(separator_1);
	}
}
