import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBDemo5 extends JFrame implements ActionListener {
    private JLabel labelHeading, labelSSn, labelDOB, labelName, labelAddress, labelSalary, labelGender;
    private JButton buttonPrevious, buttonNext, buttonDelete, buttonAdd, buttonUpdate, buttonClear;
    private JTextField txtSSn, txtDOB, txtName, txtAddress, txtSalary, txtGender;

    private ResultSet rs = null;

	/** The name of the MySQL account to use (or empty for anonymous) */
	private final String userName = "root";

	/** The password for the MySQL account (or empty for anonymous) */
	private final String password = "";

	/** The name of the computer running MySQL */
	private final String serverName = "localhost";

	/** The port of the MySQL server (default is 3306) */
	private final int portNumber = 3306;

	/** The name of the database we are testing with (this default is installed with MySQL) */
	private final String dbName = "test";
	
	/** The name of the table we are testing with */
	private final String tableName = "jdbc_test";
	
	/**
	 * Get a new database connection
	 * 
	 * @return
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("user", this.userName);
		connectionProps.put("password", this.password);

		conn = DriverManager.getConnection("jdbc:mysql://"
				+ this.serverName + ":" + this.portNumber + "/" + this.dbName,
				connectionProps);

		return conn;
	}

	/**
	 * Run a SQL command which does not return a recordset:
	 * CREATE/INSERT/UPDATE/DELETE/DROP/etc.
	 * 
	 * @throws SQLException If something goes wrong
	 */
	public boolean executeUpdate(Connection conn, String command) throws SQLException {
	    Statement stmt = null;
	    try {
	        stmt = conn.createStatement();
	        stmt.executeUpdate(command); // This will throw a SQLException if it fails
	        return true;
	    } finally {

	    	// This will run whether we throw an exception or not
	        if (stmt != null) { stmt.close(); }
	    }
	}
	
	/**
	 * Connect to MySQL and do some stuff.
	 */
	public void run() {
		// Connect to MySQL
		Connection conn = null;
		try {
			conn = this.getConnection();
			System.out.println("Connected to database");
		} catch (SQLException e) {
			System.out.println("ERROR: Could not connect to the database");
			e.printStackTrace();
			return;
		}

		// Create ResultSet 
		try {
			Statement s = conn.createStatement ();
			s.executeQuery ("SELECT * FROM jdbc_test");
			rs = s.getResultSet ();
			System.out.println("Created a result set");
			rs.next();
			System.out.println(rs.getString("id"));

	    } catch (SQLException e) {
			System.out.println("ERROR: Could not access the table");
			e.printStackTrace();
			return;
		}
	}
	
	// what happens after you click the buttons
    public void actionPerformed(ActionEvent e) {
    	if (e.getSource() == buttonPrevious)
	{
		System.out.println("You pressed PREVIOUS");
           // Insert resultSet.previous() code here
			try {
				rs.previous();
				// Update Text fields
			   	txtSSn.setText(rs.getString("id"));
			   	txtDOB.setText(rs.getString("DOB"));
			   	txtName.setText(rs.getString("Name"));
			   	txtAddress.setText(rs.getString("Address"));
			   	txtSalary.setText(rs.getString("Salary"));
			   	txtGender.setText(rs.getString("Gender"));
			   	
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
				// Update Text fields
				txtSSn.setText(rs.getString("id"));
				txtDOB.setText(rs.getString("DOB"));
				txtName.setText(rs.getString("Name"));
			   	txtAddress.setText(rs.getString("Address"));
			   	txtSalary.setText(rs.getString("Salary"));
			   	txtGender.setText(rs.getString("Gender"));
			   	
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}
    	if (e.getSource() == buttonDelete)
	{
		System.out.println("You pressed Delete");
           // Insert delete current record code here
	}
    
    	if(e.getSource() == buttonClear) 
    	{
    		System.out.println("You pressed Clear");
    		//Insert clear current record code here
    	}
    	
    	if(e.getSource() == buttonUpdate)
    	{
    		System.out.println("You pressed Update");
    		//Insert update current record code here
    	}
    	
    	if(e.getSource() == buttonAdd)
    	{
    		System.out.println("You pressed Add");
    		//Insert add current record code here
    	}
    	
    }
    
    
	 public void setUpGUI() {	
		 //Starting Frame
		JFrame frame = new JFrame();
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