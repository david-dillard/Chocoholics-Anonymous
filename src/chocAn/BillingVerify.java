package chocAn;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class BillingVerify {
	private ProviderDirectory providerDirectory;
	
	public void recordInformation() {
		JFrame frame = new JFrame("Billing Verify");
		ImageIcon icon = new ImageIcon("duck.jpg");
		Service service = new Service();
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:MM:SS");
        service.setComputerTime(time.format(formatter));
        String serviceDate = (String)JOptionPane.showInputDialog(frame, "Enter the service date in the format of MM-DD-YYYY.", "Service Date", JOptionPane.PLAIN_MESSAGE, icon, null, "");
        service.setServiceDate(serviceDate);
        String providerNumber = (String)JOptionPane.showInputDialog(frame, "Enter the 9 digit provider number.", "Provider Number", JOptionPane.PLAIN_MESSAGE, icon, null, "");
        service.setProviderNumber(providerNumber);
        String memberNumber = (String)JOptionPane.showInputDialog(frame, "Enter the 9 digit member number.", "Member Number", JOptionPane.PLAIN_MESSAGE, icon, null, "");
        service.setMemberNumber(memberNumber);
        String serviceCode = (String)JOptionPane.showInputDialog(frame, "Enter the 6 digit service code.", "Service Code", JOptionPane.PLAIN_MESSAGE, icon, null, "");
        service.setServiceCode(serviceCode);
        String comments = (String)JOptionPane.showInputDialog(frame, "Enter any optional comments up to 100 characters.", "Comments", JOptionPane.PLAIN_MESSAGE, icon, null, "");
        service.setComments(comments);
        String fee = (String)JOptionPane.showInputDialog(frame, "Enter the fee, include $ at the beginning.", "fee", JOptionPane.PLAIN_MESSAGE, icon, null, "");
        service.setFee(fee);
	}
	
	public boolean verifyMemberNumber(String number) {
		Member member = new Member();
		boolean valid = member.searchMemberNumber(number);
		return valid;
	}
	
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
	
	public boolean verifyMemberCard(String number) {
		Member member = new Member();
		boolean valid = member.searchMemberNumber(number);
		return valid;
	}
}