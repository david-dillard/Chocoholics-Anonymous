package chocAn;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class ManagerInterface {
	
	
	public void prompt(){
		boolean flag = false;
		while(true) {
		//Custom button text
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
	
	public MemberReport requestMemberReport() {
		
		GenerateReports generateReport = new GenerateReports();
		
		String memberNumber = JOptionPane.showInputDialog("What is the identification number of the member you wish to run the record of?");
		MemberReport memberReport = generateReport.generateMemberReport(memberNumber);	
		
		memberReport.printReport();
		return memberReport;
	
	}
	
	public ProviderReport requestProviderReport() {
		GenerateReports generateReport = new GenerateReports();
		
		String providerNumber = JOptionPane.showInputDialog("What is the identification number of the provider you wish to run the record of?");		
		ProviderReport providerReport = generateReport.generateProviderReport(providerNumber);	
		
		providerReport.printReport();
		return providerReport;
	
	}
	
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
	
	public EftData requestEftData(){
		GenerateReports generateReport = new GenerateReports();
		EftData eftData = generateReport.writeEftData();
		return eftData;
	}
}
