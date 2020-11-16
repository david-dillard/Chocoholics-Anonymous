package chocAn;

import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

//Numbers NEED to be 9 digits long
//Names CANNOT exceed 25 characters
/**
 * 
 * @author Jacob Grinstead
 *
 */
public class Manage {
	private JFrame frame;
	private ImageIcon icon;
	/**
	 * 
	 */
	public Manage(){
		frame = new JFrame("ChocAn");
		icon = new ImageIcon("choclate.png");
	}
	
	/**
	 * 
	 */
	public void manageMember(){
		String operation, ret;
		frame = new JFrame("ChocAn");
		icon = new ImageIcon("choclate.png");
		Object[] possibilities = {"Add Member", "Update Member", "Delete Member","Exit"};
		operation = (String)JOptionPane.showInputDialog(frame, "Which operation would you like to perform?","Manage Member",JOptionPane.PLAIN_MESSAGE, icon, possibilities, "Add Member");
		
		if (operation == "Add Member"){
			ret=addMember();
		}else if (operation == "Update Member"){
			ret=updateMember();
		}else if(operation=="Delete Member"){
			ret=deleteMember();
		}else{
			ret="Exiting";
		}
		JOptionPane.showMessageDialog(frame, ret);
	}
	
	/**
	 * 
	 * @return String
	 */
	public String addMember(){
		System.out.println("In addMember()");
		String name, number, address, city, state, zipCode, status;
		//dialogue box required to get info
		while(true){
			name=(String)JOptionPane.showInputDialog(frame,"What is the member's name?\nName must be under 26 characters","Add Member",JOptionPane.PLAIN_MESSAGE,icon,null,"John");
			if(name.length()<=25){
				break;
			}
		}
		while(true){
			number=(String)JOptionPane.showInputDialog(frame,"What is the member's number?\nNumber must be 9 integers\nInclude leading zeros as needed","Add Member",JOptionPane.PLAIN_MESSAGE,icon,null,"123456789");
			if(number.length()==9){
				break;
			}
		}
		while(true){
			address=(String)JOptionPane.showInputDialog(frame,"What is the member's address?\nAddress must be under 26 characters","Add Member",JOptionPane.PLAIN_MESSAGE,icon,null,"30 2nd St");
			if(address.length()<=25){
				break;
			}
		}
		while(true){
			city=(String)JOptionPane.showInputDialog(frame,"What is the member's place of residence?\nCity name must be under 26 characters","Add Member",JOptionPane.PLAIN_MESSAGE,icon,null,"Gotham");
			if(city.length()<=14){
				break;
			}
		}
		while(true){
			state=(String)JOptionPane.showInputDialog(frame,"What is the member's state of residence?\nState must use the 2 letter abbreviation","Add Member",JOptionPane.PLAIN_MESSAGE,icon,null,"IN");
			if(state.length()==2){
				char first, second;
				first=state.charAt(0);
				second=state.charAt(1);
				if(Character.isUpperCase(first)&&Character.isUpperCase(second)){
					break;
				}
			}
		}
		while(true){
			zipCode=(String)JOptionPane.showInputDialog(frame,"What is the member's zipCode??\nZipCode must contain 5 integers","Add Member",JOptionPane.PLAIN_MESSAGE,icon,null,"37188");
			if(zipCode.length()==5){
				break;
			}
		}
		
		Object[] possibilites = {"Active","Nonactive"};
		status = (String)JOptionPane.showInputDialog(frame, "What is the member's status?","Add Member",JOptionPane.PLAIN_MESSAGE, icon, possibilites ,"Active");
		
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
		System.out.println("In updateMember()");
		String name, number, address, city, state, zipCode, status;
		//dialogue box required to get info
		while(true){
			number=(String)JOptionPane.showInputDialog(frame,"What is the member's number?\nNumber must be 9 integers\nInclude leading zeros as needed","Add Member",JOptionPane.PLAIN_MESSAGE,icon,null,"123456789");
			if(number.length()==9){
				break;
			}
		}
		
		Member temp = new Member();
		Member curr = temp.getMemberByNumber(number);
		
		if (curr==null){
			return "This member does not exist in the ChocAn database.";
		}else{
			String oldnum = curr.getNumber();
			//dialogue box to add new information
			while(true){
				name=(String)JOptionPane.showInputDialog(frame,"What is the member's name?\nName must be under 26 characters","Add Member",JOptionPane.PLAIN_MESSAGE,icon,null,"John");
				if(name.length()<=25){
					break;
				}
			}
			while(true){
				number=(String)JOptionPane.showInputDialog(frame,"What is the member's number?\nNumber must be 9 integers\nInclude leading zeros as needed","Add Member",JOptionPane.PLAIN_MESSAGE,icon,null,"123456789");
				if(number.length()==9){
					break;
				}
			}
			while(true){
				address=(String)JOptionPane.showInputDialog(frame,"What is the member's address?\nAddress must be under 26 characters","Add Member",JOptionPane.PLAIN_MESSAGE,icon,null,"30 2nd St");
				if(address.length()<=25){
					break;
				}
			}
			while(true){
				city=(String)JOptionPane.showInputDialog(frame,"What is the member's place of residence?\nCity name must be under 26 characters","Add Member",JOptionPane.PLAIN_MESSAGE,icon,null,"Gotham");
				if(city.length()<=14){
					break;
				}
			}
			while(true){
				state=(String)JOptionPane.showInputDialog(frame,"What is the member's state of residence?\nState must use the 2 letter abbreviation","Add Member",JOptionPane.PLAIN_MESSAGE,icon,null,"IN");
				if(state.length()==2){
					char first, second;
					first=state.charAt(0);
					second=state.charAt(1);
					if(Character.isUpperCase(first)&&Character.isUpperCase(second)){
						break;
					}
				}
			}
			while(true){
				zipCode=(String)JOptionPane.showInputDialog(frame,"What is the member's zipCode??\nZipCode must contain 5 integers","Add Member",JOptionPane.PLAIN_MESSAGE,icon,null,"37188");
				if(zipCode.length()==5){
					break;
				}
			}
			
			Object[] possibilites = {"Active","Nonactive"};
			status = (String)JOptionPane.showInputDialog(frame, "What is the member's status?","Add Member",JOptionPane.PLAIN_MESSAGE, icon, possibilites ,"Active");
			
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
		System.out.println("In deleteMember()");
		String number;
		//dialogue box required to get info
		while(true){
			number=(String)JOptionPane.showInputDialog(frame,"What is the member's number?\nNumber must be 9 integers\nInclude leading zeros as needed","Add Member",JOptionPane.PLAIN_MESSAGE,icon,null,"123456789");
			if(number.length()==9){
				break;
			}
		}
		
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
		Object[] possibilities = {"Add Provider", "Update Provider", "Delete Provider","Exit"};
		//Object[] possibilities2 = {"Card","Number"};
		operation = (String)JOptionPane.showInputDialog(frame, "Which operation would you like to perform?","Manage Provider",JOptionPane.PLAIN_MESSAGE, icon, possibilities, "Add Provider");
		
		if (operation == "Add Provider"){
			ret=addProvider();
		}else if (operation == "Update Provider"){
			ret=updateProvider();
		}else if(operation=="Delete Provider"){
			ret=deleteProvider();
		}else{
			ret="Exiting manage provider";
		}
		JOptionPane.showMessageDialog(frame, ret);
	}
	
	/**
	 * 
	 * @return String
	 */
	public String addProvider(){
		System.out.println("In addProvider()");
		String name, number, address, city, state, zipCode;
		//dialogue box required to get info
		while(true){
			name=(String)JOptionPane.showInputDialog(frame,"What is the provider's name?\nName must be under 26 characters","Add Provider",JOptionPane.PLAIN_MESSAGE,icon,null,"CocoINC");
			if(name.length()<=25){
				break;
			}
		}
		while(true){
			number=(String)JOptionPane.showInputDialog(frame,"What is the provider's number?\nNumber must be 9 integers\nInclude leading zeros as needed","Add Provider",JOptionPane.PLAIN_MESSAGE,icon,null,"123456789");
			if(number.length()==9){
				break;
			}
		}
		while(true){
			address=(String)JOptionPane.showInputDialog(frame,"What is the provider's address?\nAddress must be under 26 characters","Add Provider",JOptionPane.PLAIN_MESSAGE,icon,null,"30 2nd St");
			if(address.length()<=25){
				break;
			}
		}
		while(true){
			city=(String)JOptionPane.showInputDialog(frame,"What is the provider's place of residence?\nCity name must be under 26 characters","Add Provider",JOptionPane.PLAIN_MESSAGE,icon,null,"Gotham");
			if(city.length()<=14){
				break;
			}
		}
		while(true){
			state=(String)JOptionPane.showInputDialog(frame,"What is the provider's state of residence?\nState must use the 2 letter abbreviation","Add Provider",JOptionPane.PLAIN_MESSAGE,icon,null,"IN");
			if(state.length()==2){
				char first, second;
				first=state.charAt(0);
				second=state.charAt(1);
				if(Character.isUpperCase(first)&&Character.isUpperCase(second)){
					break;
				}
			}
		}
		while(true){
			zipCode=(String)JOptionPane.showInputDialog(frame,"What is the provider's zipCode??\nZipCode must contain 5 integers","Add Provider",JOptionPane.PLAIN_MESSAGE,icon,null,"37188");
			if(zipCode.length()==5){
				break;
			}
		}
		
		Provider temp = new Provider();
		Provider poss = temp.getProviderByNumber(number);
		//code to search list && set boolean
		if (poss!=null){
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
	}
	
	/**
	 * 
	 * @return String
	 */
	public String updateProvider(){
		System.out.println("In updateProvider()");
		String name, number, address, city, state, zipCode;
		//dialogue box required to get info
		while(true){
			number=(String)JOptionPane.showInputDialog(frame,"What is the provider's number?\nNumber must be 9 integers\nInclude leading zeros as needed","Add Provider",JOptionPane.PLAIN_MESSAGE,icon,null,"123456789");
			if(number.length()==9){
				break;
			}
		}
		
		Provider temp = new Provider();
		Provider poss = temp.getProviderByNumber(number);
		//code to search list && set boolean
		if (poss==null){
			return "This provider does not exist in the ChocAn database.";
		}else{
			String oldnum=poss.getNumber();
			while(true){
				name=(String)JOptionPane.showInputDialog(frame,"What is the provider's name?\nName must be under 26 characters","Add Provider",JOptionPane.PLAIN_MESSAGE,icon,null,"CocoINC");
				if(name.length()<=25){
					break;
				}
			}
			while(true){
				number=(String)JOptionPane.showInputDialog(frame,"What is the provider's number?\nNumber must be 9 integers\nInclude leading zeros as needed","Add Provider",JOptionPane.PLAIN_MESSAGE,icon,null,"123456789");
				if(number.length()==9){
					break;
				}
			}
			while(true){
				address=(String)JOptionPane.showInputDialog(frame,"What is the provider's address?\nAddress must be under 26 characters","Add Provider",JOptionPane.PLAIN_MESSAGE,icon,null,"30 2nd St");
				if(address.length()<=25){
					break;
				}
			}
			while(true){
				city=(String)JOptionPane.showInputDialog(frame,"What is the provider's place of residence?\nCity name must be under 26 characters","Add Provider",JOptionPane.PLAIN_MESSAGE,icon,null,"Gotham");
				if(city.length()<=14){
					break;
				}
			}
			while(true){
				state=(String)JOptionPane.showInputDialog(frame,"What is the provider's state of residence?\nState must use the 2 letter abbreviation","Add Provider",JOptionPane.PLAIN_MESSAGE,icon,null,"IN");
				if(state.length()==2){
					char first, second;
					first=state.charAt(0);
					second=state.charAt(1);
					if(Character.isUpperCase(first)&&Character.isUpperCase(second)){
						break;
					}
				}
			}
			while(true){
				zipCode=(String)JOptionPane.showInputDialog(frame,"What is the provider's zipCode??\nZipCode must contain 5 integers","Add Provider",JOptionPane.PLAIN_MESSAGE,icon,null,"37188");
				if(zipCode.length()==5){
					break;
				}
			}
			poss.setName(name);
			poss.setNumber(number);
			poss.setAddress(address);
			poss.setCity(city);
			poss.setState(state);
			poss.setZipCode(zipCode);
			poss.updateProviderInDatabase(oldnum);
			return "The provider has been updated in the ChocAn database.";
		}
	}
	
	/**
	 * 
	 * @return String
	 */
	public String deleteProvider(){
		System.out.println("In deleteProvider()");
		String number;
		//dialogue box required to get info
		while(true){
			number=(String)JOptionPane.showInputDialog(frame,"What is the provider's number?\nNumber must be 9 integers\nInclude leading zeros as needed","Add Provider",JOptionPane.PLAIN_MESSAGE,icon,null,"123456789");
			if(number.length()==9){
				break;
			}
		}
		
		Provider temp = new Provider();
		Provider poss = temp.getProviderByNumber(number);
		//code to search list && set boolean
		if (poss!=null){
			poss.deleteProviderFromDatabase();
			return "This provider has been deleted from the ChocAn database.";
		}else{
			return "The provider does not exist in the ChocAn database.";
		}
	}

}
