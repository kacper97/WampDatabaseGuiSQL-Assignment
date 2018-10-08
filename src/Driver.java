import javax.swing.JFrame;

public class Driver{
/**
	 * Connect to the DB and do some stuff
	 */
	public static void main(String[] args) {
		DBDemo5 app = new DBDemo5();
		app.run();
		app.setUpGUI();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //  app.setPreferredSize(new Dimension(400,300));
        app.pack();
        app.setVisible(true);
	}
}