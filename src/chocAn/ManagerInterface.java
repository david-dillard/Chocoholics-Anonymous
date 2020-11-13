package chocAn;

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
			String[] options = new String[] {"Summary", "Member", "Provider", "EftData", "Exit"};
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
		
		Provider grandProvider = new Provider();
		List<Provider> providers = grandProvider.getProvidersFromDatabase();
		Service grandService = new Service();
		List<Service> weekServices = new ArrayList<Service>();
		for(Provider provider: providers) {
			String number = provider.getNumber();
			weekServices.addAll(grandService.getProviderServices(number));
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
		GenerateReports generateReport = new GenerateReports();
		EftData eftData = generateReport.writeEftData();
		return eftData;
	}
}
