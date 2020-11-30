package chocAn;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.time.format.*;

/**
 * Boundary Class that gathers and outputs information needed for provider reports
 * 
 * @author Jacob Pacheco
 * @version 1.0
 */
public class ProviderReport extends Report{
	private String name, number = "-1", address, city, state, zipCode, consulatations, weeklyFee;
	private List<Service> services = new ArrayList<Service>();
	
	/**
	 * Searches through Provider and adds all necessary information for provider report
	 * 
	 * @param number the providers's identification number
	 */
	public ProviderReport(String number) {
		Provider tempProvider = new Provider();
		Service tempService = new Service();
		if(tempProvider.searchProviderNumber(number)) {
			tempProvider = tempProvider.getProviderByNumber(number);
			this.name = tempProvider.getName();
			this.number = number;
			this.address = tempProvider.getAddress();
			this.city = tempProvider.getCity();
			this.state = tempProvider.getState();
			this.zipCode = tempProvider.getZipCode();
			List<Service> allServices = tempService.getProviderServices(number);
			for(Service service : allServices) {
				LocalDate cutoffDate = LocalDate.now().minusDays(7);
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
				LocalDate serviceDate = LocalDate.parse(service.getServiceDate(), formatter);
				if(!cutoffDate.isAfter(serviceDate)) {
					this.services.add(service);	
				}
			}
			this.consulatations = String.valueOf(services.size());
			double totalFee = 0;
			for(Service service : services) {
				String tempFee = service.getFee();
				tempFee = tempFee.replace("$", "");
				tempFee = tempFee.replace(",", "");
				//System.out.println(tempFee);
				totalFee += Double.parseDouble(tempFee);
			}
			if(totalFee > 99999.99)
				totalFee = 99999.99;
			this.weeklyFee = String.format("%.2f%n",totalFee);
			
		}	
	}
	/**
	 * Retrieves the provider's name
	 * 
	 * @return a String representing the provider's name
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * Retrieves the provider's identification number
	 * 
	 * @return a String representing the provider's identification number
	 */
	public String getNumber() {
		return this.number;
	}
	/**
	 * Retrieves the provider's total weekly fee
	 * 
	 * @return a String representing the provider's weekly fee
	 */
	public String getWeeklyFee() {
		return this.weeklyFee;
	}
	
	/**
	 * Writes all data for provider report to separate file 
	 */
	public void printReport() {
		String output = "";
		if(!(number.equals("-1"))) {
			output += "Provider name: " + name + "\nProvider number: " + number + "\nProvider street address: " + address + "\nProvider City: " + city + "\nProvider state: " + state + "\nProvider ZIP code " + zipCode + "\n";
			for(Service service: services) {
				Member tempMember = new Member();
				tempMember = tempMember.getMemberByNumber(service.getMemberNumber());
				output += "Date of Service: " + service.getServiceDate() + "\nDate and time data were received by the computer: " + service.getComputerTime() + "\nMember name: " + tempMember.getName() + "\nMember number: " + service.getMemberNumber() + "\nService code: " + service.getServiceCode() + "\nFee to be paid: " + service.getFee() + "\n";
			}
			output += "Total number of consultations with members: " + consulatations + "\nTotal fee for week: $" + weeklyFee;
		} else {
			output += "Provider not found";
		}
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");  
		    Date date = new Date();
			FileWriter providerReport = new FileWriter(name + formatter.format(date) + ".txt");
			providerReport.write(output);
			providerReport.close();
		} catch(IOException e) {
			System.out.println("An error occurred.");
		    e.printStackTrace();
		}
	}
	
	
	
}
