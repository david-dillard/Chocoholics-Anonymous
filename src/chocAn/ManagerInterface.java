package chocAn;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

/**
 * helper class that contains methods to prompt the user as well as allowing them to request reports
 * @author David Dillard
 */
public class ManagerInterface {
	
	/**
	 * displays a dialog box prompting the user to choose a record to request. loops until the user selects the exit option
	 */
	public void prompt(){
		boolean flag = false;
		while(true) {
			String[] options = new String[] {"Summary", "Member", "Provider", "EFT Data", "Exit"};
	    	int response = JOptionPane.showOptionDialog(null, "Which report would you like?", "Manager Options",
	    			JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
	    			null, options, options[0]);
	    	switch(response) {
	    		case 0:
	    			requestSummaryReport();
	    			break;
	    		case 1:
	    			requestMemberReport();
	    			break;
	    		case 2:
	    			requestProviderReport();
	    			break;
	    		case 3:
	    			requestEftData();
	    			break;
	    		case 4:
	    			flag = true;	
	    	}
	    	if(flag == true) {
	    		break;
	    	}
	    }
	}
	
	/**
	 * displays a dialog box prompting the user for a member number, then generates a report for the indicated member
	 * @return the generated member report
	 */
	public MemberReport requestMemberReport() {
		
		GenerateReports generateReport = new GenerateReports();
		
		String memberNumber = JOptionPane.showInputDialog("What is the identification number of the member you wish to run the record of?");
		Member temp = new Member();
		if(temp.searchMemberNumber(memberNumber) == false) {
			JOptionPane.showMessageDialog(null, "ERROR: That member does not exist.", "Inane error", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		MemberReport memberReport = generateReport.generateMemberReport(memberNumber);	
		memberReport.printReport();
		return memberReport;
	}
	
	/**
	 * displays a dialog box prompting the user for a provider number, then generates a report for the indicated provider
	 * @return the generated provider report
	 */
	public ProviderReport requestProviderReport() {
		GenerateReports generateReport = new GenerateReports();
		
		String providerNumber = JOptionPane.showInputDialog("What is the identification number of the provider you wish to run the record of?");		
		Provider temp = new Provider();
		if(temp.searchProviderNumber(providerNumber) == false) {
			JOptionPane.showMessageDialog(null, "ERROR: That provider does not exist.", "Inane error", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		ProviderReport providerReport = generateReport.generateProviderReport(providerNumber);
		providerReport.printReport();
		return providerReport;
	
	}
	
	/**
	 * loops through a list of providers to get a list of services from the week to pass to generateSummaryReport. the summary report is then
	 * generated
	 * @return the generated summary report
	 */
	public SummaryReport requestSummaryReport() {
		
		GenerateReports generateReport = new GenerateReports();
		LocalDate cutoffDate = LocalDate.now().minusDays(7);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		Provider grandProvider = new Provider();
		List<Provider> providers = grandProvider.getProvidersFromDatabase();
		Service grandService = new Service();
		List<Service> weekServices = new ArrayList<Service>();
		for(Provider provider: providers) {
			List<Service> providerServices = new ArrayList<Service>();
			String number = provider.getNumber();
			providerServices.addAll(grandService.getProviderServices(number));
			
			for (Service service: providerServices) {
				LocalDate serviceDate = LocalDate.parse(service.getServiceDate(), formatter);
				if(!cutoffDate.isAfter(serviceDate)) {
					weekServices.add(service);
				}
			}
			
		}
		SummaryReport summaryReport = generateReport.generateSummaryReport(weekServices);
		summaryReport.printReport();
		return summaryReport;
	
	}
	
	/**
	 * generates an EftReport
	 * @return the generated EftReport
	 */
	public EftData requestEftData(){
		Provider temp = new Provider();
		GenerateReports generateReport = new GenerateReports();
		String providerNumber = JOptionPane.showInputDialog("What is the identification number of the provider you wish to run the EFT data of?");
		if(temp.searchProviderNumber(providerNumber) == false) {
			JOptionPane.showMessageDialog(null, "ERROR: That provider does not exist.", "Inane error", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		ProviderReport providerReport = generateReport.generateProviderReport(providerNumber);
		EftData eftData = generateReport.writeEftData(providerReport);
		eftData.printReport();
		return eftData;
	}
}
