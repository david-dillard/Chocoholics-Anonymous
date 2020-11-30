package chocAn;


import java.util.*;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Boundary Class that gathers and outputs information needed for member reports
 * 
 * @author Jacob Pacheco
 * @version 1.0
 */
public class MemberReport extends Report {
	private String name, number = "-1", address, city, state, zipCode;
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
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
				LocalDate serviceDate = LocalDate.parse(service.getServiceDate(), formatter);
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
		String output = "";
		if(!(number.equals("-1"))) {
			 output += "Member name: " + name + "\nMember number: " + number + "\nMember street address: " + address + "\nMember city: " + city + "\nMember state: " + state + "\nMember ZIP code: " + zipCode + "\n";
			for(Service service: services) {
				Provider tempProvider = new Provider();
				tempProvider = tempProvider.getProviderByNumber(service.getProviderNumber());
				ProviderDirectory providerDirectory = new ProviderDirectory();
				output += "Date of service: " + service.getServiceDate() + "\nProvider name: " + tempProvider.getName() + "\nService name: " + providerDirectory.getName(service.getServiceCode()) +"\n";
			}
		} else {
			output += "Member not found";
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
