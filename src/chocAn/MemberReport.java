package chocAn;


import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

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
			List<Service> allServices = tempService.getMemberServices(number);
			for(Service service : allServices) {
				LocalDate cutoffDate = LocalDate.now().minusDays(7);
				LocalDate serviceDate = LocalDate.parse(service.getServiceDate());
				if(!cutoffDate.isAfter(serviceDate)) {
					this.services.add(service);	
				}
			}
		}	
	}
	
	public void printReport() {
		String output = "Member name:\t" + name + "\nMember number:\t" + number + "\nMember street address:\t" + address + "\nMember city:\t" + city + "\nMember state:\t" + state + "\nMember ZIP code:\t" + zipCode + "\n";
		for(Service service: services) {
			Provider tempProvider = new Provider();
			tempProvider = tempProvider.getProviderByNumber(service.getProviderNumber());
			ProviderDirectory providerDirectory = new ProviderDirectory();
			
			output += "Date of service:\t" + service.getServiceDate() + "Provider name:\t" + tempProvider.getName() + "Service name:\t" + providerDirectory.getName(service.getServiceCode());
		}
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
			    Date date = new Date(); 
			FileWriter memberReport = new FileWriter( name + formatter.format(date) +".txt");
			memberReport.write(output);
			memberReport.close();
		} catch(IOException e) {
			System.out.println("An error occurred.");
		    e.printStackTrace();
		}
	}
	
	
}
