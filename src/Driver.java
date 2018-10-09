import view.EmployeeGui;

import java.sql.SQLException;

import javax.swing.JFrame;

public class Driver{
/**
	 * Connect to the DB and do some stuff
 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
	    EmployeeGui app = new EmployeeGui();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.pack();
        app.setVisible(true);
	}
}