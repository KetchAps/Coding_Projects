import java.awt.EventQueue;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UI {
	private JFrame frame;
	private JTextField txtUsername;
	ButtonGroup orderType = new ButtonGroup();
	JComboBox<String> comboMainFood;
	JTextArea textAreaSummary;
	JList<String> listSelectedAddon;
	DefaultListModel<String> selectedAddonsModel = new DefaultListModel<String>();
	JList<String> listAddons;
	DefaultListModel<String> addonsModel = new DefaultListModel<String>();
	JCheckBox chckbxExtraSauce;
	JCheckBox chckbxSpicy;
	JRadioButton rdbtnDineIn;
	JRadioButton rdbtnTakeOut;

	String[] addonsMenu = { "Cheese", "Bacon", "Fries", "Drinks" };

	/**
	 * Launch the application.
	 */
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
		frame = new JFrame("Food Ordering System");
		frame.setResizable(false);
		frame.setBounds(100, 100, 624, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPSummary = new JScrollPane();
		scrollPSummary.setBounds(326, 11, 263, 439);
		frame.getContentPane().add(scrollPSummary);
		textAreaSummary = new JTextArea();
		textAreaSummary.setEditable(false);
		scrollPSummary.setViewportView(textAreaSummary);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(10, 11, 594, 439);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		txtUsername = new JTextField();
		txtUsername.setBounds(160, 11, 140, 20);
		mainPanel.add(txtUsername);
		txtUsername.setColumns(10);
		comboMainFood = new JComboBox<String>();
		comboMainFood.addItem("-");
		comboMainFood.addItem("Burger");
		comboMainFood.addItem("Pizza");
		comboMainFood.addItem("Pasta");
		comboMainFood.setBounds(160, 42, 140, 22);
		mainPanel.add(comboMainFood);
		
		JScrollPane scrollPSelectedList = new JScrollPane();
		scrollPSelectedList.setBounds(180, 116, 120, 154);
		mainPanel.add(scrollPSelectedList);
		listSelectedAddon = new JList<String>(selectedAddonsModel);
		listSelectedAddon.addMouseListener(select);
		scrollPSelectedList.setViewportView(listSelectedAddon);
		
		JScrollPane scrollPList = new JScrollPane();
		scrollPList.setBounds(50, 116, 120, 154);
		mainPanel.add(scrollPList);
		listAddons = new JList<String>(addonsModel);
		listAddons.addMouseListener(select);
		listAddons.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		setAddons();

		scrollPList.setViewportView(listAddons);
		JLabel lblNewLabel = new JLabel("Customer Name");
		lblNewLabel.setBounds(50, 14, 120, 14);
		mainPanel.add(lblNewLabel);
		
		JLabel lblSelectFoodOrder = new JLabel("Select Food Order");
		lblSelectFoodOrder.setBounds(50, 46, 120, 14);
		mainPanel.add(lblSelectFoodOrder);
		
		JLabel lblOrderType = new JLabel("Order Type");
		lblOrderType.setBounds(44, 337, 66, 14);
		mainPanel.add(lblOrderType);
		
		JSeparator separator = new JSeparator();

		separator.setBounds(110, 345, 190, 2);
		mainPanel.add(separator);
		rdbtnDineIn = new JRadioButton("Dine In");
		rdbtnDineIn.setBounds(54, 358, 66, 23);
		mainPanel.add(rdbtnDineIn);
		orderType.add(rdbtnDineIn);
		
		rdbtnDineIn.setSelected(true);
		rdbtnTakeOut = new JRadioButton("Take Out");
		rdbtnTakeOut.setBounds(175, 358, 88, 23);
		mainPanel.add(rdbtnTakeOut);
		orderType.add(rdbtnTakeOut);
		
		JSeparator sprtrExtras = new JSeparator();
		sprtrExtras.setBounds(110, 289, 190, 2);
		mainPanel.add(sprtrExtras);
		
		JLabel lblExtras = new JLabel("Extras");
		lblExtras.setBounds(50, 281, 66, 14);
		mainPanel.add(lblExtras);
		
		chckbxExtraSauce = new JCheckBox("Extra Sauce");
		chckbxExtraSauce.setBounds(60, 307, 97, 23);
		mainPanel.add(chckbxExtraSauce);
		
		chckbxSpicy = new JCheckBox("Spicy");
		chckbxSpicy.setBounds(180, 307, 97, 23);
		mainPanel.add(chckbxSpicy);
		
		JButton btnPlaceOrder = new JButton("Place Order");
		btnPlaceOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				placeOrder();
			}
		});
		btnPlaceOrder.setBounds(44, 405, 107, 23);
		mainPanel.add(btnPlaceOrder);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearFields();
			}
		});
		btnClear.setBounds(187, 405, 107, 23);
		mainPanel.add(btnClear);
		
		JLabel lblAvailable = new JLabel("Available");
		lblAvailable.setBounds(84, 101, 67, 14);
		mainPanel.add(lblAvailable);
		
		JLabel lblSelected = new JLabel("Selected");
		lblSelected.setBounds(217, 101, 60, 14);
		mainPanel.add(lblSelected);
		
		JLabel lblAddons = new JLabel("Addons");
		lblAddons.setBounds(50, 85, 66, 14);
		mainPanel.add(lblAddons);
		
		JSeparator sprtrExtras_1 = new JSeparator();
		sprtrExtras_1.setBounds(110, 91, 190, 2);
		mainPanel.add(sprtrExtras_1);
	}

	// Custom Action used in both List objects;
	MouseAdapter select = new MouseAdapter() {

		@Override
		public void mouseClicked(MouseEvent e) { // Triggers when a click inside a JList is detected
			
			Object origin = e.getComponent();
			
			if (origin == listAddons) { // Inactive options;
				
				selectedAddonsModel.addElement(listAddons.getSelectedValue()); // Add selected option to the active List;
				
				addonsModel.remove(listAddons.getSelectedIndex()); // Remove selected option from the inactive list;
			}
			if (origin == listSelectedAddon) { // Active options;
				
				addonsModel.addElement(listSelectedAddon.getSelectedValue()); // Add selected option to the inactive List;
				
				selectedAddonsModel.remove(listSelectedAddon.getSelectedIndex()); // Remove selected option from the active list;
			}

		}
	};

	void placeOrder() {
		// Preload commonly used values;
		String username = txtUsername.getText();
		String foodOrdered = (String) comboMainFood.getSelectedItem();
		int selectedAddons = selectedAddonsModel.size();
		
		// Input validation
		if (username.isEmpty() || foodOrdered.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Customer Name and Food Order cannot be blank!");

			return;
		}
		
		// Display Name and Food Ordered;
		textAreaSummary.setText(" --------------------- Order Summary -------------------\n\n"

				+ " Customer Name: " + username + "\n\n" + " Food Ordered: " + foodOrdered + "\n\n"
				+ " Selected Addons: \n\n");
		
		// Check if no Addon(JList option) is active; Display a default value if true;
		if (selectedAddons <= 0)
			textAreaSummary.append(" -\tNo Addons Selected\n");
		else // If false; loop through all elements in the active List and display them;
			for (int i = 0; i < selectedAddons; i++)
				textAreaSummary.append(" -\t" + selectedAddonsModel.getElementAt(i) + "\n");

		// Check if no Extra(Checkbox option) is active; Display a default value if true;
		textAreaSummary.append(" Selected Extras: \n\n");
		if (!chckbxExtraSauce.isSelected() && !chckbxSpicy.isSelected())
			textAreaSummary.append(" - \tNo Extras Selected\n");
		else {
			// If false; check all individually and display selected;
			if (chckbxExtraSauce.isSelected())
				textAreaSummary.append(" -\tExtra Sauce\n");
			if (chckbxSpicy.isSelected())
				textAreaSummary.append(" -\tSpicy\n");
		}
		
		textAreaSummary.append("\n\n Selected Order Type: ");
		// Check if default button is selected; else, display alternative;
		if (rdbtnDineIn.isSelected())
			textAreaSummary.append("Dine In");
		else
			textAreaSummary.append("Take Out");
		textAreaSummary.append("\n\n" +

				" ---------------------------------------------------------------\n\n");

	}

	void clearFields() { // Individually clean up each active component.
		txtUsername.setText(""); // Clear Name textField
		comboMainFood.setSelectedIndex(0); // Set Food ComboBox to the default "Empty" option
		// Remove all elements from both JLists
		addonsModel.removeAllElements();
		selectedAddonsModel.removeAllElements();
		setAddons(); // Reset the options for the inactive tab.
		// Unselect both Checkboxes
		chckbxExtraSauce.setSelected(false);
		chckbxSpicy.setSelected(false);
		rdbtnDineIn.setSelected(true); //Reset RadioButton to default
		textAreaSummary.setText(""); // Clear Summary textArea

	}

	void setAddons() { // Used in the initialisation phase and in every Clear usage to add the items in the inactive tab
		for (int i = 0; i < addonsMenu.length; i++)
			addonsModel.addElement(addonsMenu[i]);
	}
}