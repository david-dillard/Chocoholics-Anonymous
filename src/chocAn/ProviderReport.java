package chocAn;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class ProviderReport extends Report{
	private String name, number, address, city, state, zipCode, consulatations, weeklyFee;
	private List<Service> services = new ArrayList<Service>();
	
	
	public String getName() {
		return this.name;
	}

	public String getNumber() {
		return this.name;
	}

	public String getWeeklyFee() {
		return this.weeklyFee;
	}
	
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
			this.services.addAll(tempService.getProviderServices(number));
			this.consulatations = String.valueOf(services.size());
			double totalFee = 0;
			for(Service service : services) {
				String tempFee = service.getFee();
				tempFee.replaceAll("$", "");
				tempFee.replaceAll(",", "");
				totalFee += Double.valueOf(service.getFee());
			}
			if(totalFee > 99999.99)
				totalFee = 99999.99;
			this.weeklyFee = String.format("%.2g%n",totalFee);
			
		}	
	}
	
	public void printReport() {
		String output = "Provider name:\t" + name + "\nProvider number:\t" + number + "\nProvider street address:\t" + address + "\nProvider City:\t" + city + "\nProvider state:/t" + state + "\nProvider ZIP code\t" + zipCode + "\n";
		for(Service service: services) {
			Member tempMember = new Member();
			tempMember = tempMember.getMemberByNumber(service.getMemberNumber());
			output += "Date of Service:\t" + service.getServiceDate() + "\nDate and time data were recieved by the computer:\t" + service.getComputerTime() + "\nMember name:/t" + tempMember.getName() + "\nMember number:\t" + service.getMemberNumber() + "\nService code:\t" + service.getServiceCode() + "\nFee to be paid:\t$" + service.getFee() + "\n";
		}
		output += "Total number of consultations with members:\t" + consulatations + "\nTotal fee for week:\t$" + weeklyFee;
		try {
			FileWriter providerReport = new FileWriter("ProviderReport.txt");
			providerReport.write(output);
			providerReport.close();
		} catch(IOException e) {
			System.out.println("An error occurred.");
		    e.printStackTrace();
		}
	}
	
	
	
}
