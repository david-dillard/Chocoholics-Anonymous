package chocAn;


import java.util.*;

/**
 * Boundary Class that gathers and outputs information needed for member reports
 * 
 * @author Jacob Pacheco
 * @version 1.0
 */
import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class MemberReport extends Report {
	private String name, number, address, city, state, zipCode;
	private List<Service> services = new ArrayList<Service>();
	
	
	/**
	 * Searches through Member and adds all necessary information for member report
	 * @param number the member's identification number
	 */
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
	/**
	 * Writes all data for member report to separate file 
	 */
	public void printReport() {
		String output = "Member name:\t" + name + "\nMember number:\t" + number + "\nMember street address:\t" + address + "\nMember city:\t" + city + "\nMember state:\t" + state + "\nMember ZIP code:\t" + zipCode + "\n";
		for(Service service: services) {
			Provider tempProvider = new Provider();
			tempProvider = tempProvider.getProviderByNumber(service.getProviderNumber());
			ProviderDirectory providerDirectory = new ProviderDirectory();
			
			output += "Date of service:\t" + service.getServiceDate() + "\nProvider name:\t" + tempProvider.getName() + "\nService name:\t" + providerDirectory.getName(service.getServiceCode()) +"\n";
		}
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");  
			    Date date = new Date(); 
			FileWriter memberReport = new FileWriter(name + formatter.format(date) +".txt");
			memberReport.write(output);
			memberReport.close();
		} catch(IOException e) {
			System.out.println("An error occurred.");
		    e.printStackTrace();
		}
	}
	
	
}
