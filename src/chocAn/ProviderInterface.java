package chocAn;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class ProviderInterface {
	private BillingVerify billing;
	private RequestProviderDirectory request;
	private ProviderDirectory directory;
	
	public ProviderInterface() {
		billing = new BillingVerify();
		request = new RequestProviderDirectory();
		directory = new ProviderDirectory();
	}
	
	public void prompt() {
		JFrame frame = new JFrame("Provider Interface");
		ImageIcon icon = new ImageIcon("duck.jpg");
		Object[] possibilities = {"Verify Member Card", "Bill ChocAn", "Request Provider Directory"};
		String s = (String)JOptionPane.showInputDialog(frame, "Select an option below.", "Customized Dialog", JOptionPane.PLAIN_MESSAGE, icon, possibilities, "Verify Member Card");
	}
}
