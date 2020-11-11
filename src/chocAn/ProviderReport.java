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
		
	}
	
	
	
}
