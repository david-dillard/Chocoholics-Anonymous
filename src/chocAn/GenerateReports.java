package chocAn;
import java.util.List;
import java.util.ArrayList;

public class GenerateReports {
	
	public MemberReport generateMemberReport(String number) {
		
	}
	
	public ProviderReport generateProviderReport(String number) {
		
	}
	
	public SummaryReport generateSummaryReport(List<Service> services) {
		
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
		Service service;
		List<Service> services = new ArrayList<Service>();
		for(Provider provider: providers) {
			String number = provider.getNumber();
			
			
		}
		
	}
	
	
	
	
	
}
