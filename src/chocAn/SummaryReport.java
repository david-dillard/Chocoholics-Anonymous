package chocAn;

import java.util.*;


import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.*;
import java.time.temporal.TemporalAccessor;

/**
 * Boundary Class that gathers and outputs information needed for summary reports
 * 
 * @author Jacob Pacheco
 * @version 1.0
 */
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
			tempFee = tempFee.replace("$", "");
			tempFee = tempFee.replace(",", "");
			this.totalFee += Double.parseDouble(tempFee);
		}
	}
	
	public void printReport() {
		String output = "";
		for(Provider provider : providers) {
			Service tempService = new Service();
			List<Service> tempServices = tempService.getProviderServices(tempService.getProviderNumber());
			double providerFee = 0;
			for(Service service : tempServices) {
				LocalDate cutoffDate = LocalDate.now().minusDays(7);
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
				LocalDate serviceDate = LocalDate.parse(service.getServiceDate(), formatter);
				if(!cutoffDate.isAfter(serviceDate)) {
					String serviceFee = service.getFee();
					serviceFee = serviceFee.replace("$", "");
					serviceFee = serviceFee.replace(",", "");
					providerFee += Double.parseDouble(serviceFee);
				}
			}
			output += "Provider name:\t" + provider.getName() + "\nNumber of consulations performed:\t" + tempServices.size() + "\nProvider fee for the week:\t$" + String.format("%.2g%n",providerFee) + "\n";	
		}
		output += "Total number of providers:\t" + totalProviders + "\nTotal number of consultations:\t" + totalConsultations + "\nOverall fee:\t$" + String.format("%.2g%n",totalFee);
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");  
		    Date date = new Date();
			FileWriter summaryReport = new FileWriter("Summary" + formatter.format(date) + ".txt");
			summaryReport.write(output);
			summaryReport.close();
		} catch(IOException e) {
			System.out.println("An error occurred.");
		    e.printStackTrace();
		}	
	}
	

}
