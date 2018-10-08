import view.EmployeeGui;
import javax.swing.JFrame;

public class Driver{
/**
	 * Connect to the DB and do some stuff
	 */
	public static void main(String[] args) {
	    EmployeeGui app = new EmployeeGui();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.pack();
        app.setVisible(true);
	}
}