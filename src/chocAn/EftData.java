package chocAn;
import javax.swing.JOptionPane;

public class EftData extends Report{
	public void printReport() {
		Object[] options = { "YES", "NO" };
		 JOptionPane.showOptionDialog(null, "EftData has been printed.\n" + "Do you understand?", "INFORMATION",
		             JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
		             null, options, options[0]);
	}
}
