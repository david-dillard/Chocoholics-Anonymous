package chocAn;

import java.util.*;


import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.*;
import java.time.temporal.TemporalAccessor;

public class SummaryReport extends Report{
	private List<Provider> providers = new ArrayList<Provider>();
	private int totalProviders = 0, totalConsultations = 0;
	private double totalFee = 0;
	
	
	public SummaryReport(List<Service> services) {
		boolean isUnique = true;
		totalConsultations = services.size();
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
			String tempFee = service.getFee();
			tempFee.replaceAll("$", "");
			tempFee.replaceAll(",", "");
			this.totalFee += Double.valueOf(tempFee);
		}
	}
	
	public void printReport() {
		String output = "";
		for(Provider provider : providers) {
			Service tempService = new Service();
			List<Service> tempServices = tempService.getProviderServices("");
			double providerFee = 0;
			for(Service service : tempServices) {
				LocalDate cutoffDate = LocalDate.now().minusDays(7);
				LocalDate serviceDate = LocalDate.parse(service.getServiceDate());
				if(!cutoffDate.isAfter(serviceDate)) {
					String serviceFee = service.getFee();
					serviceFee.replaceAll("$", "");
					serviceFee.replaceAll(",", "");
					providerFee += Double.valueOf(serviceFee);
				}
			}
			output += "Provider name:\t" + provider.getName() + "\nNumber of consulations performed:\t" + tempServices.size() + "\nProvider fee for the week:\t$" + String.format("%.2g%n",providerFee) + "\n";	
		}
		output += "Total number of providers:\t" + totalProviders + "\nTotal number of consultations:\t" + totalConsultations + "\nOverall fee:\t$" + String.format("%.2g%n",totalFee);
		try {
			FileWriter summaryReport = new FileWriter("SummaryReport.txt");
			summaryReport.write(output);
			summaryReport.close();
		} catch(IOException e) {
			System.out.println("An error occurred.");
		    e.printStackTrace();
		}	
	}
	

}
