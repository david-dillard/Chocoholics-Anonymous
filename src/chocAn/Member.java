package chocAn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Entity class that contains information for members.
 * 
 * @author Zachary Stiles
 * @version 1.0
 */
public class Member {
	
	private String name;
	private String number;
	private String address;
	private String city;
	private String state;
	private String zipCode;
	private String status;
	
	/**
	 * Searches the ChocAnMembers.csv file to see if a member exists.
	 * @param number the member's identification number
	 * @return true if the value if the member exists, false if otherwise
	 */
	public boolean searchMemberNumber(String number) {
		List<Member> members = getMembersFromDatabase();
		for (Member member : members) {
			if (member.getNumber().equals(number))
				return true;
		}
		return false;
	}
	
	/**
	 * Retrieves a member from the ChocAnMembers.csv file.
	 * @param number the member's identification number
	 * @return a Member object with the corresponding number, null if the member does not exist
	 */
	public Member getMemberByNumber(String number) {
		List<Member> members = getMembersFromDatabase();
		for (Member member : members) {
			if (member.getNumber().equals(number))
				return member;
		}
		return null;
	}
	
	/**
	 * Adds this Member object to the ChocAnMembers.csv file.
	 */
	public void addMemberToDatabase() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("ChocAnMembers.csv", true));
			writer.append(name + "," + number + "," + address + "," + city + "," + state + "," + zipCode + "," + status +"\n");
			writer.close();
		} catch (IOException e) {
			JFrame frame = new JFrame("ERROR");
			JOptionPane.showMessageDialog(frame, "Error: Could not read lines in ChocAnMembers.csv file.");
		}
	}
	
	/**
	 * Removes this Member object from the ChocAnMembers.csv file.
	 */
	public void deleteMemberFromDatabase() {
		List<Member> members = getMembersFromDatabase();
		for (Member member : members) {
			if (member.getNumber().equals(number)) {
				members.remove(members.indexOf(member));
				break;
			}
		}
		try {
		BufferedWriter writer = new BufferedWriter(new FileWriter("ChocAnMembers.csv"));
			writer.append("name,number,address,city,state,zipCode,status\n");
			for (Member member: members) {
				writer.append(member.getName() + ",");
				writer.append(member.getNumber() + ",");
				writer.append(member.getAddress() + ",");
				writer.append(member.getCity() + ",");
				writer.append(member.getState() + ",");
				writer.append(member.getZipCode() + ",");
				writer.append(member.getStatus() + "\n");
			}
			writer.close();
		} catch (IOException e) {
			JFrame frame = new JFrame("ERROR");
			JOptionPane.showMessageDialog(frame, "Error: Could not read lines in ChocAnMembers.csv file.");
		}
	}
	
	/**
	 * Updates this Member object in the ChocAnMembers.csv file.
	 * @param number the Member's previous number (in case it was changed)
	 */
	public void updateMemberInDatabase(String number) {
		String newNumber = this.number;
		this.number = number;
		deleteMemberFromDatabase();
		this.number = newNumber;
		addMemberToDatabase();
	}
	
	/**
	 * Retrieves all of the members from the ChocAnMembers.csv file.
	 * @return a List of Member objects for each member in the ChocAnMembers.csv file, null if no members exist
	 */
	public List<Member> getMembersFromDatabase() {
		List<Member> members = new ArrayList<Member>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader("ChocAnMembers.csv"));
			String row = reader.readLine();
			String[] memberData = new String[7];
			while ((row = reader.readLine()) != null) {
				memberData = row.split(",");
				Member member = new Member();
				member.setName(memberData[0]);
				member.setNumber(memberData[1]);
				member.setAddress(memberData[2]);
				member.setCity(memberData[3]);
				member.setState(memberData[4]);
				member.setZipCode(memberData[5]);
				member.setStatus(memberData[6]);
				members.add(member);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			JFrame frame = new JFrame("ERROR");
			JOptionPane.showMessageDialog(frame, "Error: Could not find ChocAnMembers.csv file.");
		} catch (IOException e) {
			JFrame frame = new JFrame("ERROR");
			JOptionPane.showMessageDialog(frame, "Error: Could not read lines in ChocAnMembers.csv file.");
		}
		return members;
	}
	
	/**
	 * Retrieves the Member object's name.
	 * @return String containing the Member object's name (25 characters)
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the Member object's name.
	 * @param name String containing the Member object's name (25 characters)
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Retrieves the Member object's number.
	 * @return String containing the Member object's number (9 digits)
	 */
	public String getNumber() {
		return number;
	}
	
	/**
	 * Sets the Member object's number.
	 * @param number String containing the Member object's number (9 digits)
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	
	/**
	 * Retrieves the Member object's address.
	 * @return String containing the Member object's address (25 characters)
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * Sets the Member object's address.
	 * @param address String containing the Member object's address (25 characters)
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * Retrieves the Member object's city.
	 * @return String containing the Member object's city (14 characters)
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * Sets the Member object's city.
	 * @param city String containing the Member object's city (14 characters)
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * Retrieves the Member object's state.
	 * @return String containing the Member object's state (2 letters)
	 */
	public String getState() {
		return state;
	}
	
	/**
	 * Sets the Member object's state.
	 * @param state String containing the Member object's state (2 letters)
	 */
	public void setState(String state) {
		this.state = state;
	}
	
	/**
	 * Retrieves the Member object's ZIP code.
	 * @return String containing the Member object's ZIP code (5 digits)
	 */
	public String getZipCode() {
		return zipCode;
	}
	
	/**
	 * Sets the Member object's ZIP code.
	 * @param zipCode String containing the Member object's ZIP code (5 digits)
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	/**
	 * Retrieves the Member object's status.
	 * @return String containing the Member object's status (approved or suspended)
	 */
	public String getStatus() {
		return status;
	}
	
	/**
	 * Sets the Member object's status.
	 * @param status String containing the Member object's ZIP code (approved or suspended)
	 */
	public void setStatus(String status) {
		this.status = status;
	}
}