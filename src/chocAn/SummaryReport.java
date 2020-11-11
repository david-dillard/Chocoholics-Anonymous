package chocAn;

import java.util.ArrayList;
import java.util.List;

public class SummaryReport extends Report{
	private List<Provider> providers = new ArrayList<Provider>();
	private int totalProviders = 0;
	private double totalFee = 0;
	
	public SummaryReport(List<Service> services) {
		boolean isUnique = true;
		for(Service service: services) {
			for(Provider provider: providers) {
				if(provider.getNumber().equals(service.getProviderNumber())) {
					isUnique = false;
					break;
				}
			}
			if(isUnique) {
				Provider uniqueProvider = new Provider();
				uniqueProvider = uniqueProvider.getProviderByNumber(service.getProviderNumber());
				providers.add(uniqueProvider);
				totalProviders ++;
			}
			isUnique = true;
			totalFee += Double.valueOf(service.getFee());
		}
	}
	
	public void printReport() {
		
	}
	

}
