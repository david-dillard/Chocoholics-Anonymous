package chocAn;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.*;


/**
 * helper class that contains methods for generating Member, Provider, Summary, and EftData reports
 * 
 * @author David Dillard
 * @version 1.0
 */
public class GenerateReports {
	
	/**
	 * constructs and returns a MemberReport given a member ID
	 * @param number the member's identification number
	 * @return a fully populated MemberReport 
	 */
	public MemberReport generateMemberReport(String number) {
		MemberReport memberReport = new MemberReport(number);
		return memberReport;
	}
	
	/**
	 * constructs and returns a ProviderReport given a provider ID
	 * @param number the provider's identification number
	 * @return a fully populated ProviderReport 
	 */
	public ProviderReport generateProviderReport(String number) {
		ProviderReport providerReport = new ProviderReport(number);
		return providerReport;
	}
	
	/**
	 * constructs and returns a SummaryReport given a list of services completed during the week
	 * @param services list of services provided during the week
	 * @return a fully populated SummaryReport
	 */
	public SummaryReport generateSummaryReport(List<Service> services) {
		SummaryReport summaryReport = new SummaryReport(services);
		return summaryReport;		
	}
	
	/**
     * Constructs and returns an EftData file
     * @param providerReport a populated Provider Report so that the method can get provider details
     * @return fully populated EftData
     */
	public EftData writeEftData(ProviderReport providerReport) {
		EftData eftData = new EftData(providerReport.getName(), providerReport.getNumber(), providerReport.getWeeklyFee());
		return eftData;
	}
	
	/**
	 * runs the main accounting procedure by generating a report for every Member and Provider as well as each provider's EFT Data and a SummaryReport
	 */
	public void runAccountingProcedure() {
		
		Member grandMember = new Member();
		List<Member> members = grandMember.getMembersFromDatabase();
		for(Member member: members) {
			MemberReport memberReport = generateMemberReport(member.getNumber());
			memberReport.printReport();
		}
		
		
		Provider grandProvider = new Provider();
		List<Provider> providers = grandProvider.getProvidersFromDatabase();
		for(Provider provider: providers) {
			ProviderReport providerReport = generateProviderReport(provider.getNumber());
			providerReport.printReport();
			EftData eftData = writeEftData(providerReport);
			eftData.printReport();
		}
		
		LocalDate cutoffDate = LocalDate.now().minusDays(7);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
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
		SummaryReport summaryReport = generateSummaryReport(weekServices);
		summaryReport.printReport();
		
		
		
	}
}
