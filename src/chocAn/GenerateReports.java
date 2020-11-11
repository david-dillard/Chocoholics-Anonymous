package chocAn;
import java.util.List;
import java.util.ArrayList;

public class GenerateReports {
	
	public MemberReport generateMemberReport(String number) {
		MemberReport memberReport = new MemberReport(number);
		return memberReport;
	}
	
	public ProviderReport generateProviderReport(String number) {
		ProviderReport providerReport = new ProviderReport(number);
		return providerReport;
	}
	
	public SummaryReport generateSummaryReport(List<Service> services) {
		SummaryReport summaryReport = new SummaryReport(services);
		return summaryReport;		
	}
	
	public EftData writeEftData() {
		//does stuff IDK
	}
	
	
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
		}
		
	
		Service grandService = new Service();
		List<Service> weekServices = new ArrayList<Service>();
		for(Provider provider: providers) {
			String number = provider.getNumber();
			weekServices.addAll(grandService.getProviderServices(number));
		}
		SummaryReport summaryReport = generateSummaryReport(weekServices);
		summaryReport.printReport();
		
		
		writeEftData();
		
	}
	
	
	
	
	
}
