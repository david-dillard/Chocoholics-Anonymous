package chocAn;

import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

//Numbers NEED to be 9
//Names CANNOT exceed 25 characters
/**
 * 
 * @author Jacob Grinstead
 *
 */
public class Manage {
	/**
	 * 
	 */
	public Manage(){
		
	}
	
	/**
	 * 
	 */
	public void manageMember(){
		String operation, ret;
		JFrame frame = new JFrame("ChocAn");
		ImageIcon icon = new ImageIcon("choclate.png");
		Object[] possibilities = {"Add Member", "Update Member", "Delete Member"};
		operation = (String)JOptionPane.showInputDialog(frame, "Which operation would you like to perform?","Manage Member",JOptionPane.PLAIN_MESSAGE, icon, possibilities, "Add Member");
		
		if (operation == "add"){
			ret=addMember();
		}else if (operation == "update"){
			ret=updateMember();
		}else{
			ret=deleteMember();
		}
		JOptionPane.showMessageDialog(frame, ret);
	}
	
	/**
	 * 
	 * @return String
	 */
	public String addMember(){
		String name, number, address, city, state, zipCode, status;
		//dialogue box required to get info
		//List<Member> members = Member.getMembersFromDatabase();
		Member temp = new Member();
		Member poss = temp.getMemberByNumber(number);
		
		if (poss != null){
			return "This member already exists in the ChocAn database.";
		}else{
			Member curr = new Member();
			curr.setName(name);
			curr.setNumber(number);
			curr.setAddress(address);
			curr.setCity(city);
			curr.setState(state);
			curr.setZipCode(zipCode);
			curr.setStatus(status);
			curr.addMemberToDatabase();
			return "The member has been added to the ChocAn database.";
		}
	}
	
	/**
	 * 
	 * @return String
	 */
	public String updateMember(){
		String name, number, address, city, state, zipCode, status;
		//dialogue box required to get info
		Member temp = new Member();
		Member curr = temp.getMemberByNumber(number);
		
		if (curr==null){
			return "This member does not exist in the ChocAn database.";
		}else{
			String oldnum = curr.getNumber();
			//dialogue box to add new information
			curr.setName(name);
			curr.setNumber(number);
			curr.setAddress(address);
			curr.setCity(city);
			curr.setState(state);
			curr.setZipCode(zipCode);
			curr.setStatus(status);
			curr.updateMemberInDatabase(oldnum);
			return "The member has been updated.";
		}
	}
	
	/**
	 * 
	 * @return String
	 */
	public String deleteMember(){
		String number;
		//dialogue box required to get info
		Member temp = new Member();
		Member curr = temp.getMemberByNumber(number);
		//code to search list && set boolean
		if (curr==null){
			return "This member does not exist in the ChocAn database.";
		}else{
			curr.deleteMemberFromDatabase();
			return "The member has been removed from the ChocAn database.";
		}
	}
	
	/**
	 * 
	 */
	public void manageProvider(){
		String operation, ret;
		JFrame frame = new JFrame("ChocAn");
		ImageIcon icon = new ImageIcon("choclate.png");
		Object[] possibilities = {"Add Provider", "Update Provider", "Delete Provider"};
		Object[] possibilities2 = {"Card","Number"};
		operation = (String)JOptionPane.showInputDialog(frame, "Which operation would you like to perform?","Manage Member",JOptionPane.PLAIN_MESSAGE, icon, possibilities, "Verify Member Card");
		
		if (operation == "add"){
			ret=addProvider();
		}else if (operation == "update"){
			ret=updateProvider();
		}else{
			ret=deleteProvider();
		}
		JOptionPane.showMessageDialog(frame, ret);
	}
	
	/**
	 * 
	 * @return String
	 */
	public String addProvider(){
		String name, number, address, city, state, zipCode;
		boolean found = false;
		//dialogue box required to get info
		List<Provider> providers = Provider.getProvidersFromDatabase();
		//code to search list && set boolean
		if (found){
			return "This provider already exists in the ChocAn database.";
		}else{
			Provider curr = new Provider();
			curr.setName(name);
			curr.setNumber(number);
			curr.setAddress(address);
			curr.setCity(city);
			curr.setState(state);
			curr.setZipCode(zipCode);
			curr.addProviderToDatabase();
			return "The provider has been added to the ChocAn database.";
		}
		return "Task failed";
	}
	
	/**
	 * 
	 * @return String
	 */
	public String updateProvider(){
		String name, number, address, city, state, zipCode;
		boolean found = false;
		//dialogue box required to get info
		List<Provider> providers = Provider.getProvidersFromDatabase();
		//code to search list && set boolean
		if (found){
			return "This provider already exists in the ChocAn database.";
		}else{
			Provider curr = new Provider();
			curr.setName(name);
			curr.setNumber(number);
			curr.setAddress(address);
			curr.setCity(city);
			curr.setState(state);
			curr.setZipCode(zipCode);
			curr.addProviderToDatabase();
			return "The provider has been added to the ChocAn database.";
		}
		return "Task failed";
	}
	
	/**
	 * 
	 * @return String
	 */
	public String deleteProvider(){
		boolean found = false;
		//dialogue box required to get info
		List<Provider> providers = Provider.getProvidersFromDatabase();
		//code to search list && set boolean
		if (found){
			
			return "This provider has been deleted from the ChocAn database.";
		}else{
			return "The provider does not exist in the ChocAn database.";
		}
		return "Task failed";
	}

}
