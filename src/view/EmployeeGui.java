package view;

import utils.Connector;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Objects;
import java.sql.ResultSet;

import javax.swing.*;

public class EmployeeGui extends JFrame implements ActionListener {
	
	 private JFrame frame;
	 private JLabel labelHeading;
	 private JLabel labelSSn;
	 private JLabel labelDOB;
	 private JLabel labelName;
	 private JLabel labelAddress;
	 private JLabel labelSalary;
	 private JLabel labelGender;
	 private JButton buttonPrevious;
	 private JButton buttonNext;
	 private JButton buttonDelete;
	 private JButton buttonAdd;
	 private JButton buttonUpdate;
	 private JButton buttonClear;
	 private JTextField txtSSn;
	 private JTextField txtDOB;
	 private JTextField txtName;
	 private JTextField txtAddress;
	 private JTextField txtSalary;
	 private JTextField txtGender;

	 private Connector conn = new Connector();


     private ResultSet rs;
	

	/*
	 * Construction of GUI
	 */
	public EmployeeGui() throws SQLException {
		frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(555,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // Text Field
        txtSSn = new JTextField();
        txtSSn.setBounds(95, 55, 315, 30);
        frame.getContentPane().add(txtSSn);

        labelSSn = new JLabel("SSn");
        labelSSn.setBounds(35, 60, 45, 20);
        frame.getContentPane().add(labelSSn);

        txtDOB = new JTextField();
        txtDOB.setBounds(95, 90, 315, 30);
        frame.getContentPane().add(txtDOB);

        labelDOB = new JLabel("DOB");
        labelDOB.setBounds(35, 98, 45, 20);
        frame.getContentPane().add(labelDOB);

        txtName = new JTextField();
        txtName.setBounds(95, 130, 315, 30);
        frame.getContentPane().add(txtName);

        labelName = new JLabel("Name");
        labelName.setBounds(35, 135, 45, 20);
        frame.getContentPane().add(labelName);

        txtAddress = new JTextField();
        txtAddress.setBounds(95, 165, 315, 30);
        frame.getContentPane().add(txtAddress);

        labelAddress = new JLabel("Address");
        labelAddress.setBounds(35, 170, 55, 20);
        frame.getContentPane().add(labelAddress);

        txtSalary = new JTextField();
        txtSalary.setBounds(95, 201, 315, 30);
        frame.getContentPane().add(txtSalary);

        labelSalary = new JLabel("Salary");
        labelSalary.setBounds(35, 200, 45, 20);
        frame.getContentPane().add(labelSalary);

        txtGender = new JTextField();
        txtGender.setBounds(95, 237, 315, 30);
        frame.getContentPane().add(txtGender);

        labelGender = new JLabel("Gender");
        labelGender.setBounds(35, 242, 46, 20);
        frame.getContentPane().add(labelGender);

        labelHeading = new JLabel("Employee Details");
        labelHeading.setBounds(200, 24, 315,30);
        frame.getContentPane().add(labelHeading);
        
        buttonAdd = new JButton();
        buttonAdd.setBounds(95, 275, 60, 25);
        buttonAdd.setText("Add");
        frame.getContentPane().add(buttonAdd);

        buttonDelete = new JButton();
        buttonDelete.setBounds(159, 275, 80, 25);
        buttonDelete.setText("Delete");
        frame.getContentPane().add(buttonDelete);

        buttonClear = new JButton("Clear");
        buttonClear.setBounds(420, 275, 80, 25);
        frame.getContentPane().add(buttonClear);

        buttonUpdate = new JButton();
        buttonUpdate.setBounds(240, 275, 80, 25);
        buttonUpdate.setText("Update");
        frame.getContentPane().add(buttonUpdate);

        buttonPrevious = new JButton();
        buttonPrevious.setBounds(420, 55, 80, 25);
        buttonPrevious.setText("Previous");
        frame.getContentPane().add(buttonPrevious);

        buttonNext = new JButton();
        buttonNext.setBounds(420, 90, 80, 25);
        buttonNext.setText("Next");
        frame.getContentPane().add(buttonNext);

        buttonAdd.addActionListener(this);
        buttonClear.addActionListener(this);
        buttonDelete.addActionListener(this);
        buttonUpdate.addActionListener(this);
        buttonPrevious.addActionListener(this);
        buttonNext.addActionListener(this);

	        	
	        	//gets the sql records and populates the fields
	        	getSQL();
	    }
	
	
	 /*
	  * Handles action performed when a specific button is pressed 
	  * for more
	  * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	  */
	
	
	public void actionPerformed(ActionEvent e) {
    
		if (e.getSource() == buttonPrevious)
	{
		System.out.println("You pressed PREVIOUS");
			try {	
						rs.previous();
		            setText  (rs.getString("id"),
		                    rs.getString("dob"),
		                    rs.getString("name"),
		                    rs.getString("address"),
		                    rs.getInt("salary"),
		                    rs.getString("gender"));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
			
    	if (e.getSource() == buttonNext)
	{
		System.out.println("You pressed NEXT");
           // Insert resultSet.next() code here
			try {
				rs.next();
				setText(rs.getString("id"),
		                rs.getString("dob"),
		                rs.getString("name"),
		                rs.getString("address"),
		                rs.getInt("salary"),
		                rs.getString("gender"));
			   	
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
	}
    	if (e.getSource() == buttonDelete)
	{
		System.out.println("You pressed Delete");
           try {
        	rs.deleteRow();
        	getSQL();
           }catch(SQLException e1) {
        	   // TODO Auto-generated catch block
        	   e1.printStackTrace();         
        	   }
	}
    
    	//Retrieves whether the cursor is before the first row inthis ResultSet object. 
    	if(e.getSource() == buttonClear) 
    	{
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
    	
    	if(e.getSource() == buttonUpdate)
    	{
    		System.out.println("You pressed Update");
    		try {
    			Objects.equals(txtSSn.getText().toLowerCase(), rs.getString("id").toLowerCase());
    			rs.updateString("id", txtSSn.getText());
    			rs.updateString("dob", txtDOB.getText());
    			rs.updateString("name", txtName.getText());
    			rs.updateString("address", txtAddress.getText());
    			rs.updateInt("salary", Integer.parseInt(txtSalary.getText()));
    			rs.updateString("gender", txtGender.getText());
    			rs.updateRow();

    		}catch(SQLException e1) {
    			e1.printStackTrace();
    		}
    	}
    	
    	if(e.getSource() == buttonAdd)
    	{
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
