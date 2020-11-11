package chocAn;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Member {
	
	private String name;
	private String number;
	private String address;
	private String city;
	private String state;
	private String zipCode;
	private String status;
	
	public boolean searchMemberNumber(String number) {
		//TODO: Implement
		return false;
	}
	
	public Member getMemberByNumber(String number) {
		//TODO: Implement
		return null;
	}
	
	public void addMemberToDatabase() {
		//TODO: Implement
	}
	
	public void deleteMemberFromDatabase() {
		//TODO: Implement
	}
	
	public void updateMemberInDatabase() {
		//TODO: Implement
	}
	
	public List<Member> getMembersFromDatabase() {
		List<Member> members = new ArrayList<Member>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader("ChocAnMembers.csv"));
			String row = reader.readLine();
			String[] memberData = new String[7];
			while ((row = reader.readLine()) != null) {
				System.out.println(row);
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
		} catch (FileNotFoundException e) { //new FileReader
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) { //readLine
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return members;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getZipCode() {
		return zipCode;
	}
	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
}
