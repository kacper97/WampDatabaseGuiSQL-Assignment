package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utils.Connector;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.awt.event.ActionEvent;

public class Gui extends JFrame {

	private JPanel contentPane;
	private JTextField SSn;
	private JTextField DOB;
	private JTextField Name;
	private JTextField Address;
	private JTextField Salary;
	private JTextField Gender;

	private Connector conn = new Connector();


    private ResultSet rs;
	

	
	
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Gui() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSsn = new JLabel("SSn");
		lblSsn.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblSsn.setBounds(38, 78, 56, 16);
		contentPane.add(lblSsn);
		
		JLabel lblDob = new JLabel("DOB");
		lblDob.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblDob.setBounds(38, 106, 56, 16);
		contentPane.add(lblDob);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblName.setBounds(38, 150, 56, 16);
		contentPane.add(lblName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblAddress.setBounds(38, 179, 56, 16);
		contentPane.add(lblAddress);
		
		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblSalary.setBounds(38, 225, 56, 16);
		contentPane.add(lblSalary);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblGender.setBounds(38, 255, 56, 16);
		contentPane.add(lblGender);
		
		JLabel lblEmployeeDetails = new JLabel("EMPLOYEE DETAILS");
		lblEmployeeDetails.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblEmployeeDetails.setBounds(184, 33, 215, 16);
		contentPane.add(lblEmployeeDetails);
		
		SSn = new JTextField();
		SSn.setBounds(106, 75, 155, 22);
		contentPane.add(SSn);
		SSn.setColumns(10);
		
		DOB = new JTextField();
		DOB.setBounds(106, 103, 155, 22);
		contentPane.add(DOB);
		DOB.setColumns(10);
		
		Name = new JTextField();
		Name.setColumns(10);
		Name.setBounds(106, 147, 286, 22);
		contentPane.add(Name);
		
		Address = new JTextField();
		Address.setBounds(106, 176, 286, 22);
		contentPane.add(Address);
		Address.setColumns(10);
		
		Salary = new JTextField();
		Salary.setBounds(106, 222, 116, 22);
		contentPane.add(Salary);
		Salary.setColumns(10);
		
		Gender = new JTextField();
		Gender.setBounds(106, 252, 116, 22);
		contentPane.add(Gender);
		Gender.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(75, 305, 97, 25);
		contentPane.add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(184, 305, 97, 25);
		contentPane.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(293, 305, 97, 25);
		contentPane.add(btnUpdate);
		
		JButton btnPrevious = new JButton("Previous");
		btnPrevious.setBounds(451, 74, 97, 25);
		contentPane.add(btnPrevious);
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(451, 125, 97, 25);
		contentPane.add(btnNext);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(451, 265, 97, 25);
		contentPane.add(btnClear);
		
		getSQL();
	
    	//when add is pressed
    	// result sets moves into a new row not to overwrite data
    	// updates strings from values inserted and puts them in new row
    	// difference between update and add is the moving into new row
	btnAdd.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.out.println("You pressed Add");
    		try {
    			rs.moveToInsertRow();
    			rs.updateString("id", SSn.getText());
    			rs.updateString("dob", DOB.getText());
    			rs.updateString("name", Name.getText());
    			rs.updateString("address", Address.getText());
    			rs.updateInt("salary", Integer.parseInt(Salary.getText()));
    			rs.updateString("gender", Gender.getText());
    			rs.insertRow();
    		}catch(SQLException e1) {
    			e1.printStackTrace();
    		}
		}
	});
	
	btnDelete.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.out.println("You pressed Delete");
	           try {
	        	rs.deleteRow();
	        	getSQL();
	           }catch(SQLException e1) {
	        	   e1.printStackTrace();         
	        	   }
		}
	});
	
	btnUpdate.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
    		System.out.println("You pressed Update");
    		try {
    			Objects.equals(SSn.getText().toLowerCase(), rs.getString("id").toLowerCase());
    			rs.updateString("id", SSn.getText());
    			rs.updateString("dob", DOB.getText());
    			rs.updateString("name", Name.getText());
    			rs.updateString("address",Address.getText());
    			rs.updateInt("salary", Integer.parseInt(Salary.getText()));
    			rs.updateString("gender",Gender.getText());
    			rs.updateRow();

    		}catch(SQLException e1) {
    			e1.printStackTrace();
    		}
		}
	});
	
	btnPrevious.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.out.println("You pressed PREVIOUS");
			try {	
						rs.previous();
		            setText (rs.getString("id"),
		                    rs.getString("dob"),
		                    rs.getString("name"),
		                    rs.getString("address"),
		                    rs.getInt("salary"),
		                    rs.getString("gender"));
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	});
	
	btnNext.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.out.println("You pressed NEXT");
			try {
				rs.next();
				setText(rs.getString("id"),
		                rs.getString("dob"),
		                rs.getString("name"),
		                rs.getString("address"),
		                rs.getInt("salary"),
		                rs.getString("gender"));
			   	
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	});
	
	btnClear.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
    		System.out.println("You pressed Clear");
    		try {
    			rs.isBeforeFirst();
    			SSn.setText("");
    			DOB.setText("");
    			Name.setText("");
    			Address.setText("");
    			Salary.setText("");
    			Gender.setText("");
    		}catch(SQLException e1){
    			e1.printStackTrace();
    		}
		}
	});
	
	}
	
    /*
    Sets text fields
         */
    private void setText(String id, String dob, String name, String address, int salary, String gender){
        SSn.setText(id);
        DOB.setText(dob);
        Name.setText(name);
        Address.setText(address);
        Salary.setText(String.valueOf(salary));
        Gender.setText(gender);
    }
	
    // gets the result set
	private void getSQL() throws SQLException{
		rs = conn.run();
		if(rs.next()) {
			setText(rs.getString("id"),
					rs.getString("dob"),
					rs.getString("name"),
					rs.getString("address"),
					rs.getInt("salary"),
					rs.getString("gender"));
		}
	}
	
	
}
