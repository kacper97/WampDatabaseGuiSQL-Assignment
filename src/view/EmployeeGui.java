package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import utils.Connector;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.awt.event.ActionEvent;

public class EmployeeGui {

	public JFrame frame;
	private JTextField txtSSn;
	private JTextField txtDOB;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtSalary;
	private JTextField txtGender;
	private Connector conn = new Connector();
	private ResultSet rs;

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public EmployeeGui() throws SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SSn");
		lblNewLabel.setBounds(49, 90, 56, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblDob = new JLabel("DOB");
		lblDob.setBounds(49, 119, 56, 16);
		frame.getContentPane().add(lblDob);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(49, 190, 56, 16);
		frame.getContentPane().add(lblName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(49, 216, 56, 16);
		frame.getContentPane().add(lblAddress);
		
		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setBounds(49, 263, 56, 16);
		frame.getContentPane().add(lblSalary);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(49, 292, 56, 16);
		frame.getContentPane().add(lblGender);
		
		txtSSn = new JTextField();
		txtSSn.setText("SSn");
		txtSSn.setBounds(104, 87, 170, 22);
		frame.getContentPane().add(txtSSn);
		txtSSn.setColumns(10);
		
		txtDOB = new JTextField();
		txtDOB.setText("DOB");
		txtDOB.setBounds(104, 116, 170, 22);
		frame.getContentPane().add(txtDOB);
		txtDOB.setColumns(10);
		
		txtName = new JTextField();
		txtName.setText("Name");
		txtName.setBounds(104, 187, 300, 22);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setText("Address");
		txtAddress.setBounds(104, 213, 300, 22);
		frame.getContentPane().add(txtAddress);
		txtAddress.setColumns(10);
		
		txtSalary = new JTextField();
		txtSalary.setText("Salary");
		txtSalary.setBounds(104, 260, 116, 22);
		frame.getContentPane().add(txtSalary);
		txtSalary.setColumns(10);
		
		txtGender = new JTextField();
		txtGender.setText("Gender");
		txtGender.setBounds(104, 289, 116, 22);
		frame.getContentPane().add(txtGender);
		txtGender.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(49, 341, 97, 25);
		frame.getContentPane().add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(158, 341, 97, 25);
		frame.getContentPane().add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(267, 341, 97, 25);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnPrevious = new JButton("Previous");
		btnPrevious.setBounds(452, 90, 97, 25);
		frame.getContentPane().add(btnPrevious);
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(452, 139, 97, 25);
		frame.getContentPane().add(btnNext);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(452, 288, 97, 25);
		frame.getContentPane().add(btnClear);
		
		JLabel lblEmployeeDetails = new JLabel("EMPLOYEE DETAILS");
		lblEmployeeDetails.setBounds(218, 44, 128, 16);
		frame.getContentPane().add(lblEmployeeDetails);
		
		JLabel lblByKacperWoloszyn = new JLabel("By Kacper Woloszyn");
		lblByKacperWoloszyn.setBounds(452, 387, 130, 16);
		frame.getContentPane().add(lblByKacperWoloszyn);
		
	 	//gets the sql records and populates the fields
    	getSQL();

	
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				System.out.println("You pressed Add");
	    		try {
	    			rs.moveToInsertRow();
	    			rs.updateString("id", txtSSn.getText());
	    			rs.updateString("dob", txtDOB.getText());
	    			rs.updateString("name", txtName.getText());
	    			rs.updateString("address", txtAddress.getText());
	    			rs.updateInt("salary", Integer.parseInt(txtSalary.getText()));
	    			rs.updateString("gender", txtGender.getText());
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
	    			Objects.equals(txtSSn.getText().toLowerCase(), rs.getString("id").toLowerCase());
	    			rs.updateString("id", txtSSn.getText());
	    			rs.updateString("dob", txtDOB.getText());
	    			rs.updateString("name", txtName.getText());
	    			rs.updateString("address",txtAddress.getText());
	    			rs.updateInt("salary", Integer.parseInt(txtSalary.getText()));
	    			rs.updateString("gender",txtGender.getText());
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
	    			txtSSn.setText("");
	    			txtDOB.setText("");
	    			txtName.setText("");
	    			txtAddress.setText("");
	    			txtSalary.setText("");
	    			txtGender.setText("");
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
	        txtSSn.setText(id);
	        txtDOB.setText(dob);
	        txtName.setText(name);
	        txtAddress.setText(address);
	        txtSalary.setText(String.valueOf(salary));
	        txtGender.setText(gender);
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
