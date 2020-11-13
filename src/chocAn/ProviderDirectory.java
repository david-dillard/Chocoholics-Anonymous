package chocAn;

public class ProviderDirectory {
	private String[] serviceCodes = {"111111", "222222", "333333", "444444", "555555"};
	private String[] serviceNames = {"Eat less chocolate", "Intervention", "Weight loss program", "Exercise program", "Yoga"};
	
	public ProviderDirectory() {}
	
	public String[] getServiceCodes() {
		return serviceCodes;
	}
	
	public String[] getServiceNames() {
		return serviceNames;
	}
	
	public String getCode(String name) {
		int i = 0;
		while(i < serviceNames.length) {
			if(serviceNames[i] == name) {
				return serviceCodes[i];
			}
			i ++;
		}
		return null;
	}
	
	public String getName(String code) {
		int i = 0;
		while(i < serviceCodes.length) {
			if(serviceCodes[i] == code) {
				return serviceNames[i];
			}
			i ++;
		}
		return null;
	}
}
