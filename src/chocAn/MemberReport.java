package chocAn;


import java.util.*;

public class MemberReport extends Report {
	private String name, number, address, city, state, zipCode;
	private List<Service> services = new ArrayList<Service>();
	
	public MemberReport(String number) {
		Member tempMember = new Member();
		Service tempService = new Service();
		if(tempMember.searchMemberNumber(number)) {
			tempMember = tempMember.getMemberByNumber(number);
			this.name = tempMember.getName();
			this.number = number;
			this.address = tempMember.getAddress();
			this.city = tempMember.getCity();
			this.state = tempMember.getState();
			this.zipCode = tempMember.getZipCode();
			this.services.addAll(tempService.getMemberServices(number));
		}	
	}
	
	public void printReport() {
		String output = "Member name:\t" + name + "\nMember number:\t" + number + "\nMember street address:\t" + address + "\nMember city:\t" + city + "\nMember state:\t" + state + "\nMember ZIP code:\t" + zipCode + "\n";
		for(Service service: services) {
			output += "Service Name:\t"; //TODO
		}
	}
	
	
}
