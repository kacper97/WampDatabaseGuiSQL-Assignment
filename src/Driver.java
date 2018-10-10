import view.EmployeeGui;
import utils.Connector;

import java.sql.SQLException;
import javax.swing.*;

 	

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
	    EmployeeGui driver = new EmployeeGui();
	    driver.frame.setVisible(true);
	}
}