package Programme;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UI {

	private JFrame frmShiftSchedulingSystem;
	
    ButtonGroup shiftSelector = new ButtonGroup();
    ButtonGroup btnGroup = new ButtonGroup();
    JRadioButton checkBox[][] = new JRadioButton[2][6];
    
    private DefaultTableModel modelM = new DefaultTableModel(10, 3);
    private DefaultTableModel modelT = new DefaultTableModel(10, 3);
    private DefaultTableModel modelW = new DefaultTableModel(10, 3);
    private DefaultTableModel modelTh = new DefaultTableModel(10, 3);
    private DefaultTableModel modelF = new DefaultTableModel(10, 3);
    private DefaultTableModel modelS = new DefaultTableModel(10, 3);
    private DefaultTableModel tableModels[] = {modelM, modelT, modelW, modelTh, modelF, modelS};
    private DefaultListModel<String> listModel = new DefaultListModel<>();
    private JTable monTable;
    private JTable tuesTable;
    private JTable wedTable;
    private JTable thursTable;
    private JTable friTable;
    private JTable satTable;
    JList<String> searchList;
     private JTextField txtName;
    private JTextField txtID;
    private JTextField txtPosition;
    private JTextField warningField;
    private JTextField txtSearch;
    private JTextField txtNameR;
    
    
    private int queriedShifts[][] = new int[18][3];
    private JTextField txtRoleR;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI window = new UI();
					window.frmShiftSchedulingSystem.setVisible(true);
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
		frmShiftSchedulingSystem = new JFrame();
		frmShiftSchedulingSystem.setResizable(false);
		frmShiftSchedulingSystem.setTitle("Shift Scheduling System");
		frmShiftSchedulingSystem.setBounds(100, 100, 892, 350);
		frmShiftSchedulingSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmShiftSchedulingSystem.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 0, 864, 311);
		frmShiftSchedulingSystem.getContentPane().add(panel);
		panel.setLayout(null);
		
		JTabbedPane MainUI = new JTabbedPane(JTabbedPane.TOP);
		MainUI.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		MainUI.setBorder(null);
		MainUI.setBounds(0, 11, 231, 268);
		panel.add(MainUI);
		
		JPanel pnlAssignEmployee = new JPanel();
		MainUI.addTab("Assign", null, pnlAssignEmployee, null);
		pnlAssignEmployee.setLayout(null);
		
		JRadioButton chkMonday = new JRadioButton("Mon");
		checkBox[0][0] = chkMonday;
		btnGroup.add(chkMonday);
		chkMonday.setBounds(10, 128, 60, 23);
		pnlAssignEmployee.add(chkMonday);
		
		JRadioButton chkTuesday = new JRadioButton("Tue");
		checkBox[0][1] = chkTuesday;
		btnGroup.add(chkTuesday);
		chkTuesday.setBounds(79, 128, 60, 23);
		pnlAssignEmployee.add(chkTuesday);
		
		JRadioButton chkWednesday = new JRadioButton("Wed");
		checkBox[0][2] = chkWednesday;
		btnGroup.add(chkWednesday);
		chkWednesday.setBounds(141, 128, 60, 23);
		pnlAssignEmployee.add(chkWednesday);
		
		JRadioButton chckThursday = new JRadioButton("Thurs");
		checkBox[0][3] = chckThursday;
		btnGroup.add(chckThursday);
		chckThursday.setBounds(10, 154, 60, 23);
		pnlAssignEmployee.add(chckThursday);
		
		JRadioButton chkFriday = new JRadioButton("Fri");
		checkBox[0][4] = chkFriday;
		btnGroup.add(chkFriday);
		chkFriday.setBounds(79, 154, 60, 23);
		pnlAssignEmployee.add(chkFriday);
		
		JRadioButton chkSaturday = new JRadioButton("Sat");
		checkBox[0][5] = chkSaturday;
		btnGroup.add(chkSaturday);
		chkSaturday.setBounds(141, 154, 60, 23);
		pnlAssignEmployee.add(chkSaturday);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("M");
		checkBox[1][0] = rdbtnNewRadioButton;
		shiftSelector.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(10, 206, 50, 23);
		pnlAssignEmployee.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnAfternoon = new JRadioButton("A");
		checkBox[1][1] = rdbtnAfternoon;
		shiftSelector.add(rdbtnAfternoon);
		rdbtnAfternoon.setBounds(79, 206, 50, 23);
		pnlAssignEmployee.add(rdbtnAfternoon);
		
		JRadioButton rdbtnEvening = new JRadioButton("E");
		checkBox[1][2] = rdbtnEvening;
		shiftSelector.add(rdbtnEvening);
		rdbtnEvening.setBounds(141, 206, 50, 23);
		pnlAssignEmployee.add(rdbtnEvening);
		
		JButton btnAssignEmployee = new JButton("Assign Employee");
		btnAssignEmployee.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAssignEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				assignEmployee();
				
			}
		});
		btnAssignEmployee.setBounds(56, 5, 113, 23);
		pnlAssignEmployee.add(btnAssignEmployee);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 65, 50, 14);
		pnlAssignEmployee.add(lblName);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(79, 64, 112, 20);
		pnlAssignEmployee.add(txtName);
		
		JLabel lblID = new JLabel("ID");
		lblID.setBounds(10, 38, 50, 14);
		pnlAssignEmployee.add(lblID);
		
		txtID = new JTextField();
		txtID.setColumns(10);
		txtID.setBounds(79, 38, 112, 20);
		pnlAssignEmployee.add(txtID);
		
		JLabel lblPosition = new JLabel("Position");
		lblPosition.setBounds(10, 88, 50, 14);
		pnlAssignEmployee.add(lblPosition);
		
		txtPosition = new JTextField();
		txtPosition.setColumns(10);
		txtPosition.setBounds(79, 89, 112, 20);
		pnlAssignEmployee.add(txtPosition);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(56, 123, 140, 2);
		pnlAssignEmployee.add(separator);
		
		JLabel lblDay = new JLabel("Day");
		lblDay.setBounds(10, 115, 35, 14);
		pnlAssignEmployee.add(lblDay);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(56, 193, 140, 2);
		pnlAssignEmployee.add(separator_1);
		
		JLabel lblShift = new JLabel("Shift");
		lblShift.setBounds(10, 185, 35, 14);
		pnlAssignEmployee.add(lblShift);
		
		JTabbedPane TableUI = new JTabbedPane(JTabbedPane.TOP);
		TableUI.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		TableUI.setBounds(228, 52, 626, 227);
		panel.add(TableUI);
		
		JPanel monday = new JPanel();
		TableUI.addTab("Monday", null, monday, null);
		monday.setLayout(null);
		
		monTable = new JTable(modelM) {
			
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
			
		};
		monTable.setBounds(10, 28, 601, 160);
		monday.add(monTable);
		
		JLabel mornMon = new JLabel("Morning");
		mornMon.setBounds(80, 11, 46, 14);
		monday.add(mornMon);
		
		JLabel noonMon = new JLabel("Afternoon");
		noonMon.setBounds(280, 11, 60, 14);
		monday.add(noonMon);
		
		JLabel EveMon = new JLabel("Evening");
		EveMon.setBounds(480, 11, 50, 14);
		monday.add(EveMon);
		
		JPanel tuesday = new JPanel();
		tuesday.setLayout(null);
		TableUI.addTab("Tuesday", null, tuesday, null);
		
		tuesTable = new JTable(modelT) {
			
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
			
		};
		tuesTable.setBounds(10, 28, 600, 160);
		tuesday.add(tuesTable);
		
		JLabel mornTue = new JLabel("Morning");
		mornTue.setBounds(80, 11, 46, 14);
		tuesday.add(mornTue);
		
		JLabel noonTue = new JLabel("Afternoon");
		noonTue.setBounds(280, 11, 60, 14);
		tuesday.add(noonTue);
		
		JLabel EveTue = new JLabel("Evening");
		EveTue.setBounds(480, 11, 50, 14);
		tuesday.add(EveTue);
		
		JPanel wednesday = new JPanel();
		wednesday.setLayout(null);
		TableUI.addTab("Wednesday", null, wednesday, null);
		
		wedTable = new JTable(modelW) {
			
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
			
		};
		wedTable.setBounds(10, 28, 600, 160);
		wednesday.add(wedTable);
		
		JLabel lblMorning_1_1 = new JLabel("Morning");
		lblMorning_1_1.setBounds(80, 11, 46, 14);
		wednesday.add(lblMorning_1_1);
		
		JLabel lblAfternoon_1_1 = new JLabel("Afternoon");
		lblAfternoon_1_1.setBounds(280, 11, 60, 14);
		wednesday.add(lblAfternoon_1_1);
		
		JLabel lblEvening_1_1 = new JLabel("Evening");
		lblEvening_1_1.setBounds(480, 11, 50, 14);
		wednesday.add(lblEvening_1_1);
		
		JPanel thursday = new JPanel();
		thursday.setLayout(null);
		TableUI.addTab("Thursday", null, thursday, null);
		
		thursTable = new JTable(modelTh) {
			
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
			
		};
		thursTable.setFillsViewportHeight(true);
		thursTable.setBounds(10, 28, 600, 160);
		thursday.add(thursTable);
		
		JLabel lblMorning_1_1_1 = new JLabel("Morning");
		lblMorning_1_1_1.setBounds(80, 11, 46, 14);
		thursday.add(lblMorning_1_1_1);
		
		JLabel lblAfternoon_1_1_1 = new JLabel("Afternoon");
		lblAfternoon_1_1_1.setBounds(280, 11, 60, 14);
		thursday.add(lblAfternoon_1_1_1);
		
		JLabel lblEvening_1_1_1 = new JLabel("Evening");
		lblEvening_1_1_1.setBounds(480, 11, 50, 14);
		thursday.add(lblEvening_1_1_1);
		
		JPanel friday = new JPanel();
		friday.setLayout(null);
		TableUI.addTab("Friday", null, friday, null);
		
		friTable = new JTable(modelF) {
			
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
			
		};
		friTable.setBounds(10, 28, 600, 160);
		friday.add(friTable);
		
		JLabel lblMorning_1_1_2 = new JLabel("Morning");
		lblMorning_1_1_2.setBounds(80, 11, 46, 14);
		friday.add(lblMorning_1_1_2);
		
		JLabel lblAfternoon_1_1_2 = new JLabel("Afternoon");
		lblAfternoon_1_1_2.setBounds(280, 11, 60, 14);
		friday.add(lblAfternoon_1_1_2);
		
		JLabel lblEvening_1_1_2 = new JLabel("Evening");
		lblEvening_1_1_2.setBounds(480, 11, 50, 14);
		friday.add(lblEvening_1_1_2);
		
		JPanel saturday = new JPanel();
		saturday.setLayout(null);
		TableUI.addTab("Saturday", null, saturday, null);
		
		satTable = new JTable(modelS) {
			
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
			
		};
		satTable.setBounds(10, 28, 600, 160);
		saturday.add(satTable);
		
		JLabel lblMorning_1_1_2_1 = new JLabel("Morning");
		lblMorning_1_1_2_1.setBounds(80, 11, 46, 14);
		saturday.add(lblMorning_1_1_2_1);
		
		JLabel lblAfternoon_1_1_2_1 = new JLabel("Afternoon");
		lblAfternoon_1_1_2_1.setBounds(280, 11, 60, 14);
		saturday.add(lblAfternoon_1_1_2_1);
		
		JLabel lblEvening_1_1_2_1 = new JLabel("Evening");
		lblEvening_1_1_2_1.setBounds(480, 11, 50, 14);
		saturday.add(lblEvening_1_1_2_1);
		
		
		
		MainUI.getRootPane().setDefaultButton(btnAssignEmployee);
		
		JPanel pnlFindEmployee = new JPanel();
		MainUI.addTab("Search", null, pnlFindEmployee, null);
		pnlFindEmployee.setLayout(null);
		
		txtSearch = new JTextField();
		txtSearch.setBounds(10, 8, 129, 20);
		pnlFindEmployee.add(txtSearch);
		txtSearch.setColumns(10);
		
		searchList = new JList<>(listModel);
		searchList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				getSelectedShift();
			}
		});
		searchList.setBounds(10, 36, 206, 130);
		pnlFindEmployee.add(searchList);
		
		
		monTable.setRowSelectionInterval(0, 0);
		txtNameR = new JTextField();
		txtNameR.setColumns(10);
		txtNameR.setBounds(10, 177, 100, 20);
		pnlFindEmployee.add(txtNameR);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				findEmployee();
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSearch.setBounds(143, 8, 73, 20);
		pnlFindEmployee.add(btnSearch);
		
		JButton btnNewButton = new JButton("Remove");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				deleteEmployee();
				
			}
		});
		btnNewButton.setBounds(15, 205, 89, 23);
		pnlFindEmployee.add(btnNewButton);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				editEmployee();
				
			}
		});
		btnEdit.setBounds(122, 205, 89, 23);
		pnlFindEmployee.add(btnEdit);
		
		txtRoleR = new JTextField();
		txtRoleR.setColumns(10);
		txtRoleR.setBounds(116, 177, 100, 20);
		pnlFindEmployee.add(txtRoleR);
		
		warningField = new JTextField();
		warningField.setEditable(false);
		warningField.setBounds(0, 282, 854, 20);
		panel.add(warningField);
		warningField.setColumns(10);
		
		
	}
	
	public void assignEmployee() {
		boolean success = false;
		String name = txtName.getText();
		String ID = txtID.getText();
		String position = txtPosition.getText();
		if(name.isBlank() || ID.isBlank() || position.isBlank()) {
			warningField.setForeground(Color.red);
			warningField.setText("One or more Entry fields are empty.");
			return;
		}
		
		
		String entry = ID + " - " + name + " (" + position + ")";
		DefaultTableModel day = null;
		int shift = -1;
		for(int i = 0; i < 6; i++) if(checkBox[0][i].isSelected()) {
			day = tableModels[i];
			break;
		}
		for(int j = 0; j < 3; j++) if(checkBox[1][j].isSelected()) {
			shift = j;
			break;
		}
		
		if(day == null || shift < 0) {
			warningField.setForeground(Color.red);
			warningField.setText("No 'Day' selected for assignment.");
			return;
		}
		
		for(int o = 0; o < 10; o++) {
			String target = null;
			try {
				
			target = day.getValueAt(o, shift).toString();
			if(target.contains(ID)) {
				
				warningField.setForeground(Color.red);
				warningField.setText("Selected Employee is already assigned in this shift.");
				return;
			}
			System.out.println(day + " is filled");
			continue;
			
			} catch (NullPointerException e) {
				System.out.println(day + "is available");
			}
				
				day.setValueAt(entry, o, shift);
				success = true;
				warningField.setForeground(Color.green);
				warningField.setText(entry + " assigned succesfully.");
				break;
			
			
		}
		
		if(!success) {
			warningField.setForeground(Color.red);
			warningField.setText("No available slots for selected shift.");
		}
		
	}
	
	
	public void findEmployee() {
		listModel.removeAllElements();
		queriedShifts = new int[18][3];
		String dayHeaders[] = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		String shiftHeaders[] = {"Morning", "Afternoon", "Evening"};
		String query = txtSearch.getText();
		String target;
		int slot = 0;
		for(int day = 0; day < 6; day++) {
			for(int row = 0; row < 10; row++) {
				for(int col = 0; col < 3; col++) {
					try {
					target = tableModels[day].getValueAt(row, col).toString();
					} catch (NullPointerException e) {
						continue;
					}
					if(target != null && target.contains(query)) {
						listModel.addElement(dayHeaders[day] + ", " + shiftHeaders[col] + " shift.");
						queriedShifts[slot][0] = day; 
						queriedShifts[slot][1] = row; 
						queriedShifts[slot][2] = col; 
						slot++;
						
					}
					
				}
				
			}
			
		}
		
		warningField.setForeground(Color.green);
		warningField.setText("Displaying selected employee's shifts.");
		
	}
	
	public void getSelectedShift() {
		int target = searchList.getSelectedIndex();
		int day;
		int row;
		int col;
		
		
		day = queriedShifts[target][0];
		row = queriedShifts[target][1];
		col = queriedShifts[target][2];
		
		String value = tableModels[day].getValueAt(row, col).toString();
		txtNameR.setText(value.substring(value.lastIndexOf('-') + 2, value.lastIndexOf('(') - 1));
		txtRoleR.setText(value.substring(value.lastIndexOf('(') + 1, value.length() - 1));
	}
	
	public void deleteEmployee() {
		int target = 0;
		boolean error = false;
		
		try {
		target = searchList.getSelectedIndex();
		
		if(target == -1) error = true;
		} catch(NullPointerException e) {
			
			error = true;
		}
		
		if(error) {
			
			warningField.setForeground(Color.red);
			warningField.setText("No shift entry selected.");
			return;
		}
		
		int day = queriedShifts[target][0];
		int row = queriedShifts[target][1];
		int col = queriedShifts[target][2];
		
		tableModels[day].setValueAt(null, row, col);
		listModel.remove(target);
		warningField.setForeground(Color.green);
		warningField.setText("Entry removed successfully.");
	}
	
	public void editEmployee() {
		int target = 0;
		String currentVal;
		String ID;
		String newName;
		String newRole;
		boolean error = false;
		try {
		target = searchList.getSelectedIndex();
		
		if(target == -1) error = true;
		} catch(NullPointerException e) {
			error = true;
		}
		
		if(error) {
			
			warningField.setForeground(Color.red);
			warningField.setText("No shift entry selected.");
			return;
		}
		
		int day = queriedShifts[target][0];
		int row = queriedShifts[target][1];
		int col = queriedShifts[target][2];
		
		currentVal = tableModels[day].getValueAt(row, col).toString();
		
		ID = currentVal.substring(0, currentVal.lastIndexOf('-') - 1);
		newName = txtNameR.getText();
		newRole = txtRoleR.getText();
		
		tableModels[day].setValueAt(ID + " - " + newName + " (" + newRole + ")", row, col);
		
		warningField.setForeground(Color.green);
		warningField.setText("Entry edited successfully.");
		
	}
}
