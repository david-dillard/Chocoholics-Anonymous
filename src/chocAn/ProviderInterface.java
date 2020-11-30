package chocAn;
import javax.swing.*;

/**
 * This class is the interface providers will interact with.
 * @author Joseph Daly
 * @version 1.0
 */

public class ProviderInterface {
	private BillingVerify billing;
	private RequestProviderDirectory request;
	private ProviderDirectory directory;
	
	/**
	 * This is the constructor that assigns values to each of the 3 fields.
	 */
	public ProviderInterface() {
		billing = new BillingVerify();
		request = new RequestProviderDirectory();
		directory = new ProviderDirectory();
	}
	
	/**
	 * This method prompts the provider to perform one of 3 actions through a dialogue box.
	 */
	public void prompt() {
		boolean flag = true;
		while(flag == true) {
			JFrame frame = new JFrame("Provider Interface");
			ImageIcon icon = new ImageIcon("duck.jpg");
			Object[] possibilities = {"Verify Member Card", "Bill ChocAn", "Request Provider Directory"};
			Object[] possibilities2 = {"Card", "Number"};
			String s = (String)JOptionPane.showInputDialog(frame, "Select an option below.", "Provider Interface", JOptionPane.PLAIN_MESSAGE, icon, possibilities, "Verify Member Card");
			if (s == null) {
				flag = false;
			} else if(s.equals("Verify Member Card")) {
				String a = (String)JOptionPane.showInputDialog(frame, "Member Card or Member Number?", "Member Validation", JOptionPane.PLAIN_MESSAGE, icon, possibilities2, "Card");
				if (a == null) {
					
				} else if(a.equals("Card")) {
					String n = (String)JOptionPane.showInputDialog(frame, "Enter member number from member card.", "Member Card", JOptionPane.PLAIN_MESSAGE, icon, null, "");
					boolean valid = billing.verifyMemberCard(n);
					if(valid == true) {
						JOptionPane.showMessageDialog(frame, "VALIDATED");
					} else {
						JOptionPane.showMessageDialog(frame, "NOT VALIDATED");
					}
				} else if(a.equals("Number")) {
					String n = (String)JOptionPane.showInputDialog(frame, "Enter member number provided.", "Member Number", JOptionPane.PLAIN_MESSAGE, icon, null, "");
					boolean valid = billing.verifyMemberNumber(n);
					if(valid == true) {
						JOptionPane.showMessageDialog(frame, "VALIDATED");
					} else {
						JOptionPane.showMessageDialog(frame, "NOT VALIDATED");
					}
				}
			} else if(s.equals("Bill ChocAn")) {
				String a = (String)JOptionPane.showInputDialog(frame, "Member Card or Member Number?", "Member Validation", JOptionPane.PLAIN_MESSAGE, icon, possibilities2, "Card");
				boolean valid = false;
				if (a == null) {
					
				} else if(a.equals("Card")) {
					String n = (String)JOptionPane.showInputDialog(frame, "Enter member number from member card.", "Member Card", JOptionPane.PLAIN_MESSAGE, icon, null, "");
					valid = billing.verifyMemberCard(n);
					if(valid == true) {
						JOptionPane.showMessageDialog(frame, "VALIDATED");
					} else {
						JOptionPane.showMessageDialog(frame, "NOT VALIDATED");
					}
				} else if(a.equals("Number")) {
					String n = (String)JOptionPane.showInputDialog(frame, "Enter member number provided.", "Member Number", JOptionPane.PLAIN_MESSAGE, icon, null, "");
					valid = billing.verifyMemberNumber(n);
					if(valid == true) {
						JOptionPane.showMessageDialog(frame, "VALIDATED");
					} else {
						JOptionPane.showMessageDialog(frame, "NOT VALIDATED");
					}
				}
				if(valid == true) {
					billing.recordInformation();
				}
			} else if(s.equals("Request Provider Directory")){
				directory = request.requestDirectory();
				JOptionPane.showMessageDialog(frame,  "The Provider Directory has been emailed.");
			}
		}
	}
}
