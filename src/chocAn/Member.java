package chocAn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
		List<Member> members = getMembersFromDatabase();
		for (Member member : members) {
			if (member.getNumber().equals(number))
				return true;
		}
		return false;
	}
	
	public Member getMemberByNumber(String number) {
		List<Member> members = getMembersFromDatabase();
		for (Member member : members) {
			if (member.getNumber().equals(number))
				return member;
		}
		return null; //needs for not null check on other end
	}
	
	public void addMemberToDatabase() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("ChocAnMembers.csv", true));
			writer.append(name);
			writer.append(",");
			writer.append(number);
			writer.append(",");
			writer.append(address);
			writer.append(",");
			writer.append(city);
			writer.append(",");
			writer.append(state);
			writer.append(",");
			writer.append(zipCode);
			writer.append(",");
			writer.append(status);
			writer.append("\n");
			writer.close();
		} catch (IOException e) { // new FileWriter
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
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
			writer.append("name");
			writer.append(",");
			writer.append("number");
			writer.append(",");
			writer.append("address");
			writer.append(",");
			writer.append("city");
			writer.append(",");
			writer.append("state");
			writer.append(",");
			writer.append("zipCode");
			writer.append(",");
			writer.append("status");
			writer.append("\n");
			for (Member member: members) {
				writer.append(member.getName());
				writer.append(",");
				writer.append(member.getNumber());
				writer.append(",");
				writer.append(member.getAddress());
				writer.append(",");
				writer.append(member.getCity());
				writer.append(",");
				writer.append(member.getState());
				writer.append(",");
				writer.append(member.getZipCode());
				writer.append(",");
				writer.append(member.getStatus());
				writer.append("\n");
			}
			writer.close();
		} catch (IOException e) { // new FileWriter
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateMemberInDatabase(String number) {
		String newNumber = this.number;
		this.number = number;
		deleteMemberFromDatabase();
		this.number = newNumber;
		addMemberToDatabase();
	}
	
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