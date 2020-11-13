package chocAn;
import javax.swing.JOptionPane;

/**
 * helper class that contains a method to inform the user that EftData has been printed for the sake of this project
 * @author David Dillard
 */
public class EftData extends Report{
	
	/**
	 * displays a dialog box informing the user that EftData has been printed
	 */
	public void printReport() {
		Object[] options = { "YES", "NO" };
		 JOptionPane.showOptionDialog(null, "EftData has been printed.\n" + "Do you understand?", "INFORMATION",
		             JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
		             null, options, options[0]);
	}
}
