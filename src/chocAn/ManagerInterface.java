package chocAn;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class ManagerInterface {
	
	
	public void prompt(){
		
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
		
	}
}
