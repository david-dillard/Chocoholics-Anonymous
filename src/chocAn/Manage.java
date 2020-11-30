package chocAn;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * This class is the main manage class.
 * It handles inserts, updates, and deletions regarding members and providers.
 * Interacts directly with the ChocAn database
 * 
 * @author Jacob Grinstead
 * @version 1.0
 */
public class Manage {
	private JFrame frame;
	private ImageIcon icon;
	
	/**
	 * This constructor starts by providing information to the class variables
	 */
	public Manage(){
		frame = new JFrame("ChocAn");
		icon = new ImageIcon("choclate.png");
	}
	
	/**
	 * This method handles add, update, and delete member
	 */
	public void manageMember(){
		String operation, ret;
		frame = new JFrame("ChocAn");
		icon = new ImageIcon("choclate.png");
		Object[] possibilities = {"Add Member", "Update Member", "Delete Member"};
		operation = (String)JOptionPane.showInputDialog(frame, "Which operation would you like to perform?","Manage Member",JOptionPane.PLAIN_MESSAGE, icon, possibilities, "Add Member");
		
		if (operation.equals("Add Member")){
			ret=addMember();
		}else if (operation.equals("Update Member")){
			ret=updateMember();
		}else if(operation.equals("Delete Member")){
			ret=deleteMember();
		}else{
			ret="Exiting";
		}
		JOptionPane.showMessageDialog(frame, ret);
	}
	
	/**
	 * This method gets input from a user, transfers that input into a member object, and adds
	 * the member to the ChocAn database
	 * 
	 * @return String - a message that indicates if the method was successful
	 */
	public String addMember(){
		//System.out.println("In addMember()");
		String name, number, address, city, state, zipCode, status;
		//dialogue box required to get info
		while(true){
			name=(String)JOptionPane.showInputDialog(frame,"What is the member's name?\nName must be under 26 characters","Add Member",JOptionPane.PLAIN_MESSAGE,icon,null,"John");
			if(name==null) return "Leaving";
			if(name.length()<=25){
				break;
			}
		}
		while(true){
			number=(String)JOptionPane.showInputDialog(frame,"What is the member's number?\nNumber must be 9 integers\nInclude leading zeros as needed","Add Member",JOptionPane.PLAIN_MESSAGE,icon,null,"123456789");
			if(number==null) return "Leaving";
			if(number.length()==9){
				break;
			}
		}
		while(true){
			address=(String)JOptionPane.showInputDialog(frame,"What is the member's address?\nAddress must be under 26 characters","Add Member",JOptionPane.PLAIN_MESSAGE,icon,null,"30 2nd St");
			if(address==null) return "Leaving";
			if(address.length()<=25){
				break;
			}
		}
		while(true){
			city=(String)JOptionPane.showInputDialog(frame,"What is the member's place of residence?\nCity name must be under 26 characters","Add Member",JOptionPane.PLAIN_MESSAGE,icon,null,"Gotham");
			if(city==null) return "Leaving";
			if(city.length()<=14){
				break;
			}
		}
		while(true){
			state=(String)JOptionPane.showInputDialog(frame,"What is the member's state of residence?\nState must use the 2 letter abbreviation","Add Member",JOptionPane.PLAIN_MESSAGE,icon,null,"IN");
			if(state==null) return "Leaving";
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
			if(zipCode==null) return "Leaving";
			if(zipCode.length()==5){
				break;
			}
		}
		
		Object[] possibilites = {"active","suspended"};
		status = (String)JOptionPane.showInputDialog(frame, "What is the member's status?","Add Member",JOptionPane.PLAIN_MESSAGE, icon, possibilites ,"Active");
		if(status==null) return "Leaving";
		
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
	 * This method gets input from a user, then checks to see if the member exists in the database. If so, 
	 * the input is used to change the information stored in the member object
	 * 
	 * @return String - a message that indicates if the method was successful
	 */
	public String updateMember(){
		//System.out.println("In updateMember()");
		String name, number, address, city, state, zipCode, status;
		//dialogue box required to get info
		while(true){
			number=(String)JOptionPane.showInputDialog(frame,"What is the member's number?\nNumber must be 9 integers\nInclude leading zeros as needed","Add Member",JOptionPane.PLAIN_MESSAGE,icon,null,"123456789");
			if(number==null) return "Leaving";
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
				if(name==null) return "Leaving";
				if(name.length()<=25){
					break;
				}
			}
			while(true){
				number=(String)JOptionPane.showInputDialog(frame,"What is the member's number?\nNumber must be 9 integers\nInclude leading zeros as needed","Add Member",JOptionPane.PLAIN_MESSAGE,icon,null,"123456789");
				if(number==null) return "Leaving";
				if(number.length()==9){
					break;
				}
			}
			while(true){
				address=(String)JOptionPane.showInputDialog(frame,"What is the member's address?\nAddress must be under 26 characters","Add Member",JOptionPane.PLAIN_MESSAGE,icon,null,"30 2nd St");
				if(address==null) return "Leaving";
				if(address.length()<=25){
					break;
				}
			}
			while(true){
				city=(String)JOptionPane.showInputDialog(frame,"What is the member's place of residence?\nCity name must be under 26 characters","Add Member",JOptionPane.PLAIN_MESSAGE,icon,null,"Gotham");
				if(city==null) return "Leaving";
				if(city.length()<=14){
					break;
				}
			}
			while(true){
				state=(String)JOptionPane.showInputDialog(frame,"What is the member's state of residence?\nState must use the 2 letter abbreviation","Add Member",JOptionPane.PLAIN_MESSAGE,icon,null,"IN");
				if(state==null) return "Leaving";
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
				if(zipCode==null) return "Leaving";
				if(zipCode.length()==5){
					break;
				}
			}
			
			Object[] possibilites = {"active","suspended"};
			status = (String)JOptionPane.showInputDialog(frame, "What is the member's status?","Add Member",JOptionPane.PLAIN_MESSAGE, icon, possibilites ,"Active");
			if(status==null) return "Leaving";
			
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
	 * This method gets input from a user, then searches the ChocAn database. If the member is found,
	 * it is then deleted from the database
	 * 
	 * @return String - a message that indicates if the method was successful
	 */
	public String deleteMember(){
		//System.out.println("In deleteMember()");
		String number;
		//dialogue box required to get info
		while(true){
			number=(String)JOptionPane.showInputDialog(frame,"What is the member's number?\nNumber must be 9 integers\nInclude leading zeros as needed","Add Member",JOptionPane.PLAIN_MESSAGE,icon,null,"123456789");
			if(number==null) return "Leaving";
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
	 * This method is in charge of inserting, updating, and deleting members to in and from the ChocAn database.
	 * It takes user input and then directs them to the correct method
	 */
	public void manageProvider(){
		String operation, ret;
		JFrame frame = new JFrame("ChocAn");
		ImageIcon icon = new ImageIcon("choclate.png");
		Object[] possibilities = {"Add Provider", "Update Provider", "Delete Provider"};
		//Object[] possibilities2 = {"Card","Number"};
		operation = (String)JOptionPane.showInputDialog(frame, "Which operation would you like to perform?","Manage Provider",JOptionPane.PLAIN_MESSAGE, icon, possibilities, "Add Provider");
		
		if (operation.equals("Add Provider")){
			ret=addProvider();
		}else if (operation.equals("Update Provider")){
			ret=updateProvider();
		}else if(operation.equals("Delete Provider")){
			ret=deleteProvider();
		}else{
			ret="Exiting manage provider";
		}
		JOptionPane.showMessageDialog(frame, ret);
	}
	
	/**
	 * This method takes user input, puts it into a new provider object, then adds the object to
	 * the database, provided that the object does not already exist
	 * 
	 * @return String - a message that indicates if the method was successful
	 */
	public String addProvider(){
		//System.out.println("In addProvider()");
		String name, number, address, city, state, zipCode;
		//dialogue box required to get info
		while(true){
			name=(String)JOptionPane.showInputDialog(frame,"What is the provider's name?\nName must be under 26 characters","Add Provider",JOptionPane.PLAIN_MESSAGE,icon,null,"CocoINC");
			if(name==null) return "Leaving";
			if(name.length()<=25){
				break;
			}
		}
		while(true){
			number=(String)JOptionPane.showInputDialog(frame,"What is the provider's number?\nNumber must be 9 integers\nInclude leading zeros as needed","Add Provider",JOptionPane.PLAIN_MESSAGE,icon,null,"123456789");
			if(number==null) return "Leaving";
			if(number.length()==9){
				break;
			}
		}
		while(true){
			address=(String)JOptionPane.showInputDialog(frame,"What is the provider's address?\nAddress must be under 26 characters","Add Provider",JOptionPane.PLAIN_MESSAGE,icon,null,"30 2nd St");
			if(address==null) return "Leaving";
			if(address.length()<=25){
				break;
			}
		}
		while(true){
			city=(String)JOptionPane.showInputDialog(frame,"What is the provider's place of residence?\nCity name must be under 26 characters","Add Provider",JOptionPane.PLAIN_MESSAGE,icon,null,"Gotham");
			if(city==null) return "Leaving";
			if(city.length()<=14){
				break;
			}
		}
		while(true){
			state=(String)JOptionPane.showInputDialog(frame,"What is the provider's state of residence?\nState must use the 2 letter abbreviation","Add Provider",JOptionPane.PLAIN_MESSAGE,icon,null,"IN");
			if(state==null) return "Leaving";
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
			if(zipCode==null) return "Leaving";
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
	 * This method takes user input, searches for the corresponding provider,and then updates the object
	 * with the input.
	 * 
	 * @return String - a message that indicates if the method was successful
	 */
	public String updateProvider(){
		//System.out.println("In updateProvider()");
		String name, number, address, city, state, zipCode;
		//dialogue box required to get info
		while(true){
			number=(String)JOptionPane.showInputDialog(frame,"What is the provider's number?\nNumber must be 9 integers\nInclude leading zeros as needed","Add Provider",JOptionPane.PLAIN_MESSAGE,icon,null,"123456789");
			if(number==null) return "Leaving";
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
				if(name==null) return "Leaving";
				if(name.length()<=25){
					break;
				}
			}
			while(true){
				number=(String)JOptionPane.showInputDialog(frame,"What is the provider's number?\nNumber must be 9 integers\nInclude leading zeros as needed","Add Provider",JOptionPane.PLAIN_MESSAGE,icon,null,"123456789");
				if(number==null) return "Leaving";
				if(number.length()==9){
					break;
				}
			}
			while(true){
				address=(String)JOptionPane.showInputDialog(frame,"What is the provider's address?\nAddress must be under 26 characters","Add Provider",JOptionPane.PLAIN_MESSAGE,icon,null,"30 2nd St");
				if(address==null) return "Leaving";
				if(address.length()<=25){
					break;
				}
			}
			while(true){
				city=(String)JOptionPane.showInputDialog(frame,"What is the provider's place of residence?\nCity name must be under 26 characters","Add Provider",JOptionPane.PLAIN_MESSAGE,icon,null,"Gotham");
				if(city==null) return "Leaving";
				if(city.length()<=14){
					break;
				}
			}
			while(true){
				state=(String)JOptionPane.showInputDialog(frame,"What is the provider's state of residence?\nState must use the 2 letter abbreviation","Add Provider",JOptionPane.PLAIN_MESSAGE,icon,null,"IN");
				if(state==null) return "Leaving";
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
				if(zipCode==null) return "Leaving";
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
	 * This method takes user input, and then searches for the corresponding provider object. If found,
	 * the object is then deleted from the ChocAn database
	 * 
	 * @return String - a message that indicates if the method was successful
	 */
	public String deleteProvider(){
		//System.out.println("In deleteProvider()");
		String number;
		//dialogue box required to get info
		while(true){
			number=(String)JOptionPane.showInputDialog(frame,"What is the provider's number?\nNumber must be 9 integers\nInclude leading zeros as needed","Add Provider",JOptionPane.PLAIN_MESSAGE,icon,null,"123456789");
			if(number==null) return "Leaving";
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
