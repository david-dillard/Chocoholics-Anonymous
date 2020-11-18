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
		boolean flag = true;
		while(flag = true) {
			JFrame frame = new JFrame("Provider Interface");
			ImageIcon icon = new ImageIcon("duck.jpg");
			Object[] possibilities = {"Verify Member Card", "Bill ChocAn", "Request Provider Directory"};
			Object[] possibilities2 = {"Card", "Number"};
			String s = (String)JOptionPane.showInputDialog(frame, "Select an option below.", "Provider Interface", JOptionPane.PLAIN_MESSAGE, icon, possibilities, "Verify Member Card");
			if(s == "Verify Member Card") {
				String a = (String)JOptionPane.showInputDialog(frame, "Member Card or Member Number?", "Member Validation", JOptionPane.PLAIN_MESSAGE, icon, possibilities2, "Card");
				if(a == "Card") {
					String n = (String)JOptionPane.showInputDialog(frame, "Enter member number from member card.", "Member Card", JOptionPane.PLAIN_MESSAGE, icon, null, "");
					boolean valid = billing.verifyMemberCard(n);
					if(valid = true) {
						JOptionPane.showMessageDialog(frame, "VALIDATED");
					} else {
						JOptionPane.showMessageDialog(frame, "NOT VALIDATED");
					}
				} else if(a == "Number") {
					String n = (String)JOptionPane.showInputDialog(frame, "Enter member number provided.", "Member Number", JOptionPane.PLAIN_MESSAGE, icon, null, "");
					boolean valid = billing.verifyMemberNumber(n);
					if(valid = true) {
						JOptionPane.showMessageDialog(frame, "VALIDATED");
					} else {
						JOptionPane.showMessageDialog(frame, "NOT VALIDATED");
					}
				}
			} else if(s == "Bill ChocAn") {
				billing.recordInformation();
			} else if(s == "Request Provider Directory"){
				directory = request.requestDirectory();
				JOptionPane.showMessageDialog(frame,  "The Provider Directory has been emailed.");
			} else {
				flag = false;
			}
		}
	}
}
