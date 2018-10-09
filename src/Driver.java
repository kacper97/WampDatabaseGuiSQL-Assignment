import view.EmployeeGui;
import utils.Connector;

import java.sql.SQLException;
import javax.swing.JFrame;



public class Driver{
/**
	 * Connect to the DB and do some stuff
 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		Connector jdbc = new Connector();
        try {
            jdbc.getConnection();
            System.out.println("Connected to database");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        jdbc.run();
	    EmployeeGui app = new EmployeeGui();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.pack();
        app.setVisible(true);
	}
}