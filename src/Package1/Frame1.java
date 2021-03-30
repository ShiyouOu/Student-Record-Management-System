package Package1;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.Color;
import java.awt.Desktop.Action;

import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.TextListener;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.CardLayout;
import javax.swing.ListSelectionModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class Frame1 {
	static final long serialVersionUID = 42L;
	private JFrame frmStudentRecordManagement;
	private JTextField txtStudentName;
	private JTextField txtStudentID;
	private JTextField txtAddress;
	private JTextField txtPhoneNumber;
	private JLabel lblPhoneNumber;
	private JTextField txtMajor;
	private JTable tblCourses;
	private JButton btnAddClass;
	private JTextField txtCourseName;
	private JTextField txtCourseNumber;
	private JLabel lblCourseName;
	private JLabel lblCourseNumber;
	
	private static int MAX_GRADE = 100;
	
	private static JTextField[] requiredFields;
	private static JPanel[] panels;
	private JTextField txtLocation;
	private JTextField txtTime;
	private JTextField txtBirth;
	private JLabel lblDateOfBirth;
	private JTable tblStudents;
	private JTextField txtStudentSearch;
	private JTextField txtCourseSearch;

	String studentPath = "students.ser";
	String coursesPath = "courses.ser";
	private JPanel pnlStudentForm;
	private JTable tblCart;
	private JButton btnBack;
	private JPanel pnlStudentDatabase;
	private JButton btnSelect;
	private JButton btnNewCourse;
	private JButton btnNewStudent;
	private JButton btnBack2;
	private JPanel pnlStudentInfo;
	
	private ArrayList<Student> students = new ArrayList<Student>();
	private ArrayList<Course> courses = new ArrayList<Course>();
	private JPanel panel;
	private JButton btnNewButton_1;
	private JLabel lblStudentName;
	private JLabel lblStudentId;
	private JLabel lblDateOfBirth_1;
	private JLabel lblAddress_1;
	private JLabel lblMajor_1;
	private JTable tblSchedule;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblAverage;
	private JLabel lblGPA;
	private static Student selectedStudent;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
					window.frmStudentRecordManagement.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStudentRecordManagement = new JFrame();
		frmStudentRecordManagement.getContentPane().setEnabled(false);
		frmStudentRecordManagement.getContentPane().setBackground(SystemColor.activeCaption);
		frmStudentRecordManagement.setTitle("Student Record Management System");
		frmStudentRecordManagement.setBounds(100, 100, 689, 479);
		frmStudentRecordManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStudentRecordManagement.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel pnlAddStudent = new JPanel();
		pnlAddStudent.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		pnlAddStudent.setBackground(SystemColor.activeCaption);
		frmStudentRecordManagement.getContentPane().add(pnlAddStudent, "name_1677049962218400");
		pnlAddStudent.setLayout(null);
		
		pnlStudentForm = new JPanel();
		pnlStudentForm.setBackground(Color.WHITE);
		pnlStudentForm.setBounds(10, 11, 240, 378);
		pnlAddStudent.add(pnlStudentForm);
		pnlStudentForm.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Name:");
		lblNewLabel.setBounds(10, 42, 92, 14);
		pnlStudentForm.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtStudentName = new JTextField();
		txtStudentName.setFont(new Font("Arial", Font.PLAIN, 11));
		txtStudentName.setBounds(115, 36, 105, 20);
		pnlStudentForm.add(txtStudentName);
		txtStudentName.setToolTipText("Name");
		txtStudentName.setColumns(10);
		
		JLabel lblStudentNumber = new JLabel("Student ID:");
		lblStudentNumber.setBounds(10, 98, 86, 14);
		pnlStudentForm.add(lblStudentNumber);
		lblStudentNumber.setFont(new Font("Arial", Font.PLAIN, 11));
		lblStudentNumber.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtStudentID = new JTextField();
		txtStudentID.setFont(new Font("Arial", Font.PLAIN, 11));
		txtStudentID.setBounds(115, 92, 105, 20);
		pnlStudentForm.add(txtStudentID);
		txtStudentID.setToolTipText("Student Number");
		txtStudentID.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(10, 154, 86, 14);
		pnlStudentForm.add(lblAddress);
		lblAddress.setFont(new Font("Arial", Font.PLAIN, 11));
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Arial", Font.PLAIN, 11));
		txtAddress.setBounds(115, 148, 105, 20);
		pnlStudentForm.add(txtAddress);
		txtAddress.setToolTipText("Address");
		txtAddress.setColumns(10);
		
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setFont(new Font("Arial", Font.PLAIN, 11));
		txtPhoneNumber.setBounds(115, 204, 105, 20);
		pnlStudentForm.add(txtPhoneNumber);
		txtPhoneNumber.setToolTipText("Phone Number");
		txtPhoneNumber.setColumns(10);
		
		lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setBounds(10, 210, 86, 14);
		pnlStudentForm.add(lblPhoneNumber);
		lblPhoneNumber.setFont(new Font("Arial", Font.PLAIN, 11));
		lblPhoneNumber.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtMajor = new JTextField();
		txtMajor.setFont(new Font("Arial", Font.PLAIN, 11));
		txtMajor.setBounds(115, 260, 105, 20);
		pnlStudentForm.add(txtMajor);
		txtMajor.setToolTipText("Major");
		txtMajor.setColumns(10);
		
		JLabel lblMajor = new JLabel("Major:");
		lblMajor.setBounds(10, 266, 86, 14);
		pnlStudentForm.add(lblMajor);
		lblMajor.setHorizontalAlignment(SwingConstants.CENTER);
		lblMajor.setFont(new Font("Arial", Font.PLAIN, 11));
		
		txtBirth = new JTextField();
		txtBirth.setFont(new Font("Arial", Font.PLAIN, 11));
		txtBirth.setBounds(115, 316, 105, 20);
		pnlStudentForm.add(txtBirth);
		txtBirth.setToolTipText("Date of Birth");
		txtBirth.setColumns(10);
		
		lblDateOfBirth = new JLabel("Date of Birth:");
		lblDateOfBirth.setBounds(10, 322, 86, 14);
		pnlStudentForm.add(lblDateOfBirth);
		lblDateOfBirth.setHorizontalAlignment(SwingConstants.CENTER);
		lblDateOfBirth.setFont(new Font("Arial", Font.PLAIN, 11));
		
		JButton btnCreateRecord = new JButton("Add Student");
		btnCreateRecord.setBounds(150, 400, 130, 29);
		pnlAddStudent.add(btnCreateRecord);
		btnCreateRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateNewStudent();
			}
		});
		btnCreateRecord.setFont(new Font("Arial", Font.PLAIN, 11));
		
		tblCourses = new JTable();
		tblCourses.setBounds(261, 42, 402, 132);
		pnlAddStudent.add(tblCourses);
		tblCourses.setForeground(Color.BLACK);
		tblCourses.setModel(new DefaultTableModel(
			new Object[][] {
				{"Course Name", "Course Number", "Location", "Time"},
			},
			new String[] {
				"Name", "Number", "Location", "Time"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblCourses.getColumnModel().getColumn(0).setResizable(false);
		tblCourses.getColumnModel().getColumn(1).setResizable(false);
		tblCourses.getColumnModel().getColumn(2).setResizable(false);
		tblCourses.getColumnModel().getColumn(2).setPreferredWidth(104);
		tblCourses.getColumnModel().getColumn(3).setResizable(false);
		
		txtCourseSearch = new JTextField();
		txtCourseSearch.setFont(new Font("Arial", Font.PLAIN, 11));
		txtCourseSearch.setBounds(260, 11, 86, 20);
		pnlAddStudent.add(txtCourseSearch);
		txtCourseSearch.setColumns(10);
		
		JButton btnSearchByCourse = new JButton("Search Courses");
		btnSearchByCourse.setFont(new Font("Arial", Font.PLAIN, 11));
		btnSearchByCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchCourse(txtCourseSearch.getText());
			}
		});
		btnSearchByCourse.setBounds(356, 11, 107, 20);
		pnlAddStudent.add(btnSearchByCourse);
		
		tblCart = new JTable();
		tblCart.setModel(new DefaultTableModel(
			new Object[][] {
				{"Course Name", "Course Number", "Location", "Time"},
			},
			new String[] {
				"Name", "Number", "Location", "Time"
			}
		));
		tblCart.getColumnModel().getColumn(0).setResizable(false);
		tblCart.getColumnModel().getColumn(1).setResizable(false);
		tblCart.getColumnModel().getColumn(2).setResizable(false);
		tblCart.getColumnModel().getColumn(3).setResizable(false);
		tblCart.setForeground(Color.BLACK);
		tblCart.setBounds(260, 257, 402, 132);
		pnlAddStudent.add(tblCart);
		
		JLabel lblInCart = new JLabel("In Cart");
		lblInCart.setHorizontalAlignment(SwingConstants.CENTER);
		lblInCart.setFont(new Font("Arial", Font.PLAIN, 11));
		lblInCart.setBounds(260, 238, 86, 20);
		pnlAddStudent.add(lblInCart);
		
		JButton btnAddToCart = new JButton("Add Class");
		btnAddToCart.setFont(new Font("Arial", Font.PLAIN, 11));
		btnAddToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddClassToCart();
			}
		});
		btnAddToCart.setBounds(556, 11, 107, 20);
		pnlAddStudent.add(btnAddToCart);
		
		JButton btnRemoveClass = new JButton("Remove Class");
		btnRemoveClass.setFont(new Font("Arial", Font.PLAIN, 11));
		btnRemoveClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoveSelectedRow(tblCart);
			}
		});
		btnRemoveClass.setBounds(556, 222, 107, 20);
		pnlAddStudent.add(btnRemoveClass);
		
		btnBack2 = new JButton("Back");
		btnBack2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetAsActivePanel(pnlStudentDatabase);
			}
		});
		btnBack2.setFont(new Font("Arial", Font.PLAIN, 11));
		btnBack2.setBounds(10, 400, 130, 29);
		pnlAddStudent.add(btnBack2);
		
		JPanel pnlCreateCourses = new JPanel();
		pnlCreateCourses.setBackground(SystemColor.activeCaption);
		frmStudentRecordManagement.getContentPane().add(pnlCreateCourses, "name_1678304570201900");
		pnlCreateCourses.setLayout(null);
		
		btnAddClass = new JButton("Create Course");
		btnAddClass.setFont(new Font("Arial", Font.PLAIN, 11));
		btnAddClass.setBounds(334, 291, 117, 35);
		pnlCreateCourses.add(btnAddClass);
		
		txtCourseName = new JTextField();
		txtCourseName.setBounds(334, 55, 109, 29);
		pnlCreateCourses.add(txtCourseName);
		txtCourseName.setToolTipText("Course Name");
		txtCourseName.setColumns(10);
		
		txtCourseNumber = new JTextField();
		txtCourseNumber.setBounds(334, 107, 109, 29);
		pnlCreateCourses.add(txtCourseNumber);
		txtCourseNumber.setToolTipText("Course Number");
		txtCourseNumber.setColumns(10);
		
		txtLocation = new JTextField();
		txtLocation.setBounds(334, 159, 109, 29);
		pnlCreateCourses.add(txtLocation);
		txtLocation.setToolTipText("Grade");
		txtLocation.setColumns(10);
		
		txtTime = new JTextField();
		txtTime.setBounds(334, 210, 109, 29);
		pnlCreateCourses.add(txtTime);
		txtTime.setToolTipText("Grade");
		txtTime.setColumns(10);
		
		lblCourseName = new JLabel("Course Name");
		lblCourseName.setBounds(220, 55, 89, 29);
		pnlCreateCourses.add(lblCourseName);
		lblCourseName.setFont(new Font("Arial", Font.PLAIN, 11));
		lblCourseName.setForeground(Color.WHITE);
		
		lblCourseNumber = new JLabel("Course Number");
		lblCourseNumber.setBounds(220, 107, 89, 29);
		pnlCreateCourses.add(lblCourseNumber);
		lblCourseNumber.setFont(new Font("Arial", Font.PLAIN, 11));
		lblCourseNumber.setForeground(Color.WHITE);
		
		JLabel lblTime = new JLabel("Location");
		lblTime.setBounds(220, 159, 89, 29);
		pnlCreateCourses.add(lblTime);
		lblTime.setForeground(Color.WHITE);
		lblTime.setFont(new Font("Arial", Font.PLAIN, 11));
		
		JLabel lblTime_1 = new JLabel("Time");
		lblTime_1.setBounds(220, 207, 89, 35);
		pnlCreateCourses.add(lblTime_1);
		lblTime_1.setForeground(Color.WHITE);
		lblTime_1.setFont(new Font("Arial", Font.PLAIN, 11));
		
		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Arial", Font.PLAIN, 11));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetAsActivePanel(pnlStudentDatabase);
			}
		});
		btnBack.setBounds(207, 291, 117, 35);
		pnlCreateCourses.add(btnBack);
		
		pnlStudentDatabase = new JPanel();
		pnlStudentDatabase.setBackground(SystemColor.activeCaption);
		frmStudentRecordManagement.getContentPane().add(pnlStudentDatabase, "name_1678943416733100");
		pnlStudentDatabase.setLayout(null);
		
		tblStudents = new JTable();
		tblStudents.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblStudents.setBounds(10, 66, 371, 363);
		pnlStudentDatabase.add(tblStudents);
		tblStudents.setModel(new DefaultTableModel(
			new Object[][] {
				{"Name", "Student ID", "Major"},
			},
			new String[] {
				"Name", "ID", "Major"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		JButton btnNewButton = new JButton("Search By Student ID");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchStudent(txtStudentSearch.getText());
			}
		});
		btnNewButton.setBounds(236, 24, 145, 31);
		pnlStudentDatabase.add(btnNewButton);
		
		txtStudentSearch = new JTextField();
		txtStudentSearch.setBounds(10, 24, 135, 31);
		pnlStudentDatabase.add(txtStudentSearch);
		txtStudentSearch.setColumns(10);
		
		btnSelect = new JButton("Select");
		btnSelect.setFont(new Font("Arial", Font.PLAIN, 11));
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean displayInfo = DisplayStudentInfo();
				if(displayInfo) {
					SetAsActivePanel(pnlStudentInfo);
				}
			}
		});
		btnSelect.setBounds(488, 66, 121, 41);
		pnlStudentDatabase.add(btnSelect);
		
		btnNewStudent = new JButton("New Student");
		btnNewStudent.setFont(new Font("Arial", Font.PLAIN, 11));
		btnNewStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetAsActivePanel(pnlAddStudent);
			}
		});
		btnNewStudent.setBounds(488, 118, 121, 41);
		pnlStudentDatabase.add(btnNewStudent);
		
		btnNewCourse = new JButton("New Course");
		btnNewCourse.setFont(new Font("Arial", Font.PLAIN, 11));
		btnNewCourse.setBounds(488, 170, 121, 41);
		pnlStudentDatabase.add(btnNewCourse);
		btnNewCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetAsActivePanel(pnlCreateCourses);
			}
		});
		tblStudents.getColumnModel().getColumn(0).setResizable(false);
		tblStudents.getColumnModel().getColumn(1).setResizable(false);
		tblStudents.getColumnModel().getColumn(2).setResizable(false);
		btnAddClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCourse();
			}
		});
		
		pnlStudentInfo = new JPanel();
		pnlStudentInfo.setBackground(SystemColor.activeCaption);
		frmStudentRecordManagement.getContentPane().add(pnlStudentInfo, "name_1681245966682800");
		pnlStudentInfo.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 308, 378);
		pnlStudentInfo.add(panel);
		panel.setLayout(null);
		
		lblStudentName = new JLabel("Student Name:");
		lblStudentName.setFont(new Font("Arial", Font.PLAIN, 11));
		lblStudentName.setBounds(10, 38, 288, 30);
		panel.add(lblStudentName);
		
		lblStudentId = new JLabel("Student ID:");
		lblStudentId.setFont(new Font("Arial", Font.PLAIN, 11));
		lblStudentId.setBounds(10, 106, 288, 30);
		panel.add(lblStudentId);
		
		lblDateOfBirth_1 = new JLabel("Date of Birth:");
		lblDateOfBirth_1.setFont(new Font("Arial", Font.PLAIN, 11));
		lblDateOfBirth_1.setBounds(10, 174, 288, 30);
		panel.add(lblDateOfBirth_1);
		
		lblAddress_1 = new JLabel("Address:");
		lblAddress_1.setFont(new Font("Arial", Font.PLAIN, 11));
		lblAddress_1.setBounds(10, 242, 288, 30);
		panel.add(lblAddress_1);
		
		lblMajor_1 = new JLabel("Major: ");
		lblMajor_1.setFont(new Font("Arial", Font.PLAIN, 11));
		lblMajor_1.setBounds(10, 310, 288, 30);
		panel.add(lblMajor_1);
		
		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetAsActivePanel(pnlStudentDatabase);
			}
		});
		btnNewButton_1.setBounds(10, 400, 94, 29);
		pnlStudentInfo.add(btnNewButton_1);
		
		panel_1 = new JPanel();
		panel_1.setBounds(331, 11, 332, 300);
		pnlStudentInfo.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		tblSchedule = new JTable();
		panel_1.add(tblSchedule);
		tblSchedule.setModel(new DefaultTableModel(
			new Object[][] {
				{"Name", "Course Number", "Grade"},
			},
			new String[] {
				"Name", "Number", "Grade"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblSchedule.getColumnModel().getColumn(0).setResizable(false);
		tblSchedule.getColumnModel().getColumn(1).setResizable(false);
		tblSchedule.getColumnModel().getColumn(2).setResizable(false);
		
		TableModel tableModel = (TableModel) tblSchedule.getModel();
		tableModel.addTableModelListener(new TableModelListener(){
			public void tableChanged(TableModelEvent e) {
				for(int i=0; i<selectedStudent.courses.size(); i++) {
					for(int r=0; r<tableModel.getRowCount(); r++) {
						if (selectedStudent.courses.get(i).courseNumber.trim() == tableModel.getValueAt(r, 1).toString().trim()) {
							if (IsNumber(tableModel.getValueAt(r, 2).toString().trim())){
								selectedStudent.courses.get(i).courseGrade = (String) tableModel.getValueAt(r, 2);
								break;
							}
						}
					}
				}
				lblAverage.setText("Average: " + selectedStudent.calculateAverage());
				lblGPA.setText("GPA: " + selectedStudent.calculateGPA());
				//SaveStudents();
			}
		});
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(331, 324, 332, 105);
		pnlStudentInfo.add(panel_2);
		panel_2.setLayout(null);
		
		lblAverage = new JLabel("Average:");
		lblAverage.setFont(new Font("Arial", Font.PLAIN, 11));
		lblAverage.setBounds(10, 11, 312, 39);
		panel_2.add(lblAverage);
		
		lblGPA = new JLabel("GPA:");
		lblGPA.setFont(new Font("Arial", Font.PLAIN, 11));
		lblGPA.setBounds(10, 55, 312, 39);
		panel_2.add(lblGPA);
		
		
		requiredFields = new JTextField[] {txtStudentName, txtStudentID, txtAddress, txtBirth, txtPhoneNumber, txtMajor};
		panels = new JPanel[] {pnlAddStudent, pnlCreateCourses, pnlStudentDatabase, pnlStudentInfo};
		SetAsActivePanel(pnlStudentDatabase);
		RefreshStudentTable();
		RefreshCourseTable();
	}
	
	private void RemoveSelectedRow(JTable tbl) {
		int selectedRow = tbl.getSelectedRow();
		DefaultTableModel tableModel = (DefaultTableModel) tbl.getModel();
        if (selectedRow != 0) {
        	tableModel.removeRow(selectedRow);
        }
	}
	
	private void AddClassToCart() {
		int selectedRow = tblCourses.getSelectedRow();
		DefaultTableModel tableModel = (DefaultTableModel) tblCourses.getModel();
		DefaultTableModel cartModel = (DefaultTableModel) tblCart.getModel();
		if (selectedRow != 0) {
        	cartModel.addRow(new String[] {(String) tableModel.getValueAt(selectedRow, 0), (String) tableModel.getValueAt(selectedRow, 1), (String) tableModel.getValueAt(selectedRow, 2), (String) tableModel.getValueAt(selectedRow, 3)});
        }
	}
	
	private void SetAsActivePanel(JPanel pnl) {
		for(int i=0; i<panels.length; i++) {
			if (panels[i] == pnl) {
				panels[i].setVisible(true);
			}else {
				panels[i].setVisible(false);
			}
		}
	}
	
	// Change color of the textbox based on whether it is valid or not
	private void Validate(JTextField textBox, boolean valid) {
		if (valid) {
			textBox.setBackground(new Color(150, 255, 150));
		}else {
			textBox.setBackground(new Color(255, 200, 200));
		}
	}
	
	// Check if a string is numbers only
	private boolean IsNumber(String str) {
	    if (str == null) {
	        return false;
	    }
	    try {
	        int i = Integer.parseInt(str);
	    } catch (Exception e) {
	        return false;
	    }
	    return true;
	}
	
	// check the length of the text in the textbox
	private boolean CheckLength(JTextField textBox) {
		if (textBox.getText().trim().length() > 0) {
			Validate(textBox, true);
			return true;
		}else {
			Validate(textBox, false);
			return false;
		}
	}
	
	private boolean DisplayStudentInfo() {
		int selectedRow = tblStudents.getSelectedRow();
		DefaultTableModel scheduleModel = (DefaultTableModel) tblSchedule.getModel();
		DefaultTableModel tableModel = (DefaultTableModel) tblStudents.getModel();
		if (selectedRow > 0) {
			for(int i=0; i<students.size(); i++) {
				if (tableModel.getValueAt(selectedRow, 1).toString().trim() == students.get(i).studentNumber.trim()) {
					selectedStudent = students.get(i);
					lblStudentName.setText("Student Name: " + selectedStudent.studentName);
					lblStudentId.setText("Student ID: " + selectedStudent.studentNumber);
					lblDateOfBirth_1.setText("Date of Birth: " + selectedStudent.dob);
					lblAddress_1.setText("Address: " + selectedStudent.address);
					lblMajor_1.setText("Major: " + selectedStudent.major);
					
					scheduleModel.setRowCount(1);
					for (int c=0; c<selectedStudent.courses.size(); c++) {
						scheduleModel.addRow(new String[] {selectedStudent.courses.get(c).courseName, selectedStudent.courses.get(c).courseNumber, selectedStudent.courses.get(c).courseGrade});
					}
					
					lblAverage.setText("Average: " + selectedStudent.calculateAverage());
					lblGPA.setText("GPA: " + selectedStudent.calculateGPA());
					return true;
				}
			}
		}
		return false;
	}
	
	private void AddCourse() {
		boolean[] valid = {false, false, false, false};
		if(CheckLength(txtCourseName)) {
			valid[0] = true;
		}
		
		if(CheckLength(txtCourseNumber)) {
			valid[1] = true;
		}
		
		
		if(CheckLength(txtLocation)) {
			valid[2] = true;
		}
		
		if (txtTime.getText().trim().length() > 0) {
			if(IsNumber(txtTime.getText())){
				if(Integer.parseInt(txtTime.getText()) <= 24) {
					Validate(txtTime, true);
					valid[3] = true;
				}else {
					Validate(txtTime, false);
				}
			}else {
				Validate(txtTime, false);
			}
		}else {
			Validate(txtTime, false);
		}
			
		if (valid[0] && valid[1] && valid[2] && valid[3]) {
			if (!CheckIfEntryExists(txtCourseNumber.getText(), tblCourses)) {
				CreateNewCourse();
			}
			
		}
	}
	
	// if the entry is already in the table then return true else return false
	private boolean CheckIfEntryExists(String ID, JTable table) {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		if (tableModel != null) {
			boolean exists = false;
			for (int i=1; i < tableModel.getRowCount(); i++) {
				if (ID.trim().equals(tableModel.getValueAt(i, 1))) {
					exists = true;
					break;
				}
			}
			if (exists) {
				return true;
			}
		}
		return false;
	}
	
	private void SearchCourse(String name) {
		DefaultTableModel courseTableModel = (DefaultTableModel) tblCourses.getModel();
		courseTableModel.setRowCount(1);
		
		for (int i=0; i<courses.size(); i++) {
			if (courses.get(i).courseName.toLowerCase().trim().contains(name.trim())) {
				courseTableModel.addRow(new String[] {courses.get(i).courseName, courses.get(i).courseNumber, courses.get(i).courseLocation, courses.get(i).courseTime});
			}		
		}
	}
	
	private void SearchStudent(String name) {
		DefaultTableModel stuTableModel = (DefaultTableModel) tblStudents.getModel();
		stuTableModel.setRowCount(1);
		
		for (int i=0; i<students.size(); i++) {
			if (students.get(i).studentName.toLowerCase().trim().contains(name.trim())) {
				stuTableModel.addRow(new String[] {students.get(i).studentName, students.get(i).studentNumber, students.get(i).major});
			}		
		}
	}
	
	// clears the table and recreates the row to refresh the table
	private void RefreshStudentTable() {
		File tmpDir = new File(studentPath);
		boolean exists = tmpDir.exists();

		try {
			// if the file exists then read the file and fill the students table else create a new file
			if (exists) {
				ObjectInputStream oi = new ObjectInputStream(new FileInputStream(new File(studentPath)));
				
				DefaultTableModel studentTableModel = (DefaultTableModel) tblStudents.getModel();
				studentTableModel.setRowCount(1);
				students.clear();
				
				try {
					for (;;)
				    {
						Student student = (Student) oi.readObject();
						studentTableModel.addRow(new String[]{student.studentName.trim(), student.studentNumber.trim(), student.major.trim()});
						students.add(student);
				    }
				}catch (EOFException exc){
			        // end of stream
			    }
				
				oi.close();
			}else {
				ObjectOutputStream os1 = new ObjectOutputStream(new FileOutputStream(studentPath));
		        os1.close();
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	// clears the table and recreates the row to refresh the table
	private void RefreshCourseTable() {
		File tmpDir = new File(coursesPath);
		boolean exists = tmpDir.exists();
			try {
			// if the file exists then read the file and fill the students table else create a new file
			if (exists) {
				ObjectInputStream oi = new ObjectInputStream(new FileInputStream(new File(coursesPath)));
				
				DefaultTableModel courseTableModel = (DefaultTableModel) tblCourses.getModel();
				courseTableModel.setRowCount(1);
				courses.clear();
				
				try {
					for (;;)
				    {
						Course course = (Course) oi.readObject();
						courseTableModel.addRow(new String[]{course.courseName, course.courseNumber, course.courseLocation, course.courseTime});
						courses.add(course);
				    }
				}catch (EOFException exc){
			        // end of stream
			    }
				
				oi.close();
			}else {
				ObjectOutputStream os1 = new ObjectOutputStream(new FileOutputStream(coursesPath));
		        os1.close();
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	private void CreateNewCourse() {
		try {
			Course newCourse = new Course(txtCourseName.getText(), txtCourseNumber.getText(), txtLocation.getText(), txtTime.getText());
			        
			ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(coursesPath, true)) {
				protected void writeStreamHeader() throws IOException {
					 reset();
				}
			};
			
			o.writeObject(newCourse);
			RefreshCourseTable();
			
			o.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void SaveStudents() {
		try { 
			ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(studentPath)) {
				protected void writeStreamHeader() throws IOException {
					 reset();
				}
			};
			

			for(int i=0; i<students.size(); i++) {
				o.writeObject(students.get(i));
			}
			
			RefreshStudentTable();
			
			o.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private boolean CreateNewStudent() {
		ArrayList<String> problematicFields =  new ArrayList<String>();
		for (int i = 0; i < requiredFields.length; i++) {
			if (requiredFields[i].getText().trim().length() <= 0) {
				problematicFields.add(requiredFields[i].getToolTipText());
				Validate(requiredFields[i], false);
			}else {
				Validate(requiredFields[i], true);
			}
		}
		if (problematicFields.size() > 0) {
			for (int i = 0; i < problematicFields.size(); i++) {
				System.out.println(problematicFields.get(i) + " is missing");
			}
			return false;
		}
		try {
			Student newStudent = new Student(txtStudentName.getText(), txtStudentID.getText(), txtAddress.getText(), txtBirth.getText(), txtPhoneNumber.getText(), txtMajor.getText());
			if (tblCart.getRowCount() > 0) {
				DefaultTableModel cartModel = (DefaultTableModel) tblCart.getModel();
				for (int i=1; i<tblCart.getRowCount(); i++) {
					newStudent.addCourse((String) cartModel.getValueAt(i,0), (String) cartModel.getValueAt(i,1), "0", (String) cartModel.getValueAt(i,2), (String) cartModel.getValueAt(i,3));
				}
			}
			        
			ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(studentPath, true)) {
				protected void writeStreamHeader() throws IOException {
					 reset();
				}
			};
			
			if (!CheckIfEntryExists(txtStudentID.getText(), tblStudents)) {
				o.writeObject(newStudent);
				RefreshStudentTable();
			}
			
			o.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
}
