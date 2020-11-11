package chocAn;

import java.util.*;

public class ProviderReport extends Report{
	private String name, number, address, city, state, zipCode, consulatations, weeklyFee;
	private List<Service> services = new ArrayList<Service>();
	
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
				totalFee += Double.valueOf(service.getFee());
			}
			this.weeklyFee = String.valueOf(totalFee);
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
	}
	
	
	
}
