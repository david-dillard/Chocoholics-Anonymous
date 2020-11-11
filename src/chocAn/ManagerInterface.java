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
		mrep = GenerateReports.generateMemberReport(number);
		
		return mrep;
	}
	
	public ProviderReport requestProviderReport(){
		ProviderReport prep = new ProviderReport();
		prep = GenerateReports.generateProviderReport(number);
		
		return prep;
	}
	
	public SummaryReport requestSummaryReport(){
		SummaryReport srep = new SummaryReport();
		srep = GenerateReports.generateSummaryReport(services);
		
		return srep;
	}
	
	public EftData requestEftData(){
		
	}
}
