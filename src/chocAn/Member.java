package chocAn;

import java.util.List;

public class Member {
	
	private String name;
	private String number;
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
		//TODO: Implement
		return null;
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
