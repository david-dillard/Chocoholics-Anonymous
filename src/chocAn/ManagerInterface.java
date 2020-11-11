package chocAn;

public class ManagerInterface {
	//private GenerateReports gen;
	
	public ManagerInterface(){
		//gen = new GenerateReports();
	}
	
	public void prompt(){
		
	}
	
	public MemberReport requestMemberReport(){
		MemberReport mrep = new MemberReport();
		mrep = GenerateReports.generateMemberReport(String number);
		
		return mrep;
	}
	
	public ProviderReport requestProviderReport(){
		ProviderReport prep = new ProviderReport();
		prep = GenerateReports.generateProviderReport(String number);
		
		return prep;
	}
	
	public SummaryReport requestSummaryReport(){
		SummaryReport srep = new SummaryReport();
		srep = GenerateReports.generateSummaryReport(List<Service> services);
		
		return srep;
	}
	
	public EftData requestEftData(){
		
	}
}
