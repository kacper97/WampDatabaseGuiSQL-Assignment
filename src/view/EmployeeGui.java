package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EmployeeGui extends JFrame implements ActionListener{

	 private JLabel labelHeading, labelSSn, labelDOB, labelName, labelAddress, labelSalary, labelGender;
	 private JButton buttonPrevious, buttonNext, buttonDelete, buttonAdd, buttonUpdate, buttonClear;
	 private JTextField txtSSn, txtDOB, txtName, txtAddress, txtSalary, txtGender;

	
	JFrame frame = new JFrame();


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * Construction of GUI
	 */
	public EmployeeGui() {
	frame.setVisible(true);
	frame.setBounds(100, 100, 500, 368);
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
        txtSSn.setBounds(93, 55, 315, 27);
        frame.getContentPane().add(txtSSn);

        //Label SSN
        labelSSn.setBounds(35, 60, 46, 20);
        frame.getContentPane().add(labelSSn);

        //Text Field DOB
        txtDOB.setBounds(93, 93, 315, 27);
        frame.getContentPane().add(txtDOB);

        //Label DOB
        labelDOB.setBounds(35, 98, 46, 20);
        frame.getContentPane().add(labelDOB);

        //Text Field Name
        txtName.setBounds(93, 130, 315, 27);
        frame.getContentPane().add(txtName);

        //Label Name
        labelName.setBounds(35, 135, 46, 20);
        frame.getContentPane().add(labelName);

        //Text Field Address
        txtAddress.setBounds(93, 165, 315, 27);
        frame.getContentPane().add(txtAddress);

        //Label Address
        labelAddress.setBounds(35, 170, 55, 20);
        frame.getContentPane().add(labelAddress);

       	//Text Field Salary
        txtSalary.setBounds(93, 201, 315, 27);
        frame.getContentPane().add(txtSalary);

        //Label Salary
        labelSalary.setBounds(35, 206, 46, 20);
        frame.getContentPane().add(labelSalary);

        //Text Field Gender
        txtGender.setBounds(93, 237, 315, 27);
        frame.getContentPane().add(txtGender);
        
        //Label Gender
     	labelGender.setBounds(35, 242, 46, 20);
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
	    }
}
