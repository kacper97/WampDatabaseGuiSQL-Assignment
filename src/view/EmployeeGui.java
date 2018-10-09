package view;

import utils.Connector;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Objects;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EmployeeGui extends JFrame implements ActionListener{

	 private JLabel labelHeading, labelSSn, labelDOB, labelName, labelAddress, labelSalary, labelGender;
	 private JButton buttonPrevious, buttonNext, buttonDelete, buttonAdd, buttonUpdate, buttonClear;
	 private JTextField txtSSn, txtDOB, txtName, txtAddress, txtSalary, txtGender;

	 private Connector conn = new Connector();
	
	 JFrame frame = new JFrame();

	private ResultSet rs;
	
	
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
		            rsText  (rs.getString("id"),
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
				rsText(rs.getString("id"),
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
	 * Construction of GUI
	 */
	public EmployeeGui() throws SQLException {
	frame = new JFrame();
	frame.setVisible(true);
	frame.setBounds(400,400, 700, 400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    
	 // Labels initialization
		  labelSSn = new JLabel("SSn");
		  labelDOB= new JLabel("DOB");
		  labelName = new JLabel("Name");
		  labelAddress = new JLabel("Address");
		  labelSalary = new JLabel("Salary");
		  labelGender = new JLabel("Gender");
		  labelHeading = new JLabel("Employee Details");

		 // Text Fields initialization
		 txtSSn = new JTextField();
		 txtDOB = new JTextField();
		 txtName = new JTextField();
		 txtAddress = new JTextField();
		 txtSalary = new JTextField();
		 txtGender = new JTextField();
		 
		 // Buttons initialization
		 buttonAdd = new JButton("Add");
		 buttonNext = new JButton("Next");
	     buttonPrevious = new JButton("Previous");
	     buttonUpdate = new JButton("Update");
	     buttonClear = new JButton("Clear");
	     buttonDelete= new JButton("Delete");

        /*
         * Bounds 
         * x - the new x-coordinate of this component
		   y - the new y-coordinate of this component
		   width - the new width of this component
		   height - the new height of this component	
         */
        //Add Button
        buttonAdd.setBounds(93, 273, 64, 25);
        buttonAdd.setText("Add");
        frame.getContentPane().add(buttonAdd);

        //Text Field SSN
        txtSSn.setBounds(130, 55, 315, 27);
        frame.getContentPane().add(txtSSn);

        //Label SSN
        labelSSn.setBounds(25, 60, 46, 20);
        frame.getContentPane().add(labelSSn);

        //Text Field DOB
        txtDOB.setBounds(130, 93, 315, 27);
        frame.getContentPane().add(txtDOB);

        //Label DOB
        labelDOB.setBounds(25, 98, 46, 20);
        frame.getContentPane().add(labelDOB);

        //Text Field Name
        txtName.setBounds(130, 130, 315, 27);
        frame.getContentPane().add(txtName);

        //Label Name
        labelName.setBounds(25, 135, 46, 20);
        frame.getContentPane().add(labelName);

        //Text Field Address
        txtAddress.setBounds(130, 165, 315, 27);
        frame.getContentPane().add(txtAddress);

        //Label Address
        labelAddress.setBounds(25, 170, 55, 20);
        frame.getContentPane().add(labelAddress);

       	//Text Field Salary
        txtSalary.setBounds(130, 201, 315, 27);
        frame.getContentPane().add(txtSalary);

        //Label Salary
        labelSalary.setBounds(25, 206, 46, 20);
        frame.getContentPane().add(labelSalary);

        //Text Field Gender
        txtGender.setBounds(130, 237, 315, 27);
        frame.getContentPane().add(txtGender);
        
        //Label Gender
     	labelGender.setBounds(25, 242, 46, 20);
        frame.getContentPane().add(labelGender);

        //Label Heading
        labelHeading.setBounds(198, 24, 315,30);
        frame.getContentPane().add(labelHeading);

        //Button Delete
        buttonDelete.setBounds(144, 273, 80, 25);
        frame.getContentPane().add(buttonDelete);

        //Button Clear
        buttonClear.setBounds(415, 273, 90, 25);
        frame.getContentPane().add(buttonClear);

        //Button Update
        buttonUpdate.setBounds(211, 273, 80, 25);
        frame.getContentPane().add(buttonUpdate);

        //Button Previous
        buttonPrevious.setBounds(415, 55, 90, 25);
        frame.getContentPane().add(buttonPrevious);

        //Button Next
        buttonNext.setBounds(415, 80, 90, 25);
        frame.getContentPane().add(buttonNext);
	        	
		// Add action listeners
	        	buttonPrevious.addActionListener(this);
	        	buttonNext.addActionListener(this);
	        	buttonDelete.addActionListener(this);
	        	buttonAdd.addActionListener(this);
	        	buttonUpdate.addActionListener(this);
	        	buttonClear.addActionListener(this);
	        	
	        	
	        	//gets the sql records and populates the fields
	        	getSQL();
	    }
	
	
    /*
    Sets text fields
         */
    private void rsText(String id, String dob, String name, String address, int salary, String gender){
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
			rsText(rs.getString("id"),
					rs.getString("dob"),
					rs.getString("name"),
					rs.getString("address"),
					rs.getInt("salary"),
					rs.getString("gender"));
		}
	}
}
