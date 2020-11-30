package chocAn;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * This class verifies member and service information as well as records information of a service.
 * @author Joseph Daly
 * @version 1.0
 */
public class BillingVerify {
	private ProviderDirectory providerDirectory;
	
	/**
	 * This method records entered information into a new service variable.
	 */
	public void recordInformation() {
		JFrame frame = new JFrame("Billing Verify");
		ImageIcon icon = new ImageIcon("duck.jpg");
		String serviceDate, providerNumber, memberNumber, serviceCode, comments, fee;
		while(true) {
			serviceDate = (String)JOptionPane.showInputDialog(frame, "Enter the service date in the format of MM-DD-YYYY.", "Service Date", JOptionPane.PLAIN_MESSAGE, icon, null, "");
			if(serviceDate == null) return;
			if(serviceDate.length() == 10) break;
		}
		while(true) {
			providerNumber = (String)JOptionPane.showInputDialog(frame, "Enter the 9 digit provider number.", "Provider Number", JOptionPane.PLAIN_MESSAGE, icon, null, "");
			if(providerNumber == null) return;
			if(providerNumber.length() == 9) break;
		}
		while(true) {
			memberNumber = (String)JOptionPane.showInputDialog(frame, "Enter the 9 digit member number.", "Member Number", JOptionPane.PLAIN_MESSAGE, icon, null, "");
			if(memberNumber == null) return;
			if(memberNumber.length() == 9) break;
		}
		while(true) {
			serviceCode = (String)JOptionPane.showInputDialog(frame, "Enter the 6 digit service code.", "Service Code", JOptionPane.PLAIN_MESSAGE, icon, null, "");
			if(serviceCode == null) return;
			if(serviceCode.length() == 6) break;
		}
		while(true) {
			comments = (String)JOptionPane.showInputDialog(frame, "Enter any optional comments up to 100 characters.\nEnter N/A if no comments.", "Comments", JOptionPane.PLAIN_MESSAGE, icon, null, "");
			if(comments == null) return;
			if(comments.length() <= 100) break;
		}
		while(true) {
			fee = (String)JOptionPane.showInputDialog(frame, "Enter the fee, include $ at the beginning.\nInclude cents, even if price is a whole dollar amount.", "fee", JOptionPane.PLAIN_MESSAGE, icon, null, "");
			if(fee == null) return;
			if(fee.length() <= 6) break;
		}
		Service service = new Service();
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:MM:SS");
        service.setComputerTime(time.format(formatter));
        service.setServiceDate(serviceDate);
        service.setProviderNumber(providerNumber);
        service.setMemberNumber(memberNumber);
        service.setServiceCode(serviceCode);
        service.setComments(comments);
        service.setFee(fee);
	}
	
	/**
	 * This method verifies that a given member number exists.
	 * @param number
	 * @return Returns true if the number exists and false if it does not.
	 */
	public boolean verifyMemberNumber(String number) {
		Member member = new Member();
		boolean valid = member.searchMemberNumber(number);
		return valid;
	}
	
	/**
	 * This method verifies that a given service code exists.
	 * @param serviceCode
	 * @return Returns true if the service code exists and false if it does not.
	 */
	public boolean verifyServiceCode(String serviceCode) {
		providerDirectory = new ProviderDirectory();
		String[] codes = providerDirectory.getServiceCodes();
		int i = 0;
		while(i < codes.length) {
			if(codes[i] == serviceCode) {
				return true;
			}
			i ++;
		}
		return false;
	}
	
	/**
	 * This method verifies a given member card has a valid member number.
	 * @param number
	 * @return Returns true if the number exists and false if it does not.
	 */
	public boolean verifyMemberCard(String number) {
		Member member = new Member();
		boolean valid = member.searchMemberNumber(number);
		return valid;
	}
}